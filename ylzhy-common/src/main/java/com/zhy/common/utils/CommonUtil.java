package com.zhy.common.utils;

import net.sf.json.JSONObject;

import java.util.List;
import java.util.Map;

/**
 * @author : zengqiang
 * @version V1.0
 * @Project: DataCollector
 * @Package com.shoujiang.platfor.base.util
 * @Description: 工具类
 * @date Date : 2018年08月21日 15:28
 */
public class CommonUtil {

    public static boolean isNull(Object obj){
        if(obj == null){
            return true;
        }
        return false;
    }

    /**
     * 判断集合是否为空
     */
    public static boolean isEmpty(List list){
        if(isNull(list)){
            return true;
        }
        return list.isEmpty();
    }

    /**
     * 判断集合是否为空
     */
    public static boolean isEmpty(Map map){
        if(isNull(map)){
            return true;
        }
        return map.isEmpty();
    }

    public static int getValue(Integer value){
        return  isNull(value) ? 0 : value.intValue();
    }

    public static float getFloatValue(Integer value){
        return  isNull(value) ? 0 : value.floatValue();
    }

    public static double getDoubleValue(Integer value){
        return  isNull(value) ? 0 : value.doubleValue();
    }

    public static double getValue(Double value){
        return  isNull(value) ? 0 : value.doubleValue();
    }

    public static void add2Json(JSONObject obj, String key, List list){
        obj.put(key, isEmpty(list)? "": list);
    }

    public static void add2Json(JSONObject obj, String key, Map map){
        obj.put(key, isEmpty(map)? "": map);
    }


    public static String getValue(String s) {
        return isNull(s) ? "" : s;
    }

    public static String getString(Object obj) {
        return isNull(obj) ? null : obj.toString();
    }

    public static Long getLong(String str) {
        return isNull(str) ? null : Long.parseLong(str);
    }
}
