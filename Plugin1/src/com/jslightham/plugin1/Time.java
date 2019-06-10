package com.jslightham.plugin1;

public class Time {
	Main plugin;
	public Time(Main plugin) {
		this.plugin = plugin;
	}
	
	public void getTime() {
		System.out.println(plugin.time);
	}
}
