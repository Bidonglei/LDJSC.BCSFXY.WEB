package com.sunmnet.bigdata.common.util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

/**
 * hmac签名算法工具类
 * @author:  wm  
 * @since：2011-6-1 下午06:06:43 
 * @version:   
 */
public class HmacSign {
	
	public static final String CHAR_ENCODING = "UTF-8";
	public static final String MD5_ALGORITHM = "MD5";
	 /**
     * 对报文进行采用SHA进行hmac签名
     * @param value - 字符串
     * @param key - 密钥
     * @return - 签名结果，hex字符串
     */
	public static String signToBase64(String value, String key) {
		try {
			return new String(Base64.encode((sign(value.getBytes(CHAR_ENCODING),
					key.getBytes(CHAR_ENCODING)))));
		} catch (UnsupportedEncodingException e) {
			throw new RuntimeException("hmacsign fail!", e);
		}
	}

	public static String signToHex(String value, String key) {
		try {
			return toHex(sign(value.getBytes(CHAR_ENCODING),
					key.getBytes(CHAR_ENCODING)));
		} catch (UnsupportedEncodingException e) {
			throw new RuntimeException("hmacsign fail!", e);
		}
	}

	public static byte[] sign(byte[] data, byte[] key){
		return sign(data, key,MD5_ALGORITHM);
	}
	
	public static byte[] sign(byte[] data, byte[] key, String alg) {
		byte k_ipad[] = new byte[64];
		byte k_opad[] = new byte[64];
		Arrays.fill(k_ipad, key.length, 64, (byte) 54);
		Arrays.fill(k_opad, key.length, 64, (byte) 92);
		for (int i = 0; i < key.length; i++) {
			k_ipad[i] = (byte) (key[i] ^ 0x36);
			k_opad[i] = (byte) (key[i] ^ 0x5c);
		}
		MessageDigest md = null;
		try {
			md = MessageDigest.getInstance(alg);
		} catch (NoSuchAlgorithmException e) {
			throw new RuntimeException("hmacsign fail!", e);
		}
		md.update(k_ipad);
		md.update(data);
		byte dg[] = md.digest();
		md.reset();
		md.update(k_opad);
		md.update(dg, 0, 16);
		dg = md.digest();
		return dg;
	}
	
	public static String toHex(byte input[]) {
		if (input == null)
			return null;
		StringBuffer output = new StringBuffer(input.length * 2);
		for (int i = 0; i < input.length; i++) {
			int current = input[i] & 0xff;
			if (current < 16)
				output.append("0");
			output.append(Integer.toString(current, 16));
		}
		return output.toString();
	}
	
	
}
