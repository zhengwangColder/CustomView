package com.hongshi.controller;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/*
 * 这个
 */
public class ControllerServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	/**
	 * Constructor of the object.
	 */
	public ControllerServlet() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println("  <BODY>");
		out.print("    This is ");
		out.print(this.getClass());
		out.println(", using the GET method");
		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setHeader("Content-type", "text/html;charset=UTF-8");  
		response.setCharacterEncoding("UTF-8");  
		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
		String requestValue = request.getParameter("layout");
		String fileName = request.getParameter("fileName");
		
		String location = request.getServletContext().getRealPath("/");
		
		//new String(String.getBytes("ISO-8859-1"), "utf-8");解决乱码问题
		
		String xmlstr="aaa";  
	      // File file = new File("d:\\fileName.doc");  
	       File file = new File(location + fileName+".html");
	  
	       byte []strtemp = requestValue.getBytes("UTF-8");  
	       
	       
	      //来源你字符串的输入流  
	       InputStream in =new ByteArrayInputStream(strtemp);  
	       OutputStream outs =null;  
	            
	       try {  
	          //到你文件的输出流  
	           outs=  new FileOutputStream(file );  
	  
	       byte[] temp =new byte[1024];  
	  
	           //读输入，写到输出  
	           while(in.read(temp)!=-1){  
	               outs.write(temp);  
	           }  
	           out.flush();  
	         
	       }  
	       catch (Exception e) {  
	           // TODO Auto-generated catch block  
	           e.printStackTrace();  
	       }  
	       finally{  
	           try {  
	               if(in!=null){  
	                   in.close();   
	               }  
	               if(out!=null){  
	                   outs.close();  
	               }  
	                
	           }  
	           catch (IOException e) {  
	                
	           }  
	            
	       }  
		System.out.println("[ControllerServlet] doPost requestValue: "+requestValue +" fileName:"+fileName +" location:"+location);
		out.println(requestValue);
//		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
//		out.println("<HTML>");
//		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
//		out.println("  <BODY>");
//		out.print("    This is ");
//		out.print(this.getClass());
//		out.println(", using the POST method");
//		out.println("  </BODY>");
//		out.println("</HTML>");
		out.flush();
		out.close();
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
