package com.transformation.services
import com.bazaarvoice.jolt.Chainr
import com.bazaarvoice.jolt.JsonUtils
import com.fasterxml.jackson.databind.ObjectMapper
import com.transformation.util.Tool
import java.io.File
import java.io.InputStream

class TransformationService(tool: Tool ) {
    private val tool = tool

    fun transform(input: Map<Any, Any>): Map<Any, Any> {
        val chainrSpecJSON = JsonUtils.classpathToList(tool.specPath)
        val chainr = Chainr.fromSpec(chainrSpecJSON)
        val output: Map<Any, Any> = chainr.transform(input) as Map<Any, Any>
        return output
    }

    fun getSpec() {
       TODO("Get content of JSON (spec)")
    }
}