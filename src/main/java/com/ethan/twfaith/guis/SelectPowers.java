package com.ethan.twfaith.guis;

import com.ethan.twfaith.customevents.OpenGUIEvent;
import com.ethan.twfaith.data.PlayerHashMap;
import com.ethan.twfaith.data.PlayerData;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;
import java.util.Collections;
import java.util.Objects;

public class SelectPowers implements Listener {
    // TODO implement biome group and bonus selection for terrain bonus power
    private Inventory gui;
    public void openSelectPowersGui(Player player, PlayerData player_data){
        gui = Bukkit.createInventory(null, 45, "Select Powers");

        // Blessings
        // Terrain Bonus
        generateGUI(Material.GRASS_BLOCK, ChatColor.GREEN, "Terrain Bonus", player_data.getTerrain_bonus(), 10);

        // Summon God
        generateGUI(Material.WHITE_CANDLE, ChatColor.WHITE, "Summon God", player_data.getSummon_god(), 11);

        // Hell's Fury
        generateGUI(Material.FLINT_AND_STEEL, ChatColor.YELLOW, "Hell's Fury", player_data.getHells_fury(), 12);

        // Powerful Flock
        generateGUI(Material.WHITE_WOOL, ChatColor.RED, "Powerful Flock", player_data.getPowerful_flock(), 13);

        // Divine Intervention
        generateGUI(Material.ELYTRA, ChatColor.GOLD, "Divine Intervention", player_data.getDivine_intervention(), 14);

        // Mana
        generateGUI(Material.BREAD, ChatColor.GOLD, "Mana", player_data.getMana(), 15);

        // God Powers
        // Lion's Heart
        generateGUI(Material.PLAYER_HEAD, ChatColor.GOLD, "Lion's Heart", player_data.getLions_heart(), 19);

        // Savior
        generateGUI(Material.GOLDEN_CARROT, ChatColor.RED, "Savior", player_data.getSavior(), 20);

        // Taunt
        generateGUI(Material.DIAMOND, ChatColor.GOLD, "Taunt", player_data.getTaunt(), 21);

        // Insidious
        generateGUI(Material.ENDER_EYE, ChatColor.BLUE, "Insidious", player_data.getInsidious(), 22);

        // Explosive Landing
        generateGUI(Material.TNT_MINECART, ChatColor.RED, "Explosive Landing", player_data.getExplosive_landing(), 23);

        // Flood Power
        generateGUI(Material.WATER_BUCKET, ChatColor.BLUE, "Flood", player_data.getFlood(), 24);

        // Curses
        // Crumbling
        generateGUI(Material.DAMAGED_ANVIL, ChatColor.GRAY, "Crumbling", player_data.getCrumbling(), 28);

        // Heavy Boots
        generateGUI(Material.DIAMOND_BOOTS, ChatColor.BLACK, "Heavy Boots", player_data.getHeavy_boots(), 29);

        // Intoxicate
        generateGUI(Material.HONEY_BOTTLE, ChatColor.LIGHT_PURPLE, "Intoxicate", player_data.getIntoxicate(), 30);

        // Discombobulate
        generateGUI(Material.PUFFERFISH, ChatColor.YELLOW, "Discombobulate", player_data.getDiscombobulate(), 31);

        // Entangle
        generateGUI(Material.VINE, ChatColor.GREEN, "Entangle", player_data.getEntangle(), 32);

        // Frame
        ItemStack frame = new ItemStack(Material.ORANGE_STAINED_GLASS_PANE);
        for (int number : new int[]{0, 9, 18, 27, 36, 8, 17, 26, 35, 44, 1, 2, 3, 4, 5, 6, 7, 36, 37, 38, 39, 40, 41, 42, 43}){
            gui.setItem(number, frame);

        }

        player.openInventory(gui);
    }

