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
 * 对象流   写入写出文件
 * 序列化和反序列化
 * ObjectOutputStream
 * ObjectInputStream
 * 1、写出后读取
 * 2、读取与写出顺序保持一致
 * 3、不是所有的类都可以序列化，必须实现Serializable接口
 * @author qjq
 *2019年11月12日19:01:26
 */
public class ObjectStream2 {
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		
		ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("Obj.ser")));
		oos.writeBoolean(false);
		oos.writeChar('c');//可以写出基本数据类型
		oos.writeObject("编程辛酸泪，谁解其中味！");//String内部实现了Serializable接口
		oos.writeObject(new Date());
		Worker worker = new Worker("小渠",50000);
		oos.writeObject(worker);
		oos.flush();
		oos.close();
		
		
		//反序列化
		ObjectInputStream ois = new  ObjectInputStream(new BufferedInputStream(new FileInputStream("obj.ser")) );//自己取得后缀
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
		ois.close();
	}

}








