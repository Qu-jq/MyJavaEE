package cn.qjq;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.util.Date;

/**
 * ������
 * ���л��ͷ����л�
 * ObjectOutputStream
 * ObjectInputStream
 * 1��д�����ȡ
 * 2����ȡ��д��˳�򱣳�һ��
 * 3���������е��඼�������л�������ʵ��Serializable�ӿ�
 * @author qjq
 *2019��11��12��19:01:26
 */
public class ObjectStream {
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(bos));
		oos.writeBoolean(false);
		oos.writeChar('c');//����д��������������
		oos.writeObject("��������ᣬ˭������ζ��");//String�ڲ�ʵ����Serializable�ӿ�
		oos.writeObject(new Date());
		Worker worker = new Worker("С��",50000);
		oos.writeObject(worker);
		oos.flush();
		byte[] data = bos.toByteArray();
		ObjectInputStream ois = new  ObjectInputStream(new BufferedInputStream(new ByteArrayInputStream(data)) );
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
	}

}

class Worker implements java.io.Serializable{
	private transient String name;//�����ݲ���Ҫ���л�
	private int salary;
	public Worker() {
	}
	public Worker(String name,int salary) {
		this.name=name;
		this.salary = salary;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}	
}







