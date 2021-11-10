import scala.language.implicitConversions

object ConversionRequestedType extends App {

    // A function that implicitly converts Double to Int
    implicit def doubleToInt(x: Double): Int = { 
        x.toInt 
    }
    val i: Int = 3.5
    println(i) // 3

    // A function that implicitly converts an Int to a Bool
    implicit def intToBoolean(arg: Int): Boolean = { 
        arg != 0 
    }
    val b = 1
    if (b)
        println("True") // True
    else 
        println("False")

    // A class that implicitly adds a method
    implicit class HelloClass(val h: String) {
        def addWorld: String = { 
            h + " World !"
        }
        def addScala: String = { 
            h + " Scala !"
        }
    }
    println("Hello".addWorld) // Hello World !
    println("Hello".addScala) // Hello Scala !

}


// =====================================
//         Output Sample
// =====================================
// $ scalac ConversionRequestedType.scala
// $ scala ConversionRequestedType
// 3
// True
// Hello World !
// Hello Scala !