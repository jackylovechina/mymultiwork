package com.mapperdo;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.domain.WorkType;

public class DoType {

	public static WorkType getType(Long id, SqlSession session) {
		String statement = "com.mapping.userMapper.selectType";
		WorkType worktype = session.selectOne(statement,id);
		return worktype;
	}

	public static WorkType selectOneType(String type, SqlSession session) {
		String statement = "com.mapping.userMapper.selectOneType";
		WorkType worktype = session.selectOne(statement,type);
		return worktype;

	}

	public static List<WorkType> selectAllType(SqlSession session) {
		String statement = "com.mapping.userMapper.selectAllType";
		List<WorkType> types = session.selectList(statement);
		return types;

	}

	public static int insertType(WorkType worktype, SqlSession session) {
		String statement = "com.mapping.userMapper.insertType";
		int i = session.insert(statement, worktype);
		session.commit();
		return i;

	}
}
