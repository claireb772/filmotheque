package fr.eni.filmotheque.services;

import java.util.List;

import fr.eni.filmotheque.bo.User;

public interface UserService {

	public List<User> getUserList();

	public User getUserByLogin(String login);

}
