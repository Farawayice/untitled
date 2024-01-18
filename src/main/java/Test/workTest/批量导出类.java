package Test.workTest;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author liulihua
 * @date 2022/10/21 16:49
 */
public class 批量导出类 {

    public static void main(String[] args) {
        //RealtimeMonitorDataVO(id=cdfaa706a119ea7cf0ed9b039a3c2013, monitoringFactorName=除尘设施_布袋除尘器前后压差, code=100, dataTime=2022-10-26 10:17:00.0, value=3.510000, flag=正常, reducedValue=null, unit=KPa, createTime=2022-10-26 10:17:00.0),
        //RealtimeMonitorDataVO(id=cf49c651e3f938337542250ddbd64bf8, monitoringFactorName=烟气湿度, code=18, dataTime=2022-10-26 10:17:00.0, value=0.000000, flag=正常, reducedValue=null, unit=%, createTime=2022-10-26 10:17:00.0),
        //RealtimeMonitorDataVO(id=d35eb46e09ce7469bd6a1e6d05b05558, monitoringFactorName=氧气含量, code=21, dataTime=2022-10-26 10:17:00.0, value=5.042762, flag=正常, reducedValue=null, unit=%, createTime=2022-10-26 10:17:00.0),
        //RealtimeMonitorDataVO(id=e57be07cd4c6bc46c4a5a76e667cf092, monitoringFactorName=烟尘, code=23, dataTime=2022-10-26 10:17:00.0, value=5.265000, flag=正常, reducedValue=null, unit=mg/m³, createTime=2022-10-26 10:17:00.0),
        //RealtimeMonitorDataVO(id=f188c574133176c8b9f8e8298cbb3d72, monitoringFactorName=氮氧化物, code=22, dataTime=2022-10-26 10:17:00.0, value=0.000000, flag=正常, reducedValue=null, unit=mg/m³, createTime=2022-10-26 10:17:00.0)

        String timestamp = "2022-10-26 10:17:00.0";
        //模拟数据
        RealtimeMonitorDataVO realtimeMonitorDataVO1 = new RealtimeMonitorDataVO();
        realtimeMonitorDataVO1.setCode("81");
        realtimeMonitorDataVO1.setDataTime("2022-10-26 10:17:00.0");
        realtimeMonitorDataVO1.setCreateTime("2022-10-26 10:20:00.0");
        realtimeMonitorDataVO1.setId("cdfaa706a119ea7cf0ed9b039a3c2013");
        realtimeMonitorDataVO1.setValue("3.510000");
        realtimeMonitorDataVO1.setUnit("KPa");
        realtimeMonitorDataVO1.setFlag("正常");
        realtimeMonitorDataVO1.setMonitoringFactorName("除尘设施_布袋除尘器前后压差");

        RealtimeMonitorDataVO realtimeMonitorDataVO2 = new RealtimeMonitorDataVO();
        realtimeMonitorDataVO2.setCode("101");
        realtimeMonitorDataVO2.setDataTime("2022-10-26 10:17:00.0");
        realtimeMonitorDataVO2.setCreateTime("2022-10-26 10:20:00.0");
        realtimeMonitorDataVO2.setId("cf49c651e3f938337542250ddbd64bf8");
        realtimeMonitorDataVO2.setValue("0.510000");
        realtimeMonitorDataVO2.setUnit("%");
        realtimeMonitorDataVO2.setFlag("正常");
        realtimeMonitorDataVO2.setMonitoringFactorName("烟气湿度");

        RealtimeMonitorDataVO realtimeMonitorDataVO3 = new RealtimeMonitorDataVO();
        realtimeMonitorDataVO3.setCode("43");
        realtimeMonitorDataVO3.setDataTime("2022-10-26 10:17:00.0");
        realtimeMonitorDataVO3.setCreateTime("2022-10-26 10:20:00.0");
        realtimeMonitorDataVO3.setId("d35eb46e09ce7469bd6a1e6d05b05558");
        realtimeMonitorDataVO3.setValue("1.510000");
        realtimeMonitorDataVO3.setUnit("%");
        realtimeMonitorDataVO3.setFlag("正常");
        realtimeMonitorDataVO3.setMonitoringFactorName("氧气含量");

        RealtimeMonitorDataVO realtimeMonitorDataVO4 = new RealtimeMonitorDataVO();
        realtimeMonitorDataVO4.setCode("23");
        realtimeMonitorDataVO4.setDataTime("2022-10-26 10:17:00.0");
        realtimeMonitorDataVO4.setCreateTime("2022-10-26 10:20:00.0");
        realtimeMonitorDataVO4.setId("e57be07cd4c6bc46c4a5a76e667cf092");
        realtimeMonitorDataVO4.setValue("2.510000");
        realtimeMonitorDataVO4.setUnit("%");
        realtimeMonitorDataVO4.setFlag("正常");
        realtimeMonitorDataVO4.setMonitoringFactorName("烟尘");

        RealtimeMonitorDataVO realtimeMonitorDataVO5 = new RealtimeMonitorDataVO();
        realtimeMonitorDataVO5.setCode("92");
        realtimeMonitorDataVO5.setDataTime("2022-10-26 10:17:00.0");
        realtimeMonitorDataVO5.setCreateTime("2022-10-26 10:20:00.0");
        realtimeMonitorDataVO5.setId("f188c574133176c8b9f8e8298cbb3d72");
        realtimeMonitorDataVO5.setValue("10.510000");
        realtimeMonitorDataVO5.setUnit("%");
        realtimeMonitorDataVO5.setFlag("正常");
        realtimeMonitorDataVO5.setMonitoringFactorName("氮氧化物");

        List<RealtimeMonitorDataVO> list = new ArrayList<>();
        list.add(realtimeMonitorDataVO1);
        list.add(realtimeMonitorDataVO2);
        list.add(realtimeMonitorDataVO3);
//        list.add(realtimeMonitorDataVO4);
        list.add(realtimeMonitorDataVO5);

        List<String> polIdsS =new ArrayList<>();
        polIdsS.add("43");
        polIdsS.add("92");
        polIdsS.add("81");
        polIdsS.add("101");

//        polIdsS.add("23");


        //全部的map
        Map<String, List<RealtimeMonitorDataVO>> collect = list.stream().collect(Collectors.groupingBy(RealtimeMonitorDataVO::getDataTime,LinkedHashMap :: new,Collectors.toList()));
        List<List<String>> dataAll = new ArrayList<>();
        int size = polIdsS.size();

        //每一行的数据
        collect.forEach((String, realtimeMonitorDataVOS) ->  {
            List<String> dataList = new ArrayList<>();
            for (int i = 0; i < size*2+1; i++) {
                dataList.add(i,"0");
            }
            int n = 0;
            //每一行的第一列
            dataList.set(n++,String.valueOf(timestamp));
            for (RealtimeMonitorDataVO realtimeMonitorDataVO : realtimeMonitorDataVOS) {
//
//                int num = 0;
//                for (int i = (size * 2); i > 0 && num<size; i-=2,num++) {
//                        if (realtimeMonitorDataVO.getCode().equals(polIdsS.get(num))) { //5:11 10  4:9 8
//                            n=i;
//                            break;
//                        }
//
//                }
//                //定义行集合用来存放拼装好的行
//                String value = realtimeMonitorDataVO.getValue();
//                String flag = realtimeMonitorDataVO.getFlag();
//                //根据对应监测因子单位进行转换
//                dataList.set(n--, realtimeMonitorDataVO.getCode());//1
//                dataList.set(n--, realtimeMonitorDataVO.getMonitoringFactorName());//2
                //正向排序
                for (int i = 0; i < size; i++) {
                    if (realtimeMonitorDataVO.getCode().equals(polIdsS.get(i))) {
                        if (i==0){
                            n = 1;
                        }else {
                            n = i*2+1;
                        }
                        break;
                    }
                }


                //定义行集合用来存放拼装好的行
                String value = realtimeMonitorDataVO.getValue();
                String flag = realtimeMonitorDataVO.getFlag();
                //进行单位转换

                //根据对应监测因子单位进行转换
                dataList.set(n++, java.lang.String.valueOf(realtimeMonitorDataVO.getCode()));
                dataList.set(n++, java.lang.String.valueOf(value));
//            }
            }
            dataAll.add(dataList);
        });
        for (List<String> strings : dataAll) {
            for (String string : strings) {
                System.out.print(string+" ");
            }
            System.out.println();
        }
    }
}
