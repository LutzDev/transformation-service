package com.example.routes.twine

import io.ktor.server.routing.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.request.*

fun Routing.configureTwineRouting() {
    route("/transform/twine") {
        get {
            call.respond(mapOf("tool" to "twine"))
        }
        post {
            val data = call.receive<Map<Any, Any>>()
            print(data)
            call.respond(data)
        }
    }
}
