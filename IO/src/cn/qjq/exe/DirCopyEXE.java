package cn.qjq.exe;

import java.io.*;

/**
 * �ļ���copy��ϰ
 * ����
 * 		��ĳ���ļ����µ������ļ� ���Ƶ���һ���ļ���
 * @author qjq
 *2019��11��9��15:31:21
 */
public class DirCopyEXE {
	public static void main(String[] args) {
		File srcFile = new File("src/cn");
	//	System.out.println(srcFile.getName());//���ص�ǰ�ļ�����
		File desFile = new File("E:/");
	//	System.out.println(desFile.getName());
		DirCopy(srcFile, desFile);
	}
	
	public static void DirCopy(File srcFile , File desFile) {
		if(srcFile.isDirectory()) {
			File newFile =new File(desFile,srcFile.getName());//�Ӹ�����·��������·�����ַ��������µ�Fileʵ��
			System.out.println(newFile.getName());
			newFile.mkdirs();//�����ļ���
			for(File f : srcFile.listFiles()) {
				DirCopy(f,newFile);
			}
		}else if(srcFile.isFile()) {
			File newFile =new File(desFile,srcFile.getName());//���ƴ����˿��ļ�
			System.out.println(newFile);
			FileCopy(srcFile , newFile);//�����ļ�������
		}
	}
	
	public static void FileCopy(File srcFile , File desFile) {
		InputStream is = null;
		OutputStream os = null;
		try {
			is = new FileInputStream(srcFile);
			os = new FileOutputStream(desFile);
			byte[] data = new byte[1024];//ÿ�ζ�1024���ֽ�
			int len;
			while((len=is.read(data))!=-1) {
				os.write(data, 0, len);
				os.flush();//д���ˢ��һ��
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				if(null != is)
					is.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				if(null != os)
					os.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
