package com.trung.goodstore.service;

import com.trung.goodstore.persistence.MfDao;

public interface MfManager extends Manager {
 void setMfDao(MfDao mfDao);
void delete(String id);
}
