package com.sf.nirvana.os.web.utils;

import java.io.IOException;
import java.util.Random;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;

import org.apache.commons.codec.binary.Base64;

/**
 * @author <a href="mailto:tangjimo@sf-express.com">709166</a>
 */
public final class DESUtils {
	
	public static String encrypt(String message, String key) throws Exception {
		Cipher cipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
		DESKeySpec desKeySpec = new DESKeySpec(key.getBytes("UTF-8"));
		SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
		SecretKey secretKey = keyFactory.generateSecret(desKeySpec);
		IvParameterSpec iv = new IvParameterSpec(key.getBytes("UTF-8"));
		cipher.init(Cipher.ENCRYPT_MODE, secretKey, iv);
		return encodeBase64(cipher.doFinal(randomString(message).getBytes("UTF-8")));
	}

	public static String decrypt(String message, String key) throws Exception {
		byte[] bytesrc = decodeBase64(message);
		Cipher cipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
		DESKeySpec desKeySpec = new DESKeySpec(key.getBytes("UTF-8"));
		SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
		SecretKey secretKey = keyFactory.generateSecret(desKeySpec);
		IvParameterSpec iv = new IvParameterSpec(key.getBytes("UTF-8"));
		cipher.init(Cipher.DECRYPT_MODE, secretKey, iv);
		byte[] retByte = cipher.doFinal(bytesrc);
		String decStr = new String(retByte);
		return decStr.substring(0, decStr.length() - 2);
	}

	private static String encodeBase64(byte[] b) {
		return Base64.encodeBase64String(b);
	}

	private static byte[] decodeBase64(String base64String) throws IOException {
		return Base64.decodeBase64(base64String);
	}

	private static String randomString(String message) {
		Random random = new Random();
		String str = message + random.nextInt(10) + random.nextInt(10);
		return str;
	}

}
