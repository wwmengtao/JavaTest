package com.mt.amateras;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;

public class AmaterasSequenceDiagram{
	String inFileName="files/stackTraceIn.txt";
	String outFileName="files/stackTraceOut.txt";
	String str_start = "at ";
	String str_end="(1.java:1)";
	String newline = "\r\n";// \r\n即为换行  
	String line = "";
	boolean needInsertNewLine = true;
	public void createAmaterasSequenceDiagram(){
		try{
            File fileToRead = new File(inFileName);
			File fileToWrite = new File(outFileName);
			if(fileToWrite.exists()){
				fileToWrite.delete();
			}
			fileToWrite.createNewFile(); // 创建新文件
            InputStreamReader reader = new InputStreamReader(new FileInputStream(fileToRead)); // 建立一个输入流对象reader  
            BufferedReader br = new BufferedReader(reader); // 建立一个对象，它把文件内容转成计算机能读懂的语言  
	        BufferedWriter out = new BufferedWriter(new FileWriter(fileToWrite));  
            while ((line = br.readLine()) != null) {// line = br.readLine(); // 一次读入一行数据  
            	if(needInsertNewLine){
            		out.write(newline);
            		needInsertNewLine=false;
            	}
            	line=reGetLine(line);
            	out.write(line);             
    	        out.flush(); // 把缓存区内容压入文件
            }  
			br.close();
	        out.close(); // 最后记得关闭文件
		} catch (Exception e) {
            e.printStackTrace();
        }
	}
	
	public String reGetLine(String str){
		if(null==str){
			return "";
		}else if(str.equals("")){
			return "";
		}
		if(str.toLowerCase().contains(str_start.toLowerCase())){
			return str.substring(str.indexOf("at "))+newline;
		}
		return str_start+str+str_end+newline;
	}
	
	public static void dayin(Object obj){
		System.out.println(obj);
	}
}
