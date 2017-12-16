package com.icehockey.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.icehockey.entity.User;

/**
 * Servlet implementation class HeightServlet
 */
@WebServlet("/HeightServlet")
public class HeightServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HeightServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setContentType("application/json");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=UTF-8");
		HttpSession session = request.getSession();
		PrintWriter writer = response.getWriter();
		Map<String, Object> map = new HashMap<String, Object>();
		System.out.println("-----------------身高选择后台程序.html----------");
		
		User user = null;
		System.out.println("跳转后的sessionId :" + session.getId());
		// session
		if (session.getAttribute("user") == null) {
			map.put("result", "-1");
		} else {
			System.out.println("跳转前的sessionId :" + session.getId());
			user = (User) session.getAttribute("user");
			System.out.println("user: " + user);
			// 前端获取传入的data
			if (request.getParameter("height") != null) {
				String	heightValue = request.getParameter("height");
				// 转化height
				double height = Double.parseDouble(heightValue);
				map.put("result", "0");
				map.put("height", height);
				session.setAttribute("user", user);
				session.setAttribute("height", height);
				System.out.println("map..." + map);
			} else {
				map.put("result", "-2");
			}
		}
		//根据result值，判断页面如何跳转
		if ("0".equals(map.get("result"))) {// 登录成功，且不是第一次登陆
			System.out.println("页面操作正确");
			writer.println("<script>window.location.href='./views/part4/weight.jsp'</script>");
			
		} else if ("-1".equals(map.get("result"))) {// 登陆失败，用户名不存在
			writer.println(
					"<script language='javascript'>alert('当前没有登录用户');window.location.href='./views/part1/zhucedengluyemian.jsp'</script>");
		} else if ("-2".equals(map.get("result"))) {// 前端错误
			writer.println(
					"<script language='javascript'>alert('前端错误');window.location.href='./views/error/qianduanError.jsp'</script>");
		} else if ("-3".equals(map.get("result"))) {// 插入失败
			writer.println(
					"<script language='javascript'>alert('插入失败');window.location.href='./views/error/insertError.jsp'</script>");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
