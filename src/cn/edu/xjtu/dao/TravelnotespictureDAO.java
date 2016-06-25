package cn.edu.xjtu.dao;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.edu.xjtu.pojo.Travelnotespicture;

/**
 * A data access object (DAO) providing persistence and search support for
 * Travelnotespicture entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see cn.edu.xjtu.pojo.Travelnotespicture
 * @author MyEclipse Persistence Tools
 */
public class TravelnotespictureDAO extends HibernateDaoSupport {
	private static final Log log = LogFactory
			.getLog(TravelnotespictureDAO.class);
	// property constants
	public static final String URL = "url";
	public static final String SUMMARY = "summary";
	public static final String TYPE = "type";

	protected void initDao() {
		// do nothing
	}

	public void save(Travelnotespicture transientInstance) {
		log.debug("saving Travelnotespicture instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Travelnotespicture persistentInstance) {
		log.debug("deleting Travelnotespicture instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Travelnotespicture findById(java.lang.Integer id) {
		log.debug("getting Travelnotespicture instance with id: " + id);
		try {
			Travelnotespicture instance = (Travelnotespicture) getHibernateTemplate()
					.get("cn.edu.xjtu.pojo.Travelnotespicture", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Travelnotespicture instance) {
		log.debug("finding Travelnotespicture instance by example");
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
		log.debug("finding Travelnotespicture instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from Travelnotespicture as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByUrl(Object url) {
		return findByProperty(URL, url);
	}

	public List findBySummary(Object summary) {
		return findByProperty(SUMMARY, summary);
	}

	public List findByType(Object type) {
		return findByProperty(TYPE, type);
	}

	public List findAll() {
		log.debug("finding all Travelnotespicture instances");
		try {
			String queryString = "from Travelnotespicture";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Travelnotespicture merge(Travelnotespicture detachedInstance) {
		log.debug("merging Travelnotespicture instance");
		try {
			Travelnotespicture result = (Travelnotespicture) getHibernateTemplate()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Travelnotespicture instance) {
		log.debug("attaching dirty Travelnotespicture instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Travelnotespicture instance) {
		log.debug("attaching clean Travelnotespicture instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static TravelnotespictureDAO getFromApplicationContext(
			ApplicationContext ctx) {
		return (TravelnotespictureDAO) ctx.getBean("TravelnotespictureDAO");
	}
}