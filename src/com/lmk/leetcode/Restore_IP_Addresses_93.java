package com.lmk.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Restore_IP_Addresses_93 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Restore_IP_Addresses_93 test = new Restore_IP_Addresses_93();
		String s = "010010";
		System.out.println(test.restoreIpAddresses(s));
	}

	public List<String> restoreIpAddresses(String s) {
        return appendStr(0,s);
    }
    
    /**
     *deep 0-3 
     **/
    public List<String> appendStr(int deep,String s){
        List<String> ips = new ArrayList<String>();
	    if (deep >3){
	    	if (s.length() < 1){
	    		ips.add("");
	    	}
		    return ips;
		}
	    
        if (s == null || s.length()<1){
            return ips;
        }
        if (4-deep>s.length()){
            return ips;
        }
        
        for (int i=1;i<=Math.min(3, s.length());i++){
            String IpNum = s.substring(0,i);
            if (isValid(IpNum)){
                List<String> lastIps = appendStr(deep+1,s.substring(i,s.length()));
                for (String str : lastIps){
                    StringBuilder ip = new StringBuilder().append(IpNum);
                    if (!str.equals("false")){
                    	if (str.length()>0){
                    		ip.append(".").append(str);
                    	}
                        ips.add(ip.toString());
                    }
                }
            }
        }
        return ips;
    }
    
    public boolean isValid(String s){
    	if (s.charAt(0) == '0') {
    		return s.length() == 1;
    	}
    	int num = Integer.valueOf(s);
        return num >=0 && num <= 255;
    }
}
