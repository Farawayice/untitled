package Test.Test;

import java.io.*;
import java.util.*;

/**
 * @author liulihua
 * @date 2023/4/13 9:06
 */

public class test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String ip = scanner.next();
        String port = scanner.next();
        String username = scanner.next();
        String password = scanner.next();
        String d1 = scanner.next();
        String d2 = scanner.next();
        String d3 = scanner.next();
        String d4 = scanner.next();
        String videoType = scanner.next();
        System.out.println("开始生成摄像头配置文件............");
        String path1 = "\\D:\\videoType.txt";
        File file = new File(path1);
        boolean flag = file.exists();
        if (flag) {
            System.out.println("文件已存在");
        } else {
            FileWriter fileWriter = null;
            try {
                boolean b = file.createNewFile();
                System.out.println(b);
                //开始写入默认密码(覆盖)
                fileWriter = new FileWriter("\\D:\\videoType.txt", false);
                fileWriter.write("camera.videorecorder.ip=" + ip + "\n");
                fileWriter.write("camera.videorecorder.port=" + port + "\n");
                fileWriter.write("camera.videorecorder.username=" + username + "\n");
                fileWriter.write("camera.videorecorder.password=" + password + "\n");
                fileWriter.write("camera.videorecorder.d1=" + d1 + "\n");
                fileWriter.write("camera.videorecorder.d2=" + d2 + "\n");
                fileWriter.write("camera.videorecorder.d3=" + d3 + "\n");
                fileWriter.write("camera.videorecorder.d4=" + d4 + "\n");
                fileWriter.write("videoType=" + videoType + "\n");
                fileWriter.flush();
                System.out.println("文件生成及写入完毕============");
            } catch (IOException exception) {
                System.out.println("创建文件出错" + exception);
            }
        }
        System.out.println("+====================================");
        Map properties = new HashMap();
        try {
            properties = getProperties_2("\\D:\\videoType.txt");
            String videoTypes = (String) properties.get("videoType");
            String osd = (String) properties.get("osd");
            if (osd != null) {
                if (!osd.equals("1")) {
                    return;
                }
            }
//            if (!videoTypes.equals("hk")) {
//                return;
//            }

        } catch (IOException e) {
            System.out.println("视频叠加读取视频配置文件出错");
            e.printStackTrace();
            return;
        }
        String ports = (String) properties.get("camera.videorecorder.port");
        String zhs = (String) properties.get("camera.videorecorder.username");
        String mms = (String) properties.get("camera.videorecorder.password");
        System.out.println(ports);
        System.out.println(zhs);
        System.out.println(mms);
    }

    public static Map getProperties_2(String filePath) throws IOException{
        Properties prop = new Properties();
        // 通过输入缓冲流进行读取配置文件
        InputStream inputStream = null;
        try {
            inputStream = new BufferedInputStream(new FileInputStream(new File(filePath)));
            // 加载输入流
            prop.load(inputStream);
        } catch (IOException e) {
            System.out.println("读取配置文件：{}的配置项出错===="+filePath+e);
        } finally {
            if(inputStream != null){
                inputStream.close();
            }
        }
        return printAllProperty(prop);
    }
    private static Map printAllProperty(Properties props)
    {
        @SuppressWarnings("rawtypes")
        Enumeration en = props.propertyNames();
        Map<String,String> map = new HashMap();
        while (en.hasMoreElements())
        {
            String key = (String) en.nextElement();
            String value = props.getProperty(key);
            map.put(key, value);
            //System.out.println(key + ":" + value);
        }
        return map;
    }

}
