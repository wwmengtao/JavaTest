package com.mt;


public class array {
	
	public static void main(String []args){
		new array();
	}	
	
	public array(){
		visitArray();
	}
	
	public void visitArray(){
    	String [][] tags_values = {{"tag1","value1"},
		         {"tag2","value2"},
		         {"tag3","value3"}
		         };
		for(int i=0;i<tags_values.length;i++){//遍历纵向的数据
			javaTest.dayin(tags_values[i][0]+": "+tags_values[i][1]);
		}
		/*
		for(int j=0;j<tags_values[i].length;j++){//遍历横向的数据
			if(j==tags_values[i].length-1){
			dayin(tags_values[i][j]);
			}else{
			dayin2(tags_values[i][j]+" ");
			}
		}
		*/
}
}
