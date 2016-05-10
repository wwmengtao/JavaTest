package com.mt;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class grep {

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
            javaTest.dayin(s);
        }
	}
	
	public void subString1(){
		String str = "EFG ok ABC <span style=\"color: #FF0000;\">hello world</span> EFG over EFG";
		String state = str.substring(str.indexOf("\">")+2,str.indexOf("</"));
		javaTest.dayin(state);
		StringBuffer STR = new StringBuffer(str);
		STR.delete(str.indexOf("\">")+2,str.indexOf("</"));
		javaTest.dayin(STR);
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
}
