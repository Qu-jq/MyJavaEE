package cn.qjq;

import java.io.*;

/**
 * 数据流
 * 输入输出顺序一致
 * DataInputStream
 * DataOutputStream
 * @author qjq
 *2019年11月12日17:07:01
 */
public class DataStream {
	public static void main(String[] args) throws IOException {
		
		//写出
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(os));
		//操作数据类型
		dos.writeInt(4);
		dos.writeBoolean(false);
		dos.writeUTF("字符类型");
		dos.writeChar('c');
		dos.flush();
		//读取
		byte[] arr = os.toByteArray();
		ByteArrayInputStream is = new ByteArrayInputStream(arr);
		DataInputStream dis = new DataInputStream(new BufferedInputStream(is));
		//顺序与写出一致
		int i = dis.readInt();
		boolean flag=dis.readBoolean();
		String s = dis.readUTF();
		char c = dis.readChar();
		System.out.println(s);
		System.out.println(flag);
		
	}

}
