package Projectbackend.dao;

import java.util.List;

import Projectbackend.pojo.User;

public interface UserDAO {
	public boolean AddUser(User user);
	public boolean DeleteUser(User user);
	public boolean UpdateUser(User user);
	public String getpass(String email);
	public boolean CheckLogin(String email,String Pass);
	public User Details(String email);
	public boolean ExistEmail(String email);
}
