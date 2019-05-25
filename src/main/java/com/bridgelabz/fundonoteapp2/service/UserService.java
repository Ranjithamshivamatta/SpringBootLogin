package com.bridgelabz.fundonoteapp2.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.bridgelabz.fundonoteapp2.model.LoginRequest;
import com.bridgelabz.fundonoteapp2.model.User;

public interface UserService {
	public String login(LoginRequest loginReq);

	public User update(String token, User user);

	public User userRegistration(User user, HttpServletRequest request);

	public boolean delete(String token);

	public String sendMail(User user, String url, String subject);

	public List<User> getUser();

	// String login(LoginRequest loginReq);

}