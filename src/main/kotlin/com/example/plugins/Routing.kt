package com.example.plugins

import io.ktor.server.routing.*
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.request.*

import com.example.routes.*
import com.example.routes.inky.configureInkyRouting
import com.example.routes.twine.configureTwineRouting

fun Application.configureRouting() {
    routing{
        configureInkyRouting()
        configureTwineRouting()
    }


    /*
    routing {
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

     */
}
