package com.transformation
import com.bazaarvoice.jolt.Chainr
import com.bazaarvoice.jolt.JsonUtils
import com.transformation.plugins.*
import io.ktor.server.application.*
import java.io.File

fun main(args: Array<String>): Unit = io.ktor.server.netty.EngineMain.main(args)
fun Application.module() {
    //configureRouting()
    //configureSerialization()
    transform()
}


fun transform(){
    println("sample")
    val fileName = "src/main/resources/sample/output.json"
    val myfile = File(fileName)

    val chainrSpecJSON = JsonUtils.classpathToList("/sample/inky.json")
    val chainr = Chainr.fromSpec(chainrSpecJSON)

    val inputJSON = JsonUtils.classpathToObject("/sample/input.json")
    val transformedOutput = chainr.transform(inputJSON)
    myfile.writeText(JsonUtils.toJsonString(transformedOutput))
}