package io.github.faecraft.guillotine.register

import io.github.faecraft.guillotine.MOD_ID
import io.github.faecraft.guillotine.enchantments.GuillotineEnchantment
import net.minecraft.enchantment.Enchantment
import net.minecraft.util.Identifier
import net.minecraft.util.registry.Registry

object Enchantments {
    val GUILLOTINE = GuillotineEnchantment()

    fun register() {
        register("guillotine", GUILLOTINE)
    }

    private fun register(name: String, enchantment: Enchantment) {
        Registry.register(Registry.ENCHANTMENT, Identifier(MOD_ID, name), enchantment)
    }
}
