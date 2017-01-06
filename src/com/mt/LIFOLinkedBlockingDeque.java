package com.mt;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import static com.mt.MyThread.*;

public class LIFOLinkedBlockingDeque<T> extends LinkedBlockingDeque<T> {
	private static final long serialVersionUID = -4114786347960826192L;


	@Override
	public boolean offer(T e) {
		ALog.Log("LIFO: offer");
		return super.offerFirst(e);
	}

	@Override
	public T remove() {
		ALog.Log("LIFO: remove");
		return super.removeFirst();
	}
	
	@Override
    public boolean remove(Object o) {
    	ALog.Log("LIFO: remove2");
        return removeFirstOccurrence(o);
    }
    
	@Override
    public T poll() {
		ALog.Log("LIFO: poll");
        return pollFirst();
    }
	
	@Override
	public T take() throws InterruptedException {
		ALog.Log("LIFO: take");
		return super.take();
	}
	
	public static void threadInfo(Thread t){
		ALog.Log("getName:"+t.getName()+" getId:"+t.getId()+" Info:"+t);
	}
	
	public static void main(String []args){
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
}