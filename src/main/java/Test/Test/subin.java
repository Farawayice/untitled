package Test.Test;

import ch.ethz.ssh2.Connection;
import ch.ethz.ssh2.SFTPv3Client;
import ch.ethz.ssh2.SFTPv3DirectoryEntry;
import org.jetbrains.annotations.NotNull;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.nio.file.Files;
import java.util.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * @author liulihua
 * @date 2023/5/8 9:38
 */
public class subin {

    public static void main(String[] args) {
        //遍历地址下的所有文件名
//        ArrayList<String> strings = readFile("/home/yj/logs/");
//
//        HttpServletResponse response = null;
//        for (int i = 0; i < strings.size(); i++) {
//            System.out.println(new File(strings.get(i)).getName());
//        }

//        //符合条件的日志文件 筛选字符串不能为空
        List<File> files = selectFile("E:\\logs","root");
////        log.info("3. 把文件压缩进去");
//        String[] split = files.get(0).getName().split("-");
//        File zipFile = new File("E:\\logs\\"+split[0]+".zip");
//        zipFiles(files,zipFile);
//        System.out.println("压缩成功！");
    }
    //传入文件名查询本地文件是否存在
    private static List<File> selectFile(String path,String keyword){
        //目录下所有文件(包括文件夹)
        //File类型可以是文件也可以是文件夹
        File file = new File(path);
        //将该目录下的所有文件放置在一个File类型的数组中
        File[] fileList = file.listFiles();
        //目录下所有文件、新建一个文件集合
        List<File> wjList = new ArrayList<>();
        for (int i = 0; i < Objects.requireNonNull(fileList).length; i++) {
            //判断是否为文件并且按照传入的名称进行过滤
            if (fileList[i].isFile()&& fileList[i].getName().contains(keyword)) {
                wjList.add(fileList[i]);
            }
        }
//        System.out.println("===============================");
//        for (File file1 : wjList) {
//            System.out.println(file1.getName());
//        }
        System.out.println("====================");
        List<File> files1 = orderByName(path);
        for (File file1 : files1) {
            System.out.println(file1);
        }
        System.out.println("===============================");

        //目录下所有文件夹
//        List<File> wjjList = new ArrayList<File>();//新建一个文件夹集合
//        for (int i = 0; i < fileList.length; i++) {
//            if (fileList[i].isDirectory()) {//判断是否为文件夹
//                wjjList .add(fileList[i]);
//            }
//        }
        return wjList;
    }
    //远程连接ssh遍历对应文件下目录
    public static ArrayList<String> readFile(String directory) {
        //创建远程连接，默认连接端口为22，如果不使用默认，可以使用方法
        //new Connection(ip, port)创建对象
        String ip = "192.168.2.251";
        String usr = "yj";
        String pwd = "yjdrhtdrht";
        //int port=22;
        Connection conn = null;
        //所要查询的目录
        String path = directory;
        ArrayList<String> filesNameList = new ArrayList<String>();
        try {
            //连接远程服务器
            // 连接部署服务器
            conn = new Connection(ip);
            conn.connect();
            //使用用户名和密码登录
            boolean b = conn.authenticateWithPassword(usr, pwd);
            if (!b) {
                throw new IOException("登录失败！");
            } else {
                SFTPv3Client sft = new SFTPv3Client(conn);
                List<SFTPv3DirectoryEntry> v = sft.ls(path);
                for (int i = 0; i < v.size(); i++) {
                    SFTPv3DirectoryEntry s = v.get(i);
                    //文件名
                    String filename = s.filename;
                    if (filename.length()<5){
                        continue;
                    }
                    filesNameList.add(filename);
                }
            }
            System.out.println("====================");
            List<File> files1 = orderByName(directory);
            for (File file : files1) {
                System.out.println(file);
            }
            System.out.println("===============================");

            conn.close();
        } catch (IOException e) {
            System.err.printf("用户%s密码%s登录服务器%s失败！", usr, pwd, ip);
            e.printStackTrace();
        }

        return filesNameList;
    }
    /**
     * @param srcFiles 要压缩的文件
     * @param zipFile 压缩后的压缩包
     */
    public static void zipFiles(List<File> srcFiles, File zipFile) {
        // 判断压缩后的文件存在不，不存在则创建
        if (!zipFile.exists()) {
            try {
                zipFile.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        // 创建 FileOutputStream 对象
        FileOutputStream fileOutputStream = null;
        // 创建 ZipOutputStream
        ZipOutputStream zipOutputStream = null;
        // 创建 FileInputStream 对象
        FileInputStream fileInputStream = null;

        try {
            // 实例化 FileOutputStream 对象
            fileOutputStream = new FileOutputStream(zipFile);
            // 实例化 ZipOutputStream 对象
            zipOutputStream = new ZipOutputStream(fileOutputStream);
            // 创建 ZipEntry 对象
            ZipEntry zipEntry = null;
            // 遍历源文件数组
            int i = 1;
            for (File srcFile:srcFiles) {
                // 将源文件数组中的当前文件读入 FileInputStream 流中
                fileInputStream = new FileInputStream(srcFile);

                // 实例化 ZipEntry 对象，源文件数组中的当前文件，加个i防止有重名文件压缩失败
                zipEntry = new ZipEntry("[" + i + "]" +srcFile.getName());
                zipOutputStream.putNextEntry(zipEntry);

                // 该变量记录每次真正读的字节个数
                int len;
                // 定义每次读取的字节数组
                byte[] buffer = new byte[1024];
                while ((len = fileInputStream.read(buffer)) > 0) {
                    zipOutputStream.write(buffer, 0, len);
                }
                i++;
            }
            zipOutputStream.closeEntry();
            zipOutputStream.close();
            fileInputStream.close();
            fileOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    //按照名称排序
    public static List<File> orderByName(String filePath) {
        File file = new File(filePath);
        File[] files = file.listFiles();
        List fileList = Arrays.asList(files);
        Collections.sort(fileList, new Comparator<File>() {
            @Override
            public int compare(File o1, File o2) {
                if (o1.isDirectory() && o2.isFile())
                    return -1;
                if (o1.isFile() && o2.isDirectory())
                    return 1;
                return o1.getName().compareTo(o2.getName());
            }
        });
        List<File> files1 = new ArrayList<>();
        files1.addAll(Arrays.asList(files));
        return files1;
    }
    //通过文件地址下载文件接口
    public static void download(@NotNull HttpServletResponse response,String filePath){

        File file = new File(filePath);

// 取得文件名。

        String fileName = file.getName();

        InputStream fis = null;

        try {

            fis = Files.newInputStream(file.toPath());

            response.reset();

            response.setCharacterEncoding("UTF-8");

            response.setContentType("application/force-download");// 设置强制下载不打开

            response.addHeader("Content-Disposition",

                    "attachment;filename=" + new String(fileName.getBytes("utf-8"), "iso8859-1"));

            response.setHeader("Content-Length", String.valueOf(file.length()));

            byte[] b = new byte[1024];

            int len;

            while ((len = fis.read(b)) != -1) {

                response.getOutputStream().write(b, 0, len);

            }

            response.flushBuffer();

            fis.close();

        }catch (IOException e) {

            throw new RuntimeException(e);

        }

    }

}