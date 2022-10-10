package Year_2022.Month_10.Day_10.Demo01;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * @author liulihua
 * @date 2022/10/10 15:12
 * java.io.BufferedInputStream extends InputStream
 * BufferedInputStream �ֽڻ���������
 *  �̳��Ը���ĳ�Ա����:
 *      int read()���������ж�ȡ���ݵ���һ���ֽڡ�
 *      int read(byte[] b)���������ж�ȡһ���������ֽڣ�������洢�ڻ���������b�С�
 *      void close()�رմ����������ͷ����������������ϵͳ��Դ��
 *  ���췽����
 *      BufferedInputStream��InputStream in������һ��BufferedInputStream ���������������������in ���Ա㽫��ʹ�á�
 *      BufferedInputStream��InputStream in ��int size����������ָ����������С��BufferedInputStream ���������������������in,�Ա㽫��ʹ�á�
 *      ������
 *          InputStream in:�ֽ�������
 *              ���ǿ��Դ���FileInputStream,���������FileInputStream����һ�������������FileInputStream�Ķ�ȡЧ��
 *          int size:ָ���������ڲ��������Ĵ�С����ָ��Ĭ��
 *      ʹ�ò��裺
 *          1.����һ��FileInputStream ���󣬹��췽���а�Ҫ��ȡ��������
 *          2.����һ��BufferedInputStream���󣬹��췽���д���FileInputStream����,��߶�ȡЧ��
 *          3.ʹ��BufferedInputStream�����еķ���read,��ȡ�ļ�
 *
 */
public class Demo02BufferedInputStream {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("E:\\home\\yj\\test\\file\\BufferedOutputStream.txt");
        BufferedInputStream bfs = new BufferedInputStream(fis);
   /*     int len=0;//
        while ((len=bfs.read())!=-1){
            System.out.println(len);
        }*/
        byte[] bytes = new byte[1024];//�洢ÿ�ζ�ȡ������
        int len = 0;//��¼ÿ�ζ�ȡ����Ч�ֽڸ���
        while ((len = bfs.read(bytes))!=-1){
            System.out.println(new String(bytes,0,len));
        }


        bfs.close();
    }
}
