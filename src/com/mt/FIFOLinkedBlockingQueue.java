package com.mt;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;


public class FIFOLinkedBlockingQueue<T> extends LinkedBlockingQueue<T>{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7790586349451627687L;

	@Override
	public boolean offer(T e) {
		ALog.Log("FIFO: offer");
		return super.offer(e);
	}
	
	@Override
	public boolean remove(Object o) {
		ALog.Log("FIFO: remove");
		return super.remove(o);
	}
	
	@Override
	public T poll() {
		ALog.Log("FIFO: poll");
		return super.poll();
	}
	
	@Override
	public T take() throws InterruptedException{
		ALog.Log("FIFO: take");
		return super.take();
	}
	
	public static void main(String []args){
		BlockingQueue<Runnable> taskQueue = new FIFOLinkedBlockingQueue<Runnable>();
		Executor mExecutor = new ThreadPoolExecutor(1, 1, 0L, TimeUnit.MILLISECONDS, taskQueue);
		for(int i=0;i<10;i++){
			mExecutor.execute(new MyRunnable());
		}
	}

}
