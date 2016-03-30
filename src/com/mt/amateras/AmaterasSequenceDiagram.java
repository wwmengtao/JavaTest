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
	String newline = "\r\n";// \r\n��Ϊ����  
	String line = "";
	public void createAmaterasSequenceDiagram(){
		try{
            File fileToRead = new File(inFileName);
			File fileToWrite = new File(outFileName);
			if(fileToWrite.exists()){
				fileToWrite.delete();
			}
			fileToWrite.createNewFile(); // �������ļ�
            InputStreamReader reader = new InputStreamReader(new FileInputStream(fileToRead)); // ����һ������������reader  
            BufferedReader br = new BufferedReader(reader); // ����һ�����������ļ�����ת�ɼ�����ܶ���������  
	        BufferedWriter out = new BufferedWriter(new FileWriter(fileToWrite));  
            while ((line = br.readLine()) != null) {// line = br.readLine(); // һ�ζ���һ������  
                out.write(str_start+line+str_end+newline); 
                dayin(str_start+line+str_end+newline); 
    	        out.flush(); // �ѻ���������ѹ���ļ�
            }  
			br.close();
	        out.close(); // ���ǵùر��ļ�
		} catch (Exception e) {
            e.printStackTrace();
        }
	}
	public static void dayin(Object obj){
		System.out.println(obj);
	}
}