package cn.qjq;

import java.io.*;

/**
 * �ļ��ַ������
 * 1������Դ
 * 2��ѡ����
 * 3������(д������)
 * 4���ͷ���Դ
 * @author qjq
 *2019��11��9��12:00:33
 */
public class WriterFile {
	public static void main(String[] args) {
		File des = new File("WriterTest.txt");
		Writer os = null;
		try {
			os = new FileWriter(des);
			String str = "��ð���my friends\n";
			//��һ�ַ�ʽ
			/*char[] data = str.toCharArray();
			os.write(data,0,data.length);*/
			//�ڶ��ַ�ʽ
			//os.append(str).append("��������");
			//�����ַ�ʽ
			os.write(str);
			
		} catch (IOException e) {
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
