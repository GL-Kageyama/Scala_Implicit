import scala.language.implicitConversions

class Rational(numer: Int, denom: Int) {
    val n = numer
    val d = denom

    override def toString: String = {
        n.toString + "/" + d.toString
    }

    def +(that: Rational): Rational = {
        new Rational(n * that.d + that.n * d,
                     d * that.d
        )
    }
}

object ReceiverConversion extends App {

    // Function to implicitly convert from Int to Rational
    implicit def intToRational(x: Int): Rational = {
        new Rational(x, 1)
    }

    val oneHalf = new Rational(1, 2)
    println(oneHalf) // 1/2
    println(oneHalf.isInstanceOf[Rational]) // true

    val intOne = 1
    println(intOne) // 1
    println(intOne.isInstanceOf[Int]) // true

    // intOne implicitly converted to Rational type
    val rationalPlusInt = oneHalf + intOne
    println(rationalPlusInt) // 3/2
    println(rationalPlusInt.isInstanceOf[Rational]) // true

}


// =====================================
//         Output Sample
// =====================================
// $ scalac ReceiverConversion.scala
// $ scala ReceiverConversion
// 1/2
// true
// 1
// true
// 3/2
// true