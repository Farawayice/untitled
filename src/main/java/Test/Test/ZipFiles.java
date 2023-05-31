package Test.Test;

import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
public class ZipFiles {
    public static void main(String[] args) {
        // 文件列表（假设在以下路径中）
        File[] files = new File("E:\\logs").listFiles();
        // 打包后的 ZIP 文件名
        String zipFileName = "logs.zip";
        // 创建 ZIP 输出流
        try {
            FileOutputStream fos = new FileOutputStream(zipFileName);
            ZipOutputStream zos = new ZipOutputStream(fos);
            // 遍历文件列表，将每个文件打包成 ZIP 格式
            for (File file : files) {
                if (file.isFile()) {
                    ZipEntry ze = new ZipEntry(file.getName());
                    zos.putNextEntry(ze);
                    FileInputStream fis = new FileInputStream(file);
                    byte[] buffer = new byte[1024];
                    int len;
                    while ((len = fis.read(buffer)) > 0) {
                        zos.write(buffer, 0, len);
                    }
                    zos.closeEntry();
                    fis.close();
                }
            }
            zos.close();
            fos.close();
            System.out.println("Multiple files compressed into " + zipFileName);
        } catch (IOException ex) {
            System.err.println("Error occurred while zipping the files: " + ex.getMessage());
        }
    }
}