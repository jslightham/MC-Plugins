package com.jslightham.invsee;

import org.bukkit.plugin.java.JavaPlugin;

import com.jslightham.invsee.commands.EnderchestCommand;
import com.jslightham.invsee.commands.InvseeCommand;

public class Main extends JavaPlugin{
	@Override
	public void onEnable() {
		saveDefaultConfig();
		new InvseeCommand(this);
		new EnderchestCommand(this);
	}
}
