package exercice1

object StringCalculator {

  def add(input: String): Int = if (input.isEmpty) 0 else Integer.parseInt(input)

}