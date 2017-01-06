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

}