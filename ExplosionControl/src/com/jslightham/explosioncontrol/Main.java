package com.jslightham.explosioncontrol;

import org.bukkit.plugin.java.JavaPlugin;

import com.jslightham.explosioncontrol.listeners.ExplosionPrime;

public class Main extends JavaPlugin{

	public void onEnable() {
		saveDefaultConfig();
		new ExplosionPrime(this);
	}
}
