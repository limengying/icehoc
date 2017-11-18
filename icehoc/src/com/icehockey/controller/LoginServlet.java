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
import com.icehockey.service.UserService;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setContentType("application/json");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=UTF-8");
		HttpSession session = request.getSession();
		PrintWriter writer = response.getWriter();
		Map<String, Object> map = new HashMap<String, Object>();
		System.out.println("-----------------LoginOrRegister.html----------");

		UserService userService = new UserService();
		User user = null;

		// 遍历map得到前端传入的值
		String telephone = "";
		// String verificationCode = "";
		String password = "";
		String optType = "";
		if (request.getParameter("optType") != null) {
			optType = request.getParameter("optType");
			System.out.println("optType..." + optType);
			if ("login".equals(optType)) {// 登录
				if (request.getParameter("phoneNumber") != null && request.getParameter("newPassword") != null) {
					telephone = request.getParameter("phoneNumber");
					password = request.getParameter("newPassword");
					System.out.println(telephone + " ... " + password + " ... " + optType);
					// 登录函数
					user = userService.loginByTelepone(telephone, password);
					if (user != null) {// 登录成功
						if (user.getUserId() != -1) {
							System.out.println("找到session当前用户" + user);
							session.setAttribute("user", user);
							System.out.println("user: " + user);
							map.put("result", "0");
							map.put("telephone", telephone);
							map.put("password", password);
						} else {
							System.out.println("用户输入 密码错误，session存储失败");
							map.put("result", "-3");// 密码错误
						}
					} else {
						System.out.println("该用户不存在，map未找到...");
						map.put("result", "-2");
					}
				} else {// 没有登录账号或者密码的参数
					System.out.println("没有登录账号或者密码的参数...");
					map.put("result", "-1");
				}

			} else if ("register".equals(optType)) {// 注册
				if (request.getParameter("phoneNumber") != null && request.getParameter("newPassword") != null) {
					telephone = request.getParameter("phoneNumber");
					password = request.getParameter("newPassword");
					// 注册函数
					user = userService.Register(telephone, password);
					if (user != null) {// 注册成功
						if ("注册成功".equals(user.getRemark())) {
							System.out.println("找到session当前用户" + user);
							// session
							session.setAttribute("user", user);
							System.out.println("user: " + user);
							map.put("result", "10");// 跳转至登录
						} else {
							System.out.println("该用户已存在");
							map.put("result", "11");// 密码错误
						}
					} else {
						System.out.println("该用户已存在，请登录");
						map.put("result", "12");// 跳转至登录
					}
				} else {// 没有登录账号或者密码的参数
					System.out.println("没有登录账号或者密码的参数...");
					map.put("result", "-1");
				}
			}
		} else {// 没有操作类型

		}

		if ("0".equals(map.get("result"))) {// 登录成功，且不是第一次登录
			writer.println("<script>window.location.href='./views/part1/zhukongyemian.jsp'</script>");
		} else if ("-1".equals(map.get("result"))) {// 缺少参数
			writer.println("<script>alert('缺少参数');window.location.href='./views/part1/qitadenglufangshi.jsp'</script>");
		} else if ("-2".equals(map.get("result"))) {// 登录失败，用户名不存在
			writer.println(
					"<script language='javascript'>alert('用户名不存在，如果您还没有账号，可以选择注册!');window.location.href='./views/part1/qitadenglufangshi.jsp'</script>");
		} else if ("-3".equals(map.get("result"))) {// 登录失败，密码错误
			writer.println(
					"<script language='javascript'>alert('密码错误!');window.location.href='./views/part1/qitadenglufangshi.jsp'</script>");
		} else if ("10".equals(map.get("result"))) {// 注册成功，跳转至登录
			writer.println(
					"<script language='javascript'>alert('注册成功，请登录!');window.location.href='./views/part1/qitadenglufangshi.jsp'</script>");
		}  else if ("11".equals(map.get("result"))) {// 注册失败，跳转至注册
			writer.println(
					"<script language='javascript'>alert('用户已存在，请登录!');window.location.href='./views/part1/qitadenglufangshi.jsp'</script>");
		}else if ("12".equals(map.get("result"))) {// 注册失败，跳转至注册
			writer.println(
					"<script language='javascript'>alert('注册失败，请重新注册!');window.location.href='./views/part1/zhuceyemian.jsp'</script>");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
