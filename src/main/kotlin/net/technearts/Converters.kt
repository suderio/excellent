package net.technearts

import org.apache.poi.xssf.usermodel.XSSFWorkbook
import java.io.File
import java.io.FileInputStream
import java.math.BigDecimal
import java.nio.file.Path

val NumberConverter = {s: String -> BigDecimal(s)}

infix fun <T> String.convert(converter: (String) -> T): T = converter(this)

fun File.convert() = XSSFWorkbook(FileInputStream(this))

fun Path.convert() = this.toFile().convert()
