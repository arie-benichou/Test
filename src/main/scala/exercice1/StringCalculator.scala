package exercice1

object StringCalculator {

  private def addOne(input: String): Int = if (input.isEmpty) 0 else Integer.parseInt(input)

  def add(input: String): Int = input.split(",|\n").foldLeft(0)((sum, number) => sum + addOne(number))

}