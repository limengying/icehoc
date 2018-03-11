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

import com.icehockey.entity.Rink;
import com.icehockey.entity.User;
import com.icehockey.service.RinkService;

/**
 * Servlet implementation class ShenHeBingChangServlet
 */
public class ShenHeBingChangServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ShenHeBingChangServlet() {
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
		System.out.println("-----------------审核冰场----------");

		RinkService rinkservice = new RinkService();
		Rink rink = null;
		User user=null;
		List<Rink> rinks = null;
		System.out.println("跳转前sessionId :" + session.getId());
		String operateType = null;
		// session
		if (session.getAttribute("user") == null) {
			map.put("result", "-1");// û���û���¼
		} else {
			user = (User) session.getAttribute("user");
			if (request.getParameter("operateType") != null) {
				operateType = request.getParameter("operateType");
				if ("shenheToshenhebingchang".equals(operateType)) {// ��ת����˱���ҳ��
					rinks = rinkservice.getRinks();
					session.setAttribute("rinks", rinks);
					map.put("rinks", rinks);
					map.put("result", "0");
					map.put("ok", "1");

				} else if ("shenbingTOshenbingxiang".equals(operateType)) {// ��ת����˱�������ϸ��Ϣҳ��
					if (request.getParameter("rinkId") != null) {
						String rinkIdString = request.getParameter("rinkId");
						rink = rinkservice.getRinkByRinkId(Integer.parseInt(rinkIdString));
						session.setAttribute("rink", rink);
						map.put("rink", rinks);
						map.put("result", "0");
						map.put("ok", "2");
					} else {
						map.put("result", "-2");// û�в�������
					}
				} else if ("bingchangtongguo".equals(operateType)) {// ���ͨ������
					if (request.getParameter("rinkId") != null) {
						String rinkId =request.getParameter("rinkId");
						rink = rinkservice.getRinkByRinkId(Integer.parseInt(rinkId));
						rinkservice.rinkCheckOK(user.getUserId(),rink.getRinkId());
						rinks = rinkservice.getRinks();
						session.setAttribute("rinks", rinks);
						map.put("rinks", rinks);
						map.put("result", "0");
						map.put("ok", "3");
						}else {
							map.put("result", "-2");// û�в�������
						}
				 } else if ("bingchangbohui".equals(operateType)) {// ���ز���
						if (request.getParameter("rinkId") != null) {
							String rinkId =request.getParameter("rinkId");
							rink = rinkservice.getRinkByRinkId(Integer.parseInt(rinkId));
							rink.setCheckId(0);
						//	rinkservice.resetcheckId(rink);
							rinks = rinkservice.getRinks();
							session.setAttribute("rinks", rinks);
							map.put("rinks", rinks);
							map.put("result", "0");
							map.put("ok", "3");
						}else {
						map.put("result", "-2");// û�в�������
					}
					System.out.println("map:" + map);
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
						"<script language='javascript'>window.location.href='./views/part1/shenhebingchang.jsp'</script>");
			} else if ("2".equals(map.get("ok"))) {
				writer.println(
						"<script language='javascript'>window.location.href='./views/part1/shenhebingchangxiangxixinxi.jsp'</script>");
			}
			else if ("3".equals(map.get("ok"))) {
				writer.println(
						"<script language='javascript'>window.location.href='./views/part1/shenhebingchang.jsp'</script>");
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
		doGet(request, response);
	}

}