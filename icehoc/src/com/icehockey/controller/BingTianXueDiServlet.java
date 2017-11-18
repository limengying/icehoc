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
import com.icehockey.entity.DuiKang;
import com.icehockey.entity.SchoolTeam;
import com.icehockey.entity.User;
import com.icehockey.service.ClubService;
import com.icehockey.service.CompetitionService;
import com.icehockey.service.DuiKangService;
import com.icehockey.service.SchoolTeamService;

/**
 * Servlet implementation class BingTianXueDiServlet
 */
public class BingTianXueDiServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BingTianXueDiServlet() {
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
		System.out.println("-----------------冰天雪地后台程序----------");

		DuiKangService duiKangService = new DuiKangService();
		ClubService clubService = new ClubService();
		SchoolTeamService schoolTeamService = new SchoolTeamService();
		CompetitionService competitionService=new CompetitionService();
		User user = null;
		Club club = null;
		SchoolTeam schoolTeam = null;
		DuiKang duiKang = null;
		List<DuiKang> duiKangs = null;
		List<Club> clubs = null;
		List<SchoolTeam> schoolTeams = null;
		System.out.println("跳转后的sessionId :" + session.getId());
		String operateType = null;
		// session
		if (session.getAttribute("user") == null) {
			user = null;
			map.put("result", "-1");// 没有用户登录
		} else {
			user = (User) session.getAttribute("user");
			if (request.getParameter("operateType") != null) {
				operateType = request.getParameter("operateType");
				if ("zhukongToBingTianXueDi".equals(operateType)) {// 如果操作类型是主控页面到浇冰必拜主页面，则取出场地表中的所有场地信息
					clubs = clubService.getAll();
					session.setAttribute("clubs", clubs);
					map.put("result", "0");
					map.put("ok", "1");

				} else if ("clubSearch".equals(operateType)) {// 如果操作类型是主控页面到浇冰必拜主页面，则取出场地表中的所有场地信息
					String nameString = request.getParameter("searchString");
					clubs = clubService.queryClubByNameString(nameString);
					session.setAttribute("clubs", clubs);
					map.put("result", "0");
					map.put("ok", "2");

				} else if ("schoolTeamSearch".equals(operateType)) {// 如果操作类型是主控页面到浇冰必拜主页面，则取出场地表中的所有场地信息
					String nameString = request.getParameter("searchString");
					schoolTeams = schoolTeamService.querySchoolTeamsByNameString(nameString);
					session.setAttribute("schoolTeams", schoolTeams);
					map.put("result", "0");
					map.put("ok", "3");
				} else if ("competitionSearch".equals(operateType)) {// 如果操作类型是主控页面到浇冰必拜主页面，则取出场地表中的所有场地信息
					String nameString = request.getParameter("searchString");
					duiKangs = duiKangService.queryDuiKangsByNameString(nameString);
					session.setAttribute("duiKangs", duiKangs);
					map.put("result", "0");
					map.put("ok", "4");
				} else if ("clubToXiangxi".equals(operateType)) {// 如果操作类型是主控页面到浇冰必拜主页面，则取出场地表中的所有场地信息
					int clubId = Integer.parseInt(request.getParameter("searchId"));
					club = clubService.queryClubByClubId(clubId);
					session.setAttribute("club", club);
					map.put("result", "0");
					map.put("ok", "5");
				} else if ("schoolTeamAll".equals(operateType)) {// 如果操作类型是主控页面到浇冰必拜主页面，则取出场地表中的所有场地信息
					schoolTeams = schoolTeamService.querySchoolTeams();
					session.setAttribute("schoolTeams", schoolTeams);
					map.put("result", "0");
					map.put("ok", "6");
				} else if ("schoolTeamToXiangxi".equals(operateType)) {// 如果操作类型是主控页面到浇冰必拜主页面，则取出场地表中的所有场地信息
					int schoolTeamId = Integer.parseInt(request.getParameter("searchId"));
					schoolTeam = schoolTeamService.querySchoolTeamBySchoolTeamId(schoolTeamId);
					session.setAttribute("schoolTeam", schoolTeam);
					map.put("result", "0");
					map.put("ok", "7");
				} else if ("competitionAll".equals(operateType)) {// 如果操作类型是主控页面到浇冰必拜主页面，则取出场地表中的所有场地信息
					duiKangs = duiKangService.getDuiKangsAll();
					session.setAttribute("duiKangs", duiKangs);
					map.put("result", "0");
					map.put("ok", "8");
				} else if ("competitionToXiangxi".equals(operateType)) {// 如果操作类型是主控页面到浇冰必拜主页面，则取出场地表中的所有场地信息
					int id = Integer.parseInt(request.getParameter("searchId"));
					duiKang = duiKangService.getDuiKangById(id);
					session.setAttribute("duiKang", duiKang);
					map.put("result", "0");
					map.put("ok", "9");
				} else if ("tianjiaClub".equals(operateType)) {// 如果操作类型是主控页面到浇冰必拜主页面，则取出场地表中的所有场地信息
					String clubName = request.getParameter("clubName");
					String buildTime = request.getParameter("buildTime");
					String construction = request.getParameter("clubConstruction");
					boolean f = clubService.addClub(clubName, buildTime, construction);
					if (f) {
						clubs = clubService.getAll();
						session.setAttribute("clubs", clubs);
						map.put("result", "0");
						map.put("ok", "10");
					} else {
						map.put("result", "-3");
					}

				}else if ("tianjiaSchoolTeam".equals(operateType)) {// 如果操作类型是主控页面到浇冰必拜主页面，则取出场地表中的所有场地信息
					
					String teamName = request.getParameter("SchoolTeamName");
					String buildTime = request.getParameter("buildTime");
					String construction = request.getParameter("schoolTeamConstruction");
					boolean f = schoolTeamService.addschoolTeam(teamName, buildTime, construction);
					if (f) {
						schoolTeams = schoolTeamService.querySchoolTeams();
						session.setAttribute("schoolTeams", schoolTeams);
						map.put("result", "0");
						map.put("ok", "11");
					} else {
						map.put("result", "-3");
					}

				}else if ("tianjiaCompetition".equals(operateType)) {// 如果操作类型是主控页面到浇冰必拜主页面，则取出场地表中的所有场地信息
					
					String competitionName = request.getParameter("competitionName");
					String remark = request.getParameter("competitionConstruction");
					boolean f = competitionService.addCompetition(competitionName, remark);
					if (f) {
						duiKangs = duiKangService.getDuiKangsAll();
						session.setAttribute("duiKangs", duiKangs);
						map.put("result", "0");
						map.put("ok", "12");
					} else {
						map.put("result", "-3");
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
						"<script language='javascript'>window.location.href='./views/part3/bingtianxuedizhuyemian.jsp'</script>");
			} else if ("2".equals(map.get("ok"))) {
				writer.println(
						"<script language='javascript'>window.location.href='./views/part3/bingtianxuedizhuyemian.jsp'</script>");
			} else if ("3".equals(map.get("ok"))) {
				writer.println(
						"<script language='javascript'>window.location.href='./views/part3/xiaoduiyemian.jsp'</script>");
			} else if ("4".equals(map.get("ok"))) {
				writer.println(
						"<script language='javascript'>window.location.href='./views/part3/bisaiyemian.jsp'</script>");
			} else if ("5".equals(map.get("ok"))) {
				writer.println("<script language='javascript'>window.location.href='./views/part3/club.jsp'</script>");
			} else if ("6".equals(map.get("ok"))) {
				writer.println(
						"<script language='javascript'>window.location.href='./views/part3/xiaoduiyemian.jsp'</script>");
			} else if ("7".equals(map.get("ok"))) {
				writer.println(
						"<script language='javascript'>window.location.href='./views/part3/schoolTeam.jsp'</script>");
			} else if ("8".equals(map.get("ok"))) {
				writer.println(
						"<script language='javascript'>window.location.href='./views/part3/bisaiyemian.jsp'</script>");
			} else if ("9".equals(map.get("ok"))) {
				writer.println(
						"<script language='javascript'>window.location.href='./views/part3/competition.jsp'</script>");
			}else if ("10".equals(map.get("ok"))) {
				writer.println(
						"<script language='javascript'>window.location.href='./views/part3/bingtianxuedizhuyemian.jsp'</script>");
			}else if ("11".equals(map.get("ok"))) {
				writer.println(
						"<script language='javascript'>window.location.href='./views/part3/xiaoduiyemian.jsp'</script>");
			}else if ("12".equals(map.get("ok"))) {
				writer.println(
						"<script language='javascript'>window.location.href='./views/part3/bisaiyemian.jsp'</script>");
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
