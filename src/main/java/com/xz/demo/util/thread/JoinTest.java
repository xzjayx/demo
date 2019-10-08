package com.xz.demo.util.thread;


/**
 *
 * join（）方法  ：如果一个线程A调用了 B线程的join（）方法，则让出CPU的执行权，让B线程执行完毕之后 A才接着执行
 * */
public class JoinTest {

    static class JumpQueue implements Runnable{

        private Thread thread;

        public JumpQueue(Thread thread){
            this.thread = thread;
        }

        @Override
        public void run() {
            try {
                //此时构造初始完毕 thread 传入进来是主线程main 则main执行完毕之后当先子线程0才能拿到返回对象 0 继续执行，否则一直等待main执行
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+" terminate subclass");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread previous = Thread.currentThread();
        //首先第一步获取得到的previous是主线程
        for(int i= 0;i<10;i++){
            Thread thread = new Thread(new JumpQueue(previous),String.valueOf(i));
            //第一次得到的是子线程 thread [0 ,5,main] 线程主是main线程
            System.out.println(previous.getName()+" jump a queue the thread :"+thread.getName());
            //所以第一次打印 main  jump a queue the thread : 0
            thread.start();
            previous = thread;
        }
        Thread.sleep(2000);
        System.out.println(Thread.currentThread().getName()+" terminate class");
    }
}

