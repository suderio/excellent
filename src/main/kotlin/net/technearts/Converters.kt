package net.technearts

import java.math.BigDecimal

val NumberConverter = {s: String -> BigDecimal(s)}
infix fun <T> String.convert(converter: (String) -> T): T = converter(this)
