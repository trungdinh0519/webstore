package javaweb3.user.bo;

import java.util.List;

import javaweb3.user.model.User;

public interface UserBo {
	
	boolean signin(User user);
	
	void save(User user);
	User getUser(String username);
	
	List<User> findAllUsers();

}
