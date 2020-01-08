package cn.qjq.exe;

import java.io.File;

import org.apache.commons.io.FileUtils;

/**
 * 利用导入包读取文件大小
 * @author qjq
 *2019年11月15日17:10:18
 */
public class libReadAize {
	public static void main(String[] args) {
		//文件夹大小
		long len = FileUtils.sizeOfDirectory(new File("src/cn/qjq/exe"));
		System.out.println(len);
		//文件大小
		len = FileUtils.sizeOf(new File("src/cn/qjq/exe/libReadAize.java"));
		System.out.println(len);
	}
}
