package com.zhy.collector.util;

/**
 * @author : zengqiang
 * @version V1.0
 * @Project: DataCollector
 * @Package com.shoujiang.platform.base.util
 * @Description: TODO
 * @date Date : 2018年08月30日 11:51
 */
public class TestUtil {
//    private static Map<Integer, Boolean> map = new HashMap<Integer, Boolean>();
    public static void main(String[] args){

        Integer.parseInt("40074");
//        StringBuffer s = new StringBuffer();
//        byte[] b = new byte[]{0xFE,0x68,0x05,(byte)0x85,(byte)0x81,0x16,0x00,0x00,0x68,(byte)0x91,0x06,0x33,0x34,0x34,0x35,(byte)0xBC,0x55,0x69,0x16};
//        for(int i = 0 ; i < b.length; i++){
//            String bStr = Integer.toHexString(b[i] & 0xFF);
//            s.append(bStr.length() == 1 ? "0"+bStr : bStr);
//        }
//        String s = "FE 68 05 85 81 16 00 00 68 91 06 33 34 34 35 BC 55 69 16";
//        System.out.println(s.toString());
//        testPattern(s.toString());
//        System.out.println("testCs_code : "+testCs_code(b));
//            byte[] b = new byte[]{0x20,0x03,0x04,0x00,0x00,0x00,0x01,0x0A,(byte)0xF1};
//            System.out.println("testModebusPattern : "+testModbusPattern(b));
//            System.out.println("testModbusCsCode() :  "+testModbusCsCode(b));
//        byte[] b = new byte[]{(byte)0xFE,0x68,0x05,(byte)0x85,(byte)0x81,0x16,0x00,0x00,0x68,(byte)0x91,0x06,0x33,0x34,0x34,0x35,(byte)0xBC,0x55,0x69,0x16};
//        byte start_flag1 = b[1];
//        byte start_flag2 = b[8];
//        byte end_flag = b[b.length - 1];
//        System.out.println((start_flag1 == 0x68) && (start_flag2 == 0x68) && (end_flag == 0x16));
//        System.out.println(DataUtil.ByteArray2hexStr(b));

    }

    /*public static boolean testPattern(String s){
        String regex = "^fe68[0-9a-f]{12}68([0-9a-f][0-9a-f]){7,}16";
        Pattern pattern = Pattern.compile(regex);
        Matcher match = pattern.matcher(s);
        System.out.println("match result : "+match.matches());
        if(match.matches()){
            return true;
        }
        return false;
    }*/

    /*public static boolean testCs_code(byte[] b){
        int length = b.length - 2;
        byte[] csBytes = new byte[length];
        for(int i = 0 ; i < csBytes.length; i++){
            csBytes[i] = b[i];
        }
        byte cs_code = DataUtil.getCs_code(csBytes);
        if((cs_code & 0xFF) == b[length]){
            return true;
        }
        return false;
    }*/

    /*public static boolean testModbusPattern(byte[] data){
        //1.基本长度判断
        if(data.length < 7){
            return false;
        }
        //2.数据域必须是2的倍数
        if((data.length - 7)%2 != 0){
            return false;
        }
        StringBuffer s = new StringBuffer();
        for(int i = 0 ; i < data.length; i++){
            String hexStr = data[i] == 0 ? "00" :Integer.toHexString(data[i] & 0xFF);
            s.append(hexStr.length() == 1 ? "0"+hexStr : hexStr);
        }
        String regex = "[0-9a-f]{14,}";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(s.toString());
        return matcher.matches();
    }*/

    /*public static boolean testModbusCsCode(byte[] data){
        int length = data.length - 2;
        byte[] b = new byte[length];
        for(int i = 0 ; i < b.length; i++){
            b[i] = data[i];
        }
        String cs_code = DataUtil.getCrc16(b);
        System.out.println("cs code : "+cs_code);
        StringBuffer s = new StringBuffer();
        String cs1 = data[length] == 0 ? "00" :Integer.toHexString(data[length] & 0xFF);
        s.append(cs1.length() == 1 ? "0"+cs1 : cs1);
        String cs2 = data[length] == 0 ? "00" :Integer.toHexString(data[length+1] & 0xFF);
        s.append(cs2.length() == 1 ? "0"+cs2 : cs2);
        System.out.println(" return cs code : "+s.toString());
        if(s.toString().equals(cs_code)){
            return true;
        }
        return false;
    }*/

    /*public static void testMap(){
        for(int i = 0 ; i < 10; i++){
            map.put(i, true);
        }

        for(int i = 0 ; i < 10; i++ ){
            if(i%2 == 0){
                Boolean flag = map.get(i);
                flag = false;
                map.put(i, flag);
            }
        }
        for(Iterator<Boolean> it = map.values().iterator(); it.hasNext();){
            System.out.println(it.next()+" ");
        }
    }*/
}
