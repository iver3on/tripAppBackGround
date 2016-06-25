package cn.edu.xjtu.dao;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.edu.xjtu.pojo.Travelnotes;

/**
 * A data access object (DAO) providing persistence and search support for
 * Travelnotes entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see cn.edu.xjtu.pojo.Travelnotes
 * @author MyEclipse Persistence Tools
 */
public class TravelnotesDAO extends HibernateDaoSupport {
	private static final Log log = LogFactory.getLog(TravelnotesDAO.class);
	// property constants
	public static final String DISCRIPTION = "discription";
	public static final String LOCATION = "location";
	public static final String LONGITUDE = "longitude";
	public static final String LATITUDE = "latitude";

	protected void initDao() {
		// do nothing
	}

	public void save(Travelnotes transientInstance) {
		log.debug("saving Travelnotes instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Travelnotes persistentInstance) {
		log.debug("deleting Travelnotes instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Travelnotes findById(java.lang.Integer id) {
		log.debug("getting Travelnotes instance with id: " + id);
		try {
			Travelnotes instance = (Travelnotes) getHibernateTemplate().get(
					"cn.edu.xjtu.pojo.Travelnotes", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Travelnotes instance) {
		log.debug("finding Travelnotes instance by example");
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
		log.debug("finding Travelnotes instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Travelnotes as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByDiscription(Object discription) {
		return findByProperty(DISCRIPTION, discription);
	}

	public List findByLocation(Object location) {
		return findByProperty(LOCATION, location);
	}

	public List findByLongitude(Object longitude) {
		return findByProperty(LONGITUDE, longitude);
	}

	public List findByLatitude(Object latitude) {
		return findByProperty(LATITUDE, latitude);
	}

	public List findAll() {
		log.debug("finding all Travelnotes instances");
		try {
			String queryString = "from Travelnotes";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Travelnotes merge(Travelnotes detachedInstance) {
		log.debug("merging Travelnotes instance");
		try {
			Travelnotes result = (Travelnotes) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Travelnotes instance) {
		log.debug("attaching dirty Travelnotes instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Travelnotes instance) {
		log.debug("attaching clean Travelnotes instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static TravelnotesDAO getFromApplicationContext(
			ApplicationContext ctx) {
		return (TravelnotesDAO) ctx.getBean("TravelnotesDAO");
	}

	// 按照APP传过来的ID查找所有的游记
	public List<Travelnotes> findAllNotesByUserId(Integer userId) {
		return getSession()
				.createSQLQuery(
						"select * from travelnotes where userid=" + userId)
				.addEntity(Travelnotes.class).list();
	}

	/**
	 * @param offset
	 * @param limit
	 * @return
	 */
	public List<Travelnotes> getTopNotes(Integer offset, Integer limit) {
		return getSession()
				.createSQLQuery(
						"select * from travelnotes order by starCount DESC limit "
								+ limit + " offset " + offset)
				.addEntity(Travelnotes.class).list();
	}

	/**
	 * @param userid
	 * @param longitude2
	 * @param latitude2
	 * @return
	 */
	public List<Travelnotes> getNotesOfMyfriends(int userid, double longitude2,
			double latitude2, int limit) {
		return getSession()
				.createSQLQuery(
						"select * from travelnotes where userid in (select attention_userid from userattentions where userId="
								+ userid
								+ ") ORDER BY (POWER(MOD(ABS(longitude -"
								+ longitude2
								+ "),360),2) + POWER(ABS(latitude -"
								+ latitude2 + "),2)) LIMIT " + limit)
				.addEntity(Travelnotes.class).list();

	}

	/**
	 * 最近一月的
	 * 
	 * @return
	 */
	public List<Travelnotes> findByTime(Integer id) {
		return getSession()
				.createSQLQuery(
						"select * from travelnotes where userid in (select attention_userid from userattentions where userId="
								+ id
								+ ") AND DATE_SUB(CURDATE(), INTERVAL 1 MONTH) <= date(datetime)")
				.addEntity(Travelnotes.class).list();
	}
}