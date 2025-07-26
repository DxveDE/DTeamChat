package de.dxve.dTeamChat.commands;

import de.dxve.dTeamChat.DTeamChat;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

/**
 * DTeamChat by DxveDE
 *
 * @author DxveDE
 * @version 1.0.0
 */
public class DTeamChatCommand implements CommandExecutor {

    FileConfiguration config = DTeamChat.getInstance().getConfig();

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String s, @NotNull String @NotNull [] args) {
        if(!(sender instanceof Player player)) {
            sender.sendMessage(config.getString("messages.command-only-players"));
            return true;
        }

        if (!player.hasPermission(config.getString("settings.permission"))) {
            player.sendMessage(DTeamChat.getInstance().getConfigMessage("messages.no-permissions"));
            return true;
        }
        if(args.length > 0) {
            String message = args[0];
            for (int i = 1; i < args.length; i++) {
                message += " " + args[i];
            }
            String finalMessage = message;

            Bukkit.getOnlinePlayers().stream().filter(all -> all.hasPermission(config.getString("settings.permission"))).forEach(all -> {
                all.sendMessage(DTeamChat.getInstance().getConfigMessage("messages.teamchat-message").replace("%playername%", player.getName()).replace("%message%", finalMessage).replace("&", (config.getBoolean("settings.color-codes") ? "§" : "&")));
            });
        } else {
            player.sendMessage(DTeamChat.getInstance().getConfigMessage("messages.syntax"));
        }
        return false;
    }
}
