package cn.qjq;

import java.io.BufferedOutputStream;
import java.io.FileDescriptor;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

/**
 * ��ӡ��
 * PrintStream
 * @author qjq
 *2019��11��12��20:02:11
 */
public class Printstream {
	public static void main(String[] args) throws FileNotFoundException {
		//��ӡ��  System.out
		PrintStream ps = System.out;
		ps.println("hhaha");
		ps.println(false);
		
		ps = new PrintStream(new BufferedOutputStream(new FileOutputStream("print.txt")),true);
		ps.println("���");
		ps.println("haha");
		//ps.flush();//ǿ��ˢ��
		//ps.close();//�ڴ˹رյĻ���������򿴲���Ч����
		
		//�ض���
		System.setOut(ps);
		System.out.println("�������");//���ڿ���̨���
		//�ض������
		System.setOut(new PrintStream(new BufferedOutputStream(new FileOutputStream(FileDescriptor.out))));
		System.out.println("I am BACK");
		ps.close();
	}

}
