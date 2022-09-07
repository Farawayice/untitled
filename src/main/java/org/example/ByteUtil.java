//import cn.hutool.core.codec.BCD;
//import com.derunht.enums.FloatOrderEnum;
//import com.derunht.modules.entity.DeviceFloatOrder;
//import com.derunht.modules.service.DeviceFloatOrderService;
//import com.derunht.utils.SpringContextUtil;
//import com.serialserver.data.DeviceInfo;
//import lombok.SneakyThrows;
//import org.springframework.util.StringUtils;

import java.io.*;
import java.math.BigDecimal;
import java.nio.ByteBuffer;
import java.util.List;

//import static org.apache.poi.util.LittleEndian.getLong;

/**
 * 基本数据互转工具
 *
 * @author eguid
 * eguid的官网：www.eguid.cc
 * eguid的csdn博客：http://blog.csdn.net/eguid_1,博客园：http://www.cnblogs.com/eguid
 */
public class ByteUtil {
    private static ByteBuffer buffer = ByteBuffer.allocate(8);

    /**
     * int转byte
     *
     * @param x
     * @return
     */
    public static byte intToByte(int x) {
        return (byte) x;
    }

    /**
     * byte转int
     *
     * @param b
     * @return
     */
    public static int byteToInt(byte b) {
        //Java的byte是有符号，通过 &0xFF转为无符号
        return b & 0xFF;
    }

    /**
     * byte[]转int
     *
     * @param b
     * @return
     */
    public static int byteArrayToInt(byte[] b) {
        return b[3] & 0xFF |
                (b[2] & 0xFF) << 8 |
                (b[1] & 0xFF) << 16 |
                (b[0] & 0xFF) << 24;
    }

    /**
     * 字节转换为int
     *3412
     * 0 1 2 3
     * @param b 字节（至少4个字节）
     * @param index 开始位置
     *              3412顺序
     * @return
     */
    public static int byteArrayToInt1(byte[] b, int index) {

        return b[index+1] & 0xFF |
                (b[index+0] & 0xFF) << 8 |
                (b[index+3] & 0xFF) << 16 |
                (b[index+2] & 0xFF) << 24;
    }

    public static int byteArrayToInt(byte[] b, int index) {
        return b[index + 3] & 0xFF |
                (b[index + 2] & 0xFF) << 8 |
                (b[index + 1] & 0xFF) << 16 |
                (b[index + 0] & 0xFF) << 24;
    }

    public static int byteArrayToIntTwoBytes(byte[] b, int index) {
        return b[index + 1] & 0xFF |
                (b[index + 0] & 0xFF) << 8 ;
    }

    /** 德润
     * 2143
     * @param b
     * @param index
     * @return
     */
    public static float  byteArrayToFloat(byte[] b, int index) {
        return Float.intBitsToFloat(b[index + 1] & 0xFF |
                (b[index + 0] & 0xFF) << 8 |
                (b[index + 3] & 0xFF) << 16 |
                (b[index + 2] & 0xFF) << 24);
    }

    /**
     * 字节转换为浮点
     *1234
     * @param b 字节（至少4个字节）
     * @param index 开始位置
     * @return
     */
    public static float byteArrayToFloat2(byte[] b, int index) {
        int l;
        l = b[index + 0];
        l &= 0xff;
        l |= ((long) b[index + 1] << 8);
        l &= 0xffff;
        l |= ((long) b[index + 2] << 16);
        l &= 0xffffff;
        l |= ((long) b[index + 3] << 24);
        return Float.intBitsToFloat(l);
    }
    /**
     * 字节转换为浮点
     *4321
     * @param b 字节（至少4个字节）
     * @param index 开始位置
     * @return
     */
    public static float byteArrayToFloat3(byte[] b, int index) {
        int l;
        l = b[index + 3];
        l &= 0xff;
        l |= ((long) b[index + 2] << 8);
        l &= 0xffff;
        l |= ((long) b[index + 1] << 16);
        l &= 0xffffff;
        l |= ((long) b[index + 0] << 24);
        return Float.intBitsToFloat(l);
    }

