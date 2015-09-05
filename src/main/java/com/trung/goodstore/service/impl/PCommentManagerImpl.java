package com.trung.goodstore.service.impl;

import java.util.List;

import com.trung.goodstore.model.ProductComment;
import com.trung.goodstore.persistence.PCommentDao;
import com.trung.goodstore.persistence.exception.DaoException;
import com.trung.goodstore.service.PCommentManager;

public class PCommentManagerImpl extends ManagerImpl implements PCommentManager {
	private PCommentDao pCommentDao;

	public void setPCommentDao(PCommentDao pcdao) {
		this.pCommentDao = pcdao;
	}

	public List<ProductComment> getComments(String productId) throws DaoException {
		List<ProductComment> l = this.pCommentDao.getComments(productId);
		return l;
	}

}
