package com.mt.designmode;

import com.mt.ALog;

public class GreenDuck extends duck{
	public GreenDuck(){
		mFlyBehaviour= new FlyWithWings();
		mQuackhaviour = new Quack();
	}
	
	public void display(){
		ALog.Log("A GreenDuck");
	}

}