    /**
     * 字节转换为浮点
     *3412
     * @param b 字节（至少4个字节）
     * @param index 开始位置
     *              3412顺序
     * @return
     */
    public static float byteArrayToFloat1(byte[] b, int index) {
        return Float.intBitsToFloat(b[index + 2] & 0xFF |
                (b[index + 3] & 0xFF) << 8 |
                (b[index + 0] & 0xFF) << 16 |
                (b[index + 1] & 0xFF) << 24);
    }
    /**
     * 浮点转换为字节
     *4321
     * @param f
     * @return
     */
    public static byte[] float2byte(float f) {

        // 把float转换为byte[]
        int fbit = Float.floatToIntBits(f);

        byte[] b = new byte[4];
        for (int i = 0; i < 4; i++) {
            b[i] = (byte) (fbit >> (24 - i * 8));
        }

        // 翻转数组
        int len = b.length;
        // 建立一个与源数组元素类型相同的数组
        byte[] dest = new byte[len];
        // 为了防止修改源数组，将源数组拷贝一份副本
        System.arraycopy(b, 0, dest, 0, len);
        byte temp;
        // 将顺位第i个与倒数第i个交换
        for (int i = 0; i < len / 2; ++i) {
            temp = dest[i];
            dest[i] = dest[len - i - 1];
            dest[len - i - 1] = temp;
        }
        return reverse(dest);
    }

    /**
     * 浮点转换为字节
     *1234
     * @param f
     * @return
     */
    public static byte[] floatByte(float f) {

        // 把float转换为byte[]
        int fbit = Float.floatToIntBits(f);

        byte[] b = new byte[4];
        for (int i = 0; i < 4; i++) {
            b[i] = (byte) (fbit >> (24 - i * 8));
        }
        return reverse(b);
    }

    public static void main(String[] args) {
        float f=100;
        byte[] bytes = floatByte(f);
        byte[] bytes1=float2byte(f);
        byte[] bytes2=float3byte(f);
        byte[] bytes4=floatToByte(f);
        System.out.println(byteArrToHexString(bytes));
        System.out.println(byteArrToHexString(bytes1));
        System.out.println(byteArrToHexString(bytes2));
        System.out.println(byteArrToHexString(bytes4));
    }

    /**
     * 浮点转换为字节数组（2143）
     *
     * @param f
     * @return
     */
    public static byte[] float3byte(float f) {

        // 把float转换为byte[]
        int fbit = Float.floatToIntBits(f);

        byte[] b = new byte[4];
        for (int i = 0; i < 4; i++) {
            b[i] = (byte) (fbit >> (24 - i * 8));
        }

        // 翻转数组
        int len = b.length;
        // 建立一个与源数组元素类型相同的数组
        byte[] dest = new byte[len];
        // 为了防止修改源数组，将源数组拷贝一份副本
        System.arraycopy(b, 0, dest, 0, len);
        byte temp;
        // 将顺位第i个与倒数第i个交换
        for(int i=0;i<len;i+=2)
        {
            temp=dest[i];
            dest[i]=dest[i+1];
            dest[i+1]=temp;
        }
        return reverse(dest);
    }
    /**
     * byte[] 反序
     * @return
     */
    public static byte[] reverse(byte[] dest) {
        int l=dest.length;
        for(int i=0;i<=l/2-1;i++) { //首位调换
            byte temp=dest[i];
            dest[i]=dest[l-i-1];
            dest[l-i-1]=temp;
        }
        return dest ;
    }

    /**
     * int转byte[]
     *
     * @param a
     * @return
     */
    public static byte[] intToByteArray(int a) {
        return new byte[]{
                (byte) ((a >> 24) & 0xFF),
                (byte) ((a >> 16) & 0xFF),
                (byte) ((a >> 8) & 0xFF),
                (byte) (a & 0xFF)
        };
    }

    /**
     * int转byte[]3412顺序
     *
     * @param a
     * @return
     */
    public static byte[] intToByteSort(int a) {
        return new byte[]{
                (byte) ((a >> 8) & 0xFF),
                (byte) (a & 0xFF),
                (byte) ((a >> 24) & 0xFF),
                (byte) ((a >> 16) & 0xFF)

        };
    }

    /**
     * short转byte[]
     *
     * @param b
     * @param s
     * @param index
     */
    public static void byteArrToShort(byte b[], short s, int index) {
        b[index + 1] = (byte) (s >> 8);
        b[index + 0] = (byte) (s >> 0);
    }

