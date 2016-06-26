package com.mt.designmode;

import com.mt.ALog;

public class MuteQuack implements Quackhaviour{

	@Override
	public void Quack() {
		// TODO Auto-generated method stub
		ALog.Log("Silent");
	}

}
