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
	String str_end="(1.java:1)";//简化写法，模拟RuntimeException打印调用栈信息的结尾部分
	String newline = "\r\n";// \r\n即为换行  
	String line = "";
	boolean needInsertNewLine = true;
	/*-------------------------------------------------------------*/
    //下列reg匹配"	 ListView.scrollListItemsBy 	 	ListView2.scrollListItems2By3"后，将会匹配出"ListView.scrollListItemsBy"和"ListView2.scrollListItems2By3"
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
	 * howTocreateAmaterasSequenceDiagram：演示如何根据inFileName内容获取eclipse可以绘制的调用栈信息
	 * 说明：inFileName文件内容可以有下列两种形式：
	 * 形式1，手动简化方式，行信息为：类名称.方法名称，当然，正则表达式会过滤下列不合适的内容。
	 	KeyboardLayoutDialogFragment.getView	sd
		KeyboardLayoutDialogFragment.getView	1f23
		AbsListView.obtainView		 
		ListView.addViewBelow  		s2
		ListView.scrollListItemsBy	  asf
		形式2，RuntimeException.fillInStackTrace()方法产生的调用栈信息：
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
