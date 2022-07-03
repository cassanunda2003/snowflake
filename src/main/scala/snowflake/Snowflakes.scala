import scala.annotation.tailrec
object Snowflakes {

  val SnowflakeSize = 6;

  @tailrec
  def recurseMatch(firstSnowflake: List[Int], list: List[Int], nodeCount: Int, value: Boolean)(implicit f: List[Int] => List[Int], p: (List[Int], List[Int]) => Boolean): Boolean = 
      if (nodeCount <= 0 || value)  {
          value
      } else {
              recurseMatch(firstSnowflake, f(list), nodeCount - 1, p(firstSnowflake, list))
      }


  def compareRight(list1: List[Int], list2: List[Int]): Boolean = list1 == list2
  def compareLeft(list1: List[Int], list2: List[Int]): Boolean = list1 == list2.reverse

  def matchRight(snowFlake1: List[Int], snowFlake2: List[Int]): Boolean = recurseMatch(snowFlake1, snowFlake2, SnowflakeSize, false)(rotateRight, compareRight)

  def matchLeft(snowFlake1: List[Int], snowFlake2: List[Int]): Boolean = recurseMatch(snowFlake1, snowFlake2, SnowflakeSize, false)(rotateLeft, compareLeft)

  def rotateRight(snowFlake: List[Int]): List[Int] = snowFlake.takeRight(1).concat(snowFlake.dropRight(1))

  def rotateLeft(snowFlake: List[Int]): List[Int] = snowFlake.drop(1).concat(snowFlake.take(1))

  def snowFlakesAlike(snowFlake1: List[Int], snowFlake2: List[Int]) = matchRight(snowFlake1, snowFlake2) || matchLeft(snowFlake1, snowFlake2)
}
