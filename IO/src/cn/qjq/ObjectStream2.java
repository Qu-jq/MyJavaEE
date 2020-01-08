package cn.qjq;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.util.Date;

/**
 * ������   д��д���ļ�
 * ���л��ͷ����л�
 * ObjectOutputStream
 * ObjectInputStream
 * 1��д�����ȡ
 * 2����ȡ��д��˳�򱣳�һ��
 * 3���������е��඼�������л�������ʵ��Serializable�ӿ�
 * @author qjq
 *2019��11��12��19:01:26
 */
public class ObjectStream2 {
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		
		ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("Obj.ser")));
		oos.writeBoolean(false);
		oos.writeChar('c');//����д��������������
		oos.writeObject("��������ᣬ˭������ζ��");//String�ڲ�ʵ����Serializable�ӿ�
		oos.writeObject(new Date());
		Worker worker = new Worker("С��",50000);
		oos.writeObject(worker);
		oos.flush();
		oos.close();
		
		
		//�����л�
		ObjectInputStream ois = new  ObjectInputStream(new BufferedInputStream(new FileInputStream("obj.ser")) );//�Լ�ȡ�ú�׺
		boolean b = ois.readBoolean();
		char c = ois.readChar();
		//�������ݻ�ԭ   �����л�
		Object objStr = ois.readObject();
		Object objDa = ois.readObject();
		Object objWo = ois.readObject();
		//��ֹת������
		if(objStr instanceof String) {
			String ObjStr = (String)objStr;
			System.out.println(ObjStr);
		}
		if(objDa instanceof Date) {
			Date ObjDa = (Date)objDa;
			System.out.println(ObjDa);
		}
		if(objWo instanceof Worker) {
			Worker ObjWo = (Worker)objWo;
			System.out.println(ObjWo.getName()+"--->"+ObjWo.getSalary());
		}
		ois.close();
	}

}








