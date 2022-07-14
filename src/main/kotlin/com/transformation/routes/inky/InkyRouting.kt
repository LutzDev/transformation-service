package com.transformation.routes.inky

import com.transformation.services.TransformationService
import com.transformation.util.Tool
import io.ktor.server.routing.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.request.*

fun Routing.configureInkyRouting() {
    val inkyTransformation = TransformationService(Tool.INKY)

    route("/transform/inky") {
        get {
            call.respond(mapOf("tool" to "inky"))
        }
        post {
            val data = call.receive<Map<Any, Any>>()
            val output: Map<Any, Any> = inkyTransformation.transform(data)
            call.respond(output)
        }
    }

}
