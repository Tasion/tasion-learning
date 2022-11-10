package com.tasion.thread;

import java.util.concurrent.*;

public class CallableRunnableTest {
    /**
     *  Runnable和 Callable有什么区别？
     *      1.Runnable接口中的run()方法没有返回值，是void类型，它做的事情只是纯粹地去执行run()方法中的代码而已
     *      2.Callable接口中的call()方法是有返回值的，是一个泛型。它一般配合Future、FutureTask一起使用，用来获取异步执行的结果
     *      3.Callable接口call()方法允许抛出异常；而Runnable接口run()方法不能继续上抛异常
     */
    public static void main(String[] args) {
        ExecutorService executorService= Executors.newFixedThreadPool(5);

        Callable<String> callable=new Callable<String>() {
            @Override
            public String call() throws Exception {
                return "你好，callable";
            }
        };
        //支持泛型
        Future<String> futureCallable=executorService.submit(callable);
        try {
            System.out.println("获取callable的返回结果："+futureCallable.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        //Runnable
        Runnable runnable=new Runnable() {
            @Override
            public void run() {
                System.out.println("你好，Runnable");
            }
        };
        Future<?> futureRunnable = executorService.submit(runnable);
        try {
            System.out.println("获取runnable的返回结果："+futureRunnable.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        //关闭线程资源
        executorService.shutdown();
    }
}
