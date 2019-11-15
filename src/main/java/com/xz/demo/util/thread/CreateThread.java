package com.xz.demo.util.thread;

public class CreateThread {


    static class subClass extends Thread{

        @Override
        public void run(){
            System.out.println(Thread.currentThread().getName());
            new Thread(()-> System.out.println(Thread.currentThread().getName())).start();
        }
    }

    public static void main(String[] args) {
        new subClass().start();
    }
}
