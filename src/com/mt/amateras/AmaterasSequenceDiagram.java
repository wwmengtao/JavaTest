package com.mt.amateras;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public class AmaterasSequenceDiagram{
	String filename="stackTrace.txt";
	String str_start = "at ";
	String str_end="(1.java:1)";
	String newline = "\r\n";// \r\n��Ϊ����  
	public void createAmaterasSequenceDiagram(){
		String []callInfos={
				"KeyboardLayoutDialogFragment.getView",
				"KeyboardLayoutDialogFragment.getView",
				"AbsListView.obtainView",
				"ListView.addViewBelow",
				"ListView.scrollListItemsBy"
		};
        /* д��Txt�ļ� */  
		try{
			File fileToWrite = new File(filename);
			fileToWrite.createNewFile(); // �������ļ�  
	        BufferedWriter out = new BufferedWriter(new FileWriter(fileToWrite));  
			for(int i=0;i<callInfos.length;i++){
				//dayin(str_start+callInfos[i]+str_end);
		        out.write(str_start+callInfos[i]+str_end+newline); 
			}
	        out.flush(); // �ѻ���������ѹ���ļ�  
	        out.close(); // ���ǵùر��ļ�  
		} catch (Exception e) {  
            e.printStackTrace();
        }
	}
	public static void dayin(Object obj){
		System.out.println(obj);
	}
}
