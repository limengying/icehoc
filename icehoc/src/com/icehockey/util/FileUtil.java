package com.icehockey.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileUtil {
	public static String savePicture(String image, String imageType) {
		String imgePath = "";
		File pictureFile = new File(image);
		java.util.Random r = new java.util.Random();
		int randomString = Math.abs(r.nextInt());
		//System.out.println(randomString);
		//System.out.println(pictureFile.getAbsolutePath());
		try {
			File base = new File("");
			String courseFile = base.getCanonicalPath();
			// System.out.println("courseFile:" + courseFile);
			String targetFilePath = courseFile + "\\" + "picture";
			// System.out.println("targetFilePath:" + targetFilePath);
			File file = new File(targetFilePath);
			if (file.exists()) {
				if (file.isDirectory()) {
					// System.out.println("dir exists");
					Date date = new Date();
					DateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
					String time = format.format(date);
					imgePath = time + "-" + randomString + "-" + imageType + ".jpg";
					String path = targetFilePath + "\\" + imgePath;
					InputStream in = new FileInputStream(pictureFile);
					File saveFile = new File(path);
					OutputStream out = new FileOutputStream(saveFile);
					byte[] bytes = new byte[1024];
					int len = -1;
					while ((len = in.read(bytes)) != -1) {
						out.write(bytes, 0, len);
					}
					in.close();
					out.close();
					// System.out.println("rename:" +
					// pictureFile.getAbsolutePath());
				} else {
					System.out.println("the same name file exists, can not create dir");
				}
			} else {
				System.out.println("dir not exists, create it ...");
				file.mkdir();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return imgePath;
	}

}
