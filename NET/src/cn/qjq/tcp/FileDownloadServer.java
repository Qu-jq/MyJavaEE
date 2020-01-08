package cn.qjq.tcp;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * �ļ����ط�����
 * 1.ָ���˿ڣ�ʹ��ServerSocket����������
 * 2.����ʽ�ȴ�����accept
 * 3.�������������������
 * 4.�ͷ���Դ
 * @author qjq
 *2019��11��26��15:58:24
 */
public class FileDownloadServer {
	public static void main(String[] args) throws IOException {
		System.out.println("------Server-----");  
		//1.ָ���˿ڣ�ʹ��ServerSocket����������
		ServerSocket server = new ServerSocket(9999);
		 //2.����ʽ�ȴ�����accept
		Socket client = server.accept();//����
		System.out.println("һ���ͻ��˽���������");
		 //3.�������������������
		InputStream is = new BufferedInputStream(client.getInputStream());
		OutputStream os = new BufferedOutputStream(new FileOutputStream("ball2.png"));
		byte[] flush = new byte[1024];
		int len=-1;
		while((len=is.read(flush))!=-1) {
			os.write(flush, 0, len);
		}
		os.flush();
		//4.�ͷ���Դ
		os.close();
		is.close();
		client.close();
		server.close();//������һ��24h������һ�㲻��
	}

}
