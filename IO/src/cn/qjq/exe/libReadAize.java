package cn.qjq.exe;

import java.io.File;

import org.apache.commons.io.FileUtils;

/**
 * ���õ������ȡ�ļ���С
 * @author qjq
 *2019��11��15��17:10:18
 */
public class libReadAize {
	public static void main(String[] args) {
		//�ļ��д�С
		long len = FileUtils.sizeOfDirectory(new File("src/cn/qjq/exe"));
		System.out.println(len);
		//�ļ���С
		len = FileUtils.sizeOf(new File("src/cn/qjq/exe/libReadAize.java"));
		System.out.println(len);
	}
}
