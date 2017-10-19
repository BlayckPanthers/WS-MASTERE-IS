package com.ingesup.controller;

import java.io.IOException;
import java.util.Map;
import javax.servlet.http.HttpSession;
import com.ingesup.controller.utils.HttpServletUtils;
import com.ingesup.manager.UserManager;
import com.ingesup.model.Users;

public class UserController extends HttpServletUtils {

	// Send to user home page
	public void user() {
		
		if(this.request.getMethod().toUpperCase().equals(("GET"))){
			this.displayView();
		}

		try {
			this.response.sendError(404, "Not implemented yet.");
		} catch (Exception e){
			e.printStackTrace();
		}
	}
	
	public void login(){
		
		if(this.request.getMethod().toUpperCase().equals("GET")){
			
			boolean isConnected 	= this.request.getSession().getAttribute("isConnected") != null ? (boolean) this.request.getSession().getAttribute("isConnected") : false;
			String currentUsername  = (String)  this.request.getSession().getAttribute("username");
			
			if(isConnected && currentUsername != null){
				this.displayView("home","HomeController");
				return;
			}
			
			this.displayView();
			return;
		}
		
		if(this.request.getMethod().toUpperCase().equals("POST")){
			this.loginPost(this.request.getParameterMap());
			return;
		}
		
		try {
			this.response.sendError(404, "Not implemented yet.");
		} catch (Exception e){
			e.printStackTrace();
		}
	}
	public void loginPost(Map<String, String[]> params){
		
		String username = params.get("inputUsername") != null ? params.get("inputUsername")[0] : null;
		String password = params.get("inputPassword") != null ? params.get("inputPassword")[0] : null;
		
		if(username == null || password == null){
			this.request.setAttribute("error", "Please enter an username and a password.");
		}
		else{
			
			Users user = new Users();
			user.setEmail(username);
			user.setPassword(password);
			
			Users currentUser = UserManager.get(user);
			
			// Login error, false logs
			if(currentUser == null){
				this.request.setAttribute("error", "This username does'nt exist or the password is not correct.");
			}
			else {
				this.request.setAttribute("validation", "Successfully connected.");
				
				// Adding the username of the current user as a Session variable
				this.request.getSession().setAttribute("username", currentUser.getEmail());
				// Enabling the session by setting the isConnected attribute to true
				this.request.getSession().setAttribute("isConnected", true);
				
				this.displayView("profil");
				
				return;
			}

		}
		
		this.displayView("login");
		
	}

	public void create(){
		
		if(this.request.getMethod().toUpperCase().equals("GET")){
			this.displayView();
			return;
		}
		
		if(this.request.getMethod().toUpperCase().equals("POST")){
			this.createPost(this.request.getParameterMap());
			return;
		}
		
		try {
			this.response.sendError(404, "Not implemented yet.");
		} catch (Exception e){
			e.printStackTrace();
		}
		
	}
	public void createPost(Map<String, String[]> params){
		
		
		
	}

	public void profil() {
		
		if(this.request.getMethod().toUpperCase().equals("GET")) {
			this.profilGet();
			return;
		}
		
		if(this.request.getMethod().toUpperCase().equals("POST")){
			this.profilPost(this.request.getParameterMap());
			return;
		}
		
		try {
			this.response.sendError(404, "Not implemented yet.");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	public void profilGet() {
		
		String currentUsername  = (String)  this.request.getSession().getAttribute("username");

		this.request.setAttribute("username", currentUsername);
		this.displayView();

	}
	public void profilPost(Map<String, String[]> params) {
		
	}
}
