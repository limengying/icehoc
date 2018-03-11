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
import com.icehockey.entity.User;
import com.icehockey.service.ClubService;

/**
 * Servlet implementation class ShenHeJuLeBuServlet
 */
public class ShenHeJuLeBuServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShenHeJuLeBuServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
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
		System.out.println("-----------------审核俱乐部后台程序----------");

		ClubService clubService = new ClubService();;
		User user = null;
		System.out.println(user);
		Club club = null;
		List<Club> clubs = null;
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
				if ("shenheToshenhejulebu".equals(operateType)) {// 跳转到审核俱乐部界面
					clubs = clubService.getAll();
					session.setAttribute("clubs", clubs);
					map.put("result", "0");
					map.put("ok", "1");

				} else if ("julebutongguo".equals(operateType)) {// 俱乐部审核通过操作
					if (request.getParameter("clubId") != null) {
					String clubId = request.getParameter("clubId");
					club = clubService.queryClubByClubId(Integer.parseInt(clubId));
					club.setCheckId(1);
					clubService.resetcheckId(club);
					clubs=clubService.getAll();
					session.setAttribute("clubs", clubs);
					map.put("result", "0");
					map.put("ok", "2");
					}
				}else if ("julebubohui".equals(operateType)) {// 俱乐部审核驳回操作
					if (request.getParameter("clubId") != null) {
					String clubId = request.getParameter("clubId");
					club = clubService.queryClubByClubId(Integer.parseInt(clubId));
					club.setCheckId(0);
					clubService.resetcheckId(club);
					clubs=clubService.getAll();
					session.setAttribute("clubs", clubs);
					map.put("result", "0");
					map.put("ok", "2");
					}
				}  else if ("shenhejulebuTojulebuxiangxi".equals(operateType)) {// 审核俱乐部界面跳转到审核俱乐部详细信息界面
					int clubId = Integer.parseInt(request.getParameter("searchId"));
					club = clubService.queryClubByClubId(clubId);
					session.setAttribute("club", club);
					map.put("result", "0");
					map.put("ok", "5");
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
						"<script language='javascript'>window.location.href='./views/part1/shenhejulebu.jsp'</script>");
			} else if ("2".equals(map.get("ok"))) {
				writer.println(
						"<script language='javascript'>window.location.href='./views/part1/shenhejulebu.jsp'</script>");
			}else if ("5".equals(map.get("ok"))) {
				writer.println("<script language='javascript'>window.location.href='./views/part1/shenhejulebuxiangxixinxi.jsp'</script>");
			}
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
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
