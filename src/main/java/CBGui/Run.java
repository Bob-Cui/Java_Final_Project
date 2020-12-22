package main.java.CBGui;

import DataManager.XcyDataBase;
import javafx.application.Application;

import java.sql.SQLException;
import java.util.Date;

/**
 * 整个项目开始运行的入口
 */
public class Run {
    /**
     * main含糊
     *
     * @param args 不需要知道为啥的参数
     */
    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        /**
         * 注意程序是要记录时间的，这一点很重要
         */
        Date begin = new Date();

        Application.launch(XCYApplication.class, args);

        /**
         * 在程序结束时将数据写回
         *注意这里的时间是按照秒来计时的
         */
        Date end = new Date();
        long timeSpan = (end.getTime() - begin.getTime()) / 1000;


        System.out.println(timeSpan);



        XCYApplication.thisUser.setTimeSpan(XCYApplication.thisUser.getTimeSpan() + timeSpan);
        XcyDataBase.alterConfigFile(XCYApplication.thisUser);
    }
}
