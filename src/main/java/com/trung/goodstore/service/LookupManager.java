package com.trung.goodstore.service;

import java.util.List;
import java.util.Map;

import com.trung.goodstore.model.Role;
import com.trung.goodstore.persistence.LookupDao;





/**
 * Business Service Interface to talk to persistence layer and
 * retrieve values for drop-down choice lists.
 *
 * <p>
 * <a href="LookupManager.java.html"><i>View Source</i></a>
 * </p>
 *
 * @author <a href="mailto:matt@raibledesigns.com">Matt Raible</a>
 */
public interface LookupManager extends Manager {
    //~ Methods ================================================================

    public void setLookupDao(LookupDao dao);
    
    /**
     * Retrieves all possible roles from persistence layer
     * @return List
     */
    public Map<String,Role> getAllRoles();
    
   
}
