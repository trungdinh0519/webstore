package com.trung.goodstore.service;

import java.util.List;

import com.trung.goodstore.model.ProductComment;
import com.trung.goodstore.persistence.PCommentDao;
import com.trung.goodstore.persistence.exception.DaoException;

public interface PCommentManager extends Manager {
	void setPCommentDao(PCommentDao pcdao);
	List<ProductComment> getComments(String productId) throws DaoException;
}
