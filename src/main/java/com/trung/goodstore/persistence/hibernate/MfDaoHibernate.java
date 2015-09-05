package com.trung.goodstore.persistence.hibernate;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Expression;
import org.springframework.orm.hibernate3.HibernateCallback;

import com.trung.goodstore.model.Manufacturer;
import com.trung.goodstore.model.Product;
import com.trung.goodstore.persistence.MfDao;

public class MfDaoHibernate extends DaoHibernate implements MfDao {

	/* (non-Javadoc)
	 * @see com.trung.goodstore.persistence.MfDao#removeManufacturer(java.lang.Long)
	 */
	public void removeManufacturer(final Long id) {
		this.getHibernateTemplate().execute(new HibernateCallback(){
			public Object doInHibernate(Session session){
				Criteria crim=session.createCriteria(Manufacturer.class);
				crim.add(Expression.eq("id",id));
				Manufacturer m=(Manufacturer)crim.setMaxResults(1).uniqueResult();
				session.createQuery("update Product p set p.manufacturer=null where p.manufacturer=:m").setParameter("m",m).executeUpdate();
				session.delete(m);
				return null;
			}
		});
	}
	

}
