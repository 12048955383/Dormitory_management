package org.gxy.dormitory.util;

import org.apache.commons.codec.digest.DigestUtils;

public class MD5Util {
	//加密的方法
	public static String md5(String context) {
		String md5Str = DigestUtils.md5Hex(context);
		return md5Str;
	}
	//测试加密
	public static void main(String[] args){
		System.out.println(7 & 12);
	}
}
