// Command Line Arguments - Delhi 10:30AM


data class trains(
    var Name: String? = null,
	var Source: String? = null,
    var Destination: String? = null,
    var DepTime: String? = null
)

fun main(arg:Array<String>) {
    println("Hello, world!!!")
    
    var Time = arg[1]
    var Dest = arg[0]
    
    println("Time is - ${Time}")
    println("Dest is - ${Dest}")
        
    val trns = ArrayList<trains>()
    
    trns.add(trains("RjDhni","Surat","Vapi","10:00AM"))
    trns.add(trains("Express","Udhna","Delhi","10:30AM"))
    trns.add(trains("Local","Delhi","Udhna","10:30AM"))
    trns.add(trains("RjDhni","Vapi","Surat","01:00PM"))
    
    
    println("\n=============== Trains Details =================")
    println("Name \t\t Source \t Dest \t Time")
    println("------------------------------------------------")
    for(items in trns){
        println(items.Name+ "\t\t "+ items.Source+ "\t\t "+ items.Destination+ "\t "+ items.DepTime)
    }
    println("------------------------------------------------")
    
    
    println("\n======== Trains Which Arrive at ${Time} ========")    
    println("Name \t\t Source \t Dest \t Time")
    println("------------------------------------------------")
    for(items in trns){
        if(items.DepTime == Time){
	        println(items.Name+ "\t\t "+ items.Source+ "\t\t "+ items.Destination+ "\t "+ items.DepTime)
        }
    }
    println("------------------------------------------------")
    
       
    println("\n=========== Trains Which Go To ${Dest} ===========")    
    println("Name \t\t Source \t Dest \t Time")
    println("------------------------------------------------")
    for(items in trns){
        if(items.Destination == Dest){
	        println(items.Name+ "\t\t "+ items.Source+ "\t\t "+ items.Destination+ "\t "+ items.DepTime)
        }
    }
    println("------------------------------------------------")
    
}
