package me.iknees.pluginprovino;

import org.bukkit.Chunk;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ClaimCommand implements CommandExecutor {

    private final PluginProvino plugin;

    public ClaimCommand(PluginProvino plugin)
    {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player)
        {
            Player player = (Player) sender;

            Chunk chunk = player.getLocation().getChunk();

            String chunkID = chunk.getX() + "." + chunk.getZ();

            if (plugin.isChunk(chunkID))
            {
                player.sendMessage("Questo chunk è già stato claimato");
            } else {
                player.sendMessage("Hai claimato questo chunck");
                plugin.addChunk(chunkID, player.getUniqueId());
            }
        }
        return true;
    }
}
