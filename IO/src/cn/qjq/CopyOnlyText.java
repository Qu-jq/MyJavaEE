package cn.qjq;

import java.io.*;

/**
 * ���ı��Ŀ���  ���뻺����
 * 1������Դ
 * 2��ѡ�����������������
 * 3�����������ж�ȡ��
 * 4���ͷ���Դ���ȶ�ȡ�ĺ��ͷţ�
 * @author qjq
 *2019��11��11��11:11:11
 */
public class CopyOnlyText {
	public static void main(String[] args) {
		copyText("creat.txt","creatcopy.txt");
	}
	public static void copyText(String inputFile,String outputFile) {
		//1������Դ
		File  inFile = new File(inputFile);
		File outFile = new File(outputFile);
		//2��ѡ����
		//3������---���ж�ȡ
		try(BufferedReader is = new BufferedReader(new FileReader(inFile));
				BufferedWriter os = new BufferedWriter(new FileWriter(outFile))){
			
			String data = null;
			while((data = is.readLine())!=null) {
				os.write(data);
				os.newLine();
				os.flush();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
