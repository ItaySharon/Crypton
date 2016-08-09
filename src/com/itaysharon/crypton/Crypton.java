package com.itaysharon.crypton;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import com.google.gson.Gson;
import com.itaysharon.crypton.objects.Body;
import com.itaysharon.crypton.objects.Checksum;
import com.itaysharon.crypton.objects.CryptBase;
import com.itaysharon.crypton.objects.Header;
import com.itaysharon.crypton.utils.EncryptUtils;

public class Crypton {

	public static void main(String[] args) {
		String iv = "CryptonG";
		String key = "33E49B4EA462C9EA2BA372EB";
		
		EncryptUtils crypt = new EncryptUtils();
		String encrypted = crypt.encrypt("test", key, iv);
		int length = crypt.getLength();
		Header header = new Header("ItaySharon", "test.cged", "1.0.0", "dataholder", "Data", length);
		Body body = new Body(encrypted);
		Checksum checksum = new Checksum(header.hashCode() + "", body.hashCode() + "");
		
		CryptBase main = new CryptBase(header, body, checksum);
		
		Gson provider = new Gson();
		String data = provider.toJson(main, CryptBase.class);
		File file = new File(main.getHeader().getFilename());
		try {
			if(!file.exists())
				file.createNewFile();
			FileOutputStream fos = new FileOutputStream(file);
			fos.write(data.getBytes());
			fos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
