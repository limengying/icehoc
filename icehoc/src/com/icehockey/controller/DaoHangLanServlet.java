package com.icehockey.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.icehockey.entity.Player;
import com.icehockey.entity.User;
import com.icehockey.service.LoginLogService;
import com.icehockey.service.PlayerService;

/**
 * Servlet implementation class DaoHangLanServlet
 */
public class DaoHangLanServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DaoHangLanServlet() {
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
		System.out.println("-----------------导航栏后台程序.html----------");
		
		System.out.println("跳转后的sessionId :" + session.getId());
		PlayerService playerService=new PlayerService();
		LoginLogService loginLogService=new LoginLogService();

		// session
		if (session.getAttribute("user") != null&&session.getAttribute("loginLogId")!=null) {
			
			User user=(User) session.getAttribute("user");
			int loginLogId=(int) session.getAttribute("loginLogId");
			int signedNum=loginLogService.getSignedNum(user.getUserId());
			session.setAttribute("loginLogId", loginLogId);
			System.out.println(signedNum);
			session.setAttribute("signedNum", signedNum);
			map.put("reslut", "0");
			if (request.getParameter("operateType") != null) {
				String opt = request.getParameter("operateType");
				if ("shouye".equals(opt)) {
					map.put("ok", "shouye");
					System.out.println(map.get("ok"));
					writer.println("<script>window.location.href='./views/part1/zhukongyemian.jsp'</script>");

				} else if ("zhanshu".equals(opt)) {
					map.put("ok", "zhanshu");
					System.out.println(map.get("ok"));
					writer.println("<script>window.location.href='./views/part7/zhanshubanzhuyemian.jsp'</script>");

				} else if ("zhandui".equals(opt)) {
					map.put("ok", "zhandui");
					System.out.println(map.get("ok"));
					writer.println(
							"<script>alert('待开发');window.location.href='./views/part1/zhukongyemian.jsp'</script>");

				} else if ("wode".equals(opt)) {
					System.out.println(user.getUserId());
					List<Player> players=playerService.getAllFollowPlayers(user.getUserId());
					session.setAttribute("num", players.size());
					map.put("ok", "wode");
					System.out.println(map.get("ok"));
					writer.println("<script>window.location.href='./views/part8/wodezhongxin.jsp'</script>");

				} else {
					map.put("ok", "-1");
					writer.println(
							"<script>alert('操作错误');window.location.href='./views/part1/zhukongyemian.jsp'</script>");

				}
			}
		} else {
			map.put("reslut", "-1");
			writer.println(
					"<script>alert('当前没有登录用户');window.location.href='./views/part1/zhucedengluyemian.jsp'</script>");

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
