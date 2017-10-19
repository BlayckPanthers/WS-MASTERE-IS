package com.ingesup.controller;

import java.io.IOException;
import java.util.List;

import com.ingesup.controller.utils.HttpServletUtils;
import com.ingesup.manager.HistoryManager;
import com.ingesup.model.History;

public class MonitorController extends HttpServletUtils {
	
	public void monitor() {
		
		// 1. GET: request to load all recent history data and display on the monitor interface
		if(this.request.getMethod().toUpperCase().equals("GET")){
			this.monitorGet();
		}
		else{
			try {
				this.response.sendError(404, "Not implemented yet.");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * Load the recent history list and display the JSP
	 */
	public void monitorGet(){
		
		List<History> recentList = HistoryManager.getRecentList();
		
		if(recentList == null)
			return;
		
		this.request.setAttribute("historyList", recentList);
		
		this.displayView();
		
	}

}
