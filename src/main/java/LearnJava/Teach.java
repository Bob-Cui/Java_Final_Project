package main.java.LearnJava;

import javax.swing.table.TableRowSorter;
import java.util.HashMap;
import java.util.Map;

public class Teach {

    private int n;

    public Teach(int n) {
        this.n = n;
    }

    public static void main(String[] args) {
        Teach teach = new Teach(10);
        teach.n = 100;
        System.out.println(teach.n);


    }
}
