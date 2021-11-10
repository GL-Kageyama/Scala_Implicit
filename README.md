# Scala Implicit Conversions and Parameters

## Conversion to Requested Type
```Scala
    // A function that implicitly converts Double to Int
    implicit def doubleToInt(x: Double): Int = { 
        x.toInt 
    }
    val i: Int = 3.5
    println(i) // 3
```

## Receiver Conversion
```Scala
    // Function to implicitly convert from Int to Rational
    implicit def intToRational(x: Int): Rational = {
        new Rational(x, 1)
    }

    val oneHalf = new Rational(1, 2)
    val intOne = 1

    // intOne implicitly converted to Rational type
    val rationalPlusInt = oneHalf + intOne
    println(rationalPlusInt) // 3/2
    println(rationalPlusInt.isInstanceOf[Rational]) // true
```

## Implicit Parameter
```Scala
    val animal = new Animal

    // Argument is implicit parameter list 
    animal.bark(dogBark, catBark) // Dog barks is Bow-wow. Cat barks is Mew-mew.

    // Possible to omit implicit parameters
    animal.bark // Dog barks is Bow-wow. Cat barks is Mew-mew.
```
