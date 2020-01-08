package cn.qjq.tcp;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 登录 双向 服务器    ---通知客户端登录成功或者失败
 * 1.指定端口，使用ServerSocket创建服务器
 * 2.阻塞式等待连接accept
 * 3.操作：输入输出流操作
 * 4.释放资源
 * @author qjq
 *2019年11月26日15:58:24
 */
public class LoginDoubleServer {
	public static void main(String[] args) throws IOException {
		System.out.println("------Server-----");  
		//1.指定端口，使用ServerSocket创建服务器
		ServerSocket server = new ServerSocket(9999);
		 //2.阻塞式等待连接accept
		Socket client = server.accept();//阻塞
		System.out.println("一个客户端建立了连接");
		 //3.操作：输入输出流操作
		//输入操作
		DataInputStream dis = new DataInputStream(client.getInputStream());
		String data = dis.readUTF();
		String[] dataArr = data.split("&");
		String uname = "";
		String psd = "";
		for(String str:dataArr) {
			String[] userInfo = str.split("=");
			if(userInfo[0].equals("uname")) {
				System.out.println("您的用户名为："+userInfo[1]);
				uname = userInfo[1];
			}else if(userInfo[0].equals("psd")) {
				System.out.println("您的密码为："+userInfo[1]);
				psd = userInfo[1];
			}
		}
		//输出操作
		DataOutputStream dos = new DataOutputStream(client.getOutputStream());
		if(uname.equals("qjq")&&psd.equals("123")) {//实际上次数据应该从数据库里面调用
			dos.writeUTF("登录成功");
		}else {
			dos.writeUTF("账户或者密码错误");
		}
		dos.flush();
		//4.释放资源
		dos.close();
		dis.close();
		client.close();
		server.close();//服务器一般24h工作，一般不关
	}

}
