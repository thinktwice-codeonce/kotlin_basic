class TestGeneric<in T> {
    fun callSomething(a: T){
        println("Call something: " + a.toString())
    }
}