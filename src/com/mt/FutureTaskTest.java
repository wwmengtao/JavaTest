package com.mt;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

public class FutureTaskTest {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newCachedThreadPool();
        Task task = new Task();
        //直接提交Callable
        Future<Integer> result = executor.submit(task);
        //提交FutureTask，参数为Callable
        FutureTask<Integer> futureTask = new FutureTask<Integer>(task);
        executor.submit(futureTask);
        //关闭线程池
        executor.shutdown();
         
        try {
            System.out.println("task运行结果"+result.get());
            System.out.println("futureTask运行结果"+futureTask.get());            
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
         
    }
}
class Task implements Callable<Integer>{
    @Override
    public Integer call() throws Exception {
        Thread.sleep(1000);
        int sum = 0;
        for(int i=0;i<100;i++)
            sum += i;
        return sum;
    }
}
