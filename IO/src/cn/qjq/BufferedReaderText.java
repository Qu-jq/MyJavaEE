package cn.qjq;

import java.io.*;

/**
 * �ļ��ַ�������(�����ı�)  ���뻺����
 * 1������Դ
 * 2��ѡ����
 * 3������(��������)
 * 4���ͷ���Դ
 * ����������
 * 	readLine()  ---��һ��
 * @author qjq
 *2019��11��11��11:00:35
 */
public class BufferedReaderText {
	public static void main(String[] args) {
		File src = new File("ReaderTest.txt");
		BufferedReader io = null;
		try {
			io = new BufferedReader(new FileReader(src));
			String data = null;//ÿ�ζ�һ��
			while((data=io.readLine()) != null) {
				System.out.println(data);
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
