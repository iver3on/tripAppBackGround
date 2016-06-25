package cn.edu.xjtu.dao;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.edu.xjtu.pojo.Friendrelation;

/**
 * A data access object (DAO) providing persistence and search support for
 * Friendrelation entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see cn.edu.xjtu.pojo.Friendrelation
 * @author MyEclipse Persistence Tools
 */
public class FriendrelationDAO extends HibernateDaoSupport {
	private static final Log log = LogFactory.getLog(FriendrelationDAO.class);
	// property constants
	public static final String USERID = "userid";
	public static final String FRIENDID = "friendid";

	protected void initDao() {
		// do nothing
	}

	public void save(Friendrelation transientInstance) {
		log.debug("saving Friendrelation instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Friendrelation persistentInstance) {
		log.debug("deleting Friendrelation instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Friendrelation findById(java.lang.Integer id) {
		log.debug("getting Friendrelation instance with id: " + id);
		try {
			Friendrelation instance = (Friendrelation) getHibernateTemplate()
					.get("cn.edu.xjtu.pojo.Friendrelation", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Friendrelation instance) {
		log.debug("finding Friendrelation instance by example");
		try {
			List results = getHibernateTemplate().findByExample(instance);
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Friendrelation instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from Friendrelation as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByUserid(Object userid) {
		return findByProperty(USERID, userid);
	}

	public List findByFriendid(Object friendid) {
		return findByProperty(FRIENDID, friendid);
	}

	public List findAll() {
		log.debug("finding all Friendrelation instances");
		try {
			String queryString = "from Friendrelation";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Friendrelation merge(Friendrelation detachedInstance) {
		log.debug("merging Friendrelation instance");
		try {
			Friendrelation result = (Friendrelation) getHibernateTemplate()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Friendrelation instance) {
		log.debug("attaching dirty Friendrelation instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Friendrelation instance) {
		log.debug("attaching clean Friendrelation instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static FriendrelationDAO getFromApplicationContext(
			ApplicationContext ctx) {
		return (FriendrelationDAO) ctx.getBean("FriendrelationDAO");
	}
}