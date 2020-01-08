package cn.qjq;

import java.io.*;

/**
 * �ļ��ַ�������(�����ı�)
 * 1������Դ
 * 2��ѡ����
 * 3������(��������)
 * 4���ͷ���Դ
 * @author qjq
 *2019��11��9��11:46:36
 */
public class ReaderFile {
	public static void main(String[] args) {
		File src = new File("ReaderTest.txt");
		Reader io = null;
		try {
			io = new FileReader(src);
			char[] data = new char[1024];//ÿ�ζ�1024���ַ�
			int len;
			while((len=io.read(data)) != -1) {
				String str = new String(data,0,len);
				System.out.println(str);
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			
				try {
					if(null != io) {
						io.close();
				}
					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
		}
	}

}
