

fun main() {
    testFunctionExtension()
}

///-----------------------------------------------------------------------------
fun testSwitchCase() {
    val a = 1
    when(a) {
        1 -> print("a == 1")
        2 -> print("a == 2")
        else -> {
            print("a is not 1 or 2")
        }
    }
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
