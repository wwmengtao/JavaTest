package com.mt;

public class MyThread extends Thread{
	public static final int SLEEP_TIME = 2*1000;

	private volatile boolean shutdownRequested = false;
	
	public void stopNow(){
		interrupt();
	}
	
	public void showThreadInfo(int index){
		ALog.Log("<--------------------"+index+"------------------->");
		ALog.Log("1、获取当前线程信息：");
		ALog.Log("getId: "+getId());
		ALog.Log("getName: "+getName());
		ALog.Log("isInterrupted: "+isInterrupted());
		ALog.Log("2、获取当前运行线程信息：");
		ALog.Log("getId: "+Thread.currentThread().getId());
		ALog.Log("getName: "+Thread.currentThread().getName());
		ALog.Log("isInterrupted: "+Thread.currentThread().isInterrupted());
		ALog.Log("<--------------------"+index+"------------------->");
	}
	
    @Override 
    public void run() { 
        while (!Thread.currentThread().isInterrupted()){ //非阻塞过程中通过判断中断标志来退出
            try{
            	showThreadInfo(0);
            	checkTaskInterrupted();
            	Thread.sleep(SLEEP_TIME);//阻塞过程捕获中断异常来退出
            	ALog.Log("run");
            	checkTaskInterrupted();
            	ALog.Log("run1");
            }catch(InterruptedException e){
                e.printStackTrace();
              /**
               * catch块中捕获到InterruptedException异常时，线程的中断标志位已经被设置成false了，
               * 因此在此catch块中调用t.isInterrupted(),Thread.interrupted()始终都为false
               */
                ALog.Log("InterruptedException_isInterrupted:"+Thread.currentThread().isInterrupted());
                break;//捕获到异常之后，执行break跳出循环。
            }catch(MyException e){
                e.printStackTrace();
                ALog.Log("MyException");
                break;//捕获到异常之后，执行break跳出循环。
            }
        }
    } 
    
	private void checkTaskInterrupted() throws MyException {
		hardWork();
		if (isTaskInterrupted()) {
			throw new MyException();
		}
	}

	private void hardWork(){
		double i=0,j=1;
		long starTime=System.currentTimeMillis();
		while(i<99999999){
			j=i/12345678;
			i++;
		}
		long endTime=System.currentTimeMillis();
		long Time=endTime-starTime;
		ALog.Log("hardWorkTime:"+Time);
	}
	
	private boolean isTaskInterrupted() {
		/**
		 *interrupted是静态方法，用于获取当前运行线程的中断状态并重置当前运行线程的中断标记：
		 *public static boolean interrupted() {
		       return currentThread().isInterrupted(true);
		 *}
		 */
        ALog.Log("isTaskInterrupted_isInterrupted1:"+Thread.currentThread().isInterrupted());
		if (Thread.interrupted()) {
	        ALog.Log("isTaskInterrupted_isInterrupted2:"+Thread.currentThread().isInterrupted());
			return true;
		}
		return false;
	}
    
    private class MyException extends Exception{}
}
