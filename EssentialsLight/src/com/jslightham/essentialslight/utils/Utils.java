package com.jslightham.essentialslight.utils;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;

public class Utils {
	
	public static String chat (String s) {
		return ChatColor.translateAlternateColorCodes('&', s);
	}
	
	public static String getStringFromLocation(Location loc) {
		return loc.getWorld().getName() + ":" + loc.getX() + ":" + loc.getY() + ":" + loc.getZ() + ":" + loc.getYaw() + ":" + loc.getPitch() ;
	}
	public static Location getLocationFromString(String s) {
		  if (s == null || s.trim() == "") {
		  return null;
		  }
		  final String[] parts = s.split(":");
		  if (parts.length == 6) {
		  World w = Bukkit.getServer().getWorld(parts[0]);
		  double x = Double.parseDouble(parts[1]);
		  double y = Double.parseDouble(parts[2]);
		  double z = Double.parseDouble(parts[3]);
		  float yaw = Float.parseFloat(parts[4]);
		  float pitch = Float.parseFloat(parts[5]);
		  return new Location(w, x, y, z, yaw, pitch);
		  }
		  return null;
	}
}
