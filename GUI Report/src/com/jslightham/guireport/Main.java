package com.jslightham.guireport;

import org.bukkit.command.CommandExecutor;
import org.bukkit.plugin.java.JavaPlugin;

import com.jslightham.guireport.commands.TestCommand;
import com.jslightham.guireport.listeners.InventoryClickListener;
import com.jslightham.guireport.ui.TestUI;

public class Main extends JavaPlugin{
	
	@Override
	public void onEnable() {
		new TestCommand(this);
		new InventoryClickListener(this);
		TestUI.initialize();
	}
}
