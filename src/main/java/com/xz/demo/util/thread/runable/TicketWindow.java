package com.xz.demo.util.thread.runable;

public class TicketWindow implements Runnable{

    private static  final  int MAX = 100;

    private static int ticket = 0;

    @Override
    public void run() {

        while (ticket < MAX){
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
           //System.out.println(Thread.currentThread().getName() + "正在出售第" + (ticket+1) + "张票");

            System.out.println(Thread.currentThread().getName() + "正在出售第" + ++ticket + "张票");

           //ticket++;
        }
    }

}
