package exercice1

object StringCalculator {

  // You can follow a string with .r, turning it into a Regex.
  // (?s): flag for multi-line mode
  // +?  : non-greedy version of +
  val pattern = "(?s)^//([^0-9\n]+?)\n(.*)".r

  // You can use pattern matching with regexp captures
  private def parse(input: String) = input match {
    case pattern(head, tail) => (head, tail)
    case _                   => (",", input)
  }

  private def parseInt(input: String) = if (input.isEmpty) 0 else Integer.parseInt(input)

  // StringCalculator.apply(x) <=> StringCalculator(x)
  def apply(input: String): Int = {
    val (head, tail) = parse(input)
    val parts = tail.split(head + "|\n")
    val integers = parts.map(parseInt)
    val negatives = integers.filter(_ < 0)
    if (negatives.isEmpty) integers.filterNot(_ > 1000).sum
    else error("negatives not allowed: " + negatives.mkString(" "))
  }

}