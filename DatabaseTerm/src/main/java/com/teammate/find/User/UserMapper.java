package com.teammate.find.User;

public interface UserMapper {
	
	public abstract User userLogin(User u);
	public abstract int userUpdate(User u);
	public abstract int getUserLevel(User u);
	public abstract User getUserbyCode(User u);
}
