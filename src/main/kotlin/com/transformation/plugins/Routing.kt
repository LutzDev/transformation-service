package com.transformation.plugins

import io.ktor.server.routing.*
import io.ktor.server.application.*

import com.transformation.routes.inky.configureInkyRouting

fun Application.configureRouting() {
    routing {
        configureInkyRouting()
    }
}
