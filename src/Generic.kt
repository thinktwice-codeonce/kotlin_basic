import java.util.ArrayList

fun main() {
   testGeneric()
}

private fun testGeneric(items: List<Any>) {
    val a = items[0] as String
    println(a)
}

fun testGeneric() {

    var strs: MutableList<String> = mutableListOf("Item 1", "Item 2")
    var objs: MutableList<Object> = mutableListOf(Object(), Object())

    strs.add("1")
    objs.add(Object())

    strs = objs as MutableList<String>
    objs = strs as MutableList<Object>

    val o: Object = strs.get(0)
    val s: String = objs.get(0) as String //crash here

    println(s)
    println(o)
}
