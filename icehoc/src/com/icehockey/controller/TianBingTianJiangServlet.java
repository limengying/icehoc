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

import com.icehockey.entity.Category;
import com.icehockey.entity.City;
import com.icehockey.entity.Club;
import com.icehockey.entity.Country;
import com.icehockey.entity.Handling;
import com.icehockey.entity.Player;
import com.icehockey.entity.Role;
import com.icehockey.entity.User;
import com.icehockey.entity.UserFollowPlayer;
import com.icehockey.service.CategoryService;
import com.icehockey.service.ClubService;
import com.icehockey.service.CountryCityService;
import com.icehockey.service.HandlingService;
import com.icehockey.service.PlayerService;
import com.icehockey.service.RoleService;
import com.icehockey.service.UserService;

/**
 * Servlet implementation class TianBingTianJiangServlet
 */
public class TianBingTianJiangServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TianBingTianJiangServlet() {
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
		System.out.println("-----------------添兵添将后台程序----------");
		/**
		 * 
		 * 声明对象
		 */
		PlayerService playerService = new PlayerService();
		ClubService clubService = new ClubService();
		CountryCityService countryCityService = new CountryCityService();
		UserService userService = new UserService();
		RoleService roleService = new RoleService();
		HandlingService handlingService = new HandlingService();
		CategoryService categoryService = new CategoryService();
		Handling handling = null;
		Country country = null;
		City city = null;
		User user = null;
		Player player = null;
		Club club = null;
		Role role = null;
		Category category = null;
		User creatMeUser = null;
		List<Player> players = null;
		List<Club> clubs = null;
		List<Category> categories = null;
		List<Handling> handlings = null;

