package com.common.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.util.Date;

import com.service.QcService;
import com.service.impl.QcServiceImpl;

public class FileUtil {
	public static QcService qcService = new QcServiceImpl();
	public static String readFile(String filePath) {
		FileInputStream fileInputStream = null;
		FileChannel fileChannel = null;
		ByteBuffer byteBuffer = null;
		String encoding = null;
		try {
			File file = new File(filePath);
			if(!file.exists()){
				file.createNewFile();
			}
			fileInputStream = new FileInputStream(filePath);
			fileChannel = fileInputStream.getChannel();
			/*设置缓冲大小*/
			byteBuffer = ByteBuffer.allocate(1024000);
			fileChannel.read(byteBuffer);
			/*读取位置重置*/
			byteBuffer.flip();
			/*读取位置重置*/
			byteBuffer.rewind();
			/*获取系统字节码*/
			encoding = System.getProperty("file.encoding");
			/*解码成指定字符*/
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(fileChannel != null) {
					fileChannel.close();
				}
				if(fileInputStream != null) {
					fileInputStream.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}

		}
		return Charset.forName(encoding).decode(byteBuffer).toString();

	}

	public static void wirte(String filePath,String str) {
		FileOutputStream outputStream = null;
		FileChannel channel = null;
		try {
			File file = new File(filePath);
			if(!file.exists()){
				file.createNewFile();
			}
			outputStream = new FileOutputStream(file);
			channel = outputStream.getChannel();
			ByteBuffer buffer = ByteBuffer.allocate(1024000);
			buffer.put(str.getBytes());
			buffer.flip();
			channel.write(buffer);
			channel.close();
			outputStream.close();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(channel != null) {
					channel.close();
				}
				if(outputStream != null) {
					outputStream.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

	public static boolean isEmpty() {
		if(qcService.get(DateUtil.toString(new Date())) == null) {
			return true;
		}
		return false;
	}
}