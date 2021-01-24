package io.github.faecraft.guillotine

import io.github.faecraft.guillotine.register.Enchantments
import org.apache.logging.log4j.LogManager

public const val MOD_ID = "guillotine"

fun init() {
    val logger = LogManager.getLogger(MOD_ID.capitalize())

    Enchantments.register()

    logger.info("Guillotine.")
}
