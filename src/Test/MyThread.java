package Test;

import javafx.application.Application;
import main.java.CBGui.LearnJavaFX.LearnListView;

import javax.swing.*;
import java.awt.*;

/**
 * 学习多线程
 */
public class MyThread extends Thread {


    @Override
    public void run() {
        super.run();

        Application.launch(LearnListView.class);

    }

    public static void main(String[] args) {

        MyThread myThread1 = new MyThread();
        ThreadNew threadNew = new ThreadNew();


        myThread1.start();
        threadNew.start();


    }
}
