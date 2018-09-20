package com.zhy.collector.util;

/**
 * 高频方法集合类
 */
public class DataUtil {
    public static String getCrc16(byte[] arr_buff) {
        int len = arr_buff.length;
        //预置 1 个 16 位的寄存器为十六进制FFFF, 称此寄存器为 CRC寄存器。
        int crc = 0xFFFF;
        int i, j;
        for (i = 0; i < len; i++) {
            //把第一个 8 位二进制数据 与 16 位的 CRC寄存器的低 8 位相异或, 把结果放于 CRC寄存器
            crc = ((crc & 0xFF00) | (crc & 0x00FF) ^ (arr_buff[i] & 0xFF));
            for (j = 0; j < 8; j++) {
                //把 CRC 寄存器的内容右移一位( 朝低位)用 0 填补最高位, 并检查右移后的移出位
                if ((crc & 0x0001) > 0) {
                    //如果移出位为 1, CRC寄存器与多项式A001进行异或
                    crc = crc >> 1;
                    crc = crc ^ 0xA001;
                } else
                    //如果移出位为 0,再次右移一位
                    crc = crc >> 1;
            }
        }
        return Integer.toHexString(crc).substring(2, 4) + Integer.toHexString(crc).substring(0, 2);
    }
    public static byte[] getString16ToBytes(String hexString) {
        hexString = hexString.replaceAll(" ", "");
        int len = hexString.length();
        int index = 0;
        byte[] bytes = new byte[len / 2];
        while (index < len) {
            String sub = hexString.substring(index, index + 2);
            bytes[index/2] = (byte)Integer.parseInt(sub,16);
            index += 2;
        }
        return bytes;
    }
    public static String ByteArray2hexStr(byte byteArray[])
    {
        String strHex="";

        for(byte b : byteArray)
            strHex+=String.format("%02x", b);
        return strHex;
    }
    /*
     * 字节转10进制
     */
    public static int byte2Int(byte b){
        int r = (int) b;
        return r;
    }

    /*
     * 10进制转字节
     */
    public static byte int2Byte(int i){
        byte r = (byte) i;
        return r;
    }
    /*
     * 字节数组转16进制字符串
     */
    public static String bytes2HexString(byte[] b) {
        String r = "";

        for (int i = 0; i < b.length; i++) {
            String hex = Integer.toHexString(b[i] & 0xFF);
            if (hex.length() == 1) {
                hex = '0' + hex;
            }
            r += hex.toUpperCase();
        }

        return r;
    }
    /*
     * 字符转换为字节
     */
    private static byte charToByte(char c) {
        return (byte) "0123456789ABCDEF".indexOf(c);
    }

    /*
     * 16进制字符串转字节数组
     */
    public static byte[] hexString2Bytes(String hex) {

        if ((hex == null) || (hex.equals(""))){
            return null;
        }
        else if (hex.length()%2 != 0){
            return null;
        }
        else{
            hex = hex.toUpperCase();
            int len = hex.length()/2;
            byte[] b = new byte[len];
            char[] hc = hex.toCharArray();
            for (int i=0; i<len; i++){
                int p=2*i;
                b[i] = (byte) (charToByte(hc[p]) << 4 | charToByte(hc[p+1]));
            }
            return b;
        }

    }
    /*
     * 字节数组转字符串
     */
    public static String bytes2String(byte[] b) throws Exception {
        String r = new String (b,"UTF-8");
        return r;
    }
    /*
     * 字符串转字节数组
     */
    public static byte[] string2Bytes(String s){
        byte[] r = s.getBytes();
        return r;
    }
    /*
     * 16进制字符串转字符串
     */
    public static String hex2String(String hex) throws Exception{
        String r = bytes2String(hexString2Bytes(hex));
        return r;
    }
    /*
     * 字符串转16进制字符串
     */
    public static String string2HexString(String s) throws Exception{
        String r = bytes2HexString(string2Bytes(s));
        return r;
    }
    /**
     * byte数组转换为二进制字符串,每个字节以","隔开
     * **/
    public static String conver2HexStr(byte [] b)
    {
        StringBuffer result = new StringBuffer();
        for(int i = 0;i<b.length;i++)
        {
            result.append(Long.toString(b[i] & 0xff, 2)+",");
        }
        return result.toString().substring(0, result.length()-1);
    }

