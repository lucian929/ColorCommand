package com.luciandev.commands;

import me.mattstudios.mf.annotations.Command;
import me.mattstudios.mf.annotations.Default;
import me.mattstudios.mf.annotations.Permission;
import me.mattstudios.mf.base.CommandBase;
import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.inventory.meta.PotionMeta;

@Command("dyeitem")
public class dyeCommand extends CommandBase {

    private Color hexConverter(String hex) {
        return Color.fromRGB(
                Integer.valueOf(hex.substring(1, 3), 16),
                Integer.valueOf(hex.substring(3, 5), 16),
                Integer.valueOf(hex.substring(5, 7), 16));
    }

    @Default
    @Permission("dyecommand.default")
    public void dyeCommand(final Player player, String args) {

        Color hexColor;
        try {
            hexColor = hexConverter((String) args);
        } catch (Exception e) {
            player.sendMessage(ChatColor.RED + "Invalid color code!");
            return;
        }

            ItemStack item = player.getInventory().getItemInMainHand();
            ItemMeta itemMeta = item.getItemMeta();

            if (itemMeta instanceof LeatherArmorMeta meta) {
                meta.setColor(hexColor);
            } else if (itemMeta instanceof PotionMeta meta) {
                meta.setColor(hexColor);
            }
            item.setItemMeta(itemMeta);
    }
}
