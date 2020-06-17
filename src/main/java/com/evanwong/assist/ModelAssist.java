package com.evanwong.assist;

import com.evanwong.models.User;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Admin
 */
public class ModelAssist {

    public static void main(String[] args) {
        try {
            List<User> userList = getUserList(10);

            for (User u : userList) {
                System.out.println(u.getName() + " " + u.getHeight());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static List<User> getUserList(int listSize) {

        List<User> result = new ArrayList<>();

        for (int i = 0; i < listSize; i++) {
            User u = new User();

            u.setName("name-" + i);
            u.setAge(i);
            u.setGender(i % 2 == 0 ? "M" : "F");
            u.setHeight(Double.parseDouble(i + "." + i));

            result.add(u);
        }

        return result;
    }

}
