package me.bladian.genbuckets;

import me.bladian.genbuckets.util.ItemBuilder;
import me.bladian.genbuckets.util.Reference;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

/**
 * Created by Bladian. Before using the code, kindly ask permission to him via the following methods.
 * <p>
 * Twitter: BladianMC
 * Discord: Bladian#6411
 * <p>
 * Thank you for reading!
 */


public class Inventories
{

    private GenBucketV2 genBucketV2 = GenBucketV2.instance;
    private Reference reference = genBucketV2.getReference();

    public Inventories()
    {
        inventory.setItem(11, vertCobble);
        inventory.setItem(12, vertSand);
        inventory.setItem(13, vertObsidian);
        inventory.setItem(14, horiCobble);
        inventory.setItem(15, horiObsidian);
        for(int i = 0; i<inventory.getSize(); i++)
        {
            if(inventory.getItem(i) == null)
            {
                inventory.setItem(i, new ItemStack(Material.STAINED_GLASS_PANE));
            }
        }
    }

    public ItemStack vertCobble = new ItemBuilder(Material.LAVA_BUCKET).setName("§c§lCOBBLESTONE GEN BUCKET").addLore("§a§lPRICE:§e§l " + reference.BUCKET_COBBLESTONE_BUY, "§a§lUSE:§e§l " + reference.BUCKET_COBBLESTONE_USE).toItemStack();
    public ItemStack vertSand = new ItemBuilder(Material.LAVA_BUCKET).setName("§c§lSAND GEN BUCKET").addLore("§a§lPRICE:§e§l " + reference.BUCKET_SAND_BUY, "§a§lUSE:§e§l " + reference.BUCKET_SAND_USE).toItemStack();
    public ItemStack vertObsidian = new ItemBuilder(Material.LAVA_BUCKET).setName("§c§lOBSIDIAN GEN BUCKET").addLore("§a§lPRICE:§e§l " + reference.BUCKET_OBSIDIAN_BUY, "§a§lUSE:§e§l " + reference.BUCKET_OBSIDIAN_USE).toItemStack();
    public ItemStack horiCobble = new ItemBuilder(Material.LAVA_BUCKET).setName("§c§lHORIZONTAL COBBLESTONE GEN BUCKET").addLore("§a§lPRICE:§e§l " + reference.HORIZONTAL_BUCKET_COBBLESTONE_BUY, "§a§lUSE:§e§l " + reference.HORIZONTAL_BUCKET_COBBLESTONE_USE, "§a§lDISTANCE:§e§l " + reference.HORIZONTAL_BUCKET_COBBLESTONE_DISTANCE,  "The direction will be opposite the way you look at").toItemStack();
    public ItemStack horiObsidian = new ItemBuilder(Material.LAVA_BUCKET).setName("§c§lHORIZONTAL OBSIDIAN GEN BUCKET").addLore("§a§lPRICE:§e§l " + reference.HORIZONTAL_BUCKET_OBSIDIAN_BUY, "§a§lUSE:§e§l " + reference.HORIZONTAL_BUCKET_OBSIDIAN_USE, "§a§lDISTANCE:§e§l " + reference.HORIZONTAL_BUCKET_OBSIDIAN_DISTANCE,  "The direction will be opposite the way you look at").toItemStack();

    public Inventory inventory = Bukkit.createInventory(null, 27, "§c§lGEN BUCKET SHOP");

    public void genBucket(Player p)
    {
        p.openInventory(inventory);
    }
}
