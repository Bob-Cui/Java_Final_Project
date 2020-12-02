package Test;

public class ThreadNew extends Thread{


    @Override
    public void run() {
        super.run();

        for (int i = 0; i < 100; i++) {
            System.out.println(i);
        }

    }
}

