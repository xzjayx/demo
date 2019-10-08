package com.xz.demo.util.thread;

public class CreateThread {


    static class subClass extends Thread{

        @Override
        public void run(){
            Thread thread = new Thread(()-> System.out.println(Thread.currentThread().getThreadGroup().getName()));
            thread.start();
        }
    }

    public static void main(String[] args) {
        new subClass().start();
    }
}
