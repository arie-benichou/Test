package exercice1

import org.junit.runner.RunWith
import org.scalatest.FunSpec
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class StringCalculatorTest extends FunSpec {

  describe("[StringCalculator]") {

    it("should return 0 for an empty string") {
      assert(StringCalculator("") === 0) // => assertEquals(StringCalculator(""), 0)
    }

    it("should return 1 for \"1\"") {
      assert(StringCalculator("1") === 1)
    }

    it("should return 2 for \"2\"") {
      assert(StringCalculator("2") === 2)
    }

    it("should return 3 for \"1,2\"") {
      assert(StringCalculator("1,2") === 3)
    }

    it("should return 6 for \"1,2,3\"") {
      assert(StringCalculator("1,2,3") === 6)
    }

    it("should handle an unknown amount of numbers") {
      assert(StringCalculator("1,2,3,4") === 10)
    }

    it("should handle new lines as delimiter") {
      assert(StringCalculator("1\n2,3") === StringCalculator("1,2,3"))
    }

    it("should handle option for a different delimiter") {
      assert(StringCalculator("//,\n" + "1,2,3") === StringCalculator("1,2,3"))
      assert(StringCalculator("//:\n" + "1:2:3") === StringCalculator("1,2,3"))
      assert(StringCalculator("//:\n" + "1:2\n3") === StringCalculator("1,2,3"))
    }

    it("should not allow negative numbers") {
      try {
        StringCalculator("1,-2,3,-4")
      }
      catch {
        case e: Exception => {
          assert(e.getMessage === "negatives not allowed: -2 -4")
        }
      }
    }

    it("should ignore numbers greater than 1000") {
      assert(StringCalculator("1,1000") === 1001)
      assert(StringCalculator("1,1001") === 1)
      assert(StringCalculator("2,1001") === 2)
      assert(StringCalculator("2,1001,1002") === 2)
      assert(StringCalculator("1001") === 0)
    }

  }

}