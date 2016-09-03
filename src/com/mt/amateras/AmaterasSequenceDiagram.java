package com.mt.amateras;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.mt.javaTest;

public class AmaterasSequenceDiagram{
	/*-------------------------------------------------------------*/
	String str_start = "at ";
	String str_end="(1.java:1)";//��д����ģ��RuntimeException��ӡ����ջ��Ϣ�Ľ�β����
	String newline = "\r\n";// \r\n��Ϊ����  
	String line = "";
	boolean needInsertNewLine = true;
	/*-------------------------------------------------------------*/
    //����regƥ��"	 ListView.scrollListItemsBy 	 	ListView2.scrollListItems2By3"�󣬽���ƥ���"ListView.scrollListItemsBy"��"ListView2.scrollListItems2By3"
	String reg = "[0-9a-zA-Z]+\\.[0-9a-zA-Z]+";
    Pattern mPattern = Pattern.compile(reg);
    Matcher mMatcher = null;
    
	public static void main(String []args){
		new AmaterasSequenceDiagram();
	}
	public AmaterasSequenceDiagram(){
		howTocreateAmaterasSequenceDiagram();
	}
    
	/*-------------------------------------------------------------*/
	/**
	 * howTocreateAmaterasSequenceDiagram����ʾ��θ���inFileName���ݻ�ȡeclipse���Ի��Ƶĵ���ջ��Ϣ
	 * ˵����inFileName�ļ����ݿ���������������ʽ��
	 * ��ʽ1���ֶ��򻯷�ʽ������ϢΪ��������.�������ƣ���Ȼ��������ʽ��������в����ʵ����ݡ�
	 	KeyboardLayoutDialogFragment.getView	sd
		KeyboardLayoutDialogFragment.getView	1f23
		AbsListView.obtainView		 
		ListView.addViewBelow  		s2
		ListView.scrollListItemsBy	  asf
		��ʽ2��RuntimeException.fillInStackTrace()���������ĵ���ջ��Ϣ��
		01-05 22:44:32.303  4129  4129 E M_T_AT  : 	at com.lenovo.powersetting.apprestriction.appmanager.ApplicationsAdapter.getView(ApplicationsAdapter.java:168)

		01-05 22:44:32.303  4129  4129 E M_T_AT  : 	at android.widget.AbsListView.obtainView(AbsListView.java:2474)
		
		01-05 22:44:32.303  4129  4129 E M_T_AT  : 	at android.widget.ListView.fillFromTop(ListView.java:778)
	 */
	public void howTocreateAmaterasSequenceDiagram(){
		String inFileName="files/stackTraceIn.txt";
		String outFileName="files/stackTraceOut.txt";
		createAmaterasSequenceDiagram(inFileName,outFileName);
	}
	
	public void createAmaterasSequenceDiagram(String inFileName,String outFileName){
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
            	if(needInsertNewLine){
            		out.write(newline);
            		needInsertNewLine=false;
            	}
            	line=reGetLine(line);
            	out.write(line);             
    	        out.flush(); // �ѻ���������ѹ���ļ�
            }  
			br.close();
	        out.close(); // ���ǵùر��ļ�
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
		String str_reg = null;
        mMatcher = mPattern.matcher(str);
        while(mMatcher.find()){
        	str_reg = mMatcher.group();
            break;
        }
		return str_start+str_reg+str_end+newline;
	}
	
	public static void dayin(Object obj){
		System.out.println(obj);
	}
}
