package cn.qjq;

import java.io.*;

/**
 * �ļ��Ŀ���   ���뻺�������Ľ��� ---->���뻺�������Ч��
 * 1������Դ
 * 2��ѡ�����������������
 * 3���������ֿ��ȡ��
 * 4���ͷ���Դ���ȶ�ȡ�ĺ��ͷţ�
 * @author qjq
 *2019��11��9��09:57:18
 */
public class BufferedCopy2 {
	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		copy("creat.txt","creatcopy.txt");
		long last = System.currentTimeMillis();
		System.out.println("�ܹ���ʱ��"+(last-start));
	}
	public static void copy(String inputFile,String outputFile) {
		//1������Դ
		File  inFile = new File(inputFile);
		File outFile = new File(outputFile);
		//3������
		try(BufferedInputStream is= new BufferedInputStream(new FileInputStream(inFile));
				BufferedOutputStream os = new BufferedOutputStream(new FileOutputStream(outFile))) {
			
			byte[] data = new byte[1024]; 
			int len;
			while((len = is.read(data))!=-1) {
				os.write(data, 0, len);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
