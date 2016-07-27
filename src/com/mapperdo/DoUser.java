package com.mapperdo;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.domain.User;

public class DoUser {

	public static User getUser(Long id, SqlSession session) {
		String statement = "com.mapping.userMapper.selectOneUser";
		User user = session.selectOne(statement, id);
		session.commit();
		return user;
	}

	public static int insertUser(User user, SqlSession session) {
		String statement = "com.mapping.userMapper.insertUser";
		int i = session.insert(statement, user);
		session.commit();
		return i;
	}

	public static List<User> selectUser(SqlSession session) {
		String statement = "com.mapping.userMapper.selectAllUser";
		List<User> users = session.selectList(statement);
		return users;

	}
}
