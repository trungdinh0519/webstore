package com.trung.goodstore.persistence.hibernate;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;
import org.springframework.orm.hibernate3.HibernateCallback;

import com.trung.goodstore.model.Product;
import com.trung.goodstore.model.ProductComment;
import com.trung.goodstore.persistence.PCommentDao;
import com.trung.goodstore.persistence.exception.DaoException;

public class PCommentDaoHibernate extends DaoHibernate implements PCommentDao {

	public List getComments(final String productId) throws DaoException {
		return this.getHibernateTemplate().executeFind(new HibernateCallback() {
			public Object doInHibernate(Session session) {
				Criteria criteria1 = session.createCriteria(Product.class);
				if(!StringUtils.isNumeric(productId))return new ArrayList();
				criteria1.add(Expression.eq("id", new Long(productId)));
				Product p = (Product) criteria1.setMaxResults(1).uniqueResult();
				Criteria criteria2 = session
						.createCriteria(ProductComment.class);
				criteria2.add(Expression.eq("product",p));
				List l = criteria2.list();
				return l;
			}
		});
	}
}
