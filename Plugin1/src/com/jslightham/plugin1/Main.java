package com.jslightham.plugin1;

import org.bukkit.command.CommandExecutor;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.plugin.java.JavaPlugin;

import com.jslightham.plugin1.commands.HelloCommand;

public class Main extends JavaPlugin{

	public int time = 2;
	private Time t = new Time(this);
	public static void main(String[] args) {
		

	}
	@Override
	public void onEnable() {
		t.getTime();
		this.getCommand("test").setExecutor((CommandExecutor)new HelloCommand());
		this.getCommand("heal").setExecutor((CommandExecutor)new CommandClass());
	}
	
	@Override
	public void onDisable() {
		
	}
}
