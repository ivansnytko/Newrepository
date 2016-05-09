package dao.myBatis;

import java.io.IOException;
import java.io.Reader;
import java.util.List;
import java.util.logging.Logger;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import model.Info;
import model.MainAddr;
import model.States;

public class Select {
	public static Logger log = Logger.getLogger(Select.class.getName());

	public void selectInfo() throws IOException {
		SqlSession session = null;
		try {
			Reader reader = Resources.getResourceAsReader("SqlMapConfig.xml");
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
			session = sqlSessionFactory.openSession();

		
			List<Info> info = session.selectList("Info.getStates");
			List<Integer> abc = session.selectList("Info.getCount");
			for (int i = 0; i < info.size(); i++)
				log.info(info.get(i).getLegalNm() + " " + abc.get(i).intValue());
		} finally {
			session.commit();
			session.close();
		}
	}

	public void selectAllById() throws IOException {
		SqlSession session = null;
		try {
			Reader reader = Resources.getResourceAsReader("SqlMapConfig.xml");
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
			session = sqlSessionFactory.openSession();
			List<States> states = session.selectList("States.getAll");
			List<Info> info = session.selectList("Info.getAll");
			List<MainAddr> mainaddr = session.selectList("MainAddr.getAll");
			for (int i = 0; i < info.size(); i++) {
				log.info(info.get(i).getLegalNm() + " " + info.get(i).getFirmCrdNb() + " " + mainaddr.get(i).getStrt1()
						+ " " + states.get(i).getRgltrCd());

			}
		} finally {
			session.commit();
			session.close();
		}
	}
}
