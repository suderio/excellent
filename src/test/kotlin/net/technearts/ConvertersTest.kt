package net.technearts

import io.kotlintest.shouldBe
import io.kotlintest.shouldNotBe
import io.kotlintest.specs.StringSpec
import java.io.File
import java.math.BigDecimal
import kotlin.reflect.KFunction

class ConvertersTest : StringSpec({

    "number conversion should return a BigDecimal" {
        "0" converter NumberConverter shouldBe BigDecimal.ZERO
    }

    "workbook path should return a workbook" {
        File(this::class.java.getResource("/test.xlsx").toURI()).excelReader() shouldNotBe null
    }

    "author should be parsed" {
        val excelReader = File(this::class.java.getResource("/test.xlsx").toURI()).excelReader()
        excelReader.parse(Author::class.java).apply {
            Author::getBirth column 3
            Author::setName column 2
            Author::setTitle column 1

        }

        excelReader.parse(Book::class.java).apply {
            Author::getBirth column 3
            Author::setName column 2
            Author::setTitle column 1

        }

        val authors = Author::class.java from excelReader
    }
})







