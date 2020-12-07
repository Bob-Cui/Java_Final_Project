package main.java.LearnJava;

import java.util.HashMap;
import java.util.Map;

public class Teach {

    public static class Test {
        private int c;

        public int getC() {
            return c;
        }

        public void setC(int c) {
            this.c = c;
        }

        public Test(int c) {
            this.c = c;
        }
    }

    public static void change(Test a) {
        a.setC(100);


    }

    public static void learnHashMap() {
        HashMap<Integer, String> c = new HashMap<>();


        c.put(1, "dsfasdf");
        c.put(1903, "dsfsdfsadfdsaf");
        c.put(0, "dfasdfweqweqw");

        c.put(0, "2342342");
        for (Map.Entry<Integer, String> c1 : c.entrySet()) {
            System.out.println(c1.getKey() + "    " + c1.getValue());
        }


    }

    public static void learnHashMap2() {
        HashMap<Integer, Test> c = new HashMap<>();


        c.put(1, new Test(100));
        c.put(1903, new Test(200));
        c.put(0, new Test(300));

        c.get(1).setC(2000);


        System.out.println(c.get(1).getC());




    }


    public static void main(String[] args) {
        learnHashMap2();


    }
}
