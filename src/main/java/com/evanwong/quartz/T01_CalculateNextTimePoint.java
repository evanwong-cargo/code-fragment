package com.evanwong.quartz;

import org.springframework.scheduling.support.CronSequenceGenerator;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class T01_CalculateNextTimePoint {

    public static void main(String[] args) {
        try {

            //每个五分钟执行一次
            final String PER_5_MIN = "0 */3 * * * ?";

            getNextTimePoint(PER_5_MIN);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Date getNextTimePoint(String cronExpresion) {
        try {

            CronSequenceGenerator cronSequenceGenerator = new CronSequenceGenerator(cronExpresion);

            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd:HH:mm:ss");

            // 当前时间
            Date currentTime = new Date();
            System.out.println("currentTime: " + dateFormat.format(currentTime));

            // 时间线对齐
            Date timeLineAlign = cronSequenceGenerator.next(currentTime);
            System.out.println("timeLineAlign: " + dateFormat.format(timeLineAlign));

            // 下下次执行时间
            Date nextTime1 = cronSequenceGenerator.next(timeLineAlign);
            System.out.println("nextTime1: " + dateFormat.format(nextTime1));

            // 下下次执行时间
            Date nextTime2 = cronSequenceGenerator.next(nextTime1);
            System.out.println("nextTime2: " + dateFormat.format(nextTime2));

            // 下下次执行时间
            Date nextTime3 = cronSequenceGenerator.next(nextTime2);
            System.out.println("nextTime3: " + dateFormat.format(nextTime3));

            // 下下次执行时间
            Date nextTime4 = cronSequenceGenerator.next(nextTime3);
            System.out.println("nextTime4: " + dateFormat.format(nextTime4));

            return timeLineAlign;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


}
