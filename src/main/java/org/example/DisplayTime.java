package org.example;
import java.util.concurrent.TimeUnit;

public class DisplayTime {
    public static void main(String[] args) {
        Thread Thread1 = new Thread(() -> {
            int seconds = 1;
            while (true) {
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                if(seconds%5!=0){System.out.println(seconds);}

                seconds +=1;
            }
        });
        Thread Thread2 = new Thread(() -> {
            int seconds = 5;
            while (true) {
                try {
                    TimeUnit.SECONDS.sleep(5);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("Минуло " + seconds + " секунд");
                seconds +=5;
            }
        });

        Thread1.start();
        Thread2.start();
    }

}
