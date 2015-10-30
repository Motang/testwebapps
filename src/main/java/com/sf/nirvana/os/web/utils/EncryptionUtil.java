package com.sf.nirvana.os.web.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class EncryptionUtil {
	public static String MD5(String source) {
		MessageDigest md = null;
		try {
			md = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		md.update(source.getBytes());
		byte[] bt = md.digest();

		StringBuilder sb = new StringBuilder();
		int p = 0;
		for (int i = 0; i < bt.length; i++) {
			p = bt[i];
			if (p < 0)
				p += 256;
			if (p < 16)
				sb.append("0");
			sb.append(Integer.toHexString(p));
		}
		return sb.toString();
	}

	public static String Sha1(final String plainText) {
		String str = "";
		String tempStr = "";
		try {
			final MessageDigest md = MessageDigest.getInstance("SHA-1");// SHA-1
			final byte[] digest = md.digest(plainText.getBytes());

			for (int index = 0; index < digest.length; index++) {
				tempStr = (Integer.toHexString(digest[index] & 0xff));
				if (tempStr.length() == 1) {
					str = str + "0" + tempStr;
				} else {
					str = str + tempStr;
				}
			}
		} catch (final NoSuchAlgorithmException e) {
		}
		return str;
	}

}
