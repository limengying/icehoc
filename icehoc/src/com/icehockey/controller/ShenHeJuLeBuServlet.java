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
		System.out.println("-----------------��˾��ֲ���̨����----------");

		ClubService clubService = new ClubService();
		;
		User user = null;
		System.out.println(user);
		Club club = null;
		List<Club> clubs = null;
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
				if ("shenheToshenhejulebu".equals(operateType)) {// ��ת����˾��ֲ�����
					clubs = clubService.getAll();
					session.setAttribute("clubs", clubs);
					map.put("result", "0");
					map.put("ok", "1");

				} else if ("julebutongguo".equals(operateType)) {// ���ֲ����ͨ������
					if (request.getParameter("clubId") != null) {
						String clubId = request.getParameter("clubId");
						club = clubService.queryClubByClubId(Integer.parseInt(clubId));
						club.setCheckId(1);
						clubService.clubCheckOK(user.getUserId(), club.getClubId());
						clubs = clubService.getAll();
						session.setAttribute("clubs", clubs);
						map.put("result", "0");
						map.put("ok", "2");
					}
				} else if ("julebubohui".equals(operateType)) {// ���ֲ���˲��ز���
					if (request.getParameter("clubId") != null) {
						String clubId = request.getParameter("clubId");
						club = clubService.queryClubByClubId(Integer.parseInt(clubId));
						clubService.clubCheckRefused(user.getUserId(), club.getClubId());
						clubs = clubService.getAll();
						session.setAttribute("clubs", clubs);
						map.put("result", "0");
						map.put("ok", "2");
					}
				} else if ("shenhejulebuTojulebuxiangxi".equals(operateType)) {// ��˾��ֲ�������ת����˾��ֲ���ϸ��Ϣ����
					int clubId = Integer.parseInt(request.getParameter("searchId"));
					club = clubService.queryClubByClubId(clubId);
					session.setAttribute("club", club);
					map.put("result", "0");
					map.put("ok", "5");
				}
			} else {
				map.put("result", "-2");// û�в�������
			}
		}

		// ����resultֵ���ж�ҳ�������ת
		if ("0".equals(map.get("result"))) {// ��¼�ɹ����Ҳ��ǵ�һ�ε�½
			System.out.println("ҳ�������ȷ");
			if ("1".equals(map.get("ok"))) {
				writer.println(
						"<script language='javascript'>window.location.href='./views/part1/shenhejulebu.jsp'</script>");
			} else if ("2".equals(map.get("ok"))) {
				writer.println(
						"<script language='javascript'>window.location.href='./views/part1/shenhejulebu.jsp'</script>");
			} else if ("5".equals(map.get("ok"))) {
				writer.println(
						"<script language='javascript'>window.location.href='./views/part1/shenhejulebuxiangxixinxi.jsp'</script>");
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
