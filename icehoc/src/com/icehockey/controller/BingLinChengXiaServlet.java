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

import com.icehockey.entity.Club;
import com.icehockey.entity.Match;
import com.icehockey.entity.Rink;
import com.icehockey.entity.User;
import com.icehockey.service.ClubService;
import com.icehockey.service.CompetitionService;
import com.icehockey.service.MatchService;
import com.icehockey.service.RinkService;

/**
 * Servlet implementation class BingLinChengXiaServlet
 */
public class BingLinChengXiaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BingLinChengXiaServlet() {
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
		System.out.println("-----------------兵临城下后台程序----------");

		ClubService clubService = new ClubService();
		RinkService rinkService = new RinkService();
		CompetitionService competitionService = new CompetitionService();
		MatchService matchService=new MatchService();

		User user = null;
		List<Match> matchs = null;
		List<Club> clubs = null;
		List<Rink> rinks = null;
		System.out.println("跳转后的sessionId :" + session.getId());
		String operateType = null;
		// session
		if (session.getAttribute("user") == null) {
			map.put("result", "-1");// 没有用户登录
		} else {
			user = (User) session.getAttribute("user");
			if (request.getParameter("operateType") != null) {
				operateType = request.getParameter("operateType");
				if ("zhukongToBingLinChengXia".equals(operateType)) {// 如果操作类型是主控页面到浇冰必拜主页面，则取出场地表中的所有场地信息
					matchs = matchService.getAllUserFollowCompetition(user.getUserId());
					session.setAttribute("matchs", matchs);
					System.out.println(matchs);
					map.put("matchs", matchs);
					map.put("result", "0");
					map.put("ok", "1");

				} else if ("tianjianxunliansai".equals(operateType)) {// 如果操作类型是主控页面到浇冰必拜主页面，则取出场地表中的所有场地信息
					rinks = rinkService.getRinks();
					clubs = clubService.getAll();
					session.setAttribute("rinks", rinks);
					session.setAttribute("clubs", clubs);
					map.put("result", "0");
					map.put("ok", "2");

				} else if ("BingLinChengXia".equals(operateType)) {// 如果操作类型是主控页面到浇冰必拜主页面，则取出场地表中的所有场地信息
					matchs = matchService.getAllUserFollowCompetition(user.getUserId());
					session.setAttribute("matchs", matchs);
					System.out.println(matchs);
					map.put("matchs", matchs);
					map.put("result", "0");
					map.put("ok", "1");

				} else if ("tijiaolinshisaishi".equals(operateType)) {// 如果操作类型是主控页面到浇冰必拜主页面，则取出场地表中的所有场地信息
					int rinkId = Integer.parseInt(request.getParameter("rinkId"));
					int teamAId = Integer.parseInt(request.getParameter("teamAId"));
					int teamBId = Integer.parseInt(request.getParameter("teamBId"));
					String remark = request.getParameter("remark");
					String time = request.getParameter("time");
					boolean f = competitionService.addCompetition(teamAId, teamBId, rinkId, time, remark, false);// 添加临时约赛
					if (f) {
						matchs = matchService.getAllUserFollowCompetition(user.getUserId());
						session.setAttribute("matchs", matchs);
						map.put("result", "0");
						map.put("ok", "3");
					} else {
						System.out.println("添加失败");
					}
				} else if ("yaoqingsaishichakan".equals(operateType)) {// 如果操作类型是主控页面到浇冰必拜主页面，则取出场地表中的所有场地信息
					matchs = matchService.getAllOfficialCompetitions();
					System.out.println(matchs);
					session.setAttribute("matchs", matchs);
					map.put("matchs", matchs);
					map.put("result", "0");
					map.put("ok", "4");
				} else if ("guanzhuyaoqingsaishi".equals(operateType)) {// 如果操作类型是主控页面到浇冰必拜主页面，则取出场地表中的所有场地信息
					int competitionId = Integer.parseInt(request.getParameter("competitionId"));
					System.out.println(competitionId);
					boolean f = matchService.addFollowCompetition(competitionId, user.getUserId());
					map.put("result", "0");
					map.put("ok", "5");
					if (f) {// 关注成功
						map.put("add", "0");
					} else {
						map.put("add", "-1");
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
						"<script language='javascript'>window.location.href='./views/part5/binglinchengxiazhuyemian.jsp'</script>");
			} else if ("2".equals(map.get("ok"))) {
				writer.println(
						"<script language='javascript'>window.location.href='./views/part5/tianjiaxunliansai.jsp'</script>");
			} else if ("3".equals(map.get("ok"))) {
				writer.println(
						"<script language='javascript'>alert('提交成功');window.location.href='./views/part5/binglinchengxiazhuyemian.jsp'</script>");
			} else if ("4".equals(map.get("ok"))) {
				writer.println(
						"<script language='javascript'>window.location.href='./views/part5/saishixuanze.jsp'</script>");
			} else if ("5".equals(map.get("ok"))) {
				if ("0".equals(map.get("add"))) {
					writer.println("<script language='javascript'>alert('关注成功');</script>");
				} else {
					writer.println("<script language='javascript'>alert('关注失败');</script>");
				}
				writer.println(
						"<script language='javascript'>window.location.href='./views/part5/saishixuanze.jsp'</script>");

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
