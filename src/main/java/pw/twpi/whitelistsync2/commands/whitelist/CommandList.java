package pw.twpi.whitelistsync2.commands.whitelist;

import com.mojang.brigadier.builder.ArgumentBuilder;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.network.chat.TextComponent;
import pw.twpi.whitelistsync2.Utilities;
import pw.twpi.whitelistsync2.WhitelistSync2;

public class CommandList {
    // Name of the command
    private static final String commandName = "list";
    private static final int permissionLevel = 4;

    static ArgumentBuilder<CommandSourceStack, ?> register() {
        return Commands.literal(commandName)
                .requires(cs -> cs.hasPermission(permissionLevel))
                .executes(context -> {
                    context.getSource().sendSuccess(new TextComponent(Utilities.FormatWhitelistedPlayersOutput(WhitelistSync2.whitelistService.getWhitelistedPlayersFromDatabase())), false);
                    return 0;
                });
    }
}
