

fun main() {
    testGeneric2()
}

///-----------------------------------------------------------------------------
fun testSwitchCase() {
    val a = 1
    val result = when(a) {
        1 -> println("a == 1")
        2 -> println("a == 2")
        else -> {
            println("a is not 1 or 2")
        }
    }
    println("switch-case result: ${result}")
}

///-----------------------------------------------------------------------------
fun testLoop() {
    val items = listOf(1, 2, 3, 4)
    for (i in items) {
        println("Item: " + i)
    }
    for (i in 0 until items.size) {
        println("Item by index: " + items[i])
    }
    for((index, value) in items.withIndex()) {
        println("Item pair: $index, $value")
    }
    breakPoint@ for(i in 5..100) {
        println("Value in range: $i")
        break@breakPoint
    }
}

///-----------------------------------------------------------------------------
fun testAnonymousClass() {
    var humanObject :Human = object:Human {
        override fun think() {
            println("I'm thinking...")
        }
    }
    humanObject.think()
}

interface Human {
    fun think()
}

///-----------------------------------------------------------------------------
class Student(val name: String, var age: Int) {
    var message: String = "First message"
    constructor(yourName: String, yourAge: Int, message: String): this(yourName, yourAge) {
        this.message = message
    }
}

fun testConstructors() {
    val student = Student("Phong Handsome", 26)
    println("Student: " + student.name + ", " + student.age)
    println("Student2: ${student.name} and ${student.age}")
    val student2 = Student("Phong", 33, "Updated message")
    println("Student2: ${student2.name}, ${student2.age}, ${student2.message}")
}

///-----------------------------------------------------------------------------
//Inheritance
fun testInheritance() {
    var women: Girl = Women()
    women.think()
}

open class Girl {
    open fun think() {
        println("Girls like rich men!")
    }
}

class Women : Girl() {
    override fun think() {
        println("Women like good men")
    }
}

///-----------------------------------------------------------------------------
//Interface
interface MyInterface {
    var myVar: Int
    fun myFun()
}

interface InterfaceA {
    fun printMeFromA() {
        println("Print me from A")
    }
}

interface InterfaceB {
    fun printMeFromB() {
        println("Print me from B")
    }
}

class MyInterfaceImpl: MyInterface, InterfaceA, InterfaceB {
    override var myVar = 15;
    override fun myFun() {
        println("Implement function of interface: ${myVar}")
    }
}

fun testInterface() {
    var myInterfaceImpl = MyInterfaceImpl()
    myInterfaceImpl.myFun()
    myInterfaceImpl.printMeFromA()
    myInterfaceImpl.printMeFromB()
}

///-----------------------------------------------------------------------------
//Access modifier
/**
 * "internal" access modifier = default access modifier in Java
 * No access modifier = public access modifier
 */
internal class MyAccessModifier {
    internal var a: Int = 0
    internal var b: String = ""
}

///-----------------------------------------------------------------------------
//Function Extension
class Alien {
    var skills: String = "First Skill"
    fun printMySkill() {
        println("Alien skills: ${skills}")
    }

    companion object {
        fun show(): String {
            return "What are you doing"
        }
    }
}

fun Alien.addMoreSkills(a: Alien) : String {
    var mirrorAlien = Alien()
    mirrorAlien.skills = this.skills + a.skills;
    return mirrorAlien.skills;
}

fun testFunctionExtension() {
    var a1 = Alien()
    var a2 = Alien()

    a1.skills = "A1 skills "
    a2.skills = "A2 skills "

    var a3 = Alien()
    a3.skills = a1.addMoreSkills(a2)
    a3.printMySkill()

    println("Skills: " + Alien.show())
}

///-----------------------------------------------------------------------------
//Data classes
data class Book(val name: String, val publisher: String, var reviewScore: Int)

fun testDataClass() {
    val book = Book("Book A", "Nguyen Nhat Anh", 5)
    println(book.toString())
    println(book.hashCode())
    println(book.hashCode())

    book.reviewScore = 7
    println(book.toString())
    println(book.hashCode())
}

///-----------------------------------------------------------------------------
//Sealed class: it's kind of extension class of enum, but it can be inherited by other classes
sealed class MySealed {
    class OP1: MySealed()
    class OP2: MySealed()
}

fun testSealedClass() {
    var mySealed: MySealed
    mySealed = MySealed.OP2()
    mySealed = MySealed.OP1()
    val result = when (mySealed) {
        is MySealed.OP1 -> "My Sealed OP1"
        is MySealed.OP2 -> "My Sealed OP2"
    }
    println(result)
}

///-----------------------------------------------------------------------------
//Test generic
fun testGeneric1() {
    var a: Int = 1
    var b: Number
    b = a
    println(b)

    var gen1 = MyGenericClass<String> ("Cool")
    var gen2 = MyGenericClass<Any> ("Ok")
    gen1 = gen2
    gen2 = gen1
}

// <out t> is equal with <? extends T> in JAVA, <in t> is equal with <? super T> in JAVA
class MyGenericClass<in T>( a: T) {
    init {
        println("This my generic class with value: " + a)
    }
}

fun testGeneric2() {
    val t: TestGeneric<Book> = TestGeneric()
    t.callSomething(Book("abc", "Phong", 5))
}
///-----------------------------------------------------------------------------
//Test delegation
interface Base {

    val a: String

    fun printMe()

    fun print3()
}

class BaseImpl(val x: Int) : Base {

    override val a: String = "WTH?"

    override fun print3() {
        println("Print third time!")
    }

    override fun printMe() {
        println("Value of x: " + x)
    }

    fun print2() {
        println("Print second time!")
    }
}

class Derived(b: Base) : Base by b {

}

fun testDelegation() {
    Derived(BaseImpl(123)).printMe()
    Derived(BaseImpl(123)).print3()
    println(Derived(BaseImpl(456)).a)
}