// Task - 2

interface Ingredients{
    fun hotWater()
    fun milk()
    fun sugar()

}

class Mixture(val number: Int) : Ingredients{

    override fun hotWater(){
        println("Adding HotWater")
    }
    override fun milk(){
        println("Adding Milk")
    }
    override fun sugar(){
        println("Adding Sugar")
    }

    fun addIngredients(){
        if(number >1){
            println("Coffe bag Added")
            println("Coffee's Ready! Enjoy")
        }
        else{
            println("Tea bag Added ")
            println("Tea's Ready! Enjoy")
        }
    }

    fun getMixture(){
        hotWater()
        milk()
        sugar()
        addIngredients()
    }
}


abstract class Beveragers{
    abstract fun cleanPot()
    fun getBeverage(){
        println("Your Beverage is getting ready...")
    }
}

class Tea(): Beveragers(){
    override fun cleanPot(){
        println("Cleaning Tea pot...")
    }
}


class Coffe(): Beveragers(){
    override fun cleanPot(){
        println("Cleaning Coffee pot...")
    }
}


fun main(arg : Array<String>){
    println("Want Beverages ?.. \nPress 1. for Tea \nPress 2. for Coffe")
    val num = arg[0].toInt()   
    val mix = Mixture(num)
    
    when(num){
        1 ->{
            val tea = Tea()
            tea.cleanPot()
            tea.getBeverage()
        } 
        2 ->{
            val coffe = Coffe()
            coffe.cleanPot()
            coffe.getBeverage()
        }   
    }
    mix.getMixture()

}
