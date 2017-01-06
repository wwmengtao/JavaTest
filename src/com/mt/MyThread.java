package com.mt;

public class MyThread extends Thread{
	public static final int SLEEP_TIME = 2*1000;

	private volatile boolean shutdownRequested = false;
	
	public void stopNow(){
		interrupt();
	}
	
	public void showThreadInfo(int index){
		ALog.Log("<--------------------"+index+"------------------->");
		ALog.Log("1����ȡ��ǰ�߳���Ϣ��");
		ALog.Log("getId: "+getId());
		ALog.Log("getName: "+getName());
		ALog.Log("isInterrupted: "+isInterrupted());
		ALog.Log("2����ȡ��ǰ�����߳���Ϣ��");
		ALog.Log("getId: "+Thread.currentThread().getId());
		ALog.Log("getName: "+Thread.currentThread().getName());
		ALog.Log("isInterrupted: "+Thread.currentThread().isInterrupted());
		ALog.Log("<--------------------"+index+"------------------->");
	}
	
    @Override 
    public void run() { 
        while (!Thread.currentThread().isInterrupted()){ //������������ͨ���ж��жϱ�־���˳�
            try{
            	showThreadInfo(0);
            	checkTaskInterrupted();
            	Thread.sleep(SLEEP_TIME);//�������̲����ж��쳣���˳�
            	ALog.Log("run");
            	checkTaskInterrupted();
            	ALog.Log("run1");
            }catch(InterruptedException e){
                e.printStackTrace();
              /**
               * catch���в���InterruptedException�쳣ʱ���̵߳��жϱ�־λ�Ѿ������ó�false�ˣ�
               * ����ڴ�catch���е���t.isInterrupted(),Thread.interrupted()ʼ�ն�Ϊfalse
               */
                ALog.Log("InterruptedException_isInterrupted:"+Thread.currentThread().isInterrupted());
                break;//�����쳣֮��ִ��break����ѭ����
            }catch(MyException e){
                e.printStackTrace();
                ALog.Log("MyException");
                break;//�����쳣֮��ִ��break����ѭ����
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
		 *interrupted�Ǿ�̬���������ڻ�ȡ��ǰ�����̵߳��ж�״̬�����õ�ǰ�����̵߳��жϱ�ǣ�
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
