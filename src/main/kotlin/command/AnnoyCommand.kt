package command

import org.bukkit.Bukkit
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player

class AnnoyCommand : CommandExecutor {
    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<out String>): Boolean {
        if (args.size == 3) {
            var target = sender as Player

            val nickname = args[0]
            val action = args[1]
            val behave = args[2]

            if (Bukkit.getPlayer(action) != null) {
                target = Bukkit.getPlayer(nickname)!!
            }
            when(action) {
                "shift" -> {
                    if (behave == "up") {
                        target.isSneaking = false
                    } else if (behave == "down") {
                        target.isSneaking = true
                    }
                }
                "sprint" -> {
                    if (behave == "up") {
                        target.isSprinting = false
                    } else if (behave == "down") {
                        target.isSprinting = true
                    }
                }
                "jump" -> {
                    target.isJumping = true
                }
                "swimming" -> {
                    if (behave == "up") {
                        target.isSwimming = false
                    } else if (behave == "down") {
                        target.isSwimming = true
                    }
                }
                "drop" -> {
                    target.dropItem(true)
                }
                "attack" -> {
                    target.attack(target)
                }
            }
        }
        return true
    }
}