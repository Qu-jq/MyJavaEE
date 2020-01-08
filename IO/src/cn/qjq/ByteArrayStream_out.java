package cn.qjq;

import java.io.*;

/**
 * �ֽ����������
 * 1������Դ���ֽ�,��Ҫ̫�󣬷�ֹ�ڴ�ռ�����ڲ�ά��
 * 2��ѡ����   ��������Դ��
 * 3��������д�����ݣ�
 * 4���ͷ�ϵͳ��Դ�����п��ޣ�Ϊ�˺�ǰ���ļ��ֽ������ֱ��ͳһ�������У�
 * 
 *����������
 *	��ȡ����----�� toByteArray()
 * @author qjq
 *2019��11��9��18:09:28
 */
public class ByteArrayStream_out {
	public static void main(String[] args) {
		//1.��������Դͷ
		byte[] rec;
		//2.ѡ����
		ByteArrayOutputStream bos = null;//��Ϊʹ���������������Դ˴�������
		//3.����
		try {
			bos = new ByteArrayOutputStream();//����Ҫ���ݲ���
			byte[] data = "show me the code".getBytes();
			bos.write(data, 0, data.length);//д�뻺����
			bos.flush();
			//��ȡ����
			rec = bos.toByteArray();//��������
			System.out.println(rec.length+ "�ֽ�"  + "--->" + new String(rec,0,rec.length));
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				if(null != bos)
					bos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}

}
