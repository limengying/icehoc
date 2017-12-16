package com.icehockey.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.icehockey.entity.Player;
import com.icehockey.entity.User;
import com.icehockey.service.PlayerService;
import com.icehockey.service.UserService;

/**
 * Servlet implementation class AliasServlet
 */
@WebServlet("/AliasServlet")
public class AliasServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AliasServlet() {
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
		System.out.println("-----------------身高选择后台程序.html----------");

		User user = null;
		Player player =null;
		String f = "";
		PlayerService playerService = new PlayerService();
		List<Player> players = null;
		UserService userService = new UserService();
		System.out.println("跳转后的sessionId :" + session.getId());
		// session
		if (session.getAttribute("user") == null) {
			map.put("reslut", "-1");
		} else {
			System.out.println("跳转前的sessionId :" + session.getId());
			user = (User) session.getAttribute("user");
			System.out.println("user: " + user);
			// 前端获取传入的data
			String userName = "";
			String imageUrl = "";
			String idNo = "";// 身份证号码
			
			if (request.getParameter("name") != null && request.getParameter("touxiang") != null
					&& request.getParameter("idnum") != null) {
				userName = request.getParameter("name");
				imageUrl = request.getParameter("touxiang");
				idNo = request.getParameter("idnum");
				player=playerService.getPlayerByPlayerIdNo(idNo);
				System.out.println(player);
				if (player == null) {
					map.put("result", "0");
					session.setAttribute("user", user);
					session.setAttribute("userName", userName);
					session.setAttribute("imageUrl", imageUrl);
					session.setAttribute("idNo", idNo);
					boolean gender = (Boolean) session.getAttribute("gender");
					double height = (Double) session.getAttribute("height");
					double weight = (Double) session.getAttribute("weight");
					String category = (String) session.getAttribute("role");
					String handlingValue = (String) session.getAttribute("handling");

					System.out.println("gender:" + gender);
					System.out.println("height:" + height);
					System.out.println("weight:" + weight);
					System.out.println("category:" + category);
					System.out.println("handlingValue:" + handlingValue);
					f = userService.insertNewPlayer(user.getUserId(), gender, height, weight, category, handlingValue,
							userName, imageUrl, idNo);
					if ("创建成功".equals(f)) {
						players = playerService.getUserFollowedPlayers(user.getUserId());
						session.setAttribute("players", players);
						map.put("ok", "0");
					} else {
						map.put("ok", "-1");
					}
				} else {
					map.put("result", "-4");// 身份证号码已存在
				}

			} else {
				map.put("result", "-2");
			}
		}
		// 根据result值，判断页面如何跳转
		if ("0".equals(map.get("result"))) {// 登录成功，且不是第一次登陆
			System.out.println("页面操作正确");
			if ("0".equals(map.get("ok"))) {
				writer.println(
						"<script language='javascript'>alert('新建球员成功');window.location.href='./views/part4/tianbingtianjiangzhuyemian.jsp'</script>");
			} else {
				writer.println(
						"<script language='javascript'>alert('新建球员失败');window.location.href='./views/part4/tianbingtianjiangzhuyemian.jsp'</script>");
			}
		}else if ("-1".equals(map.get("result"))) {// 登陆失败，用户名不存在
			writer.println(
					"<script language='javascript'>alert('当前没有登录用户');window.location.href='./views/part1/zhucedengluyemian.jsp'</script>");
		} else if ("-2".equals(map.get("result"))) {// 前端错误
			writer.println(
					"<script language='javascript'>alert('前端错误');window.location.href='./views/error/qianduanError.jsp'</script>");
		} else if ("-3".equals(map.get("result"))) {// 插入失败
			writer.println(
					"<script language='javascript'>alert('插入失败');window.location.href='./views/error/insertError.jsp'</script>");
		} else if ("-4".equals(map.get("result"))) {// 插入失败
			writer.println(
					"<script language='javascript'>alert('身份证号码已存在');window.location.href='./views/part4/alias.jsp'</script>");

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
