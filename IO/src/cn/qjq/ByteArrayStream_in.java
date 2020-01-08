package cn.qjq;

import java.io.*;

/**
 * �ֽ�����������
 * 1������Դ���ֽ�,��Ҫ̫�󣬷�ֹ�ڴ�ռ����
 * 2��ѡ����
 * 3������
 * 4���ͷ�ϵͳ��Դ�����п��ޣ�Ϊ�˺�ǰ���ļ��ֽ������ֱ��ͳһ�������У�
 * @author qjq
 *2019��11��9��17:05:38
 */
public class ByteArrayStream_in {
	public static void main(String[] args) {
		//1������Դ���ֽڣ�
		byte[] src = "show me the code".getBytes();//�ַ�ת�ֽ�
		//2��ѡ����
		InputStream bio = null;
		try {
			bio = new ByteArrayInputStream(src);
			//3������
			byte[] flush = new byte[1024];//ÿ�ζ�1024�ֽ�
			int len;
			while((len = bio.read(flush)) != -1) {
				String str = new String(flush,0,len);
				System.out.println(str);
			}
		} catch (IOException e) {
				e.printStackTrace();
		}finally {
			//4���ͷ�ϵͳ��Դ�����п��ޣ�Ϊ�˺�ǰ���ļ��ֽ������ֱ��ͳһ�������У�
			try {
				if(null != bio)
					bio.close();
			} catch (IOException e) {
					e.printStackTrace();
			}
		}
		
	}

}
