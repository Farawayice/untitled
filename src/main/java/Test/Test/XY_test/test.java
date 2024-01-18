package Test.Test.XY_test;

import cn.hutool.core.util.XmlUtil;
import org.w3c.dom.*;

import java.io.File;
import java.util.*;

/**
 * @author liulihua
 * @date 2023/7/11 9:39
 */
public class test {
    //协议类型 water水  smoke烟
    private static String type = "smoke";
    //XmlUtil.cleanInvalid 除XML文本中的无效字符
    //XmlUtil.getElements 根据节点名获得子节点列表
    //XmlUtil.getElement 根据节点名获得第一个子节点
    //XmlUtil.elementText 根据节点名获得第一个子节点
    //XmlUtil.transElements 将NodeList转换为Element列表
    public static void main(String[] args) {
        File file = new File("src/main/java/Test/Test/XY_test/Template.xml");
        //解析协议测试
        demo_test(file);
    }
    private static void demo_test(File file){
        Document document = XmlUtil.readXML(file);
        System.out.println("协议名称：" + file.getName());
        //获取子节点
        NodeList Template = document.getElementsByTagName("Template");
        for (int i = 0; i < Template.getLength(); i++) {
            Node item = Template.item(i);
            String nodeName = item.getNodeName();
            String nodeValue = item.getNodeValue();
            System.out.println(nodeName+":"+nodeValue);
        }
        List<Element> elements = XmlUtil.transElements(Template);
        for (Element element : elements) {
            NamedNodeMap attributes = element.getAttributes();
            for (int i = 0; i < attributes.getLength(); i++) {
                //协议类型:水协议
                if (attributes.item(i).getNodeName().equals("type") && !attributes.item(i).getNodeValue().isEmpty()) {
                    type = attributes.item(i).getNodeValue();
                }
            }
            //调用通用的协议解析器
            System.out.println("数据类型为：" + type);
            List<Element> groups = XmlUtil.getElements(element, "Groups");
            //遍历所有的Groups
            for (Element element1 : groups) {

                List<Element> group = XmlUtil.getElements(element1, "Group");
                //遍历每一个Group
                for (Element element2 : group) {
                    //每一个Group的配置项
                    for (int i = 0; i < element2.getAttributes().getLength(); i++) {
                        String nodeName = element2.getAttributes().item(i).getNodeName();
                        String nodeValue = element2.getAttributes().item(i).getNodeValue();
                        System.out.println(nodeName + ":" + nodeValue);
                    }
                    //实时值解析
                    setWorkValue(element2, "Factor");
                    //工作状态解析
                    setState(element2, "WorkState");
                    //数据标识解析
                    setState(element2,"DataFlag");

                    if (type.equals("water")) {
                        //WaterParamUtil.updateMonitorVO(deviceInfo);
                    } else {
                        //BuildSmokeAlgorithm.updateMonitorVO(deviceInfo);
                    }

                }
            }
        }
    }
    //写入实时值、写入工作参数
    private static void setWorkValue(Element element2,String str) {
        //遍历每个Factor
        List<Element> factor = XmlUtil.getElements(element2,str);
        for (Element element3 : factor) {
            // 定义每一个参数的配置项
            int index = 0;
            int dataType = 0;
            String polCode = "";
            String transFunc = "";
            for (int i = 0; i < element3.getAttributes().getLength(); i++) {
                Node item = element3.getAttributes().item(i);
                String nodeName = item.getNodeName();
                String nodeValue = item.getNodeValue();
                //每一个实时值参数的读取位置
                switch (nodeName) {
                    case "index":
                        index = Integer.parseInt(nodeValue);
                        break;
                    case "dataType":
                        if (nodeValue.isEmpty()) {
                            dataType = 0;
                        } else {
                            dataType = Integer.parseInt(nodeValue);
                        }
                        break;
                    case "polCode":
                        polCode = nodeValue;
                        break;
                    case "transFunc":
                        transFunc = nodeValue;
                        break;
                }
            }
            if (type.equals("water")) {
                System.out.println("协议对应的：index=" + index + " dataType=" + dataType + " polCode=" + polCode + " transFunc=" + transFunc);
                if (transFunc.isEmpty()) {
                    float value = 0;
                    switch (dataType) {
                        case 0:
                            break;
                        case 1:
                            break;
                        case 2:
                            break;
                        case 3:
                            break;
                        case 4:
                            break;
                    }
                }
                //WaterParamUtil.setValueByPolCode(polCode,value,deviceInfo);
            } else {
                //BuildSmokeAlgorithm.setValueByPolCode(polCode,value,deviceInfo);
            }
        }
    }
    //写入工作状态、写入数据标识、写入报警详情
    private static void setState(Element element2, String str){
        //设置工作状态读取的参数
        Map<Integer,String> stateMap = new LinkedHashMap<>();
        int index = 0;//开始读取的位置
        int dataType = 0;//读取所需要解析的方法类型
        List<Element> workState1 = XmlUtil.getElements(element2,str);
        for (Element element3 : workState1) {
            //一条报文中只有一个工作状态
            Node item = element3.getAttributes().item(0);
            String nodeName = item.getNodeName();
            String nodeValue = item.getNodeValue();
            switch (nodeName) {
                    case "index":
                        index = Integer.parseInt(nodeValue);
                        break;
                    case "dataType":
                        dataType = Integer.parseInt(nodeValue);
                        break;
                    default:
                        System.out.println("缺少index或者dataType!");
                        break;
                }

            System.out.println(str+"开始读取的位置index=" + index + " 数据类型dataType=" + dataType);
            System.out.println("--------------------");

            //获取下一级标题 Maps
            List<Element> workState2 = XmlUtil.getElements(element3, "Maps");
            for (Element element4 : workState2) {
                //每一条Map
                List<Element> workState3 = XmlUtil.getElements(element4, "Map");

                for (Element element : workState3) {
                    int value = 0; String state = "";
                    for (int j = 0; j < element.getAttributes().getLength(); j++) {
                        Node item1 = element.getAttributes().item(j);
                        String nodeName1 = item1.getNodeName();
                        String nodeValue1 = item1.getNodeValue();
                        switch (nodeName1){
                            case "value":
                                value = Integer.parseInt(nodeValue1);
                                break;
                            case "to":
                                state = nodeValue1;
                                break;
                        }
                    }
                    stateMap.put(value,state);
                    System.out.println("--------------------");
                }
            }
        }
        //实际解析出的值
        Integer value = 0;

        for (Map.Entry<Integer, String> entry : stateMap.entrySet()) {
            if (value.equals(entry.getKey())) {
                switch (str) {
                    case "WorkState":
                        switch (entry.getValue()){
                            case "":
                                break;
                        }
                        break;
                    case "DataFlag":

                        break;
                    case "Warning":

                        break;
                }
            }

        }
    }


