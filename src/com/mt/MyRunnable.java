package com.mt;

public class MyRunnable implements Runnable{
	private static int i=0;
	private int index=0;
	public MyRunnable(){
		index = i++;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			Thread.sleep(1000);
			ALog.Log(""+index);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
};
