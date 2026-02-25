package com.cobblemon.fossilore.command;

import com.cobblemon.fossilore.config.ModConfig;
import com.mojang.brigadier.CommandDispatcher;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.text.Text;

/**
 * Command to reload mod configuration without restarting the server/game
 * Usage: /fossilore reload
 */
public class ReloadCommand {
    
    public static void register(CommandDispatcher<ServerCommandSource> dispatcher) {
        dispatcher.register(
            CommandManager.literal("fossilore")
                .requires(source -> source.hasPermissionLevel(2)) // Requires OP level 2
                .then(CommandManager.literal("reload")
                    .executes(context -> {
                        // Reload configuration
                        ModConfig.reload();
                        
                        // Send confirmation message
                        context.getSource().sendFeedback(
                            () -> Text.literal("§a[Cobblemon Fossil Ore] Configuration reloaded successfully!"),
                            true // Broadcast to all ops
                        );
                        
                        return 1; // Success
                    })
                )
        );
    }
}
