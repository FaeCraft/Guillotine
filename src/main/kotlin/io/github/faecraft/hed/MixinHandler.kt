package io.github.faecraft.hed

import net.minecraft.entity.EntityType
import net.minecraft.entity.damage.DamageSource
import net.minecraft.entity.mob.CreeperEntity
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
        val entity = source.source ?: return

        if (entity.type == EntityType.CREEPER) {
            val creeper = entity as CreeperEntity

            if (creeper.shouldRenderOverlay() && source.isExplosive) {
                player.dropStack(createHead(player))
            }
        } else if (entity.type == EntityType.SPECTRAL_ARROW) {
            if (player.world.random.nextInt(4) == 0) {
                player.dropStack(createHead(player))
            }
        }
    }
}
