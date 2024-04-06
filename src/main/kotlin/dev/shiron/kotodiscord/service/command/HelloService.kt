package dev.shiron.kotodiscord.service.command

import dev.shiron.kotodiscord.util.data.action.BotSlashCommandData
import dev.shiron.kotodiscord.util.meta.SingleCommandEnum
import dev.shiron.kotodiscord.util.service.SingleCommandServiceClass
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.MessageSource
import org.springframework.stereotype.Service
import java.util.*

@Service
class HelloService
    @Autowired
    constructor(
        private val messages: MessageSource,
    ) : SingleCommandServiceClass(
            SingleCommandEnum.HELLO,
            messages,
        ) {
        override fun onSlashCommand(cmd: BotSlashCommandData) {
            cmd.reply(
                messages.getMessage(
                    "command.message.hello",
                    arrayOf(cmd.event.user.asMention),
                    Locale.JAPAN,
                ),
            )
        }
    }
