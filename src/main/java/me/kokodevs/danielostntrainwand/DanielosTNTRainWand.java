package me.kokodevs.danielostntrainwand;

import org.bukkit.Material;
import org.bukkit.entity.Item;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;
import org.json.simple.ItemList;

public final class DanielosTNTRainWand extends JavaPlugin {

    public ItemStack tntBaseStick;

    @Override
    public void onEnable() {
        //item creation
        tntBaseStick = new ItemStack(Material.STICK, 1);
        ItemMeta meta = tntBaseStick.getItemMeta();
        meta.setDisplayName("TNT WAND");
        tntBaseStick.setItemMeta(meta);


        getCommand("tntcommand").setExecutor(new TNTCommand(this));
        getServer().getPluginManager().registerEvents(new ItemListener(this), this);

        getConfig().options().copyDefaults();
        saveDefaultConfig();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
