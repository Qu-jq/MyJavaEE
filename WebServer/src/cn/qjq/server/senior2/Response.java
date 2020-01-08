package cn.qjq.server.senior2;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Date;

/**
 * 封装响应类
 * @author qjq
 *2019年12月2日19:58:43
 */
public class Response {
	private BufferedWriter bw;
	private StringBuilder contents;//正文信息
	private StringBuilder headInfo;//头部信息
	private int len;//正文的字节长度
	private final String BLANK = " ";
	private final String CRLF = "\r\n";//换行符
	private Response() {
		contents = new StringBuilder();
		headInfo = new StringBuilder();
		len = 0;
	}
	public Response(Socket client) {
		this();
		try {
			bw = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
		
		} catch (IOException e) {
			headInfo=null;
			e.printStackTrace();
		}
	}
	public Response(OutputStream os) {
		this();
		bw = new BufferedWriter(new OutputStreamWriter(os));
	}
	
	//推送给服务器
	public void push2Browser(int code) throws IOException {
		if(null == headInfo) {
			code = 505;
		}
		creatHeadInfo(code);
		bw.append(headInfo);
		bw.append(contents);
		bw.flush();
	}
	
	//构建头部信息
	private void creatHeadInfo(int code){
		//1、响应行: HTTP/1.1 200 OK
		headInfo.append("HTTP/1.1").append(BLANK);
		headInfo.append(code).append(BLANK);
		switch(code){
			case 200:
				headInfo.append("OK").append(CRLF);
				break;
			case 404:
				headInfo.append("NOT FIND").append(CRLF);
				break;
			case 505:
				headInfo.append("SERVER ERROR").append(CRLF);
				break;
		}
		//2、响应头(最后一行存在空行):
		/*
		 Date:Mon,31Dec209904:25:57GMT
		Server:qjq Server/0.0.1;charset=GBK
		Content-type:text/html
		Content-length:39725426
		 */
		headInfo.append("Date:").append(new Date()).append(CRLF);
		headInfo.append("Server:").append("qjq Server/0.0.1;charset=UTF-8").append(CRLF);
		headInfo.append("Content-type:text/html").append(CRLF);
		headInfo.append("Content-length:").append(this.len).append(CRLF);
		headInfo.append(CRLF);
	}
	
	//动态添加内容  流模式
	public Response print(String info) {
		contents.append(info);
		len += info.getBytes().length;
		return this;
	}
	public Response println(String info) {//换行
		contents.append(info).append(CRLF);
		len += (info+CRLF).getBytes().length;
		return this;
	}

}
