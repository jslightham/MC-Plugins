package com.jslightham.guireport.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.jslightham.guireport.Main;
import com.jslightham.guireport.ui.TestUI;

public class TestCommand implements CommandExecutor{
	
	private Main plugin;
	
	public TestCommand(Main plugin) {
		this.plugin = plugin;
		
		plugin.getCommand("test").setExecutor(this);
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if(!(sender instanceof Player)) {
			return true;
		}
		
		Player p = (Player) sender;
		
		if(p.hasPermission("guireport.opentest")) {
			p.openInventory(TestUI.GUI(p));
		}
		
		
		return false;
	}
	
	

}
