package cn.qjq.server.finals;

public class RegisterServlet implements Servlet {

	@Override
	public void service(Request request,Response response){
		
		response.print("注册成功！！!");

	}

}