    @EventHandler
    public void guiClickEvent(InventoryClickEvent e){
        try{        if(!Objects.equals(e.getClickedInventory(), gui)){
            return;
        }}catch (NullPointerException exception){return;}

        e.setCancelled(true);
        Player p = (Player) e.getWhoClicked();
        PlayerData player_data = PlayerHashMap.player_data_hashmap.get(p.getDisplayName());

        switch (e.getSlot()){
            case 10:
                inventoryClickSwitch(player_data.getTerrain_bonus(), Material.GREEN_TERRACOTTA, ChatColor.GREEN, "Terrain Bonus", p);
                break;
            case 11:
                inventoryClickSwitch(player_data.getSummon_god(), Material.WHITE_TERRACOTTA, ChatColor.WHITE, "Summon God", p);
                break;
            case 12:
                inventoryClickSwitch(player_data.getHells_fury(), Material.RED_TERRACOTTA, ChatColor.RED, "Hell's Fury", p);
                break;
            case 13:
                inventoryClickSwitch(player_data.getPowerful_flock(), Material.WHITE_TERRACOTTA, ChatColor.WHITE, "Powerful Flock", p);
                break;
            case 14:
                inventoryClickSwitch(player_data.getDivine_intervention(), Material.YELLOW_TERRACOTTA, ChatColor.YELLOW, "Divine Intervention", p);
            case 15:
                inventoryClickSwitch(player_data.getMana(), Material.YELLOW_TERRACOTTA, ChatColor.GOLD, "Mana", p);
                break;
            case 19:
                inventoryClickSwitch(player_data.getLions_heart(), Material.RED_TERRACOTTA, ChatColor.RED, "Lion's Heart", p);
                break;
            case 20:
                inventoryClickSwitch(player_data.getSavior(), Material.MAGENTA_TERRACOTTA, ChatColor.LIGHT_PURPLE, "Savior", p);
                break;
            case 21:
                inventoryClickSwitch(player_data.getTaunt(), Material.ORANGE_TERRACOTTA, ChatColor.GOLD, "Taunt", p);
                break;
            case 22:
                inventoryClickSwitch(player_data.getInsidious(), Material.BLUE_TERRACOTTA, ChatColor.BLUE, "Insidious", p);
                break;
            case 23:
                inventoryClickSwitch(player_data.getExplosive_landing(), Material.RED_TERRACOTTA, ChatColor.RED, "Explosive Landing", p);
                break;
            case 24:
                inventoryClickSwitch(player_data.getFlood(), Material.BLUE_TERRACOTTA, ChatColor.BLUE, "Flood", p);
                break;
            case 28:
                inventoryClickSwitch(player_data.getCrumbling(), Material.GRAY_TERRACOTTA, ChatColor.GRAY, "Crumbling", p);
                break;
            case 29:
                inventoryClickSwitch(player_data.getHeavy_boots(), Material.BLACK_TERRACOTTA, ChatColor.BLACK, "Heavy Boots", p);
                break;
            case 30:
                inventoryClickSwitch(player_data.getIntoxicate(), Material.MAGENTA_TERRACOTTA, ChatColor.LIGHT_PURPLE, "Intoxicate", p);
                break;
            case 31:
                inventoryClickSwitch(player_data.getDiscombobulate(), Material.YELLOW_TERRACOTTA, ChatColor.YELLOW, "Discombobulate", p);
                break;
            case 32:
                inventoryClickSwitch(player_data.getEntangle(), Material.GREEN_TERRACOTTA, ChatColor.GREEN, "Entangle", p);
                break;
        }
    }

    @EventHandler
    public void faithUpgradeEvent(OpenGUIEvent e){
        if(e.getGui_name().equals("Select Powers")){
            PlayerData player_data = PlayerHashMap.player_data_hashmap.get(e.getPlayer().getDisplayName());
            openSelectPowersGui(e.getPlayer(), player_data);
        }
    }

    // This method will populate the power selection GUI with the powers.
    public void generateGUI(Material block, ChatColor color, String display, int data, int spot){
        ItemStack item = new ItemStack(block);
        ItemMeta item_meta = item.getItemMeta();
        assert item_meta != null;
        item_meta.setDisplayName(color + display);
        switch (data){
            case 0:
                item_meta.setLore(Collections.singletonList(ChatColor.RED + "Not Owned"));
                break;
            case 1:
                item_meta.setLore(Collections.singletonList(ChatColor.GREEN + "Owned"));
                break;
        }
        item.setItemMeta(item_meta);
        gui.setItem(spot, item);

    }

    // This method gives the god the terracotta power block from the selection menu
    public void inventoryClickSwitch(int player_data, Material block, ChatColor color, String display_name, Player p){
        if (player_data > 0){
            ItemStack item = new ItemStack(block);
            ItemMeta item_meta = item.getItemMeta();
            assert item_meta != null;
            item_meta.setDisplayName(color + display_name);
            PersistentDataContainer item_data = item_meta.getPersistentDataContainer();
            item_data.set(new NamespacedKey(Objects.requireNonNull(Bukkit.getPluginManager().getPlugin("TWFaith")), "Power"), PersistentDataType.STRING, display_name);
            item.setItemMeta(item_meta);

            p.getInventory().addItem(item);
        }else{p.sendMessage(ChatColor.DARK_RED + "ERROR: Player must own power to equip it");}
    }
}

