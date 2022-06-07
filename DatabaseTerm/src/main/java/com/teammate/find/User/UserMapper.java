package com.teammate.find.User;

public interface UserMapper {
	public abstract User viewUserProfile(User u);
	public abstract int getUserLevel(User u);
	public abstract User getUserbyCode(User u);
	public abstract User userLogin(User u);
	public abstract User userJoinCheck(User u);
	
	public abstract int joinUser(User u);
	
	public abstract int updateUser(User u);
	public abstract int deleteUser(User u);
}
