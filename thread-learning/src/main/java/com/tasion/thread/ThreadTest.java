package com.tasion.thread;

import org.springframework.scheduling.concurrent.CustomizableThreadFactory;

import java.util.concurrent.*;

public class ThreadTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException{
        //1.继承Thread方式
//        Thread threade=new myThread();
//        threade.start();
        //2.实现Runnable接口方式
//        myRunnable runnable=new myRunnable();
//        Thread thread=new Thread(runnable);
//        thread.start();
        //3.实现Callable接口方式
//        myCallable mc = new myCallable();
//        FutureTask<Integer> ft = new FutureTask<>(mc);
//        Thread thread = new Thread(ft);
//        thread.start();
//        System.out.println(ft.get());
        //4.测试线程池方式
        ThreadPoolExecutor poolExecutor=new ThreadPoolExecutor(5, 5, 1,
                TimeUnit.MINUTES, new ArrayBlockingQueue<Runnable>(20), new CustomizableThreadFactory("Tasion-Thread-pool"));
        poolExecutor.execute(()->{
            System.out.println("测试线程池方式");
        });
        poolExecutor.shutdown();
    }
}
class myThread extends Thread{
    @Override
    public void run() {
        System.out.println("测试继承Thread方式·····");
    }
}

class myRunnable implements Runnable{
    @Override
    public void run() {
        System.out.println("测试实现Runnable接口方式·····");
    }
}

class myCallable implements Callable{
    @Override
    public String call() throws Exception {
        return "测试实现Callable接口方式·····";
    }
}