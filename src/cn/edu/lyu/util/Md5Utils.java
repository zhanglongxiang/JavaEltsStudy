package cn.edu.lyu.util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

public class Md5Utils {
	public static byte[] md5(byte[] data){
		try {
			MessageDigest md = 
					MessageDigest.getInstance("md5");
			md.update(data);
			return md.digest();//获得摘要结果
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public static String md5(String data){
		try {
			byte[] md5 = md5(data.getBytes("utf-8"));
			return toHexString(md5);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";
	}

	public static String toHexString(byte[] md5) {
		StringBuilder buf = new StringBuilder();
		for(byte b : md5){
			buf.append(leftPad(Integer.toHexString(b&0xff),'0',2));
		}
		return buf.toString();
		
	}
	public static String leftPad(String hex,char c,int size){
		char[] cs = new char[size];
		Arrays.fill(cs, c);
		System.arraycopy(hex.toCharArray(), 0, cs, cs.length-hex.length(), hex.length());
		return new String(cs);
	}
	
	public static void main(String[] args) {//测试一下
		System.out.println(md5("1234"));
		//81dc9bdb52d04dc20036dbd8313ed055
	}

}
