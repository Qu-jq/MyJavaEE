package cn.qjq;

import java.io.*;

/**
 * �ļ��ֽ������   ���뻺����
 * 1������Դ
 * 2��ѡ����
 * 3������(д������)
 * 4���ͷ���Դ
 * Ĭ��GBK
 * @author Administrator
 *2019��11��11��10:22:32
 */
public class BufferdeStream_out {
	public static void main(String[] args) {
		//1������Դ
		File file = new File("creat.txt");
		//2��ѡ����
		OutputStream is =null;
		try {
			//3������(д������)
			is = new BufferedOutputStream(new FileOutputStream(file));//Ĭ��Ϊfalse,���Ϊtrue ����ļ���󣬼���������ݣ�false����ͷ��ʼ
			String str = "I have learnt Java For long time!\n";
			String str2 = "hold on!\n";
			byte[] data = str.getBytes("utf-8");//����
			byte[] data2 = str2.getBytes("utf-8");//����
			is.write(data,0,data.length);
			is.flush();//ˢ��������������ʱ����ü���
			is.write(data2,0,data2.length);
			is.flush();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			if(is!=null) {
				try {
					is.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

}
