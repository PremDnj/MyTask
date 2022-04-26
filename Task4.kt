

import kotlinx.coroutines.*
import kotlin.system.measureTimeMillis

fun main() = runBlocking {

    var flag = true
    val mesureTime = measureTimeMillis {

        val parJobs = launch {
            println("Execution Started!...")
            delay(60000L)
            if (flag) {
                repeat(20) {
                    launch {
                        val drive = async {
                            carDrive()
                        }
                        val batry = async {
                            carBatteries()
                        }
                        val inter = async {
                            carInterior()
                        }
                        val body = async {
                            carBody()
                        }
                        val painting = async {
                            carPainting()
                        }

                        body.await()
                        painting.await()
                        drive.await()
                        batry.await()
                        inter.await()
                        println("Car Done $it / 20 ")
                    }
                }
                flag = false
            }
        }
        parJobs.cancel()
        println("Execution Ended !....")
    }
    println("operation took $mesureTime")
}

suspend fun carBody(): String {
    delay(5000L)
    println("Build Body of car ---> End")
    return "Done"
}

suspend fun carPainting(): String {
    delay(5000L)
    println("Car painting Done ---> End")
    return "Done"
}

suspend fun carDrive(): String {
    delay(10000L)
    println("Install Car DriveTrain ---> End")
    return "Done"
}

suspend fun carBatteries(): String {
    delay(15000L)
    println("Install Batteries ---> End")
    return "Done"
}

suspend fun carInterior(): String {
    delay(15000L)
    println("Install Interior ---> End")
    return "Done"
}




// ================================== New Code =======================================



import kotlinx.coroutines.*
import kotlin.system.measureTimeMillis
import kotlin.time.Duration.Companion.microseconds
import kotlin.time.Duration.Companion.milliseconds

suspend fun main() {
    println("<----- Tesla Car Building Start ---->")
    val takeTime = measureTimeMillis {
        val job = CoroutineScope(Dispatchers.IO).launch {
            buildCars()
        }
        job.join()
    }
    println("<----- Tesla Car Building  End ----->")
    println("<----- Total time taken to build - ${takeTime.microseconds} ----->")

}

fun buildCars() = runBlocking {

    repeat(10000) {
        launch {
            var drive = async { scarDrive() }
            var batry = async { scarBatteries() }
            var inter = async { scarInterior() }
            var body = async { scarBody() }
            var painting = async { scarPainting() }

            println(body.await())
            println(painting.await())
            println(drive.await())
            println(batry.await())
            println(inter.await())
            println("Car Done $it / 10000 and it takes ${it.milliseconds}")
        }
    }
}

suspend fun scarBody(): String {
    delay(5000L)
    return "Build Body of car ---> End"
}

suspend fun scarPainting(): String {
    delay(5000L)
    return "Car painting Done ---> End"
}

suspend fun scarDrive(): String {
    delay(10000L)
    return "Install Car DriveTrain ---> End"
}

suspend fun scarBatteries(): String {
    delay(15000L)
    return "Install Batteries ---> End"
}

suspend fun scarInterior(): String {
    delay(15000L)
    return "Install Interior ---> End"
}


