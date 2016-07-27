package com.controller;

import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.domain.Mission;
import com.domain.User;
import com.domain.UserType;
import com.domain.WorkType;
import com.mapperdo.DoMission;
import com.mapperdo.DoType;
import com.mapperdo.DoUser;
import com.mapperdo.DoUserType;
import com.test.Test;

@Controller
public class LoadController {
	private static Logger log = Logger.getLogger(LoadController.class);

	String resource = "conf.xml";
	// 使用类加载器加载mybatis的配置文件（它也加载关联的映射文件）
	InputStream inputstream = Test.class.getClassLoader().getResourceAsStream(
			resource);
	// 构建sqlSession的工厂
	SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder()
			.build(inputstream);
	SqlSession session = sessionFactory.openSession();

	// 查询单个用户
	@ResponseBody
	@RequestMapping(value = "/selectuser.do")
	public JSONArray SelectUserPage(HttpServletRequest req,
			HttpServletResponse res) {
		Long id = Long.valueOf(req.getParameter("id"));
		User user = DoUser.getUser(id, session);
		JSONArray jsonarray = JSONArray.fromObject(user);
		req.getSession().setAttribute("user", user);
		return jsonarray;
	}

	// 查询所有用户
	@ResponseBody
	@RequestMapping(value = "/selectalluser.do")
	public JSONArray SelectAllUserPage(HttpServletRequest req,
			HttpServletResponse res) {
		List<User> users = DoUser.selectUser(session);
		JSONArray jsonarray = JSONArray.fromObject(users);
		req.getSession().setAttribute("user", users);
		return jsonarray;
	}