    /**
     * byte[]转short
     *
     * @param b
     * @param index
     * @return
     */
    public static short byteArrToShort(byte[] b, int index) {
        return (short) (((b[index + 0] << 8) | b[index + 1] & 0xff));
    }
    /**
     * byte[]转short
     *
     * @param b
     * @param index
     * @return
     */
    public static int byteArrToUShort(byte[] b, int index) {
        return ((b[index + 0]& 0xff) << 8) +(b[index + 1] & 0xff);
    }

    /**
     * 两个字节byte[]转short
     *
     * @param b
     * @param index
     * @return
     */
    public static int byteArrToUShortTwoBytes(byte[] b, int index) {
        return (((b[index + 0]& 0xff) << 8) +(b[index + 1] & 0xfF)) & 0xffff;
    }

    /**
     * byte[]转short
     *
     * @param b
     * @param index
     * @return
     */
    public static int byteArrToReverseUShort(byte[] b, int index) {
        return ((b[index + 1]& 0xff) << 8) +(b[index + 0] & 0xff);
    }

    /**
     * byte[]转64位无符号long
     *
     * @param b
     * @param index
     * @return
     */
    public static long byteArrToUInt(byte[] b, int index) {
        int i = byteArrayToInt(b,index);
        if(i<0){
            return ((long)0xffffffff + 1)/2 -(long)i;
        }else {
            return i;
        }
    }

    /**
     * 16位short转byte[]
     *
     * @param s short
     * @return byte[]
     */
    public static byte[] shortToByteArr(short s) {
        byte[] targets = new byte[2];
        for (int i = 0; i < 2; i++) {
            int offset = (targets.length - 1 - i) * 8;
            targets[i] = (byte) ((s >>> offset) & 0xff);
        }
        return targets;
    }

    /**
     * byte[]转16位short
     *
     * @param b
     * @return
     */
    public static short byteArrToShort(byte[] b) {
        return byteArrToShort(b, 0);
    }
    /**
     * byte[]转16位short
     *
     * @param b
     * @return
     */
    public static int byteArrToUShort(byte[] b) {
        return byteArrToUShort(b, 0);
    }
    /**
     * long转byte[]
     *
     * @param x
     * @return
     */
    public static byte[] longToBytes(long x) {
        buffer.putLong(0, x);
        return buffer.array();
    }

    /**
     * byte[]转Long
     *
     * @param bytes
     * @return
     */
    public static long bytesToLong(byte[] bytes) {
        buffer.put(bytes, 0, bytes.length);
        buffer.flip();//need flip
        return buffer.getLong();
    }

    /**
     * 从byte[]中抽取新的byte[]
     *
     * @param data  - 元数据
     * @param start - 开始位置
     * @param end   - 结束位置
     * @return 新byte[]
     */
    public static byte[] getByteArr(byte[] data, int start, int end) {
        byte[] ret = new byte[end - start];
        for (int i = 0; (start + i) < end; i++) {
            ret[i] = data[start + i];
        }
        return ret;
    }

    /**
     * 流转换为byte[]
     *
     * @param inStream
     * @return
     */
  /*  @SneakyThrows
    public static byte[] readInputStream(InputStream inStream) {
        ByteArrayOutputStream outStream = null;
        try {
            outStream = new ByteArrayOutputStream();
            byte[] buffer = new byte[1024];
            byte[] data = null;
            int len = 0;
            while ((len = inStream.read(buffer)) != -1) {
                outStream.write(buffer, 0, len);
            }
            data = outStream.toByteArray();
            return data;
        } catch (IOException e) {
            return null;
        } finally {
            if (outStream != null) {
                outStream.close();
            }
            if (inStream != null) {
                inStream.close();
            }
        }
    }*/

    /**
     * byte[]转inputstream
     *
     * @param b
     * @return
     */
    public static InputStream readByteArr(byte[] b) {
        return new ByteArrayInputStream(b);
    }

