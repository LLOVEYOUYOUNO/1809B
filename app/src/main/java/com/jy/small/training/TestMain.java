package com.jy.small.training;

/*
 * created by taofu on 2019/5/13
 **/
public class TestMain {

    private static int count = 0;

    private static ThreadLocal<String> threadLocal = new ThreadLocal<>();
    public static void main(String args []){

        threadLocal.set("thread main , zhangsan");
        System.out.println("thread main  : " + threadLocal.get());


        new Thread(new Runnable() {
            @Override
            public void run() {
                threadLocal.set("thread 0 lisi");
                System.out.println("thread 0 : " + threadLocal.get());
            }
        }).start();

    new Thread(new Runnable() {
        @Override
        public void run() {
            System.out.println("thread 2  : " + threadLocal.get());
        }
    }).start();

    }
}
