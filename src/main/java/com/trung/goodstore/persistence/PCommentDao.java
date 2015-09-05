package com.trung.goodstore.persistence;

import java.util.List;


import com.trung.goodstore.model.ProductComment;
import com.trung.goodstore.persistence.exception.DaoException;

public interface PCommentDao extends Dao {
	List getComments(String productId) throws DaoException;
}
