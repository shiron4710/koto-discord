package dev.shiron.kotodiscord.util

import dev.shiron.kotodiscord.util.meta.SubCommandEnum
import net.dv8tion.jda.api.interactions.commands.build.Commands
import net.dv8tion.jda.api.interactions.commands.build.SlashCommandData
import org.springframework.context.MessageSource
import java.util.*

abstract class SubCommandServiceClass(
    val commandMeta: SubCommandEnum,
    private val messages: MessageSource
) : RunnableCommandServiceClass(commandMeta.metadata, messages) {

    override val slashCommandData: SlashCommandData
        get() = Commands.slash(commandMeta.metadata.commandName, messages.getMessage("command.description.${commandMeta.group.metadata.commandName}.${commandMeta.metadata.commandName}", arrayOf(), Locale.JAPAN)).addOptions(commandOptions)
            .addOptions(sharedOptionData)
}