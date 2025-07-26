package de.dxve.dTeamChat.listener;

import de.dxve.dTeamChat.DTeamChat;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

/**
 * DTeamChat by DxveDE
 *
 * @author DxveDE
 * @version 1.0.0
 */
public class JoinListener implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();

        if(player.isOp()) {
            DTeamChat.getInstance().getLatestVersion(latestVersion -> {
                String currentVersion = DTeamChat.getInstance().getPluginMeta().getVersion();
                if (!currentVersion.equalsIgnoreCase(latestVersion)) {
                    player.sendMessage("§8◢◤ §7§m                                                  §8 ◥◣");
                    player.sendMessage(" ");
                    player.sendMessage("§8  »  §7An update for §4" + DTeamChat.getInstance().getPluginMeta().getName() + "§7 is §navailable§8!");
                    player.sendMessage("§8  »  §7Current version: §4" + DTeamChat.getInstance().getPluginMeta().getVersion());
                    player.sendMessage("§8  »  §7New version: §4" + latestVersion);
                    player.sendMessage(" ");
                    player.sendMessage("§8  »  §7Download: https://github.com/DxveDE/" + DTeamChat.getInstance().getPluginMeta().getName() + "/releases/latest");
                    player.sendMessage(" ");
                    player.sendMessage("§8◥◣ §7§m                                                  §8 ◢◤");
                }
            });
        }
    }
}
