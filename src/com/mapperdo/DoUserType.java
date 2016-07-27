package com.mapperdo;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.domain.UserType;
import com.domain.WorkType;

public class DoUserType {

	public static List<WorkType> getUserType(Long user_id, SqlSession session) {
		try {
			String statement = "com.mapping.userMapper.selectUserType";
			List<WorkType> worktype = session.selectList(statement, user_id);
			return worktype;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return null;
		}

	}

	public static int insertUserType(UserType usertype, SqlSession session) {
		try {
			String statement = "com.mapping.userMapper.insertUserType";
			int i = session.insert(statement, usertype);
			session.commit();
			return i;
		} catch (Exception e) {
			return 0;
		}

	}

	public static int deleteUserType(UserType usertype, SqlSession session) {
		try {
			String statement = "com.mapping.userMapper.deleteUserType";
			int i = session.delete(statement, usertype);
			session.commit();
			return i;
		} catch (Exception e) {
			return 0;
		}
	}

}
