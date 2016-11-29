package com.mt;

import java.util.Random;

public class BreakpointDemo {
	
	private Random random = new Random();
	
	private int value = -1;
	
	private void setValue(int count){
		System.out.println("entering setValue method ...");
		for(int i=0; i< count ; i++){
			value = random.nextInt(10);
			printDemo();
		}
		System.out.println("leaving setValue method ...");
	}
	
	private void printValue(int count){
		setValue(count);
		printDemo();
		if(value%3==0){
			throw new IllegalArgumentException("value is illegal");
		}
		printDemo();
		printDemo();
		printDemo();
		printDemo();
		printDemo();
		printDemo();
		System.out.println(value);
	}
	
	public static void main(String []args){
		new BreakpointDemo();
	}
	
	public BreakpointDemo(){
		printValue(2);
	}
	
	public void printDemo(){
		System.out.println("haha");
	}
}
