package cn.edu.xjtu.dao;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.edu.xjtu.pojo.Stars;

/**
 * A data access object (DAO) providing persistence and search support for Stars
 * entities. Transaction control of the save(), update() and delete() operations
 * can directly support Spring container-managed transactions or they can be
 * augmented to handle user-managed Spring transactions. Each of these methods
 * provides additional information for how to configure it for the desired type
 * of transaction control.
 * 
 * @see cn.edu.xjtu.pojo.Stars
 * @author MyEclipse Persistence Tools
 */
public class StarsDAO extends HibernateDaoSupport {
	private static final Log log = LogFactory.getLog(StarsDAO.class);
	// property constants
	public static final String TOPIC_TYPE = "topicType";

	protected void initDao() {
		// do nothing
	}

	public void save(Stars transientInstance) {
		log.debug("saving Stars instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Stars persistentInstance) {
		log.debug("deleting Stars instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Stars findById(java.lang.Integer id) {
		log.debug("getting Stars instance with id: " + id);
		try {
			Stars instance = (Stars) getHibernateTemplate().get(
					"cn.edu.xjtu.pojo.Stars", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Stars instance) {
		log.debug("finding Stars instance by example");
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
		log.debug("finding Stars instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Stars as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByTopicType(Object topicType) {
		return findByProperty(TOPIC_TYPE, topicType);
	}

	public List findAll() {
		log.debug("finding all Stars instances");
		try {
			String queryString = "from Stars";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Stars merge(Stars detachedInstance) {
		log.debug("merging Stars instance");
		try {
			Stars result = (Stars) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Stars instance) {
		log.debug("attaching dirty Stars instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Stars instance) {
		log.debug("attaching clean Stars instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static StarsDAO getFromApplicationContext(ApplicationContext ctx) {
		return (StarsDAO) ctx.getBean("StarsDAO");
	}

	/**
	 * @param userId
	 * @param type
	 * @param id
	 * @return
	 */
	public Stars findStar(int userId, int type, int id) {
		String sql = "";
		if (type == 0) {
			sql = "select * from stars where userId=" + userId
					+ " and topic_type=" + type + " and newscenicspots_id="
					+ id;
		} else if (type == 1) {
			sql = "select * from stars where userId=" + userId
					+ " and topic_type=" + type + " and travelnotes_id=" + id;
		} else {
			sql = "select * from stars where userId=" + userId
					+ " and topic_type=" + type + " and detailnotes_id=" + id;
		}
		return (Stars) getSession().createSQLQuery(sql).addEntity(Stars.class)
				.list().get(0);
	}
}