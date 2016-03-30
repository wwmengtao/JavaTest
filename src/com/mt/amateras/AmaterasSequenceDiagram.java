package com.mt.amateras;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public class AmaterasSequenceDiagram{
	String filename="stackTrace.txt";
	String str_start = "at ";
	String str_end="(1.java:1)";
	String newline = "\r\n";// \r\n即为换行  
	public void createAmaterasSequenceDiagram(){
		String []callInfos={
				"KeyboardLayoutDialogFragment.getView",
				"KeyboardLayoutDialogFragment.getView",
				"AbsListView.obtainView",
				"ListView.addViewBelow",
				"ListView.scrollListItemsBy"
		};
        /* 写入Txt文件 */  
		try{
			File fileToWrite = new File(filename);
			fileToWrite.createNewFile(); // 创建新文件  
	        BufferedWriter out = new BufferedWriter(new FileWriter(fileToWrite));  
			for(int i=0;i<callInfos.length;i++){
				//dayin(str_start+callInfos[i]+str_end);
		        out.write(str_start+callInfos[i]+str_end+newline); 
			}
	        out.flush(); // 把缓存区内容压入文件  
	        out.close(); // 最后记得关闭文件  
		} catch (Exception e) {  
            e.printStackTrace();
        }
	}
	public static void dayin(Object obj){
		System.out.println(obj);
	}
}
