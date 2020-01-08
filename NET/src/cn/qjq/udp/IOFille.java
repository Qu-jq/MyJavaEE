package cn.qjq.udp;

import java.io.*;

/**
 * �����ֽ��� �ļ��ֽ��� �ۺ�ʵ��
 * ����
 * 1���ļ���ȡ���ֽ�����
 * 2���ֽ�����д�����ļ�
 * @author qjq
 *2019��11��9��20:01:30
 */
public class IOFille {
	/*
	 * ����1���ļ���ȡ���ֽ�����
	 * A �ļ�  -->  ͨ���ļ��ֽ���  --> �ֽ�(����) ---> �����ֽ��� -->  �ֽ�����
	 */
	public static byte[] fileToArray(String filePath) {
		//1������Դ
		File src = new File(filePath);
		//2��ѡ����
		InputStream is = null;
		ByteArrayOutputStream bos = null;
		//3������
		try {
			is = new FileInputStream(src);
			bos = new ByteArrayOutputStream();
			byte[] flush = new byte[1024];
			int len;
			while((len = is.read(flush)) != -1 ) {
				bos.write(flush, 0, len);//�����ֽ���� 
			}
			return bos.toByteArray();//��������ĵ�ǰ���ݣ���Ϊ�ֽ����顣 
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			//4���ͷ���Դ
			try {
				if(null != is)
				is.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}
	/*
	 * ����2���ֽ�����������ļ�
	 * B �ֽ����� --> �����ֽ���  --> �ֽ�(����)-->  ͨ���ļ��ֽ��� --->   �ļ�  
	 */
	public static void arrayTOFile(byte[] data,String desFilePath) {
		File desFile = new File(desFilePath);
		OutputStream os = null;
		InputStream bis = null;
		try {
			os = new FileOutputStream(desFile);
			bis = new ByteArrayInputStream(data);
			byte[] flush = new byte[1024];
			int len;
			while((len = bis.read(flush)) != -1) {
				os.write(flush, 0, len);
				os.flush();
			}
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if(null != os)
					os.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

}
