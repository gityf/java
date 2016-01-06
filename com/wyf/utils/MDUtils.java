package com.wyf.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MDUtils {
	/**
	 * 将摘要信息转换为相应的编码
	 *
	 * @param code
	 *            编码类型
	 * @param message
	 *            摘要信息
	 * @return 相应的编码字符串
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
	 * 将摘要信息转换成MD5编码
	 *
	 * @param message
	 *            摘要信息
	 * @return MD5编码之后的字符串
	 */
	public String md5Encode(String message) {
		return Encode("MD5", message);
	}

	/**
	 * 将摘要信息转换成SHA编码
	 *
	 * @param message
	 *            摘要信息
	 * @return SHA编码之后的字符串
	 */
	public String shaEncode(String message) {
		return Encode("SHA", message);
	}

	/**
	 * 将摘要信息转换成SHA-256编码
	 *
	 * @param message
	 *            摘要信息
	 * @return SHA-256编码之后的字符串
	 */
	public String sha256Encode(String message) {
		return Encode("SHA-256", message);
	}

	/**
	 * 将摘要信息转换成SHA-224编码
	 *
	 * @param message
	 *            摘要信息
	 * @return SHA-224编码之后的字符串
	 */
	public String sha224Encode(String message) {
		return Encode("SHA-224", message);
	}

	/**
	 * 将摘要信息转换成SHA-384编码
	 *
	 * @param message
	 *            摘要信息
	 * @return SHA-384编码之后的字符串
	 */
	public String sha384Encode(String message) {
		return Encode("SHA-384", message);
	}

	/**
	 * 将摘要信息转换成SHA-512编码
	 *
	 * @param message
	 *            摘要信息
	 * @return SHA-512编码之后的字符串
	 */
	public String sha512Encode(String message) {
		return Encode("SHA-512", message);
	}

	public boolean validate(String expected, String actural) {
		return expected.equals(actural);
	}

	public static void main(String[] args) {

		MDUtils cu = new MDUtils();
		// 对MD5进行验证
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

		// 对SHA进行验证
		System.out.println("----SHA----");
		System.out.println(cu.validate("2fd4e1c67a2d28fced849ee1bb76e7391b93eb12",
				cu.shaEncode("The quick brown fox jumps over the lazy dog")));
		System.out.println(cu.validate("de9f2c7fd25e1b3afad3e85a0bd17d9b100db4b3",
				cu.shaEncode("The quick brown fox jumps over the lazy cog")));
		System.out.println(cu.validate("da39a3ee5e6b4b0d3255bfef95601890afd80709", cu.shaEncode("")));
		System.out.println("-----------");
		// 下面显示MD5 SHA SHA-256 SHA-512所生成的长度

		System.out.println("--MD5--:" + cu.md5Encode("test"));
		System.out.println("--SHA--:" + cu.shaEncode("test"));
		System.out.println("SHA-256:" + cu.sha256Encode("test"));
		System.out.println("SHA-224:" + cu.sha224Encode("test"));
		System.out.println("SHA-384:" + cu.sha384Encode("test"));
		System.out.println("SHA-512:" + cu.sha512Encode("test"));
	}
}
