package com.mt.designmode;

public abstract class duck {
	
	FlyBehaviour mFlyBehaviour;
	Quackhaviour mQuackhaviour;
	
	public void performFly(){
		mFlyBehaviour.fly();
	}
	
	public void performQuack(){
		mQuackhaviour.Quack();
	}
	
	public abstract void display();
}
