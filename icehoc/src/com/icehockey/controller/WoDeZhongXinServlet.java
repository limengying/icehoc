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

import com.icehockey.entity.City;
import com.icehockey.entity.Country;
import com.icehockey.entity.IdInfo;
import com.icehockey.entity.Player;
import com.icehockey.entity.User;
import com.icehockey.service.CountryCityService;
import com.icehockey.service.IdInfoService;
import com.icehockey.service.PlayerService;
import com.icehockey.service.UserService;

/**
 * Servlet implementation class WoDeZhongXinServlet
 */
public class WoDeZhongXinServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public WoDeZhongXinServlet() {
		super();
		// TODO Auto-generated constructor stub
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
		System.out.println("-----------------我的中心后台程序----------");

		/**
		 * 变量声明
		 * 
		 */
		PlayerService playerService = new PlayerService();
		CountryCityService countryCityService = new CountryCityService();
		UserService userService = new UserService();
		IdInfoService idInfoService = new IdInfoService();
		Country country = null;
		City city = null;
		User user = null;
		IdInfo idInfo = null;
		List<Player> players = null;
		System.out.println("跳转后的sessionId :" + session.getId());
		String operateType = null;
		// session
		if (session.getAttribute("user") == null) {
			map.put("result", "-1");// 没有用户登录
		} else {
			user = (User) session.getAttribute("user");
			System.out.println(user + "user");
			if (request.getParameter("operateType") != null) {
				operateType = request.getParameter("operateType");
				if ("zhongxinToManager".equals(operateType)) {// 如果操作类型是主控页面到浇冰必拜主页面，则取出场地表中的所有场地信息

					country = countryCityService.queryCountry(user.getCountryId());
					city = countryCityService.queryCity(user.getCityId());
					idInfo = idInfoService.getRecordByIdInfo(user.getIdInfoId());
					System.out.println(country);
					System.out.println(city);
					System.out.println(idInfo);
					session.setAttribute("country", country);
					session.setAttribute("city", city);
					session.setAttribute("idInfo", idInfo);
					map.put("result", "0");
					map.put("ok", "1");
				} else if ("xiugaixinxi".equals(operateType)) {// 如果操作类型是主控页面到浇冰必拜主页面，则取出场地表中的所有场地信息

					String name = user.getUserName();
					if (!(request.getParameter("name") == null||"".equals(request.getParameter("name")))) {
						name = request.getParameter("name");
					}
					String birthday = user.getBirthday();
					if (!(request.getParameter("birthday") == null||"".equals(request.getParameter("birthday")))) {
						birthday = request.getParameter("birthday");
					}
					String address = user.getAddress();
					if (!(request.getParameter("address") == null||"".equals(request.getParameter("address")))) {
						address = request.getParameter("address");
					}
					boolean f = userService.updateUser(user.getUserId(), name, birthday, address);
					if (f) {
						user=userService.queryUserById(user.getUserId());
						session.setAttribute("user", user);
						map.put("result", "0");
						map.put("ok", "2");
					} else {
						System.out.println("更新失败");
					}
				} else if ("zhongxinToPlayer".equals(operateType)) {// 如果操作类型是主控页面到浇冰必拜主页面，则取出场地表中的所有场地信息
					players = playerService.getUserFollowedPlayers(user.getUserId());
					if (players != null) {
						session.setAttribute("players", players);
						map.put("result", "0");
						map.put("ok", "3");
					} else {

						System.out.println("更新失败");
					}
				}
			} else {
				map.put("result", "-2");// 没有操作类型
			}
		}
		// 根据result值，判断页面如何跳转
		if ("0".equals(map.get("result"))) {// 登录成功，且不是第一次登陆
			System.out.println("页面操作正确");
			if ("1".equals(map.get("ok"))) {
				writer.println(
						"<script language='javascript'>window.location.href='./views/part8/mangerCard.jsp'</script>");
			} else if ("2".equals(map.get("ok"))) {
				writer.println(
						"<script language='javascript'>alert('提交成功');window.location.href='./views/part8/wodezhongxin.jsp'</script>");
			} else if ("3".equals(map.get("ok"))) {
				writer.println(
						"<script language='javascript'>window.location.href='./views/part8/playerCard.jsp'</script>");
			} else {

			}
		} else if ("-1".equals(map.get("result"))) {// 登陆失败，用户名不存在
			writer.println(
					"<script language='javascript'>alert('当前没有登录用户');window.location.href='./views/part1/zhucedengluyemian.jsp'</script>");

		} else if ("-2".equals(map.get("result"))) {// 前端错误
			writer.println(
					"<script language='javascript'>alert('前端错误');window.location.href='history.back(-1);'</script>");

		} else if ("-3".equals(map.get("result"))) {// 插入失败
			writer.println(
					"<script language='javascript'>alert('插入失败');window.location.href='history.back(-1);'</script>");

		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
