package com.jslightham.guireport.utils;

import java.util.ArrayList;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Utils {
	
	public static String chat(String s) {
		return ChatColor.translateAlternateColorCodes('&', s);
	}
	
	public static ItemStack createItem(Inventory inv, String materialId, int amount, int invSlot, String displayName, String... loreString) {
		ItemStack item;
		ArrayList<String> lore = new ArrayList<String>();
		
		item = new ItemStack(Material.ACACIA_BOAT, amount);
		
		ItemMeta meta = item.getItemMeta();
		meta.setDisplayName(Utils.chat(displayName));
		for(String s : loreString) {
			lore.add(Utils.chat(s));
		}
		meta.setLore(lore);
		item.setItemMeta(meta);
		
		inv.setItem(invSlot, item);
		return item;
	}
	
	public static ItemStack createItemByte(Inventory inv, String materialId, int byteId, int amount, int invSlot, String displayName, String... loreString) {
		ItemStack item;
		ArrayList<String> lore = new ArrayList();
		
		item = new ItemStack(Material.getMaterial(materialId), amount, (short) byteId);
		
		ItemMeta meta = item.getItemMeta();
		meta.setDisplayName(Utils.chat(displayName));
		for(String s : loreString) {
			lore.add(Utils.chat(s));
		}
		meta.setLore(lore);
		item.setItemMeta(meta);
		
		inv.setItem(invSlot, item);
		return item;
	}
	
	
}