	// 插入一个用户
	@ResponseBody
	@RequestMapping(value = "/insertuser.do")
	public JSONArray InsertUserPage(HttpServletRequest req,
			HttpServletResponse res) {
		Long userid = Long.valueOf(req.getParameter("userid"));
		String userinfo = null;
		try {
			userinfo = new String(String.valueOf(req.getParameter("userinfo"))
					.getBytes("iso-8859-1"), "utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		int password = Integer.valueOf(req.getParameter("password"));
		User user = new User(userid, userinfo, password);
		int i = DoUser.insertUser(user, session);
		JSONArray jsonarray = JSONArray.fromObject(i);
		return jsonarray;

	}

	// 查询单个类型
	@ResponseBody
	@RequestMapping(value = "/selecttype.do")
	public JSONArray SelectTypePage(HttpServletRequest req,
			HttpServletResponse res) {
		String type = null;
		try {
			type = new String(String.valueOf(req.getParameter("type"))
					.getBytes("iso-8859-1"), "utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		WorkType worktype = DoType.selectOneType(type, session);
		JSONArray jsonarray = JSONArray.fromObject(worktype);
		req.getSession().setAttribute("worktype", worktype);
		return jsonarray;
	}

	@ResponseBody
	@RequestMapping(value = "/gettype.do")
	public JSONArray SelectTypeFromIdPage(HttpServletRequest req,
			HttpServletResponse res) {

		Long typeid = Long.valueOf(req.getParameter("typeid"));

		WorkType worktype = DoType.getType(typeid, session);
		JSONArray jsonarray = JSONArray.fromObject(worktype);
		req.getSession().setAttribute("worktype", worktype);
		return jsonarray;
	}

	// 查询所有类型
	@ResponseBody
	@RequestMapping(value = "/selectalltype.do")
	public JSONArray SelectAllTypePage(HttpServletRequest req,
			HttpServletResponse res) {
		List<WorkType> worktypes = DoType.selectAllType(session);
		JSONArray jsonarray = JSONArray.fromObject(worktypes);
		req.getSession().setAttribute("worktypes", worktypes);
		return jsonarray;
	}

	// 输入一个类型
	@ResponseBody
	@RequestMapping(value = "/inserttype.do")
	public JSONArray InsertTypePage(HttpServletRequest req,
			HttpServletResponse res) {
		Long typeid = Long.valueOf(req.getParameter("typeid"));
		String type = null;
		try {
			type = new String(String.valueOf(req.getParameter("type"))
					.getBytes("iso-8859-1"), "utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		WorkType worktype = new WorkType(typeid, type);
		int i = DoType.insertType(worktype, session);
		JSONArray jsonarray = JSONArray.fromObject(i);
		return jsonarray;

	}

	// 查询用户对应工作类型
	@ResponseBody
	@RequestMapping(value = "/selectusertype.do")
	public JSONArray SelectUserTypePage(HttpServletRequest req,
			HttpServletResponse res) {
		Long userid = Long.valueOf(req.getParameter("userid"));
		List<WorkType> worktypes = DoUserType.getUserType(userid, session);
		JSONArray jsonarray = JSONArray.fromObject(worktypes);
		req.getSession().setAttribute("worktypes", worktypes);

		return jsonarray;
	}

	// 关联用户和工作类型
	@ResponseBody
	@RequestMapping(value = "/insertusertype.do")
	public JSONArray InsertUserTypePage(HttpServletRequest req,
			HttpServletResponse res) {
		Long userid = Long.valueOf(req.getParameter("userid"));
		Long typeid = Long.valueOf(req.getParameter("typeid"));

		UserType usertype = new UserType(userid, typeid);
		int i = DoUserType.insertUserType(usertype, session);
		JSONArray jsonarray = JSONArray.fromObject(i);
		return jsonarray;

	}

	// 删除用户和工作类型
	@ResponseBody
	@RequestMapping(value = "/deleteusertype.do")
	public JSONArray DeleteUserTypePage(HttpServletRequest req,
			HttpServletResponse res) {
		Long userid = Long.valueOf(req.getParameter("userid"));
		Long typeid = Long.valueOf(req.getParameter("typeid"));

		UserType usertype = new UserType(userid, typeid);
		int i = DoUserType.deleteUserType(usertype, session);
		JSONArray jsonarray = JSONArray.fromObject(i);
		return jsonarray;

	}

	// 插入mission信息
	@ResponseBody
	@RequestMapping(value = "/insertmission.do")
	public JSONArray InsertMissionPage(HttpServletRequest req,
			HttpServletResponse res) {
		Long userid = Long.valueOf(req.getParameter("userid"));
		Long typeid = Long.valueOf(req.getParameter("typeid"));
		Long time = Long.valueOf(req.getParameter("time"));
		String content = null;
		try {
			content = new String(String.valueOf(req.getParameter("content"))
					.getBytes("iso-8859-1"), "utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Mission mission = new Mission(userid, typeid, time, content);
		int i = DoMission.insertMission(mission, session);
		JSONArray jsonarray = JSONArray.fromObject(i);
		return jsonarray;

	}

	// 删除mission信息
	@ResponseBody
	@RequestMapping(value = "/deletemission.do")
	public JSONArray DeleteMissionPage(HttpServletRequest req,
			HttpServletResponse res) {

		Long userid = Long.valueOf(req.getParameter("userid"));
		Long typeid = Long.valueOf(req.getParameter("typeid"));
		Mission mission = new Mission(userid, typeid);
		int i = DoMission.deleteMission(mission, session);
		JSONArray jsonarray = JSONArray.fromObject(i);
		return jsonarray;

	}

	// 查询全部mission
	@ResponseBody
	@RequestMapping(value = "/selectmission.do")
	public JSONArray SelectMissionPage(HttpServletRequest req,
			HttpServletResponse res) {
		List<Mission> missions = DoMission.selectMission(session);
		JSONArray jsonarray = JSONArray.fromObject(missions);
		req.getSession().setAttribute("worktypes", missions);
		return jsonarray;
	}

	// 修改全部mission
	@ResponseBody
	@RequestMapping(value = "/updatemission.do")
	public JSONArray UpdateMissionPage(HttpServletRequest req,
			HttpServletResponse res) {
		int id = Integer.valueOf(req.getParameter("id"));
		Long typeid = Long.valueOf(req.getParameter("typeid"));

		String content = null;
		try {
			content = new String(String.valueOf(req.getParameter("content"))
					.getBytes("iso-8859-1"), "utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Mission mission = new Mission(id, typeid, content);
		int i = DoMission.updateMission(mission, session);
		JSONArray jsonarray = JSONArray.fromObject(i);
		req.getSession().setAttribute("worktypes", jsonarray);
		return jsonarray;
	}
}
