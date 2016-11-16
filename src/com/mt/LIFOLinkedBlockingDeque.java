package com.mt;

import java.util.NoSuchElementException;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;


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
	
	public static void main(String []args){
		BlockingQueue<Runnable> taskQueue = new LIFOLinkedBlockingDeque<Runnable>();
		Executor mExecutor = new ThreadPoolExecutor(1, 1, 0L, TimeUnit.MILLISECONDS, taskQueue);
		for(int i=0;i<10;i++){
			mExecutor.execute(new MyRunnable());
		}
	}
}