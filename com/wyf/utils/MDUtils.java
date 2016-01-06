package com.wyf.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MDUtils {
	/**
	 * ��ժҪ��Ϣת��Ϊ��Ӧ�ı���
	 *
	 * @param code
	 *            ��������
	 * @param message
	 *            ժҪ��Ϣ
	 * @return ��Ӧ�ı����ַ���
	 */
	private String Encode(String code, String message) {
		MessageDigest md;
		String encode = null;
		try {
			md = MessageDigest.getInstance(code);
			encode = Hex.encodeHexStr(md.digest(message.getBytes()));
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return encode;
	}

	/**
	 * ��ժҪ��Ϣת����MD5����
	 *
	 * @param message
	 *            ժҪ��Ϣ
	 * @return MD5����֮����ַ���
	 */
	public String md5Encode(String message) {
		return Encode("MD5", message);
	}

	/**
	 * ��ժҪ��Ϣת����SHA����
	 *
	 * @param message
	 *            ժҪ��Ϣ
	 * @return SHA����֮����ַ���
	 */
	public String shaEncode(String message) {
		return Encode("SHA", message);
	}

	/**
	 * ��ժҪ��Ϣת����SHA-256����
	 *
	 * @param message
	 *            ժҪ��Ϣ
	 * @return SHA-256����֮����ַ���
	 */
	public String sha256Encode(String message) {
		return Encode("SHA-256", message);
	}

	/**
	 * ��ժҪ��Ϣת����SHA-224����
	 *
	 * @param message
	 *            ժҪ��Ϣ
	 * @return SHA-224����֮����ַ���
	 */
	public String sha224Encode(String message) {
		return Encode("SHA-224", message);
	}

	/**
	 * ��ժҪ��Ϣת����SHA-384����
	 *
	 * @param message
	 *            ժҪ��Ϣ
	 * @return SHA-384����֮����ַ���
	 */
	public String sha384Encode(String message) {
		return Encode("SHA-384", message);
	}

	/**
	 * ��ժҪ��Ϣת����SHA-512����
	 *
	 * @param message
	 *            ժҪ��Ϣ
	 * @return SHA-512����֮����ַ���
	 */
	public String sha512Encode(String message) {
		return Encode("SHA-512", message);
	}

	public boolean validate(String expected, String actural) {
		return expected.equals(actural);
	}

	public static void main(String[] args) {

		MDUtils cu = new MDUtils();
		// ��MD5������֤
		System.out.println("----MD5----");
		System.out.println(cu.validate("d41d8cd98f00b204e9800998ecf8427e", cu.md5Encode("")));
		System.out.println(cu.validate("0cc175b9c0f1b6a831c399e269772661", cu.md5Encode("a")));
		System.out.println(cu.validate("900150983cd24fb0d6963f7d28e17f72", cu.md5Encode("abc")));
		System.out.println(cu.validate("f96b697d7cb7938d525a2f31aaf161d0", cu.md5Encode("message digest")));
		System.out.println(cu.validate("c3fcd3d76192e4007dfb496cca67e13b", cu.md5Encode("abcdefghijklmnopqrstuvwxyz")));
		System.out.println(cu.validate("d174ab98d277d9f5a5611c2c9f419d9f",
				cu.md5Encode("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789")));
		System.out.println(cu.validate("57edf4a22be3c955ac49da2e2107b67a",
				cu.md5Encode("12345678901234567890123456789012345678901234567890123456789012345678901234567890")));

		// ��SHA������֤
		System.out.println("----SHA----");
		System.out.println(cu.validate("2fd4e1c67a2d28fced849ee1bb76e7391b93eb12",
				cu.shaEncode("The quick brown fox jumps over the lazy dog")));
		System.out.println(cu.validate("de9f2c7fd25e1b3afad3e85a0bd17d9b100db4b3",
				cu.shaEncode("The quick brown fox jumps over the lazy cog")));
		System.out.println(cu.validate("da39a3ee5e6b4b0d3255bfef95601890afd80709", cu.shaEncode("")));
		System.out.println("-----------");
		// ������ʾMD5 SHA SHA-256 SHA-512�����ɵĳ���

		System.out.println("--MD5--:" + cu.md5Encode("test"));
		System.out.println("--SHA--:" + cu.shaEncode("test"));
		System.out.println("SHA-256:" + cu.sha256Encode("test"));
		System.out.println("SHA-224:" + cu.sha224Encode("test"));
		System.out.println("SHA-384:" + cu.sha384Encode("test"));
		System.out.println("SHA-512:" + cu.sha512Encode("test"));
	}
}
