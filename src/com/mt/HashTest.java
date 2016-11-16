package com.mt;

import java.util.HashSet;
import java.util.Set;

public class HashTest {  
    private int i;  
  
    public int getI() {  
        return i;  
    }  
  
    public void setI(int i) {  
        this.i = i;  
    }  
  
    public int hashCode() {  
        return i % 10;  
    }  
  
    public final static void main(String[] args) {  
    	Set<Integer> mSet = new HashSet<Integer>();
    	mSet.add(1);
    	mSet.add(1);
    	mSet.add(2);
    	System.out.println(mSet);
    }  
}  



