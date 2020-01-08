package cn.qjq;

import java.io.File;
import java.io.*;
/**
 * �ļ���copy
 * 1������Դ
 * 2��ѡ����
 * 3���������ݹ飩
 * 4���ͷ���Դ
 * @author qjq
 *2019��11��9��10:27:41
 */

/*
 * 
 * ���󣺸��ƶ༶�ļ���
 * ����Դ��
 * Ŀ�ĵأ�
 * 
 * ����
 * 		A����װ����Դ��
 * 		B����װĿ�ĵ�
 * 		C���жϸ�File���ļ������ļ���
 * 			a:���ļ���
 * 					����Ŀ�ĵ��´������ļ���
 * 					��ȡ��File����������ļ������ļ��ж���
 * 					�����õ�ÿһ��File����
 * 					�ص�C
 * 			b:���ļ�
 * 				�����ļ�
 * 
 * */
public class DirCopy {
 
	public static void main(String[] args) throws IOException {
 
		File srcFile=new File("src/cn");
		File destFile=new File("E:/");
		copyFolder(srcFile,destFile);
 
	}
 
	private static void copyFolder(File srcFile, File destFile) throws IOException {
		
		if(srcFile.isDirectory()){
			File newFolder=new File(destFile,srcFile.getName());//�Ӹ�·�����ַ�������·�����ַ��������µ�Fileʵ��
			newFolder.mkdirs();//����Ŀ¼
			File[] fileArray=srcFile.listFiles();
			
			for(File file:fileArray){
				copyFolder(file, newFolder);
			}
			
		}else{
			File newFile=new File(destFile,srcFile.getName());
			copyFile(srcFile,newFile);
		}
		
	}
 
	private static void copyFile(File srcFile, File newFile) throws IOException{
		// TODO Auto-generated method stub
		BufferedInputStream bis=new BufferedInputStream(new FileInputStream(srcFile));
		BufferedOutputStream bos=new BufferedOutputStream(new FileOutputStream(newFile));
		
		byte[] bys=new byte[1024];
		int len=0;
		while((len=bis.read(bys))!=-1){
			bos.write(bys,0,len);
		}
		bos.close();
		bis.close();
		
	}
}
