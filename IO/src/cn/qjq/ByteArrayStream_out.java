package cn.qjq;

import java.io.*;

/**
 * 字节数组输出流
 * 1、创建源（字节,不要太大，防止内存占满）内部维护
 * 2、选择流   （不关联源）
 * 3、操作（写出内容）
 * 4、释放系统资源（可有可无，为了和前面文件字节流保持编程统一，可以有）
 * 
 *新增方法：
 *	获取数据----》 toByteArray()
 * @author qjq
 *2019年11月9日18:09:28
 */
public class ByteArrayStream_out {
	public static void main(String[] args) {
		//1.创建接收源头
		byte[] rec;
		//2.选择流
		ByteArrayOutputStream bos = null;//因为使用新增方法，所以此处是子类
		//3.操作
		try {
			bos = new ByteArrayOutputStream();//不需要传递参数
			byte[] data = "show me the code".getBytes();
			bos.write(data, 0, data.length);//写入缓冲区
			bos.flush();
			//获取数据
			rec = bos.toByteArray();//新增方法
			System.out.println(rec.length+ "字节"  + "--->" + new String(rec,0,rec.length));
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				if(null != bos)
					bos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}

}
