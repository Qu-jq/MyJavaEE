package cn.qjq.tcp;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * �ļ��ϴ��ͻ���  --TCP�޴����С����
 * 1.ָ���˿ڣ�ʹ��Socket�����ͻ���  �������� ָ����������ַ �˿�
 * 2.�������������������
 * 3.�ͷ���Դ
 * @author qjq
 *2019��11��26��15:58:19
 */
public class FileUploadClient {
	public static void main(String[] args) throws UnknownHostException, IOException {
		System.out.println("------Client-----"); 
		//1.ָ���˿ڣ�ʹ��Socket�����ͻ���  �������� ָ����������ַ �˿�
		Socket client = new Socket("localhost",9999);
		 //2.�������������������
		InputStream is = new BufferedInputStream(new FileInputStream("ball.png"));
		OutputStream os = new BufferedOutputStream(client.getOutputStream());
		byte[] flush = new byte[1024];
		int len=-1;
		while((len=is.read(flush))!=-1) {
			os.write(flush, 0, len);
		}
		os.flush();
		//3.�ͷ���Դ
		os.close();
		is.close();
		client.close();
	}

}
