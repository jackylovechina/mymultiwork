package com.mapperdo;

import java.util.List;

import com.domain.Mission;
import org.apache.ibatis.session.SqlSession;

public class DoMission {

	public static int insertMission(Mission mission, SqlSession session) {
		String statement = "com.mapping.userMapper.insertMission";
		int i = session.insert(statement, mission);
		session.commit();
		return i;

	}

	public static List<Mission> selectMission(SqlSession session) {
		String statement = "com.mapping.userMapper.selectMission";
		List<Mission> missions = session.selectList(statement);
		return missions;

	}

	public static int updateMission(Mission mission, SqlSession session) {
		String statement = "com.mapping.userMapper.updateMission";
		int i = session.update(statement, mission);
		session.commit();
		return i;
	}

	public static int deleteMission(Mission mission, SqlSession session) {
		String statement = "com.mapping.userMapper.deleteMission";
		int i = session.delete(statement, mission);
		session.commit();
		return i;
	}
}
