package com.itaysharon.crypton.utils;

import java.util.Arrays;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class EncryptUtils {

	byte[] input;
	byte[] keyBytes;
	byte[] ivBytes;
	byte[] output;
	int enc_len;
	int dec_len;
	
	public EncryptUtils() {
		
	}
	
	public String encrypt(String data, String ckey, String iv) {
		input = data.getBytes();
		keyBytes = ckey.getBytes();
		ivBytes = iv.getBytes();
		// wrap key data in Key/IV specs to pass to cipher
		SecretKeySpec key = new SecretKeySpec(keyBytes, "DES");
		IvParameterSpec ivSpec = new IvParameterSpec(ivBytes);
		// create the cipher with the algorithm you choose
		// see javadoc for Cipher class for more info, e.g.
		try {
			Cipher cipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
			cipher.init(Cipher.ENCRYPT_MODE, key, ivSpec);
			byte[] encrypted = new byte[cipher.getOutputSize(input.length)];
			int enc_len = cipher.update(input, 0, input.length, encrypted, 0);
			enc_len += cipher.doFinal(encrypted, enc_len);
			output = encrypted;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new String(output);
	}
	
	public String decrypt(String data, String ckey, String iv, int len) {
		input = data.getBytes();
		keyBytes = ckey.getBytes();
		ivBytes = iv.getBytes();
		// wrap key data in Key/IV specs to pass to cipher
		SecretKeySpec key = new SecretKeySpec(keyBytes, "DES");
		IvParameterSpec ivSpec = new IvParameterSpec(ivBytes);
		// create the cipher with the algorithm you choose
		// see javadoc for Cipher class for more info, e.g.
		try {
			Cipher cipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
			cipher.init(Cipher.DECRYPT_MODE, key, ivSpec);
			byte[] decrypted = new byte[cipher.getOutputSize(len)];
			int dec_len = cipher.update(input, 0, enc_len, decrypted, 0);
			dec_len += cipher.doFinal(decrypted, dec_len);
			output = decrypted;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new String(output);
	}

	public byte[] getInput() {
		return input;
	}

	public void setInput(byte[] input) {
		this.input = input;
	}

	public byte[] getKeyBytes() {
		return keyBytes;
	}

	public void setKeyBytes(byte[] keyBytes) {
		this.keyBytes = keyBytes;
	}

	public byte[] getIvBytes() {
		return ivBytes;
	}

	public void setIvBytes(byte[] ivBytes) {
		this.ivBytes = ivBytes;
	}

	public byte[] getOutput() {
		return output;
	}

	public void setOutput(byte[] output) {
		this.output = output;
	}

	public int getEnc_len() {
		return enc_len;
	}

	public void setEnc_len(int enc_len) {
		this.enc_len = enc_len;
	}

	public int getDec_len() {
		return dec_len;
	}

	public void setDec_len(int dec_len) {
		this.dec_len = dec_len;
	}
	
	public int getLength() {
		return enc_len;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + dec_len;
		result = prime * result + enc_len;
		result = prime * result + Arrays.hashCode(input);
		result = prime * result + Arrays.hashCode(ivBytes);
		result = prime * result + Arrays.hashCode(keyBytes);
		result = prime * result + Arrays.hashCode(output);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EncryptUtils other = (EncryptUtils) obj;
		if (dec_len != other.dec_len)
			return false;
		if (enc_len != other.enc_len)
			return false;
		if (!Arrays.equals(input, other.input))
			return false;
		if (!Arrays.equals(ivBytes, other.ivBytes))
			return false;
		if (!Arrays.equals(keyBytes, other.keyBytes))
			return false;
		if (!Arrays.equals(output, other.output))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "EncryptUtils [input=" + Arrays.toString(input) + ", keyBytes=" + Arrays.toString(keyBytes)
				+ ", ivBytes=" + Arrays.toString(ivBytes) + ", output=" + Arrays.toString(output) + ", enc_len="
				+ enc_len + ", dec_len=" + dec_len + "]";
	}
}
