package com.mt;

import java.io.File;
import java.util.ArrayList;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.mt.amateras.AmaterasSequenceDiagram;


public class javaTest {
	String [] strPercents = {" %","% "};
	public static void main(String []args){
		new javaTest();
	}
	public javaTest(){
		//1、正则表达式
		//String str="15 		%";dayin(subString0(str));
		//String str2="	 ListView.scrollListItemsBy 	 	ListView2.scrollListItems2By3";subString(str2);
		//2、生成eclipse可解析的调用栈信息
		AmaterasSequenceDiagram asd = new AmaterasSequenceDiagram();
		asd.howTocreateAmaterasSequenceDiagram();

	}
	
	public String subString0(String str){
		String strTemp=null;
		if(null!=str && str.contains("%") && containsNumeric(str)){
	        String reg = "[^0-9^%]";
	        Pattern pattern = Pattern.compile(reg);
	        Matcher matcher = pattern.matcher(str);
	        while (matcher.find()) {
	            strTemp=str.replaceAll(reg, "");
	        }
		}
		if(null==strTemp){
			strTemp = str;
		}
        return strTemp;
	}
	
	public static boolean containsNumeric(String str){ 
	    Pattern pattern = Pattern.compile("[0-9]"); 
	    return pattern.matcher(str).find();
	} 
	
	public void subString(String str){
        String reg = "[0-9a-zA-Z]+\\.[0-9a-zA-Z]+";
        Pattern p = Pattern.compile(reg);
        Matcher m = p.matcher(str);
        while(m.find()){
            String s = m.group();
            dayin(s);
        }
	}
	
	public void subString1(){
		String str = "EFG ok ABC <span style=\"color: #FF0000;\">hello world</span> EFG over EFG";
		String state = str.substring(str.indexOf("\">")+2,str.indexOf("</"));
		dayin(state);
		StringBuffer STR = new StringBuffer(str);
		STR.delete(str.indexOf("\">")+2,str.indexOf("</"));
		dayin(STR);
	}

	
	public void visitArray(){
    	String [][] tags_values = {{"tag1","value1"},
		         {"tag2","value2"},
		         {"tag3","value3"}
		         };
		for(int i=0;i<tags_values.length;i++){//遍历纵向的数据
			dayin(tags_values[i][0]+tags_values[i][1]);
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
	
	public String getPercentStringWithoutSpace(String str){
		String strProper=null;
		if(null!=str){
			if(str.contains(" ")){
				strProper = str.replace(" ", "");
			}
		}
    	if(null==strProper){
    		strProper = str;
    	}
		return strProper;
	}
	
	
	//批量函数名称转换
	public void reNameFile1(){ 
		String strStart = "【城市一家】宋太宗（第二部）";
        String  dirName = "D:\\BaiduYun\\王立群读宋史宋太宗第二部";
        File file = new File(dirName);    
        String fileName;
        String fileNameTemp;
        if(file.isDirectory()){ 
            File[] files = file.listFiles(); 
            for(int i=0; i<files.length; i++){ 
            	fileName = files[i].getAbsolutePath();//包括了文件名
            	fileNameTemp = fileName.replace(strStart, "");
            	dayin(fileName);
            	dayin(fileNameTemp);
            	if(null!=fileNameTemp){
            		boolean flag = files[i].renameTo(new File(fileNameTemp));
            	}
            }
        }
	}
	//批量函数名称转换
	public void reNameFile2(){ 
        String reg1 = "\\([0-9]{1}\\)";//将"abc(2).mp3"转换为"2_abc.mp3"
        String reg2 = "\\([0-9]{2}\\)";//将"abc(12).mp3"转换为"12_abc.mp3"
        Pattern pattern1 = Pattern.compile(reg1);
        Pattern pattern2 = Pattern.compile(reg2);
        String  dirName = "filesDir";
        File file = new File(dirName);     
        String fileName;
        String strTemp=null;
        if(file.isDirectory()){ 
            File[] files = file.listFiles(); 
            int count = files.length;
            for(int i=0; i<count; i++){ 
            	fileName = files[i].getAbsolutePath();//包括了文件名
            	for(int j=count;j>0;j--){
            		if(fileName.contains("("+j+")")){
            			if(j>9){
            				strTemp = fileNameModify(dirName,fileName,j,reg2,pattern2);
            			}
            			else{
            				strTemp = fileNameModify(dirName,fileName,j,reg1,pattern1);
            			}
            			break;
            		}
            	}
            	
            	dayin(strTemp);
            	//dayin(files[i].getAbsolutePath());
            	if(null!=strTemp){
            		boolean flag = files[i].renameTo(new File(strTemp));
            	}
            } 
        }        
 
    }
    public String fileNameModify(String dirName,String fileName,int num,String reg,Pattern pattern){
        String strTemp=null;
    	Matcher matcher = pattern.matcher(fileName);
        while (matcher.find()) {
        	strTemp = fileName.replaceAll(reg, "");
        	strTemp = strTemp.replace(dirName+File.separator, dirName+File.separator+num+"_");
        }
        return strTemp;
    }
	
    static class MergedItem {
    	String a;
    	ArrayList<String>b;
    }
	public void typename(Object obj, Object mem){
		if(obj.getClass().toString().endsWith("MergedItem")){
			MergedItem temp = (MergedItem)obj;
			
		}
	}
	public void typename(Object obj){
		dayin(obj.getClass().toString());
	}
	public static void dayin2(Object obj){
		System.out.print(obj);
	}
	public static void dayin(Object obj){
		System.out.println(obj);
	}
}
