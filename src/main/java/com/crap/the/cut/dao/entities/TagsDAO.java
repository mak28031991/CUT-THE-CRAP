package com.crap.the.cut.dao.entities;
import static org.hibernate.criterion.Example.create;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.LockOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A data access object (DAO) providing persistence and search support for
 * Tags entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.viksitpro.core.dao.entities.Tags
 * @author MyEclipse Persistence Tools
 */
public class TagsDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory.getLogger(TagsDAO.class);

	public void save(Tags transientInstance) {
		log.debug("saving Tags instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Tags persistentInstance) {
		log.debug("deleting Tags instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Tags findById(java.lang.Integer id) {
		log.debug("getting Tags instance with id: " + id);
		try {
			Tags instance = (Tags) getSession().get("com.viksitpro.core.dao.entities.Tags", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Tags> findByExample(Tags instance) {
		log.debug("finding Tags instance by example");
		try {
			List<Tags> results = (List<Tags>) getSession()
					.createCriteria("com.viksitpro.core.dao.entities.Tags").add(create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List<Tags> findByProperty(String propertyName, Object value) {
		log.debug("finding Tags instance with property: " + propertyName + ", value: " + value);
		try {
			String queryString = "from Tags as model where model." + propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.getResultList();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<Tags> findAll() {
		log.debug("finding all Tags instances");
		try {
			String queryString = "from Tags";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.getResultList();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Tags merge(Tags detachedInstance) {
		log.debug("merging Tags instance");
		try {
			Tags result = (Tags) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Tags instance) {
		log.debug("attaching dirty Tags instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Tags instance) {
		log.debug("attaching clean Tags instance");
		try {
			getSession().buildLockRequest(LockOptions.NONE).lock(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}
