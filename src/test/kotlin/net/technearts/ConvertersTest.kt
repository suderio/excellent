package net.technearts

import io.kotlintest.shouldBe
import io.kotlintest.specs.StringSpec
import java.math.BigDecimal

class ConvertersTest : StringSpec({

    "number conversion should return a BigDecimal" {
        "0" convert NumberConverter shouldBe BigDecimal.ZERO
    }
})



