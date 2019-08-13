package net.technearts

import org.apache.poi.ss.usermodel.Workbook
import org.apache.poi.xssf.usermodel.XSSFWorkbook
import java.io.File
import java.io.FileInputStream
import java.math.BigDecimal
import java.nio.file.Path

val NumberConverter = {s: String -> BigDecimal(s)}

infix fun <T> String.converter(converter: (String) -> T): T = converter(this)

class ExcelReader(workbook: Workbook) {
    fun <T> parse(java: Class<T>) {

    }
}

fun Workbook.excelReader() = ExcelReader(this)

fun File.excelReader() = XSSFWorkbook(FileInputStream(this)).excelReader()

fun Path.excelReader() = this.toFile().excelReader()

infix fun <T> Class<T>.from(reader: ExcelReader): List<T> {
    return listOf<T>()
}