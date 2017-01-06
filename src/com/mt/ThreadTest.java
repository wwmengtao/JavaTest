package com.mt;

import static com.mt.MyThread.SLEEP_TIME;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadTest {
	public static void main(String []args){
		new ThreadTest();
	}
	
	public ThreadTest(){
		boolean useExecutor = true;
		BlockingQueue<Runnable> taskQueue = new LIFOLinkedBlockingDeque<Runnable>();
		Executor mExecutor = new ThreadPoolExecutor(1, 1, 0L, TimeUnit.MILLISECONDS, taskQueue);
		MyThread mMyThread = new MyThread();
		threadInfo(Thread.currentThread());
		threadInfo(mMyThread);
		if(useExecutor){
			mExecutor.execute(mMyThread);
		}else{
			mMyThread.start();
		}
		
		try {
			long sleepTime = (long) (SLEEP_TIME*0.09);
			ALog.Log("sleepTime:"+sleepTime);
			Thread.sleep(sleepTime);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if(useExecutor){
			((ExecutorService) mExecutor).shutdownNow();
		}else{
			mMyThread.interrupt();
		}

	}
	
	public static void threadInfo(Thread t){
		ALog.Log("getName:"+t.getName()+" getId:"+t.getId()+" Info:"+t);
	}
}
