package com.wyf.utils;
import java.security.SecureRandom;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.spec.SecretKeySpec;

public class CipherUtils {
	private final int TripleDesKeyLength = 112;
	private final int DesKeyLength = 56;
	private final int AesKeyLength = 128;
	
	public byte[] encryptMode(String key, int len, String src, String mode) {
		try {
			KeyGenerator kgen = KeyGenerator.getInstance(mode);  
	        kgen.init(len, new SecureRandom(key.getBytes()));  
	  
	        Cipher cipher = Cipher.getInstance(mode);  
	        cipher.init(Cipher.ENCRYPT_MODE, new SecretKeySpec(kgen.generateKey().getEncoded(), mode));  
	          
	        return cipher.doFinal(src.getBytes("utf-8")); 
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public byte[] decryptMode(String key, int len, byte[] src, String mode) {
		try {
			KeyGenerator kgen = KeyGenerator.getInstance(mode);  
	        kgen.init(len, new SecureRandom(key.getBytes()));  
	  
	        Cipher cipher = Cipher.getInstance(mode);  
	        cipher.init(Cipher.DECRYPT_MODE, new SecretKeySpec(kgen.generateKey().getEncoded(), mode));  
	          
	        return cipher.doFinal(src); 
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public String DesEncode(String src, String key) {
		return Hex.encodeHexStr(encryptMode(key, DesKeyLength, src, "DES"));
	}
	public String DesDencode(String src, String key) {
		return new String(decryptMode(key, DesKeyLength, Hex.decodeHex(src.toCharArray()), "DES"));
	}
	public String TripleDesEncode(String src, String key) {
		return Hex.encodeHexStr(encryptMode(key, TripleDesKeyLength, src, "DESede"));
	}
	public String TripleDesDecode(String src, String key) {
		return new String(decryptMode(key, TripleDesKeyLength, Hex.decodeHex(src.toCharArray()), "DESede"));
	}
	public String AesEncode(String src, String key) {
		return Hex.encodeHexStr(encryptMode(key, AesKeyLength, src, "AES"));
	}
	public String AesDencode(String src, String key) {
		return new String(decryptMode(key, AesKeyLength, Hex.decodeHex(src.toCharArray()), "AES"));
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String src = "123";
		String key = "key";
		CipherUtils cipherUtils = new CipherUtils();
		String dst = cipherUtils.TripleDesEncode(src, key);
		System.out.println(dst);
		System.out.println(cipherUtils.TripleDesDecode(dst, key));
		dst = cipherUtils.AesEncode(src, key);
		System.out.println(dst);
		System.out.println(cipherUtils.AesDencode(dst, key));
		dst = cipherUtils.DesEncode(src, key);
		System.out.println(dst);
		System.out.println(cipherUtils.DesDencode(dst, key));
	}
}
