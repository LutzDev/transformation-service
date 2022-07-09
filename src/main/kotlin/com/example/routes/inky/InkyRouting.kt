package com.example.routes.inky

import io.ktor.server.routing.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.request.*

fun Routing.configureInkyRouting() {

    route("/transform/inky") {
        get {
            call.respond(mapOf("tool" to "inky"))
        }
        post {
            val data = call.receive<Map<Any, Any>>()
            print(data)
            call.respond(data)
        }
    }

}
