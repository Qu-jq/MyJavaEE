package cn.qjq.server.senior;

public class LoginServlet implements Servlet{

	@Override
	public void service(Request request,Response response) {
		//关注了内容
		response.print("<html>"); 
		response.print("<head>"); 
		response.print("<title>");
		response.print("第一个servlet....");
		response.print("</title>");
		response.print("</head>");
		response.print("<body>");
		response.print("shsxt server终于回来了。。。。"+request.getParameter("uname"));
		response.print("</body>");
		response.print("</html>");
		
		
	}
	
	

}
