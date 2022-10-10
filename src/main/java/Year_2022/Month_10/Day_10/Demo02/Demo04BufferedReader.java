package Year_2022.Month_10.Day_10.Demo02;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author liulihua
 * @date 2022/10/10 16:40
 * java.io.BufferedReader extends Reader
 * BufferedReader:�ַ�����������
 *  �̳��Ը���Ĺ��Գ�Ա������
 *      int read() ��ȡ�����ַ�������
 *      int read(char[] char)һ�ζ�ȡ����ַ������ַ���������
 *      void close()�رո������ͷ���ֵ������������Դ
 *  ���췽����
 *      BufferedReader(Reader in)����һ��ʹ��Ĭ�ϴ�С���뻺�����Ļ����ַ���������
 *      BufferedReader(Reader in, int size)����һ��ʹ��ָ����С���뻺�����Ļ����ַ�������
 *      ������
 *          Reader in:�ַ�������
 *              ���ǿ��Դ���FileReader,���������FileReader����һ�������������FileReader�Ķ�ȡЧ��
 *  ���еĳ�Ա������
 *      String readLine()��ȡһ���ı��С�
 *
 *      ����ֵ��
 *         �����������ݵ��ַ������������κ�����ֹ��������Ѿ�������ĩβ���򷵻�null
 *      ʹ�ò��裺
 *          1�������ַ��������������󣬹��췽���д����ַ�������
 *          2��ʹ���ַ����������������еķ���read/readLine��ȡ�ı�
 *          3���ͷ���Դ
 */
public class Demo04BufferedReader {
    public static void main(String[] args) throws IOException {
        //1�������ַ��������������󣬹��췽���д����ַ�������
        BufferedReader br = new BufferedReader(new FileReader("E:\\home\\yj\\test\\file\\BufferedWriter.txt"));
        //2��ʹ���ַ����������������еķ���read/readLine��ȡ�ı�
        String s;
        while ((s =br.readLine())!=null){
            System.out.println(s);
        }
        //3���ͷ���Դ
        br.close();
    }
}
