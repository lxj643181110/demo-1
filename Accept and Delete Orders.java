//Asa-Lv 68708475
package com.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.HzpBean;
import com.bean.NewsBean;
import com.util.Constant;

public class HzpAction extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public HzpAction() {
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

		doPost(request,response);
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

		request.setCharacterEncoding(Constant.CHARACTERENCODING);
		response.setContentType(Constant.CONTENTTYPE);
		HttpSession session=request.getSession();
		HzpBean tb=new HzpBean();
		String method=request.getParameter("method").trim();
		///////////////////////////////////////////////////////////////////////Commodity
		if(method.equals("deltrave")){
			String id=request.getParameter("id").trim();
			int flag = tb.delTrave(id);
			if(flag == Constant.SUCCESS){
				request.setAttribute("message", "Successful operation£¡");
				request.getRequestDispatcher("admin/hzp/index.jsp").forward(request, response);
			}
			else{
				request.setAttribute("message", "System maintenance, please try again later£¡");
				request.getRequestDispatcher("admin/hzp/index.jsp").forward(request, response);
			}
		}
		else if(method.equals("hotdeltrave")){
			String id=request.getParameter("id").trim();
			int flag = tb.delTrave(id);
			if(flag == Constant.SUCCESS){
				request.setAttribute("message", "Successful operation£¡");
				request.getRequestDispatcher("admin/hzp/hot.jsp").forward(request, response);
			}
			else{
				request.setAttribute("message", "System maintenance, please try again later£¡");
				request.getRequestDispatcher("admin/hzp/hot.jsp").forward(request, response);
			}
		}
		else if(method.equals("tejiadeltrave")){
			String id=request.getParameter("id").trim();
			int flag = tb.delTrave(id);
			if(flag == Constant.SUCCESS){
				request.setAttribute("message", "Successful operation£¡");
				request.getRequestDispatcher("admin/hzp/tejia.jsp").forward(request, response);
			}
			else{
				request.setAttribute("message", "System maintenance, please try again later£¡");
				request.getRequestDispatcher("admin/hzp/tejia.jsp").forward(request, response);
			}
		}
		else if(method.equals("tuijiandeltrave")){
			String id=request.getParameter("id").trim();
			int flag = tb.delTrave(id);
			if(flag == Constant.SUCCESS){
				request.setAttribute("message", "Successful operation£¡");
				request.getRequestDispatcher("admin/hzp/tuijian.jsp").forward(request, response);
			}
			else{
				request.setAttribute("message", "System maintenance, please try again later£¡");
				request.getRequestDispatcher("admin/hzp/tuijian.jsp").forward(request, response);
			}
		}
		else if(method.equals("hotTrave")){
			String id=request.getParameter("id").trim();
			int flag = tb.hotTrave(id);
			if(flag == Constant.SUCCESS){
				request.setAttribute("message", "Successful operation£¡");
				request.getRequestDispatcher("admin/hzp/index.jsp").forward(request, response);
			}
			else{
				request.setAttribute("message", "System maintenance, please try again later£¡");
				request.getRequestDispatcher("admin/hzp/index.jsp").forward(request, response);
			}
		}
		else if(method.equals("nohotTrave")){
			String id=request.getParameter("id").trim();
			int flag = tb.nohotTrave(id);
			if(flag == Constant.SUCCESS){
				request.setAttribute("message", "Successful operation£¡");
				request.getRequestDispatcher("admin/hzp/hot.jsp").forward(request, response);
			}
			else{
				request.setAttribute("message", "System maintenance, please try again later£¡");
				request.getRequestDispatcher("admin/hzp/hot.jsp").forward(request, response);
			}
		}
		else if(method.equals("addType")){
			String type=request.getParameter("type").trim();
			int flag=tb.addType(type);
			if(flag == Constant.SUCCESS){
				request.setAttribute("message", "Successful operation£¡");
				request.getRequestDispatcher("admin/hzp/type.jsp").forward(request, response);
			}
			else if(flag==Constant.DEFAULT_ERROR){
				request.setAttribute("message", "This category already exists£¡");
				request.getRequestDispatcher("admin/hzp/type.jsp").forward(request, response);
			}
			else{
				request.setAttribute("message", "System maintenance, please try again later£¡");
				request.getRequestDispatcher("admin/hzp/type.jsp").forward(request, response);
			}
		}
		else if(method.equals("delType")){
			String id=request.getParameter("id").trim();
			int flag=tb.delType(id);
			if(flag == Constant.SUCCESS){
				request.setAttribute("message", "Successful operation£¡");
				request.getRequestDispatcher("admin/hzp/type.jsp").forward(request, response);
			}
			
			else{
				request.setAttribute("message", "System maintenance, please try again later£¡");
				request.getRequestDispatcher("admin/hzp/type.jsp").forward(request, response);
			}
		}
		//////////////////////////////////////////////////////////////////Shopping cart
		else if(method.equals("addprep")){
			String sid=request.getParameter("sid").trim();
			String num=request.getParameter("num").trim();
			String member=(String)session.getAttribute("member");
			int flag = tb.addPrep(sid, Integer.parseInt(num), member);
			if(flag == Constant.SUCCESS){
				request.setAttribute("message", "Successful operation£¡");
				request.getRequestDispatcher("index.jsp").forward(request, response);
			}
			else{
				request.setAttribute("message", "System maintenance, please try again later£¡");
				request.getRequestDispatcher("index.jsp").forward(request, response);
			}
		}
		else if(method.equals("upprep")){/////////////////////////////////////////////////Change the number of purchases
			String id=request.getParameter("id").trim();
			String num=request.getParameter("num").trim();
			String sid=request.getParameter("sid").trim();
			String snum=request.getParameter("snum").trim();
			int flag = tb.updatePrep(id, num,sid,snum);
			if(flag == Constant.SUCCESS){
				request.setAttribute("message", "Successful operation£¡");
				request.getRequestDispatcher("member/prep/index.jsp").forward(request, response);
			}
			else if(flag == Constant.DEFAULT_ERROR){
				request.setAttribute("message", "The number of purchases exceeds the number of remaining products£¡");
				request.getRequestDispatcher("member/prep/index.jsp").forward(request, response);
			}
			else{
				request.setAttribute("message", "System maintenance, please try again later£¡");
				request.getRequestDispatcher("member/prep/index.jsp").forward(request, response);
			}
		}
		else if(method.equals("memberdelPrep")){
			String id=request.getParameter("id");
			int flag = tb.memberdelPrep(id);
			if(flag == Constant.SUCCESS){
				request.setAttribute("message", "Successful operation£¡");
				request.getRequestDispatcher("member/prep/index.jsp").forward(request, response);
			}
			else{
				request.setAttribute("message", "System maintenance, please try again later£¡");
				request.getRequestDispatcher("member/prep/index.jsp").forward(request, response);
			}
		}
		////////////////////////////////////////////////////////////////////////////////////Generate orders
		else if(method.equals("scdDan")){
			String check[] = request.getParameterValues("checkit");
			String member=(String)session.getAttribute("member");
			if(check == null){
				request.setAttribute("message", "Please select the shopping record to submit the generated order£¡");
				request.getRequestDispatcher("member/prep/index.jsp").forward(request, response);
			}
			else{
				int id2[]= new int[check.length];
				for(int i = 0;i<check.length;i++){
					int s = Integer.parseInt(check[i]);				
					id2[i] = s;
				}
				int flag = tb.scdDan(id2,member); 
				if(flag == Constant.SUCCESS){
					request.setAttribute("message", "The order has been submitted successfully, please wait for the administrator to ship£¡");
					request.getRequestDispatcher("member/prep/index.jsp").forward(request, response);
				}
				else{
					request.setAttribute("message", "System maintenance, please try again later£¡");
					request.getRequestDispatcher("member/prep/index.jsp").forward(request, response);
				}
			}
		}
		else if(method.equals("mdelPost")){/////////////////////Member deletes orders that have already been shipped
			String pid=request.getParameter("pid");
			int flag = tb.mdelPost(pid);
			if(flag == Constant.SUCCESS){
				request.setAttribute("message", "Successful operation£¡");
				request.getRequestDispatcher("member/prep/yi.jsp").forward(request, response);
			}
			else{
				request.setAttribute("message", "System maintenance, please try again later£¡");
				request.getRequestDispatcher("member/prep/yi.jsp").forward(request, response);
			}
		}
		/////////////////////////////////////////////////////////////////////////////////Administrator Manage Order¡¢Delete and Shipment
		else if(method.equals("admindelPrep")){
			String dnum=request.getParameter("dnum");
			int flag = tb.adelPost(dnum);
			if(flag == Constant.SUCCESS){
				request.setAttribute("message", "Successful operation£¡");
				request.getRequestDispatcher("admin/prep/index.jsp").forward(request, response);
			}
			else{
				request.setAttribute("message", "System maintenance, please try again later£¡");
				request.getRequestDispatcher("admin/prep/index.jsp").forward(request, response);
			}
		}
		else if(method.equals("admindelPrep2")){
			String dnum=request.getParameter("dnum");
			int flag = tb.adelPost(dnum);
			if(flag == Constant.SUCCESS){
				request.setAttribute("message", "Successful operation£¡");
				request.getRequestDispatcher("admin/prep/prep.jsp").forward(request, response);
			}
			else{
				request.setAttribute("message", "System maintenance, please try again later£¡");
				request.getRequestDispatcher("admin/prep/prep.jsp").forward(request, response);
			}
		}
		 
		else if(method.equals("sendB")){
			String dnum=request.getParameter("dnum");
			String member=request.getParameter("member");
			int flag = tb.sendB(dnum,member);
			if(flag == Constant.SUCCESS){
				request.setAttribute("message", "Successful operation£¡");
				request.getRequestDispatcher("admin/prep/prep.jsp").forward(request, response);
			}
			else{
				request.setAttribute("message", "System maintenance, please try again later£¡");
				request.getRequestDispatcher("admin/prep/prep.jsp").forward(request, response);
			}
		}
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occure
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
