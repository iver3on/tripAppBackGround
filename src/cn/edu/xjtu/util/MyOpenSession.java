/**
 * 
 */
package cn.edu.xjtu.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.dao.DataAccessResourceFailureException;
import org.springframework.orm.hibernate3.support.OpenSessionInViewFilter;

/**
 * @author Iver3oN Zhang
 * @date 2016年6月6日
 */
public class MyOpenSession extends OpenSessionInViewFilter {

	@Override
	protected Session getSession(SessionFactory sessionFactory)
			throws DataAccessResourceFailureException {
		// TODO Auto-generated method stub
		return super.getSession(sessionFactory);
	}

}
