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

  }

}