    /**
     * @param document
     * @param node1  第一个节点
     * @param node2  第二个节点
     * @param node3  第三个节点
     *
     * */
    private static List<Map<String,String>> getThreeNodTeValue(Document document,String node1,String node2,String node3){
        List<Map<String,String>> mapList = new ArrayList<>();
        if (node1.isEmpty()||node2.isEmpty()||node3.isEmpty()){
            System.out.println("找不到节点!");
            return Collections.emptyList();
        }
        //获取根节点
        NodeList nodeList = document.getElementsByTagName(node1);
        List<Element> elementList = XmlUtil.transElements(nodeList);
        for (Element element2 : elementList) {
            //第二级别节点值
            List<Element> elementList1 = XmlUtil.getElements(element2, node2);
            for (Element element : elementList1) {
                List<Element> elements = XmlUtil.getElements(element, node3);
                for (int n = 0; n < elements.size(); n++) {
                    element = elements.get(n);
                    Map<String, String> map = new LinkedHashMap<>();
                    for (int m = 0; m < element.getAttributes().getLength(); m++) {
                        Node node = element.getAttributes().item(m);
                        //子节点下所有的键值对
                        String nodeNodeName = node.getNodeName();
                        String nodeNodeValue = node.getNodeValue();
                        //过滤空值
                        if (!nodeNodeValue.isEmpty()) map.put(nodeNodeName, nodeNodeValue);
                    }
                    mapList.add(map);
                }
            }
        }
        return mapList;
    }

}
