package net.technearts

import org.apache.poi.ss.usermodel.Workbook
import org.apache.poi.xssf.usermodel.XSSFWorkbook
import java.io.File
import java.io.FileInputStream
import java.lang.reflect.Field
import java.math.BigDecimal
import java.nio.file.Path
import kotlin.reflect.KFunction
import kotlin.reflect.KMutableProperty
import kotlin.reflect.jvm.javaField

val NumberConverter = { s: String -> BigDecimal(s) }

infix fun <T> String.converter(converter: (String) -> T): T = converter(this)
class BeanParser<T>() {
    val map = HashMap<Int, KFunction<*>>()

    infix fun <V> KFunction<V>.column(i: Int): BeanParser<T> {
        map.put(i, this)
        return this@BeanParser
    }

    infix fun <V> KFunction<V>.header(h: String): BeanParser<T> {
        map.put(i, this)
        return this@BeanParser
    }

}

class ExcelReader(workbook: Workbook) {
    fun <T> parse(java: Class<T>): BeanParser<T> {
        return BeanParser<T>()
    }


}

fun Workbook.excelReader() = ExcelReader(this)

fun File.excelReader() = XSSFWorkbook(FileInputStream(this)).excelReader()

fun Path.excelReader() = this.toFile().excelReader()

infix fun <T> Class<T>.from(reader: ExcelReader): List<T> {
    return listOf<T>()
}