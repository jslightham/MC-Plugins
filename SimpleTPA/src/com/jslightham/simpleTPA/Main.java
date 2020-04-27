package com.jslightham.simpleTPA;

import java.util.ArrayList;

import org.bukkit.plugin.java.JavaPlugin;

import com.jslightham.simpleTPA.utils.TPAreq;

public class Main extends JavaPlugin{
	
	private ArrayList<TPAreq> tpas = new ArrayList<TPAreq>();
	
	public void onEnable() {
		saveDefaultConfig();
		
	}
	
	public Player getRequestee() {
		
		for(int i=0; i < tpas.size(); i++) {
			tpas.get(i);
		}
	}
	
	public Player getRequestor() {
		
	}
	
}
 