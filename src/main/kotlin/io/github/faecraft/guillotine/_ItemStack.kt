package io.github.faecraft.guillotine

import net.minecraft.enchantment.Enchantment
import net.minecraft.item.ItemStack
import net.minecraft.nbt.CompoundTag
import net.minecraft.util.registry.Registry

fun ItemStack.enchantmentLevel(enchant: Enchantment): Int? {
    val enchants: MutableList<CompoundTag> = mutableListOf()

    this.enchantments.listIterator().forEach { enchants.add(it as CompoundTag) }

    val id = Registry.ENCHANTMENT.getId(enchant).toString()

    enchants.forEach {
        if (it.getString("id") == id) {
            return it.getShort("lvl").toInt()
        }
    }

    return null
}