    /**
     * byte数组内数字是否相同
     *
     * @param s1
     * @param s2
     * @return
     */
    public static boolean isEq(byte[] s1, byte[] s2) {
        int slen = s1.length;
        if (slen == s2.length) {
            for (int index = 0; index < slen; index++) {
                if (s1[index] != s2[index]) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    /**
     * byte数组转换为Stirng
     *
     * @param s1     -数组
     * @param encode -字符集
     * @param err    -转换错误时返回该文字
     * @return
     */
    public static String getString(byte[] s1, String encode, String err) {
        try {
            return new String(s1, encode);
        } catch (UnsupportedEncodingException e) {
            return err == null ? null : err;
        }
    }

    /**
     * byte数组转换为Stirng
     *
     * @param s1-数组
     * @param encode-字符集
     * @return
     */
    public static String getString(byte[] s1, String encode) {
        return getString(s1, encode, null);
    }


    /**
     * 字节数组转16进制字符串
     * 打日志使用 字节加空格
     *
     * @param b
     * @return
     */
    public static String byteArrToHexString(byte[] b) {
        return byteArrToHexString(b," ");
    }
    /**
     * 字节数组转16进制字符串
     * 打日志使用 字节加空格
     *
     * @param b
     * @return
     */
    public static String byteArrToHexString(byte[] b,String charStr) {
        String result = "";
        for (int i = 0; i < b.length; i++) {
            result += (Integer.toString((b[i] & 0xff) + 0x100, 16).substring(1) + charStr);
        }
        return result;
    }

    public static byte[] convertToASCII(String string) {
        char[] ch = string.toCharArray();
        byte[] tmp = new byte[ch.length];
        for (int i = 0; i < ch.length; i++) {
            tmp[i] = (byte) Integer.valueOf(ch[i]).intValue();
        }
        return tmp;
    }

    /**
     * 16进制字符创转int
     *
     * @param hexString
     * @return
     */
    public static int hexStringToInt(String hexString) {
        return Integer.parseInt(hexString, 16);
    }

    /**
     * 十进制转二进制
     *
     * @param i
     * @return
     */
    public static String intToBinary(int i) {
        return Integer.toBinaryString(i);
    }

    /**
     * 从十六进制字符串到字节数组转换
     *
     * @param hexstr
     * @return
     */
    public static byte[] hexString2Bytes(String hexstr) {
        hexstr = hexstr.replace(" ","");
        byte[] b = new byte[hexstr.length() / 2];
        int j = 0;
        for (int i = 0; i < b.length; i++) {
            char c0 = hexstr.charAt(j++);
            char c1 = hexstr.charAt(j++);
            b[i] = (byte) ((parse(c0) << 4) | parse(c1));
        }
        return b;
    }

    private static int parse(char c) {
        if (c >= 'a')
            return (c - 'a' + 10) & 0x0f;
        if (c >= 'A')
            return (c - 'A' + 10) & 0x0f;
        return (c - '0') & 0x0f;
    }

    /**
     * Byte转BCD字符串
     *
     * @param src
     * @return
     */
    public static String bcdToHexString(byte[] src) {
        StringBuilder stringBuilder = new StringBuilder("");
        if (src == null || src.length <= 0) {
            return null;
        }
        for (int i = 0; i < src.length; i++) {
            int v = src[i] & 0xFF;
            int v1 = v / 10;
            int v2 = v % 10;

            if (v >= 0 && v < 100) {
                stringBuilder.append(v1);
                stringBuilder.append(v2);
            }
        }
        return stringBuilder.toString();
    }

    /**
     * BCD转byte数组
     *
     * @param hexString
     * @return
     */
    public static byte[] bcdStringToBytes(String hexString) {
        if (hexString == null) {
            return null;
        }
        hexString = hexString.replace(" ", "");
        if (hexString.equals("") || hexString.length() % 2 != 0) {
            return null;
        }
        hexString = hexString.toUpperCase();
        int length = hexString.length() / 2;
        char[] hexChars = hexString.toCharArray();
        byte[] d = new byte[length];
        for (int i = 0; i < length; i++) {
            int pos = i * 2;
            d[i] = (byte) (charToByte(hexChars[pos]) * 10 + charToByte(hexChars[pos + 1]));
        }
        return d;
    }
    /** CRC 16 校验
     * @param data
     * @param startIndex
     * @param endIndex
     * @return
     */
    public static byte getModbusASCIICrc(byte[] data,int startIndex ,int endIndex) {
        byte result = 0;
        for (int i = startIndex; i <= endIndex; i++) {
            result+=data[i];
        }
        result = (byte) (256-result&0xff);
        return result;
    }
    /** CRC 16 校验
     * @param data
     * @param startIndex
     * @param endIndex
     * @return
     */
    public static byte[] getCrc(byte[] data,int startIndex ,int endIndex) {
        int CRC = 0x0000ffff;
        int POLYNOMIAL = 0x0000a001;

        int i, j;
        for (i = startIndex; i <= endIndex; i++) {
            CRC ^= ((int) data[i] & 0x000000ff);
            for (j = 0; j < 8; j++) {
                if ((CRC & 0x00000001) != 0) {
                    CRC >>= 1;
                    CRC ^= POLYNOMIAL;
                } else {
                    CRC >>= 1;
                }
            }
        }
        //获取低八位
        byte low = (byte) (CRC >> 8);
        //或者wcrc/256
        byte up = (byte) (CRC % 256);
        //获取高八位
        byte[] crc = {up, low};
        return crc;
    }

    /** 生成HJ212 2017 CRC  校验
     * @param src
     * @param len
     * @return
     */
    public static String crc16(String src, int len) {
        int crc = 0x0000FFFF;
        short tc;
        char sbit;
        for (int i = 0; i < len; i++) {
            tc = (short) (crc >>> 8);
            crc = ((tc ^ src.charAt(i)) & 0x00FF);
            for (int r = 0; r < 8; r++) {
                sbit = (char) (crc & 0x01);
                crc >>>= 1;
                if (sbit != 0)
                    crc = (crc ^ 0xA001) & 0x0000FFFF;
            }
        }
        String str=Integer.toHexString(crc);
        if(str.length()==3){
            return "0"+str.toUpperCase();
        }else if(str.length()==2){
            return "00"+str.toUpperCase();
        }else if(str.length()==1){
            return "000"+str.toUpperCase();
        }
        return str.toUpperCase();
    }
    public static byte[] byteMergerAll(byte[]... values) {
        int length_byte = 0;
        for (int i = 0; i < values.length; i++) {
            if(null == values[i]){
                continue;
            }
            length_byte += values[i].length;
        }
        byte[] all_byte = new byte[length_byte];
        int countLength = 0;
        for (int i = 0; i < values.length; i++) {
            if(null == values[i]){
                continue;
            }
            byte[] b = values[i];
            System.arraycopy(b, 0, all_byte, countLength, b.length);
            countLength += b.length;
        }
        return all_byte;
    }
    private static byte charToByte(char c) {
        return (byte) "0123456789ABCDEF".indexOf(c);
    }

    public static byte[] floatToByte(float val) {
        //转16进制
        int bit = Float.floatToIntBits(val);
        //排序
        int temp= sort(bit);
        byte[] b = new byte[4];
        for (int i = 0; i < 4; i++) {
            b[i] = (byte) (temp >> (24 - i * 8));
        }
        return b;

    }
/** *//**
     * @函数功能: BCD码转为10进制串(阿拉伯数据)
     * @输入参数: BCD码
     * @输出结果: 10进制串
     */
    public static String bcd2Str(byte[] bytes) {
        StringBuffer temp = new StringBuffer(bytes.length * 2);

        for (int i = 0; i < bytes.length; i++) {
            temp.append((byte) ((bytes[i] & 0xf0) >>> 4));
            temp.append((byte) (bytes[i] & 0x0f));
        }
        return temp.toString().substring(0, 1).equalsIgnoreCase("0") ? temp.toString().substring(1) : temp.toString();
    }
    public static String str2HexStr(byte[] bs) {

        char[] chars = "0123456789ABCDEF".toCharArray();
        StringBuilder sb = new StringBuilder("");
        int bit;

        for (int i = 0; i < bs.length; i++) {
            bit = (bs[i] & 0x0f0) >> 4;
            sb.append(chars[bit]);
            bit = bs[i] & 0x0f;
            sb.append(chars[bit]);
            sb.append(' ');
        }
        return sb.toString().trim();
    }

    /** 2143排序
     * @param
     * @param
     * @param
     * @return
     */
    private static int sort(int bit){

        byte byte4 = (byte) (bit & 0xff);
        byte byte3 = (byte) ((bit & 0xff00) >> 8);
        byte byte2 = (byte) ((bit & 0xff0000) >> 16);
        byte byte1 = (byte) ((bit & 0xff000000) >> 24);

        return (byte1& 0xff)<<8  |(byte2& 0xff) | (byte3& 0xff)<< 24| (byte4& 0xff)<<16 ;
    }

    public static byte[] byteMergerList(List<byte[]> byteList) {
        int length_byte = 0;
        for (int i = 0; i < byteList.size(); i++) {
            length_byte += byteList.get(i).length;
        }
        byte[] all_byte = new byte[length_byte];
        int countLength = 0;
        for (int i = 0; i < byteList.size(); i++) {
            byte[] b = byteList.get(i);
            System.arraycopy(b, 0, all_byte, countLength, b.length);
            countLength += b.length;
        }
        return all_byte;
    }

    /**
     * byte顺序 3412
     * @param bytes
     * @return
     */
    public static byte[] byteTo3412(byte[] bytes){
        // 建立一个与源数组元素类型相同的数组
        byte[] dest = new byte[bytes.length];
        // 为了防止修改源数组，将源数组拷贝一份副本
        System.arraycopy(bytes, 0, dest, 0, bytes.length);
        dest[0] = bytes[2];
        dest[1] = bytes[3];
        dest[2] = bytes[0];
        dest[3] = bytes[1];
        return dest;
    }
    //b为传入的字节，i为第几位（范围0-7），如要获取bit0，则i=0
    public static int getBit(byte b,int i) {
        int bit = (int) ((b >> i) & 0x1);
        return bit;
    }
    /**
     *
     * @param b 字节数据
     * @param index 读取位置索引
     * @param deviceInfo 当前设备对象
     * @return
     */
   /* public static float analysisFloat(byte[] b, int index, DeviceInfo deviceInfo){
        try {
            DeviceFloatOrderService deviceFloatOrderService = SpringContextUtil.getApplicationContext().getBean(DeviceFloatOrderService.class);
            DeviceFloatOrder d = deviceFloatOrderService.getByDeviceId(deviceInfo.getId());
            float value=0;
            //当库里未记录顺序时默认按4321顺序解析
            if(d==null || StringUtils.isEmpty(d.getFloatOrder())){
                value = ByteUtil.byteArrayToFloat3(b, index);
            }
            else {
                String floatOrder = d.getFloatOrder();
                //当顺序为1234时
                if(floatOrder.equals(FloatOrderEnum.ASC.getOrderBy())){
                    value = ByteUtil.byteArrayToFloat2(b, index);
                }
                //当顺序为4321时
                if(floatOrder.equals(FloatOrderEnum.DESC.getOrderBy())){
                    value = ByteUtil.byteArrayToFloat3(b, index);
                }
                //当顺序为2143时
                if(floatOrder.equals(FloatOrderEnum.SMALL_LOW_FRONT.getOrderBy())){
                    value = ByteUtil.byteArrayToFloat(b, index);
                }
                //当顺序为3412时
                if(floatOrder.equals(FloatOrderEnum.BIG_LOW_FRONT.getOrderBy())){
                    value = ByteUtil.byteArrayToFloat1(b, index);
                }
            }
            return value;
        }catch (Exception e){
            return 0f;
        }
       }

*/


    /**
     *计算解析float类型字节坐标索引
     * @param iONo 监测因子对应的路数
     * @return
     */
    public static int computeFloatIndex(String iONo){
        BigDecimal subtract = new BigDecimal(iONo).subtract(new BigDecimal("1"));
        BigDecimal multiply = subtract.multiply(new BigDecimal("4"));
        return new BigDecimal("3").add(multiply).intValue();
    }

    /**
     *计算解析ushort类型字节坐标索引
     * @param iONo 监测因子对应的路数
     * @return
     */
    public static int computeUshortIndex(String iONo){
        BigDecimal subtract = new BigDecimal(iONo).subtract(new BigDecimal("1"));
        BigDecimal multiply = subtract.multiply(new BigDecimal("2"));
        return new BigDecimal("3").add(multiply).intValue();
    }

    /**
     * float 转 double 保持精度
     * @param f float值
     * @return double值
     */
    public static Double floatToDouble(float f){
        try {
            BigDecimal bigDecimal = new BigDecimal(String.valueOf(f));
            return bigDecimal.doubleValue();
        }catch (Exception e){
            return BigDecimal.ZERO.doubleValue();
        }
    }

    /**
     * float 转 double 保持精度
     * @param f float值
     * @return double值
     */
    public static Integer floatToInt(float f){
        BigDecimal bigDecimal = new BigDecimal(String.valueOf(f));
        return bigDecimal.intValue();
    }

    /**
     * 处理数据段中标志位后无用的占位数据，返回纯数据段数组
     * @param datas 原始数据包
     * @param placeholder 占位符
     * @param flag 标志位
     * @param start 帧头数据位数
     * @param end 帧尾数据位数
     * @return byte[]处理后的数据段
     */
    public static byte[] getDataBytes(byte[] datas,byte flag,byte placeholder,int start,int end) {
        //处理原始数据包获取数据段
        ByteBuffer buffer1 = ByteBuffer.wrap(datas);
        byte[] bytes = new byte[datas.length-start-end];
        for (int i = 0; i < bytes.length; i++) {
            bytes[i]=buffer1.get(i+start);
        }
        //开始处理数据段
        ByteBuffer buffer = ByteBuffer.wrap(bytes);
        int b= 0;
        for (int i = 0; i <bytes.length ; i++) {
            buffer.put(bytes[i]);
            if(i>=bytes.length-1){
                break;
            }
            if(bytes[i] == flag && bytes[i+1] == placeholder ){
                i++;
                b++;
            }
        }
        //如果存在占位符，则返回处理后数组
        if(b != 0){
            byte[] validByte = new byte[buffer.position()];
            buffer.clear();
            buffer.get(validByte, 0, bytes.length-b);
            return validByte;
        }
        return bytes;
    }

    /**
     * byte转16进制String
     * @param data
     * @return
     */
    public static String byteArrToHexString(byte data) {

            String  i= Integer.toString((data & 0xff) + 0x100, 16).substring(1);

        return i;

    }

    /**
     * 4位BCD
     * @param data 数据
     * @return
     */
//    public static String byteToBCDStr(byte[] data){
//        return  BCD.bcdToStr(data);
//    }


    /**
     * 十进制数转16进制数字符串
     * @param n
     * @return
     */
    public static String intToHex(int n) {
        StringBuilder sb = new StringBuilder(8);
        String a;
        char []b = {'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
        while(n != 0){
            sb = sb.append(b[n%16]);
            n = n/16;
        }
        a = sb.reverse().toString();
        return a;
    }
    /**
     * byte数组转double正序
     * @param b
     * @return
     */
    public static double byteToDouble(byte[] b,int index)
    {
        long l;
        l = b[index];
        l &= 0xff;
        l |= ((long) b[1+index] << 8);
        l &= 0xffff;
        l |= ((long) b[2+index] << 16);
        l &= 0xffffff;
        l |= ((long) b[3+index] << 24);
        l &= 0xffffffffl;
        l |= ((long) b[4+index] << 32);
        l &= 0xffffffffffl;
        l |= ((long) b[5+index] << 40);
        l &= 0xffffffffffffl;
        l |= ((long) b[6+index] << 48);
        l &= 0xffffffffffffffl;
        l |= ((long) b[7+index] << 56);
        return Double.longBitsToDouble(l);
    }

    /**
     * byte数组转double倒叙
     * @param b
     * @return
     */
    public static double byteToDouble2(byte[] b,int index)
    {
        long l;
        l = ((long) b[index] >> 56);
        l &= 0xff ;
        l |= ((long) b[1+index] >> 48);
        l &= 0xffff;
        l |= ((long) b[2+index] >> 40);
        l &= 0xffffff;
        l |= ((long) b[3+index] >> 32);
        l &= 0xffffffffl;
        l |= ((long) b[4+index] >> 24);
        l &= 0xffffffffffl;
        l |= ((long) b[5+index] >> 16);
        l &= 0xffffffffffffl;
        l |= ((long) b[6+index] >> 8);
        l &= 0xffffffffffffffl;
        l |= (long)b[7+index];
        return Double.longBitsToDouble(l);
    }

//    public static double bytes2Double(byte[] bytes) {
//        long l = getLong(bytes);
//        return Double.longBitsToDouble(l);
//    }
    /**
     * 把byte转为字符串的bit
     */
    public static String byteToBit(byte b) {
        return ""
                + (byte) ((b >> 7) & 0x1) + (byte) ((b >> 6) & 0x1)
                + (byte) ((b >> 5) & 0x1) + (byte) ((b >> 4) & 0x1)
                + (byte) ((b >> 3) & 0x1) + (byte) ((b >> 2) & 0x1)
                + (byte) ((b >> 1) & 0x1) + (byte) ((b >> 0) & 0x1);
    }
}
