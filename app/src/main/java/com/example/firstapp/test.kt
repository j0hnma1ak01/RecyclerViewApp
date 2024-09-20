package com.example.firstapp

fun main(){
    print("hello")

    var e = Employee(type = "Mobile App")
    var p = Programmer()
    p.print()
    var x = p.display()
    println(x)

    fun Int.isOdd() : Boolean {return this % 2 == 1}
    fun Programmer.myfun() : Int {return 10}
    var ten = p.myfun()
    println(ten)

    var d  = MyDataClass (5,"john")
    d.id = 100
    println(d.id)

    println(MyEnum.MALE)
}


open class Employee (var name: String = "",var id: Int = 0,var type:String){
          var bonus: Double = 100.0
                  set(value) {
              if (type.equals("Programmer")) {
                        field = 1000.0
                  }
              else{
                      field= value
                  }
                  }
              get() {return field}

    open fun print(){
        print("Employee")
    }
}
 class Programmer(mytype : String = ""): Employee(type = mytype),Person {

     override fun print(){
         println("Programmer")
     }

     override fun display(): Int {
         var x = 4
         return x+4
     }
 }

interface Person{

    fun display() : Int
}