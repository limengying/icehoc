package com.icehockey.service;

import com.icehockey.dao.RoleDao;
import com.icehockey.entity.Role;

public class RoleService {
	RoleDao dao=new RoleDao();
	Role role=null;
	public Role queryRole(int roleId) {//通过角色名称查找角色对象并返回
		role=dao.getRoleByRoleId(roleId);
		if(role!=null){
			System.out.println(role.toString());
		}
		return role;
	}
}
