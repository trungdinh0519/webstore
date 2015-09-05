package com.trung.goodstore.persistence.hibernate;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;
import org.springframework.orm.hibernate3.HibernateCallback;

import com.trung.goodstore.model.Product;

public class SearchProductDaoHibernate extends DaoHibernate {
	public List searchAdvance(final String keyword, final boolean id,
			final boolean name, final boolean sort_desc, final boolean desc,
			final Double fromPrice, final Double toPrice) {
		return this.getHibernateTemplate().executeFind(new HibernateCallback() {
			public Object doInHibernate(Session session) {
				Criteria cri = session.createCriteria(Product.class);
				cri.addOrder(Order.asc("cdate"));
				try {
					if (id)
						cri.add(Expression.eq("id", new Long(keyword)));
					if (name)
						cri.add(Expression.like("name", "%" + keyword + "%"));
					if (sort_desc)
						cri.add(Expression.like("sort_desc", "%" + keyword
								+ "%"));
					if (desc)
						cri.add(Expression.like("desc", "%" + keyword + "%"));
					if (fromPrice != null && toPrice != null)
						cri.add(Expression
								.and(Expression.ge("unitPrice", fromPrice),
										Expression.le("unitPrice", toPrice)));

				} catch (Exception e) {
					e.printStackTrace();
				}
				return cri.list();
			}
		});
	}
}
