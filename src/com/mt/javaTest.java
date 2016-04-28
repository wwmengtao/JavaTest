package com.mt;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.mt.amateras.AmaterasSequenceDiagram;


public class javaTest {
	public static final int BASE_SYSTEM_ASYNC_CHANNEL = 0x00011000;
	String [] strPercents = {" %","% "};
	public static void main(String []args){
		new javaTest();
	}
	public javaTest(){
		//1��������ʽ
		//String str="15 		%";dayin(subString0(str));
		//String str2="	 ListView.scrollListItemsBy 	 	ListView2.scrollListItems2By3";subString(str2);
		//2������eclipse�ɽ����ĵ���ջ��Ϣ
		AmaterasSequenceDiagram asd = new AmaterasSequenceDiagram();
		asd.howTocreateAmaterasSequenceDiagram();
		//3���оٳ��ļ�����
		//listDrawableFileNames();
		//4�����ļ����ݣ��������֮����д��
		//readAndWriteFile();
		//5��ʮ���ơ�ʮ������ת��
		dayin(parseHexString("11"));
		dayin(toHexString(17));
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
		for(int i=0;i<tags_values.length;i++){//�������������
			dayin(tags_values[i][0]+tags_values[i][1]);
		}
		/*
		for(int j=0;j<tags_values[i].length;j++){//�������������
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
	
	
	//������������ת��
	public void reNameFile1(){ 
		String strStart = "������һ�ҡ���̫�ڣ��ڶ�����";
        String  dirName = "D:\\BaiduYun\\����Ⱥ����ʷ��̫�ڵڶ���";
        File file = new File(dirName);    
        String fileName;
        String fileNameTemp;
        if(file.isDirectory()){ 
            File[] files = file.listFiles(); 
            for(int i=0; i<files.length; i++){ 
            	fileName = files[i].getAbsolutePath();//�������ļ���
            	fileNameTemp = fileName.replace(strStart, "");
            	dayin(fileName);
            	dayin(fileNameTemp);
            	if(null!=fileNameTemp){
            		boolean flag = files[i].renameTo(new File(fileNameTemp));
            	}
            }
        }
	}
	//������������ת��
	public void reNameFile2(){ 
        String reg1 = "\\([0-9]{1}\\)";//��"abc(2).mp3"ת��Ϊ"2_abc.mp3"
        String reg2 = "\\([0-9]{2}\\)";//��"abc(12).mp3"ת��Ϊ"12_abc.mp3"
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
            	fileName = files[i].getAbsolutePath();//�������ļ���
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
	
	public void listDrawableFileNames(){ 
        String  dirName = "D:\\workspace\\JavaTest\\files\\drawable";
        File file = new File(dirName);    
        String fileName;
        if(file.isDirectory()){ 
            File[] files = file.listFiles(); 
            for(int i=0; i<files.length; i++){ 
            	fileName = files[i].getName();
            	if(fileName.contains(".xml")){
            		dayin("\""+fileName.replace(".xml", "\","));
            	}
            	
            }
        }
	}
	
	public void readAndWriteFile(){
		String inFileName = "files"+File.separator+"in.txt";
		String outFileName = "files"+File.separator+"out.txt";
		String line = null;
		StringBuffer strBuffer0 = new StringBuffer();
		StringBuffer strBuffer1 = new StringBuffer();
        File fileToRead = new File(inFileName);
		File fileToWrite = new File(outFileName);
		if(fileToWrite.exists()){
			fileToWrite.delete();
		}
		try{
			fileToWrite.createNewFile(); // �������ļ�
            InputStreamReader reader = new InputStreamReader(new FileInputStream(fileToRead)); // ����һ������������reader  
            BufferedReader br = new BufferedReader(reader); // ����һ�����������ļ�����ת�ɼ�����ܶ���������  
	        BufferedWriter out = new BufferedWriter(new FileWriter(fileToWrite));  
            while ((line = br.readLine()) != null) {// line = br.readLine(); // һ�ζ���һ������  
            	if(isValidString(line)){  
					String [] strs = line.split(" ");
					if(2==strs.length){
						strBuffer0.append(strs[0]+",");
						strBuffer1.append(strs[1]+",");
					}
            	}
            }  
        	out.write(strBuffer0.toString()+"\n");        
        	out.write(strBuffer1.toString()+"\n");         
	        out.flush(); // �ѻ���������ѹ���ļ�
			br.close();
	        out.close(); // ���ǵùر��ļ�
		} catch (Exception e) {
            e.printStackTrace();
        }
	}
	
	String reg = "[a-zA-Z]+\\ [a-zA-Z]+";
    Pattern mPattern = Pattern.compile(reg);
    Matcher mMatcher = null;
	public boolean isValidString(String str){
        mMatcher = mPattern.matcher(str);
        while(mMatcher.find()){
        	//dayin("find:"+mMatcher.group());
        	return true;
        }
        return false;
	}
	
	public void typename(Object obj){
		dayin(obj.getClass().toString());
	}
	public static String toHexString(int mInt){
		return Integer.toHexString(mInt);
	}
	
	//eg:parseHexString("11"), result is 17
	public static int parseHexString(String mData){
		return Integer.parseInt(mData,16);
	}	
	public static void dayin2(Object obj){
		System.out.print(obj);
	}
	public static void dayin(Object obj){
		System.out.println(obj);
	}
}
