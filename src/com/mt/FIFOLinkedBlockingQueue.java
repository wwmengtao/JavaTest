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
	private static final ThreadLocal<String> sThreadLocal = new ThreadLocal<String>();

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
		sThreadLocal.set(Thread.currentThread().getName());
		BlockingQueue<Runnable> taskQueue = new FIFOLinkedBlockingQueue<Runnable>();
		Executor mExecutor = new ThreadPoolExecutor(1, 1, 0L, TimeUnit.MILLISECONDS, taskQueue);
		for(int i=0;i<10;i++){
			mExecutor.execute(new MyRunnable());
		}
		//ÒÔÏÂ²âÊÔThreadLocal
		ALog.Log("sThreadLocal:"+sThreadLocal.get());
		
		new Thread("Thread#1") {  
		    @Override  
		    public void run() {  
				sThreadLocal.set(Thread.currentThread().getName());
				ALog.Log("sThreadLocal:"+sThreadLocal.get());
		    };  
		}.start();  
		  
		new Thread("Thread#2") {  
		    @Override  
		    public void run() {  
		    	ALog.Log("sThreadLocal:"+sThreadLocal.get());
		    };  
		}.start();  
	}

	
	
}
