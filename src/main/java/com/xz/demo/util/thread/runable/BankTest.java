package com.xz.demo.util.thread.runable;

public class BankTest {


    public static void main(String[] args) {

        TicketWindow ticketWindow = new TicketWindow();

        Thread thread =  new Thread(ticketWindow,"窗口一");

        Thread thread1 =  new Thread(ticketWindow,"窗口二");

        Thread thread2 =  new Thread(ticketWindow,"窗口三");


        thread.start();
        thread1.start();
        thread2.start();




    }
}
