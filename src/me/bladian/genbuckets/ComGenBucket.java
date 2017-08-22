package me.bladian.genbuckets;

import org.bukkit.Bukkit;
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

    private Core core = Core.instance;
    private Inventories inventories = core.getInventories();

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
