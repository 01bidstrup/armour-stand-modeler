package dev.aucorg.armourstandmodeler.debug;

import dev.aucorg.armourstandmodeler.ArmourStandInteractionMap;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class DebugPrintInteractionListCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (commandSender instanceof Player player) {
            ArmourStandInteractionMap.getInteractionPairs().forEach(entry ->
                    player.sendMessage(entry.getKey().getDisplayName() + ": " + entry.getValue().getUniqueId()));
        }
        return false;
    }
}
