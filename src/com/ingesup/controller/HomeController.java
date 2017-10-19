package com.ingesup.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import com.ingesup.controller.utils.HttpServletUtils;

public class HomeController extends HttpServletUtils {
	
	public void home() {
		this.displayView();
	}
	
	public void model() {
		List<String> model = new ArrayList<>();
		model.add("Hello");
		displayView(model);
	}
	
	public void formulaire() {
		
		if(this.request.getMethod().toUpperCase().equals("GET")) {
			this.formulaireGet();
			return;
		}
		
		if(this.request.getMethod().toUpperCase().equals("POST")){
			this.formulairePost(this.request.getParameterMap());
			return;
		}
		
		try {
			this.response.sendError(404, "Not implemented yet.");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void formulaireGet() {
		this.displayView();
	}	
	public void formulairePost(Map<String, String[]> params){
		
		for(Entry<String, String[]> currentParam : params.entrySet()){
			this.request.setAttribute(currentParam.getKey(), currentParam.getValue()[0]);
		}
		
		this.displayView("result");
	}
	
//	public void username() {
//		
//		if(this.request.getMethod().toUpperCase().equals("GET")){
//			this.usernameGet();
//			return;
//		}
//		
//		if(this.request.getMethod().toUpperCase().equals("POST")){
//			this.usernamePost(this.request.getParameterMap());
//			return;
//		}
//		
//		try {
//			this.response.sendError(404, "Not implemented yet.");
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		
//	}
//	public void usernameGet() {
//		
//		List<Personne> userList = PersonneManager.getAllPersonne();
//		if(userList != null)
//			this.request.setAttribute("userList", userList);
//		
//		String inputUsername = request.getParameterNames().hasMoreElements() ? request.getParameterNames().nextElement().toLowerCase() : null;
//		
//		// If any username to search has been given
//		if(inputUsername != null){
//			
//			Personne currentPersonne = PersonneManager.getPersonneByUsername(inputUsername);
//			
//			if(currentPersonne == null){
//				this.request.setAttribute("error", "This username does'nt exist.");
//			}
//			else{
//				this.request.setAttribute("seachedUser", currentPersonne);
//			}
//			
//			this.displayView("resultUsername");
//			
//		}
//		
//		this.displayView();
//		
//	}
//	public void usernamePost(Map<String, String[]> params) {
//		
//		String inputUsername = params.get("inputUsername")[0];
//		Integer inputAge	 = Integer.valueOf(params.get("inputAge")[0]);
//		
//		Personne newPersonne = new Personne();
//		newPersonne.setUsername(inputUsername.toLowerCase());
//		newPersonne.setAge(inputAge);
//		
//		PersonneManager.createOrUpdate(newPersonne);
//		
//		List<Personne> userList = PersonneManager.getAllPersonne();
//		if(userList != null)
//			this.request.setAttribute("userList", userList);
//		
//		this.request.setAttribute("validation", "Utilisateur créer avec succès.");
//		
//		this.displayView("resultUsername");
//	}
}
