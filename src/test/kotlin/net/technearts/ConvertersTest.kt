package net.technearts

import io.kotlintest.shouldBe
import io.kotlintest.shouldNotBe
import io.kotlintest.specs.StringSpec
import java.io.File
import java.math.BigDecimal

class ConvertersTest : StringSpec({

    "number conversion should return a BigDecimal" {
        "0" convert NumberConverter shouldBe BigDecimal.ZERO
    }

    "workbook path should return a workbook" {
        File(this::class.java.getResource("/test.xlsx").toURI()).convert() shouldNotBe null
    }
})





