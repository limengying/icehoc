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
		HttpSession session = request.getSession();
		response.setContentType("application/json");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=UTF-8");
		response.setHeader("set-Cookie", "name=value;HttpOnly");
		System.out.println("-------------首页.html-----------");
		PrintWriter writer = response.getWriter();
		Map<String, Object> map = new HashMap<String, Object>();
		System.out.println("跳转后的sessionId :" + session.getId());
		PlayerService playerService=new PlayerService();
		// session
		if (session.getAttribute("user") != null) {
			User user=(User) session.getAttribute("user");
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
					List<Player> players=playerService.getUserFollowedPlayers(user.getUserId());
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
