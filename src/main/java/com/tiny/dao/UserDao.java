package com.tiny.dao;

import java.util.List;
import com.tiny.domain.User;

public interface UserDao {
	public void createUser();
	public void dropUser();
	
	public void saveUser(User user);
	public void updateUser(User user);
	public void deleteUser(String name);
	public User getUser(String name);
	public List<User> getAllUser();
}
