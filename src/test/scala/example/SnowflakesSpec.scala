import org.scalatest._
import flatspec._
import matchers._

class SnowflakesSpec extends AnyFlatSpec with should.Matchers {
    
    "rotateRight" should "rotate an list of ints one to the right" in {
        Snowflakes.rotateRight(List(1,2,3,4,5,6)) should be (List(6, 1, 2, 3, 4, 5))
    }
    "rotateLeft" should "rotate a list of ints one to the left" in {
        Snowflakes.rotateLeft(List(1,2,3,4,5,6)) should be (List(2, 3, 4, 5, 6, 1))
    }

    "matchRight" should "match alike snowflakes" in {
        Snowflakes.matchRight(List(1,2,3,4,5,6), List(6,1,2,3,4,5)) should be (true)
        Snowflakes.matchRight(List(1,2,3,4,5,6), List(5,6,1,2,3,4)) should be (true)
        Snowflakes.matchRight(List(1,2,3,4,5,6), List(4,5,6,1,2,3)) should be (true)
        Snowflakes.matchRight(List(1,2,3,4,5,6), List(3,4,5,6,1,2)) should be (true)
        Snowflakes.matchRight(List(1,2,3,4,5,6), List(2,3,4,5,6,1)) should be (true)
        Snowflakes.matchRight(List(1,2,3,4,5,6), List(1,2,3,4,5,6)) should be (true)
    }

    "matchRight" should "not match different snowflakes" in {
         Snowflakes.matchRight(List(4,2,3,4,5,6), List(6,1,2,3,4,5)) should be (false)
    }

    "matchLeft" should "match alike snowflakes" in {
        Snowflakes.matchLeft(List(1,2,3,4,5,6), List(3,2,1,6,5,4)) should be (true)
        Snowflakes.matchLeft(List(1,2,3,4,5,6), List(6,5,4,3,2,1)) should be (true)
    }

    "matchLeft" should "not match different snowflakes" in {
         Snowflakes.matchLeft(List(4,2,3,4,5,6), List(6,1,2,3,4,5)) should be (false)
    }

    "snowFlakesAlike" should "match a left and right matching snowflake" in {
        Snowflakes.snowFlakesAlike(List(1,2,3,4,5,6), List(1,2,3,4,5,6)) should be (true)
    }
    
    "snowFlakesAlike" should "not match a differing snowflake" in {
        Snowflakes.snowFlakesAlike(List(1,2,3,4,5,6), List(8,1,2,3,4,5)) should be (false)
    }
} 