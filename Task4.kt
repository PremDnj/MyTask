package com.example.myunittesting

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

