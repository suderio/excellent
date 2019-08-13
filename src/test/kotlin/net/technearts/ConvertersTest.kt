package net.technearts

import io.kotlintest.shouldBe
import io.kotlintest.shouldNotBe
import io.kotlintest.specs.StringSpec
import java.io.File
import java.math.BigDecimal

class ConvertersTest : StringSpec({

    "number conversion should return a BigDecimal" {
        "0" converter NumberConverter shouldBe BigDecimal.ZERO
    }

    "workbook path should return a workbook" {
        File(this::class.java.getResource("/test.xlsx").toURI()).excelReader() shouldNotBe null
    }

    "author should be parsed" {
        val excelReader = File(this::class.java.getResource("/test.xlsx").toURI()).excelReader()
        excelReader.parse(Author::class.java)

        val authors = Author::class.java from excelReader
    }
})





