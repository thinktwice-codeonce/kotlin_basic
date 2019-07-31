

fun main() {
    testConstructors()
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


