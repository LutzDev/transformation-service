package com.transformation.routes.inky

import com.transformation.services.TransformationService
import com.transformation.util.Tool
import io.ktor.http.content.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import io.ktor.utils.io.core.*
import java.io.File
import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.Paths

fun Routing.configureInkyRouting() {
    val inkyTransformation = TransformationService(Tool.INKY)

    route("/transform/inky") {
        post {
            val data = call.receive<Map<Any, Any>>()
            val output: Map<Any, Any> = inkyTransformation.transform(data)
            call.respond(output)
        }
    }
}
