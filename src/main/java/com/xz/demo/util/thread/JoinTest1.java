package com.xz.demo.util.thread;

public class JoinTest1 {

    public static void main(String[] args) {
        System.out.println("MainThread start");
        Thread thread = new Thread(() -> {

            System.out.println("Thread start");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Thread finished");
        });
        thread.start();

        System.out.println("MainThread join before");
        try {
            //由于在main中调用了线程 join()方法 则main线程等待 thread线程运行完毕之后，才会在执行main线程
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("MainThread run finished");

    }
}
