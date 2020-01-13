package cn.qjq;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.commons.io.FileUtils;

/**
 * ����ͼƬ
 * @author qjq
 *2019��11��18��10:31:28
 */
public class WebDownloader {
	public void download(String url,String name) {
		try {
			FileUtils.copyURLToFile(new URL(url), new File(name));
		} catch (MalformedURLException e) {
			System.out.println("���Ϸ���URL");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("����ʧ��");
			e.printStackTrace();
		}
	}
}