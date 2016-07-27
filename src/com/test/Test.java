package com.test;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.domain.User;

public class Test {

	public static void main(String[] args) throws IOException {
		// mybatis的配置文件
		String resource = "conf.xml";
		// 使用类加载器加载mybatis的配置文件（它也加载关联的映射文件）
		InputStream inputstream = Test.class.getClassLoader()
				.getResourceAsStream(resource);
		// 构建sqlSession的工厂
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder()
				.build(inputstream);

		SqlSession session = sessionFactory.openSession();
		/**
		 * 映射sql的标识字符串，
		 * com.mapping.userMapper是userMapper.xml文件中mapper标签的namespace属性的值，
		 * getUser是select标签的id属性值，通过select标签的id属性值就可以找到要执行的SQL
		 */
		// 映射sql的标识字符串
		String statement_get = "com.mapping.userMapper.selectOneUser";

		User user = session.selectOne(statement_get, 3);
		System.out.println(user);

	}

}
