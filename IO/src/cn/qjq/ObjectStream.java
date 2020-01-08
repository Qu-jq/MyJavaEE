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
 * 对象流
 * 序列化和反序列化
 * ObjectOutputStream
 * ObjectInputStream
 * 1、写出后读取
 * 2、读取与写出顺序保持一致
 * 3、不是所有的类都可以序列化，必须实现Serializable接口
 * @author qjq
 *2019年11月12日19:01:26
 */
public class ObjectStream {
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(bos));
		oos.writeBoolean(false);
		oos.writeChar('c');//可以写出基本数据类型
		oos.writeObject("编程辛酸泪，谁解其中味！");//String内部实现了Serializable接口
		oos.writeObject(new Date());
		Worker worker = new Worker("小渠",50000);
		oos.writeObject(worker);
		oos.flush();
		byte[] data = bos.toByteArray();
		ObjectInputStream ois = new  ObjectInputStream(new BufferedInputStream(new ByteArrayInputStream(data)) );
		boolean b = ois.readBoolean();
		char c = ois.readChar();
		//对象数据还原   反序列化
		Object objStr = ois.readObject();
		Object objDa = ois.readObject();
		Object objWo = ois.readObject();
		//防止转换错误
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
	private transient String name;//该数据不需要序列化
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







