package io.github.sbkimxtheia.unbreakableelytra;

import org.apache.commons.lang.ObjectUtils;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerItemDamageEvent;
import org.bukkit.plugin.java.JavaPlugin;

public final class UnbreakableElytra extends JavaPlugin {
	private static UnbreakableElytra plugin;
	
	@Override
	public void onEnable () {
		// Plugin startup logic
		plugin = this;
		getServer().getPluginManager().registerEvents(new UEListener(), plugin);
		Bukkit.getServer().getConsoleSender().sendMessage("Unbreakable-Elytra Initialized!");
	}
	
	@Override
	public void onDisable () {
		// Plugin shutdown logic
	}
}

class UEListener implements org.bukkit.event.Listener{
	
	@EventHandler
	public void onDamage(PlayerItemDamageEvent e){
		if(e.getItem().getType().equals(Material.ELYTRA)){
			e.setCancelled(true);
		}
	}
}
