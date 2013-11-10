package exercice1

object StringCalculator {

  val pattern = "(?s)^//(.+?)\n(.*)".r

  private def parse(input: String) = {
    input match {
      case pattern(head, tail) => (head, tail)
      case _                   => (",", input)
    }
  }

  private def parseInt(input: String): Int = if (input.isEmpty) 0 else Integer.parseInt(input)

  def add(input: String): Int = {
    val (head, tail) = parse(input)
    val parts = tail.split(head + "|\n")
    val integers = parts.map(parseInt)
    val negatives = integers.filter(_ < 0)
    if (negatives.isEmpty) integers.filterNot(_ > 1000).sum
    else error("negatives not allowed: " + negatives.mkString(","))
  }

}