package me.bladian.genbuckets.command;

import me.bladian.genbuckets.GenBucketV2;
import me.bladian.genbuckets.Inventories;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * Created by Bladian. Before using the code, kindly ask permission to him via the following methods.
 * <p>
 * Twitter: BladianMC
 * Discord: Bladian#6411
 * <p>
 * Thank you for reading!
 */


public class ComGenBucket implements CommandExecutor
{

    private GenBucketV2 genBucketV2 = GenBucketV2.instance;
    private Inventories inventories = genBucketV2.getInventories();

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings)
    {
        if(command.getName().equalsIgnoreCase("gb"))
        {
            Player p = (Player) commandSender;
            inventories.genBucket(p);
        }
        return false;
    }
}
