package com.mt;

import java.util.ArrayList;

public class javaTest {
	public static final int BASE_SYSTEM_ASYNC_CHANNEL = 0x00011000;
	String [] strPercents = {" %","% "};
	public static void main(String []args){
		new javaTest();
	}
	public javaTest(){
		//1��������ʽ
		//grep mGrep=new grep();
		//String str="15 		%";dayin(mGrep.subString0(str));
		//String str2="	 ListView.scrollListItemsBy 	 	ListView2.scrollListItems2By3";mGrep.subString(str2);
		//2������eclipse�ɽ����ĵ���ջ��Ϣ
		//AmaterasSequenceDiagram asd = new AmaterasSequenceDiagram();
		//asd.howTocreateAmaterasSequenceDiagram();
		//3���оٳ��ļ�����
		//fileOperate mfileOperate = new fileOperate();
		//mfileOperate.listDrawableFileNames();
		//4�����ļ����ݣ��������֮����д��
		//mfileOperate.readAndWriteFile();
		//5��ʮ���ơ�ʮ������ת��
		//dayin(parseHexString("11"));
		//dayin(toHexString(17));
		
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
