package org.blog.Util;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyBatisFactory {
	private static SqlSessionFactory instance = null;
	private MyBatisFactory(){
	}
	
	private static SqlSessionFactory initSqlSessionFactory() {
		String resource = "conf.xml";
		try {
			Reader reader = Resources.getResourceAsReader(resource);
			
			instance = new SqlSessionFactoryBuilder().build(reader, "development");
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return instance;
	}
	
	public static SqlSessionFactory getFactory() {
		if(instance == null) {
			initSqlSessionFactory();
		}
		return instance;
	}
	
	public static SqlSession getSession() {
		if(instance == null) {
			initSqlSessionFactory();
		}
		return instance.openSession();
	}
}
