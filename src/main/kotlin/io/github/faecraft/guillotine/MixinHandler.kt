package io.github.faecraft.guillotine

import io.github.faecraft.guillotine.register.Enchantments
import net.minecraft.entity.LivingEntity
import net.minecraft.entity.damage.DamageSource
import net.minecraft.item.ItemStack
import net.minecraft.item.Items
import net.minecraft.server.network.ServerPlayerEntity
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo

object MixinHandler {
    private fun createHead(player: ServerPlayerEntity): ItemStack {
        val head = ItemStack(Items.PLAYER_HEAD, 1)
        val tag = head.getOrCreateTag()

        tag.putString("SkullOwner", player.name.asString())

        head.tag = tag

        return head
    }

    fun onDeath(player: ServerPlayerEntity, source: DamageSource, ci: CallbackInfo) {
        val attacker = source.attacker ?: return

        val item = when (attacker) {
            is ServerPlayerEntity -> attacker.mainHandStack
            is LivingEntity -> attacker.activeItem

            else -> null
        } ?: return

        val level = item.enchantmentLevel(Enchantments.GUILLOTINE) ?: return

        when (level) {
            0, 1 -> if (player.world.random.nextInt(2) == 1) {
                player.dropStack(createHead(player))
            }

            else -> player.dropStack(createHead(player))
        }
    }
}
