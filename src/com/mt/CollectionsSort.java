package com.mt;

import java.text.Collator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
public class CollectionsSort extends javaTest{
	private ArrayList<NameTest> mArrayname = new ArrayList<NameTest>();

	public static void main(String []args){
		new CollectionsSort();
	}
	
	public CollectionsSort(){
		mArrayname.add(new NameTest("A"));
		mArrayname.add(new NameTest("¨¤"));
		mArrayname.add(new NameTest("a"));
		testNameComparator();
	}
	
	public void testNameComparator(){
		NameComparator mnameTestComparator = null;
		for(int i=0;i<=2;i++){
			mnameTestComparator = new NameComparator(i);
			Collections.sort(mArrayname,mnameTestComparator);
			printArrayname(mArrayname);
		}
	}
	
	public void printArrayname(ArrayList<NameTest> mArrayname){
		dayin("#######################");
		for(NameTest mNameTest : mArrayname){
			dayin(mNameTest.processName);
		}
	}
	
	class NameTest{
		public String processName=null;
		public NameTest(String processName){
			this.processName=processName;
		}
	}
	
    /**
     * 
	    µ± collator.setStrength(Collator.PRIMARY):
		a equals b -> false
		a equals ¨¤ -> true
		A equals a -> true
		µ± collator.setStrength(Collator.SECONDARY):
		a equals b -> false
		a equals ¨¤ -> false
		A equals a -> true
		µ± collator.setStrength(Collator.TERTIARY):
		a equals b -> false
		a equals ¨¤ -> false
		A equals a -> false
     * @author Mengtao1
     *
     */
    public class NameComparator implements Comparator<NameTest> {
    	private final Collator mCollator = Collator.getInstance();
		public NameComparator(int type) {
			if(0==type){
				mCollator.setStrength(Collator.PRIMARY);
			}else if(1==type){
				mCollator.setStrength(Collator.SECONDARY);
			}else if(2==type){
				mCollator.setStrength(Collator.TERTIARY);
			}
		}
		public final int compare(NameTest a, NameTest b) {
		    return mCollator.compare(a.processName, b.processName);
		}
    }
}
