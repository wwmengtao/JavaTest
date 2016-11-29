package com.mt;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class fileOperate {
	public void listDrawableFileNames(){ 
        String  dirName = "D:\\workspace\\JavaTest\\files\\drawable";
        File file = new File(dirName);    
        String fileName;
        if(file.isDirectory()){ 
            File[] files = file.listFiles(); 
            for(int i=0; i<files.length; i++){ 
            	fileName = files[i].getName();
            	if(fileName.contains(".xml")){
            		javaTest.dayin("\""+fileName.replace(".xml", "\","));
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

	public static void main(String []args){
		new fileOperate();
	}
	
	public fileOperate(){
		reNameFile1();
	}
	
	//������������ת��
	public void reNameFile1(){ 
		String strStart = "Kangxi.Dynasty";
        String  dirName = "D:\\BaiduNetDisk\\��������";
        File file = new File(dirName);    
        String fileName;
        String fileNameTemp;
        if(file.isDirectory()){ 
            File[] files = file.listFiles(); 
            for(int i=0; i<files.length; i++){ 
            	fileName = files[i].getAbsolutePath();//�������ļ���
            	fileNameTemp = fileName.replace(strStart, "��������");
            	javaTest.dayin(fileName);
            	javaTest.dayin(fileNameTemp);
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
            	
            	javaTest.dayin(strTemp);
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
	
}
