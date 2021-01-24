package io.github.faecraft.guillotine.enchantments

import net.minecraft.enchantment.Enchantment
import net.minecraft.enchantment.EnchantmentTarget
import net.minecraft.entity.EquipmentSlot
import net.minecraft.item.AxeItem
import net.minecraft.item.ItemStack

class GuillotineEnchantment : Enchantment(Rarity.RARE, EnchantmentTarget.WEAPON, arrayOf(EquipmentSlot.MAINHAND)) {
    override fun isAcceptableItem(stack: ItemStack): Boolean {
        return stack.item is AxeItem || super.isAcceptableItem(stack)
    }

    override fun getMaxLevel(): Int = 2

    override fun getMinPower(level: Int): Int = 5 + (level - 1) * 9
    override fun getMaxPower(level: Int): Int = getMinPower(level) + 22
}
