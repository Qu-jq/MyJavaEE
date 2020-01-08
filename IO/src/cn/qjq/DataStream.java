package cn.qjq;

import java.io.*;

/**
 * ������
 * �������˳��һ��
 * DataInputStream
 * DataOutputStream
 * @author qjq
 *2019��11��12��17:07:01
 */
public class DataStream {
	public static void main(String[] args) throws IOException {
		
		//д��
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(os));
		//������������
		dos.writeInt(4);
		dos.writeBoolean(false);
		dos.writeUTF("�ַ�����");
		dos.writeChar('c');
		dos.flush();
		//��ȡ
		byte[] arr = os.toByteArray();
		ByteArrayInputStream is = new ByteArrayInputStream(arr);
		DataInputStream dis = new DataInputStream(new BufferedInputStream(is));
		//˳����д��һ��
		int i = dis.readInt();
		boolean flag=dis.readBoolean();
		String s = dis.readUTF();
		char c = dis.readChar();
		System.out.println(s);
		System.out.println(flag);
		
	}

}
