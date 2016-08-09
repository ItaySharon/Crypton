package com.itaysharon.crypton;

import java.io.BufferedReader;
import java.io.FileReader;

import com.google.gson.Gson;
import com.itaysharon.crypton.objects.CryptBase;

public class Verbose {

	static String json;
	static boolean headerValid = false;
	static boolean bodyValid = false;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new FileReader("test.cged"));
		try {
			StringBuilder sb = new StringBuilder();
			String line = br.readLine();

			while (line != null) {
				sb.append(line);
				sb.append(System.lineSeparator());
				line = br.readLine();
			}
			json = sb.toString();
		} finally {
			br.close();
		}
		Gson provider = new Gson();
		CryptBase data = provider.fromJson(json, CryptBase.class);
		System.out.println(data.toString());
		System.out.println("Checksum validation, Header: ["
				+ (headerValid = data.getChecksum().getHeader().equals(data.getHeader().hashCode() + "")) + "], Body: ["
				+ (bodyValid = data.getChecksum().getBody().equals(data.getBody().hashCode() + "")) + "]");
		if(headerValid && bodyValid) {
			System.out.println("\u001B[32mChecksum OK!\u001B[0m");
		} else {
			System.err.println("\u001B[31mBad Checksum!\u001B[0m");
		}
	}

}
