package dao.myBatis;

import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import dao.IFiling;
import model.Filing;
import model.Firm;

public class FilingImpl implements IFiling {
	public void insertFiling(ArrayList<Firm> listFirms, int a, Filing filing) throws IOException {
		SqlSession session = null;
		try {
			Reader reader = Resources.getResourceAsReader("SqlMapConfig.xml");
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
			session = sqlSessionFactory.openSession();
			session.insert("Filing.insert", filing);
		} finally {
			session.commit();
			session.close();
		}
	}
}
