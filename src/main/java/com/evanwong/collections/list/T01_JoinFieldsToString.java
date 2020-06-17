package com.evanwong.collections.list;

import com.evanwong.assist.ModelAssist;
import com.evanwong.models.User;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Admin
 */
public class T01_JoinFieldsToString {

    public static void main(String[] args) {
        try {
            List<User> userList = ModelAssist.getUserList(10);

            /*String s = joinFields(userList, "name", ",");
            System.out.println(s);*/

            List<String> sList = joinFieldsByInterval(userList, "age", ",", 3);
            for (String s: sList) {
                System.out.println(s);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 把集合中所有对象的某一个字段，按指定分隔符串联
     *
     * @param objectList
     * @param fieldName
     * @param separator
     * @return
     */
    public static String joinFields(List<?> objectList, String fieldName, String separator) {
        try {
            StringBuffer sb = new StringBuffer();
            for (Object o : objectList) {

                Field field = o.getClass().getDeclaredField(fieldName);
                field.setAccessible(true);
                sb.append(String.valueOf(field.get(o)));

                // 非尾元素
                if (objectList.indexOf(o) < (objectList.size() - 1)) {
                    sb.append(separator);
                }
            }
            return sb.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


    /**
     *  集合分组串联对象字段
     *
     * @param objectList
     * @param fieldName
     * @param separator
     * @param interval
     * @return
     */
    public static List<String> joinFieldsByInterval(List<?> objectList, String fieldName, String separator, int interval) {
        try {
            List<String> result = new ArrayList<String>();

            // 分段数量
            int sections = objectList.size() % interval == 0 ? objectList.size() / interval : objectList.size() / interval + 1;

            for (int i = 0; i < sections; i++) {

                // 计算子集合开始下标，结束下标
                int startIndex = i * interval;
                int endIndex = startIndex + interval;

                // 如果是最后一段
                if (i == sections - 1) {
                    endIndex = objectList.size();
                }

                List<?> subList = objectList.subList(startIndex, endIndex);
                String s = joinFields(subList, "name", "','");

                result.add(s);
            }

            return result;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
