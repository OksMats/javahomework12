package org.example;
import java.util.Scanner;


public class FizzBuzzClass {
    private int n;
    private int current;
    private Object lock;

    public FizzBuzzClass(int n) {
        this.n = n;
        this.current = 1;
        this.lock = new Object();
    }

    public void fizz() {
        synchronized (lock) {
            if (current > n) return;
            if (current % 3 == 0 && current % 5 != 0) {
                System.out.println("fizz");
                current++;
            }
        }
    }

    public void buzz() {
        synchronized (lock) {
            if (current > n) return;
            if (current % 3 != 0 && current % 5 == 0) {
                System.out.println("buzz");
                current++;
            }
        }
    }

    public void fizzbuzz() {
        synchronized (lock) {
            if (current > n) return;
            if (current % 15 == 0) {
                System.out.println("fizzbuzz");
                current++;
            }
        }
    }

    public void number() {
        synchronized (lock) {
            if (current > n) return;
            if (current % 3 != 0 && current % 5 != 0) {
                System.out.println(current);
                current++;
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введіть n: ");
        int n = scanner.nextInt();

        FizzBuzzClass fizzBuzz = new FizzBuzzClass(n);

        Thread threadA = new Thread(() -> {
            while (true) {
                fizzBuzz.fizz();
            }
        });

        Thread threadB = new Thread(() -> {
            while (true) {
                fizzBuzz.buzz();
            }
        });

        Thread threadC = new Thread(() -> {
            while (true) {
                fizzBuzz.fizzbuzz();
            }
        });

        Thread threadD = new Thread(() -> {
            while (true) {
                fizzBuzz.number();
            }
        });

        threadA.start();
        threadB.start();
        threadC.start();
        threadD.start();
    }
}
