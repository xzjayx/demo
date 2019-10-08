package com.xz.demo.util.thread;

public  class  SynchronizedTest implements Runnable{

    private static  int i = 0;

    private synchronized void say1(){

        for (int j=0;j<100000;j++){
            i++;
        }
        System.out.println(i);
    }


    @Override
    public void run() {
        say1();
    }

    public static void main(String[] args) {
        SynchronizedTest synchronizedTest1 = new SynchronizedTest();
        Thread thread1 = new Thread(synchronizedTest1);

        SynchronizedTest synchronizedTest2 = new SynchronizedTest();
        Thread thread2 = new Thread(synchronizedTest2);

        thread1.start();
        thread2.start();

    }


}
