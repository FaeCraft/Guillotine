package io.github.faecraft.hed

import org.apache.logging.log4j.LogManager

public const val MOD_ID = "hed"

fun init() {
    val logger = LogManager.getLogger(MOD_ID.capitalize())

    logger.info("Hed.")
}
