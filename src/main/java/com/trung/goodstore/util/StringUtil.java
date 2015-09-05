package com.trung.goodstore.util;

import java.security.MessageDigest;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class StringUtil {
	private final static Log log = LogFactory.getLog(StringUtil.class);

	public static String encodePassword(String password, String algorithm) {
		byte[] input = password.getBytes();
		MessageDigest digest = null;
		try {
			digest = MessageDigest.getInstance(algorithm);

		} catch (Exception e) {
			log.error("Exception:" + e);
			return password;
		}
		digest.reset();
		digest.update(input);
		byte[] encodePassword = digest.digest();
		StringBuffer buf = new StringBuffer();
		for (int i = 0; i < encodePassword.length; i++) {
			if ((encodePassword[i] & 0xff) < 0x10) {
				buf.append("0");
			}
			buf.append(Long.toString(encodePassword[i]&0xff, 16));
		}
		return buf.toString();
	}

	public static String encodeString(String str) {
		return Base64.encodeBase64URLSafeString(str.getBytes()).trim();
	}

	public static String decodeString(String str) {
			return new String(Base64.decodeBase64(str));
	}
	public static boolean isHttpAddress(String s){
		boolean rs=false;
		if(s.indexOf("http://")==0)return true;
		return rs;
	}
}
