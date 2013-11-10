package exercice1

import org.junit.runner.RunWith
import org.scalatest.FunSpec
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class StringCalculatorTest extends FunSpec {

  describe("[StringCalculator]") {

    it("should return 0 for an empty string") {
      assert(StringCalculator.add("") === 0)
    }

    it("should return 1 for \"1\"") {
      assert(StringCalculator.add("1") === 1)
    }

    it("should return 2 for \"2\"") {
      assert(StringCalculator.add("2") === 2)
    }

    it("should return 3 for \"1,2\"") {
      assert(StringCalculator.add("1,2") === 3)
    }

    it("should return 6 for \"1,2,3\"") {
      assert(StringCalculator.add("1,2,3") === 6)
    }

    it("should handle an unknown amount of numbers") {
      assert(StringCalculator.add("1,2,3,4") === 10)
    }

    it("should handle new lines between numbers ") {
      assert(StringCalculator.add("1\n2,3") === StringCalculator.add("1,2,3"))
    }

  }

}