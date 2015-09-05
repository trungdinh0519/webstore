package com.trung.goodstore.persistence.hibernate;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;
import org.springframework.orm.hibernate3.HibernateCallback;

import com.trung.goodstore.model.ShipMethod;
import com.trung.goodstore.model.Shiprate;
import com.trung.goodstore.persistence.ShipDao;

public class ShipDaoHibernate extends DaoHibernate implements ShipDao {

	public Shiprate getShiprate(Long id) {
		Shiprate rate = (Shiprate) this.getHibernateTemplate().get(
				Shiprate.class, id);
		return rate;
	}

	public List getShiprates() {
		return this.getHibernateTemplate().find(
				"from Shiprate s order by upper(s.name)");

	}

	public Shiprate removeShiprate(Long id) {
		Shiprate rate = this.getShiprate(id);
		this.getHibernateTemplate().delete(rate);
		return rate;
	}

	




	

	public List getShiprateByMethod(final ShipMethod sm) {
		return this.getHibernateTemplate().executeFind(new HibernateCallback() {
			public Object doInHibernate(Session session) {
				Criteria criteria = session.createCriteria(Shiprate.class);
				if (sm != null)
					criteria.add(Expression.eq("method", sm));
				criteria.addOrder(Order.asc("name"));
				return criteria.list();
			}
		});

	}

	@Override
	public void saveShiprate(Shiprate rate) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List getProvincesByShiprate(Shiprate rate) {
		// TODO Auto-generated method stub
		return null;
	}

}
