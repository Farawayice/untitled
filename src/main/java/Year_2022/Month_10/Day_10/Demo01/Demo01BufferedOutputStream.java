package Year_2022.Month_10.Day_10.Demo01;

import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * @author liulihua
 * @date 2022/10/10 10:31
 *
 * java.io.BufferedOutputStream extends OutputStream
 * BufferedOutputStream���ֽڻ��������
 *  �̳��Ը���Ĺ��Գ�Ա������
 *      public void close():�رմ���������ͷ��������������κ�ϵͳ��Դ��
 *      public void flush():ˢ�´��������ǿ���κλ��������ֽڱ�д����
 *      public void write(byte[] b):��b.length�ֽڴ�ָ�����ֽ�����д����������
 *      public void write(byte[] b,int off,int len):��ָ�����ֽ�����д��len�ֽڣ���ƫ����off��ʼ��������������
 *      public abstract void write(int b):��ָ�����ֽ��������
 *      ���췽����
 *          BufferedOutputStream(OutputStream out):����һ���µĻ�����������Խ�����д��ָ���ĵײ��������
 *          BufferedOutputStream(OutputStream out ,int size):����һ���µĻ�����������Խ�����ָ����������С������д��ָ���ĵײ��������
 *          ������
*               OutputStream out �ֽ������
 *               ���ǿ��Դ���FileOutputStream,���������FileOutputStream ����һ�������������FileOutputStream ��д��Ч��
 *              int size ָ���������ڲ��������Ĵ�С����ָ��Ĭ��
 *          ʹ�ò��裨�ص㣩
 *              1.����FileOutputStream���󣬹��췽���а�Ҫ�����Ŀ�ĵ�
 *              2.����BufferedOutputStream���󣬹��췽���д���FileOutputStream�������FileOutputStream����Ч��
 *              3.ʹ��BufferedOutputStream�����еķ���write,������д�뵽�ڲ���������
 *              4.ʹ��BufferedOutputStream�����еķ���flush,���ڲ��������е����ݣ�ˢ�µ��ļ���
 *              5.�ͷ���Դ�����ȵ���flush ����ˢ�����ݣ���4���ֿ���ʡ�ԣ�
 *
 */
public class Demo01BufferedOutputStream {
    public static void main(String[] args) throws IOException {
        //1.����FileOutputStream���󣬹��췽���а�Ҫ�����Ŀ�ĵ�
        FileOutputStream fos = new FileOutputStream("E:\\home\\yj\\test\\file\\BufferedOutputStream.txt");
        //2.����BufferedOutputStream���󣬹��췽���д���FileOutputStream�������FileOutputStream����Ч��
        BufferedOutputStream bos = new BufferedOutputStream(fos);
        //3.ʹ��BufferedOutputStream�����еķ���write,������д�뵽�ڲ���������
        bos.write("onms".getBytes(StandardCharsets.UTF_16BE));
        bos.flush();
    }
}