		System.out.println("跳转后的sessionId :" + session.getId());
		String operateType = null;
		// session
		if (session.getAttribute("user") == null) {
			map.put("result", "-1");// 没有用户登录
		} else {
			user = (User) session.getAttribute("user");
			if (request.getParameter("operateType") != null) {
				operateType = request.getParameter("operateType");
				if ("zhukongToTianBingTianJiang".equals(operateType)) {// 如果操作类型是主控页面到浇冰必拜主页面，则取出用户关注的所有球员的信息
					players = playerService.getUserFollowedPlayers(user.getUserId());
					System.out.println(players);
					session.setAttribute("players", players);
					map.put("result", "0");
					map.put("ok", "1");

				} else if ("mohusousuo".equals(operateType)) {// 如果操作类型是模糊搜索，即根据名字字符串搜索当前关注球员
					String playerNameString = request.getParameter("playerName");
					System.out.println("playerNameString:" + playerNameString);
					players = playerService.getUserFollowedPlayersByNameString(user.getUserId(), playerNameString);
					System.out.println(players);
					session.setAttribute("players", players);
					map.put("result", "0");
					map.put("ok", "2");
				} else if ("jingquesousuo".equals(operateType)) {// 如果操作类型是精确搜索，即根据名字字符串搜索当前关注球员
					String playerName = request.getParameter("playerName");
					System.out.println("playerName:" + playerName);
					player = playerService.getUserFollowedPlayersByPlayerName(user.getUserId(), playerName);
					if (player != null) {
						country = countryCityService.queryCountry(player.getCountryId());
						city = countryCityService.queryCity(player.getCityId());
					}
					session.setAttribute("country", country);
					session.setAttribute("city", city);
					System.out.println(player);
					session.setAttribute("player", player);
					map.put("result", "0");
					map.put("ok", "3");
				} else if ("zhuyemianToXiangxi".equals(operateType)) {// 如果操作类型是精确搜索，即根据名字字符串搜索当前关注球员
					int playerId = Integer.parseInt(request.getParameter("playerId"));
					System.out.println("playerId:" + playerId);
					player = playerService.getPlayerByPlayerId(playerId);
					if (player != null) {
						club = clubService.queryClub(player.getPlayerId());
						country = countryCityService.queryCountry(player.getCountryId());
						city = countryCityService.queryCity(player.getCityId());
						role = roleService.queryRole(player.getRoleId());
						creatMeUser = userService.queryUserById(player.getCreatMeld());
						handling = handlingService.queryHandling(player.getHandlingId());
						category = categoryService.queryCategoryByCategoryId(player.getCategoryId());
					}
					System.out.println("creatMeUser" + creatMeUser);
					session.setAttribute("player", player);
					session.setAttribute("club", club);
					session.setAttribute("country", country);
					session.setAttribute("city", city);
					session.setAttribute("role", role);
					session.setAttribute("creatMeUser", creatMeUser);
					session.setAttribute("handling", handling);
					session.setAttribute("category", category);

					map.put("result", "0");
					map.put("ok", "4");
				} else if ("quxiaoguanzhu".equals(operateType)) {// 如果操作类型是精确搜索，即根据名字字符串搜索当前关注球员
					int playerId = Integer.parseInt(request.getParameter("playerId"));
					System.out.println("playerId:" + playerId);
					boolean flag = playerService.cancelFollowed(user.getUserId(), playerId);
					if (flag) {
						players = playerService.getUserFollowedPlayers(user.getUserId());
						System.out.println(flag);
						session.setAttribute("flag", flag);
						session.setAttribute("players", players);
						map.put("result", "0");
						map.put("ok", "5");
					} else {
						map.put("result", "-3");
					}
				} else if ("guanzhuqiuyuan".equals(operateType)) {// 如果操作类型是精确搜索，即根据名字字符串搜索当前关注球员
					int playerId = Integer.parseInt(request.getParameter("playerId"));
					System.out.println("playerId:" + playerId);
					UserFollowPlayer userFollowPlayer = playerService.userFollowPlayer(user.getUserId(), playerId);
					System.out.println(userFollowPlayer);
					players = playerService.getUserFollowedPlayers(user.getUserId());
					session.setAttribute("userFollowPlayer", userFollowPlayer);
					
					session.setAttribute("players", players);
					map.put("result", "0");
					map.put("ok", "6");
				} else if ("jibexinxi".equals(operateType)) {// 如果操作类型是精确搜索，即根据名字字符串搜索当前关注球员
					int playerId = Integer.parseInt(request.getParameter("playerId"));
					System.out.println("playerId:" + playerId);
					map.put("result", "0");
					map.put("ok", "7");
				} else if ("jibenxinxiToxiugai".equals(operateType)) {// 如果操作类型是精确搜索，即根据名字字符串搜索当前关注球员
					categories = categoryService.getAll();
					clubs = clubService.getAll();
					handlings = handlingService.getAll();

					session.setAttribute("categories", categories);
					session.setAttribute("clubs", clubs);
					session.setAttribute("handlings", handlings);
					System.out.println(categories);
					System.out.println(clubs);
					System.out.println(handlings);
					map.put("result", "0");
					map.put("ok", "8");
				} else if ("tijiaoxiugai".equals(operateType)) {// 如果操作类型是精确搜索，即根据名字字符串搜索当前关注球员
					int playerId = Integer.parseInt(request.getParameter("playerId"));
					player = playerService.getPlayerByPlayerId(playerId);

					String image = player.getImage();
					if (request.getParameter("image") != null && request.getParameter("image").length() > 24) {
						image = request.getParameter("image");
					}

					double weight = player.getWeight();
					if (!(request.getParameter("weight") == null||"".equals(request.getParameter("weight")))) {
						weight = Double.parseDouble(request.getParameter("weight"));
					}

					double height = player.getHeight();
					if (!(request.getParameter("height") == null||"".equals(request.getParameter("height")))) {
						height = Double.parseDouble(request.getParameter("height"));
					}

					String position = player.getPosition();
					if (!(request.getParameter("position") == null||"".equals(request.getParameter("position")))) {
						position = request.getParameter("position");
					}

					int categoryId = player.getCategoryId();
					if (!(request.getParameter("categoryId") == null||"".equals(request.getParameter("categoryId")))) {
						categoryId = Integer.parseInt(request.getParameter("categoryId"));
					}

					int handlingId = player.getHandlingId();
					if (!(request.getParameter("handlingId") == null||"".equals(request.getParameter("handlingId")))) {
						handlingId = Integer.parseInt(request.getParameter("handlingId"));
					}

					String birthday = player.getBirthday();
					if (!(request.getParameter("birthday") == null||"".equals(request.getParameter("birthday")))) {
						birthday = request.getParameter("birthday");
						System.out.println("birthday:"+birthday);
					}
					//这里没有处理球员所在俱乐部
					boolean f = playerService.updateInfo(playerId, weight, height, position, categoryId,
							handlingId, birthday, image);
					if (f) {
						players = playerService.getUserFollowedPlayers(user.getUserId());
						session.setAttribute("players", players);
						map.put("result", "0");
						map.put("ok", "9");
					} else {
						map.put("result", "-3");
					}
				} else {
					map.put("result", "-2");// 没有操作类型
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
						"<script language='javascript'>window.location.href='./views/part4/tianbingtianjiangzhuyemian.jsp'</script>");
			} else if ("2".equals(map.get("ok"))) {
				writer.println(
						"<script language='javascript'>window.location.href='./views/part4/tianbingtianjiangzhuyemian.jsp'</script>");
			} else if ("3".equals(map.get("ok"))) {
				writer.println(
						"<script language='javascript'>window.location.href='./views/part4/sousuojieguo.jsp'</script>");
			} else if ("4".equals(map.get("ok"))) {
				writer.println(
						"<script language='javascript'>window.location.href='./views/part4/qiuyuanxiangxixinxi.jsp'</script>");
			} else if ("5".equals(map.get("ok"))) {
				writer.println(
						"<script language='javascript'>window.location.href='./views/part4/tianbingtianjiangzhuyemian.jsp'</script>");
			} else if ("6".equals(map.get("ok"))) {
				writer.println(
						"<script language='javascript'>window.location.href='./views/part4/tianbingtianjiangzhuyemian.jsp'</script>");
			} else if ("7".equals(map.get("ok"))) {
				writer.println(
						"<script language='javascript'>window.location.href='./views/part4/jibenxinxi.jsp'</script>");
			} else if ("8".equals(map.get("ok"))) {
				writer.println(
						"<script language='javascript'>window.location.href='./views/part4/jibenxinxixiugai.jsp'</script>");
			} else if ("9".equals(map.get("ok"))) {
				writer.println(
						"<script language='javascript'>window.location.href='./views/part4/tianbingtianjiangzhuyemian.jsp'</script>");
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
		doGet(request, response);
	}

}
