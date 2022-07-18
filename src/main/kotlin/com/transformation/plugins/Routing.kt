package com.transformation.plugins

import io.ktor.server.routing.*
import io.ktor.server.application.*

import com.transformation.routes.inky.configureInkyRouting
import com.transformation.routes.twine.configureTwineRouting

fun Application.configureRouting() {
    routing {
        configureInkyRouting()
        configureTwineRouting()
    }
}
