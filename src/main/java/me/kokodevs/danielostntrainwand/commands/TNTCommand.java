package me.kokodevs.danielostntrainwand.commands;

import me.kokodevs.danielostntrainwand.DanielosTNTRainWand;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.block.data.type.TNT;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.TNTPrimed;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class TNTCommand implements CommandExecutor, TabCompleter {

    private final DanielosTNTRainWand plugin;

    public TNTCommand(DanielosTNTRainWand plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

        if (sender instanceof Player p) {

            if (!p.hasPermission("danielplugin.tntstick")) return true;

            if (args.length == 0) {
                p.getInventory().addItem(plugin.tntBaseStick);
            } else if (args[0].equals("reload")) {
                plugin.reloadConfig();
                p.sendMessage("Plugin's config reloaded!");
            } else if (args[0].equals("setBase1")) {
                p.sendMessage("Set base 1");
                Location loc = p.getLocation();
                plugin.getConfig().set("base1.x", loc.getX());
                plugin.getConfig().set("base1.y", loc.getY());
                plugin.getConfig().set("base1.z", loc.getZ());
                plugin.saveConfig();
            } else if (args[0].equals("setBase2")) {
                p.sendMessage("Set base 2");
                Location loc = p.getLocation();
                plugin.getConfig().set("base2.x", loc.getX());
                plugin.getConfig().set("base2.y", loc.getY());
                plugin.getConfig().set("base2.z", loc.getZ());
                plugin.saveConfig();
            } else if (args[0].equals("explosion")) {
                try {
                    int explosion = Integer.parseInt(args[1]);
                    plugin.getConfig().set("explosion-power", explosion);
                    plugin.saveConfig();
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }
            } else if (args[0].equals("radius")) {
                try {
                    int radius = Integer.parseInt(args[1]);
                    plugin.getConfig().set("radius", radius);
                    plugin.saveConfig();
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }
            }

        }

        return true;
    }

    @Override
    public @Nullable List<String> onTabComplete(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

        if(args.length == 1) {
            return List.of("reload", "setBase1", "setBase2", "explosion", "radius");
        }

        return List.of();
    }
}
