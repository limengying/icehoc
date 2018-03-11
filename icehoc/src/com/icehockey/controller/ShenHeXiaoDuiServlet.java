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

import com.icehockey.entity.Team;
import com.icehockey.entity.User;
import com.icehockey.service.TeamService;

/**
 * Servlet implementation class ShenHeXiaoDuiServlet
 */
public class ShenHeXiaoDuiServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ShenHeXiaoDuiServlet() {
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
		System.out.println("-----------------���У�Ӻ�̨����----------");
		TeamService teamService = new TeamService();
		User user = null;
		System.out.println(user);
		Team team = null;
		List<Team> teams = null;
		System.out.println("��ת���sessionId :" + session.getId());
		String operateType = null;
		// session
		if (session.getAttribute("user") == null) {
			user = null;
			map.put("result", "-1");// û���û���¼
		} else {
			user = (User) session.getAttribute("user");
			if (request.getParameter("operateType") != null) {
				operateType = request.getParameter("operateType");
				if ("xiaoduitongguo".equals(operateType)) {// ���ͨ������
					if (request.getParameter("teamId") != null) {
						String teamId = request.getParameter("teamId");
						team = teamService.queryTeamByTeamId(Integer.parseInt(teamId));
						team.setCheckId(1);
						teamService.resetcheckId(team);
						teams = teamService.queryTeams();
						session.setAttribute("teams", teams);
						map.put("teams", teams);
						map.put("result", "0");
						map.put("ok", "3");
					} else {
						map.put("result", "-2");// û�в�������
					}
				} else if ("xiaoduibohui".equals(operateType)) {// ���ͨ������
					if (request.getParameter("teamId") != null) {
						String schoolTeamId = request.getParameter("teamId");
						team = teamService.queryTeamByTeamId(Integer.parseInt(schoolTeamId));
						team.setCheckId(0);
						teamService.resetcheckId(team);
						teams = teamService.queryTeams();
						session.setAttribute("teams", teams);
						map.put("teams", teams);
						map.put("result", "0");
						map.put("ok", "3");
					} else {
						map.put("result", "-2");// û�в�������
					}
				} else if ("schoolTeamAll".equals(operateType)) {// �����������������ҳ�浽�����ذ���ҳ�棬��ȡ�����ر��е����г�����Ϣ
					teams = teamService.queryTeams();
					session.setAttribute("teams", teams);
					map.put("result", "0");
					map.put("ok", "6");
				} else if ("shenhexiaoduiToshenhexiaoduixiangxi".equals(operateType)) {// �����������������ҳ�浽�����ذ���ҳ�棬��ȡ�����ر��е����г�����Ϣ
					int teamId = Integer.parseInt(request.getParameter("searchId"));
					team = teamService.queryTeamByTeamId(teamId);
					session.setAttribute("schoolTeam", team);
					map.put("result", "0");
					map.put("ok", "7");
				}
			} else {
				map.put("result", "-2");// û�в�������
			}
		}

		// ����resultֵ���ж�ҳ�������ת
		if ("0".equals(map.get("result"))) {// ��¼�ɹ����Ҳ��ǵ�һ�ε�½
			System.out.println("ҳ�������ȷ");
			if ("3".equals(map.get("ok"))) {
				writer.println(
						"<script language='javascript'>window.location.href='./views/part1/henhexiaodui.jsp'</script>");
			} else if ("6".equals(map.get("ok"))) {
				writer.println(
						"<script language='javascript'>window.location.href='./views/part1/shenhexiaodui.jsp'</script>");
			} else if ("7".equals(map.get("ok"))) {
				writer.println(
						"<script language='javascript'>window.location.href='./views/part1/shenhexiaoduixiangxi.jsp'</script>");
			}
		} else if ("-1".equals(map.get("result"))) {// ��½ʧ�ܣ��û���������
			writer.println(
					"<script language='javascript'>alert('��ǰû�е�¼�û�');window.location.href='./views/part1/zhucedengluyemian.jsp'</script>");
		} else if ("-2".equals(map.get("result"))) {// ǰ�˴���
			writer.println(
					"<script language='javascript'>alert('ǰ�˴���');window.location.href='./views/error/qianduanError.jsp'</script>");
		} else if ("-3".equals(map.get("result"))) {// ����ʧ��
			writer.println(
					"<script language='javascript'>alert('����ʧ��');window.location.href='./views/error/insertError.jsp'</script>");
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