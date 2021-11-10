object BarkMemo {
    // Variable declaration using implicit
    implicit val dogBark = new DogAnimal("Bow-wow")
    implicit val catBark = new CatAnimal("Mew-mew")
}

class DogAnimal(val dog: String)
class CatAnimal(val cat: String)

class Animal {
    // Functions that can implicitly supply a parameter list
    def bark(implicit dogBark: DogAnimal, catBark: CatAnimal): Unit = {
        print("Dog barks is " + dogBark.dog + ". ")
        println("Cat barks is " + catBark.cat + ".")
    }
}

object ImplicitParameter extends App {
    // Introducing BarkMemo members into scope
    import BarkMemo._

    val animal = new Animal

    // Argument is implicit parameter list 
    animal.bark(dogBark, catBark) // Dog barks is Bow-wow. Cat barks is Mew-mew.

    // Possible to omit implicit parameters
    animal.bark // Dog barks is Bow-wow. Cat barks is Mew-mew.
}


// =====================================
//         Output Sample
// =====================================
// $ scalac ImplicitParameter.scala
// $ scala ImplicitParameter
// Dog barks is Bow-wow. Cat barks is Mew-mew.
// Dog barks is Bow-wow. Cat barks is Mew-mew.