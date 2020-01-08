package cn.qjq;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.commons.io.FileUtils;

/**
 * 下载图片
 * @author qjq
 *2019年11月18日10:31:28
 */
public class WebDownloader {
	public void download(String url,String name) {
		try {
			FileUtils.copyURLToFile(new URL(url), new File(name));
		} catch (MalformedURLException e) {
			System.out.println("不合法的URL");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("下载失败");
			e.printStackTrace();
		}
	}
}