    /**
     * byte转换为十六进制
     * **/
    public static String conver2HexStr(byte b)
    {
        String s = Integer.toHexString(b & 0xFF);
        return s.length()==1? ("0"+s) : s;
    }

    /**
     * byte数组转换为二进制字符串,每个字节以","隔开
     * **/
    public static String conver2HexStr8Bit(byte [] b)
    {
        StringBuffer result = new StringBuffer();
        for(int i = 0;i<b.length;i++)
        {
            result.append(convert2HexStr8Bit(b[i])+",");
        }
        return result.toString().substring(0, result.length()-1);
    }

    /***
     * 转换成8位二进制字符串
     * @param b
     * @return
     */
    public static String convert2HexStr8Bit(byte b){
        StringBuffer s = new StringBuffer();
        s.append((b>>7)&1).append((b>>6)&1).append((b>>5)&1).append((b>>4)&1).append((b>>3)&1).append((b>>2)&1).append((b>>1)&1).append(b&1);
        return s.toString();
    }

    /**
     * 二进制字符串转换为byte数组,每个字节以","隔开
     * **/
    public static byte[] conver2HexToByte(String hex2Str) {
        String[] temp = hex2Str.split(",");
        byte[] b = new byte[temp.length];
        for (int i = 0; i < b.length; i++) {
            b[i] = Long.valueOf(temp[i], 2).byteValue();
        }
        return b;
    }

    /**
     * 二进制字符串转换为byte数组,每个字节以regex隔开
     * **/
    public static byte[] conver2HexToByte(String hex2Str, String regex) {
        String[] temp = hex2Str.split(regex);
        byte[] b = new byte[temp.length];
        for (int i = 0; i < b.length; i++) {
            b[i] = Long.valueOf(temp[i], 2).byteValue();
        }
        return b;
    }

    /**
     * 获取8位二进制字节第n位
     * @param bit
     * @return
     */
    public static int getBinaryBit(byte b, int bit){
        if(bit > 8 || bit < 0){
            try {
                throw new Exception("字节位数必须在1-8（包含）之间");
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return (b>>(bit-1))&1;
    }

    public static void main(String[] args){
        /*int[] data = new int[]{40051,40052,40053,40057,40058,40059,40060,40061,40062,40063,40065,40066,40067,40068,40069,40070,40096,
                40097,40098,40071,40072,40073,40099,40100,40074};
        for(int i = 0 ; i < data.length; i++){
            System.out.println(Integer.toHexString((data[i] - 40000) & 0xFFFF));
        }*/
        System.out.println(hexString2Byte("16"));
    }

    private static void test4Byte2Int(){
        byte[] data = new byte[4];
        data[0] = 0;
        data[1] = 1;
        data[2] = 1;
        data[3] = 2;
        int flag = 0x00000602;
        for(int i = 0; i < data.length; i++) {
            System.out.println((data[i] & 0xFFFFFFFF) << (((3-i)*8)));
            flag += ((data[i] & 0xFFFFFFFF) << ((3-i)*8));
        }
        System.out.println(flag);
        System.out.print(bytes2HexString(data));
    }

    private static void testByte2Double(){
        byte[] data = new byte[]{26,00,00,00};
        StringBuffer s = new StringBuffer();
        for (int i = data.length; i > 0 ; i--)
        {
            if(i == 1){
                s.append(".");
            }
            s.append(data[i-1]==0 ? "00" : data[i-1]);
            System.out.println(data[i-1]==0 ? "00" : data[i-1]);
        }
        System.out.println(s.toString());
        System.out.print( Double.parseDouble(s.toString()));
    }

    public static byte getCs_code(byte[] b){
        int result = 0;
        for(int i = 0 ; i < b.length; i++){
            result += (b[i]%256);
            if(result > 256){
                result = (result % 256);
            }
        }
        return (byte)result;
    }

    /**
     * 16进制字符串转字节
     * @param hex
     * @return
     */
    public static byte hexString2Byte(String hex) {
        if ((hex == null) || (hex.equals(""))){
            return 0;
        }
        else if (hex.length()%2 != 0){
            return 0;
        }
        else{
            hex = hex.toUpperCase();
            int len = hex.length()/2;
            byte b = 0;
            char[] hc = hex.toCharArray();
            for (int i=0; i<len; i++){
                b = (byte) (charToByte(hc[i]) << 4 | charToByte(hc[i+1]));
            }
            return b;
        }
    }
}