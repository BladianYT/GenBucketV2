package me.bladian.genbuckets.events;

import me.bladian.genbuckets.type.GenerationType;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.BlockFace;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

import java.util.List;

/**
 * Created by Bladian. Before using the code, kindly ask permission to him via the following methods.
 * <p>
 * Twitter: BladianMC
 * Discord: Bladian#6411
 * <p>
 * Thank you for reading!
 */


public class GenerationEndEvent extends Event
{
    @Override
    public HandlerList getHandlers()
    {
        return null;
    }

    private GenerationType generationType;
    private Material material;
    private int ticks;
    private Location startingLocation;
    private Location endLocation;
    private List<Location> affectedBlocks;
    private  int distance;
    private BlockFace blockFace;

    /**
     *
     * @param generationType
     *      The type of generation (Horizontal, Vertical, Vertical with Gravity)
     * @param material
     *      The material which the gen bucket creates
     * @param ticks
     *      The amount of ticks it takes to place one block
     * @param startingLocation
     *      Location of where the first block was placed
     *@param endLocation
     *      Location of where the final block was placed
     *@param  affectedBlocks
     *      List of all the locations which were changed during the generation process
     */
    public GenerationEndEvent(GenerationType generationType, Material material, int ticks, Location startingLocation, Location endLocation, List<Location> affectedBlocks)
    {
        this.generationType = generationType;
        this.material = material;
        this.ticks = ticks;
        this.startingLocation = startingLocation;
        this.endLocation = endLocation;
        this.affectedBlocks = affectedBlocks;
    }

    /**
     *
     * @param generationType
     *      The type of generation (Horizontal, Vertical, Vertical with Gravity)
     * @param material
     *      The material which the gen bucket creates
     * @param ticks
     *      The amount of ticks it takes to place one block
     * @param startingLocation
     *      Location of where the first block was placed
     *@param endLocation
     *      Location of where the final block was placed
     *@param  affectedBlocks
     *      List of all the locations which were changed during the generation process
     * @param distance
     *      How many blocks should the gen bucket go
     * @param blockFace
     *      This is the direction of the bucket, it'll be the opposite of the clicked block
     */
    public GenerationEndEvent(GenerationType generationType, Material material, int ticks, Location startingLocation, Location endLocation, List<Location> affectedBlocks, int distance, BlockFace blockFace)
    {
        this.generationType = generationType;
        this.material = material;
        this.ticks = ticks;
        this.startingLocation = startingLocation;
        this.endLocation = endLocation;
        this.affectedBlocks = affectedBlocks;
        this.distance = distance;
        this.blockFace = blockFace;
    }

    public GenerationType getGenerationType()
    {
        return generationType;
    }

    public Material getMaterial()
    {
        return material;
    }

    public int getTicks()
    {
        return ticks;
    }

    public Location getStartingLocation()
    {
        return startingLocation;
    }

    public Location getEndLocation()
    {
        return endLocation;
    }

    public List<Location> getAffectedBlocks()
    {
        return affectedBlocks;
    }

    public int getDistance()
    {
        return distance;
    }

    public BlockFace getBlockFace()
    {
        return blockFace;
    }
}
