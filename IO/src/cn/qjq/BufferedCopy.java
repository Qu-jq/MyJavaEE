package cn.qjq;

import java.io.*;

/**
 * �ļ��Ŀ���   ���뻺����
 * 1������Դ
 * 2��ѡ�����������������
 * 3���������ֿ��ȡ��
 * 4���ͷ���Դ���ȶ�ȡ�ĺ��ͷţ�
 * @author qjq
 *2019��11��9��09:57:18
 */
public class BufferedCopy {
	public static void main(String[] args) {
		copy("creat.txt","creatcopy.txt");
	}
	public static void copy(String inputFile,String outputFile) {
		//1������Դ
		File  inFile = new File(inputFile);
		File outFile = new File(outputFile);
		//2��ѡ����
		InputStream  is  =  null;
		BufferedInputStream bis = null;
		OutputStream os = null;
		BufferedOutputStream bos = null;
		//3������
		try {
			is = new FileInputStream(inFile);
			os=new FileOutputStream(outFile);
			bis = new BufferedInputStream(is);
			bos=new BufferedOutputStream(os);
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
		}finally {
			//�رջ��������ɣ����Զ��ر��ڲ��ֽ���
			try {
				if(null != bos)
					bos.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
