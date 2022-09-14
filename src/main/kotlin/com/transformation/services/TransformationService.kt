package com.transformation.services
import com.bazaarvoice.jolt.Chainr
import com.bazaarvoice.jolt.JsonUtils
import com.transformation.util.Tool

class TransformationService(tool: Tool ) {
    private val tool = tool

    fun transform(input: Map<Any, Any>): Map<Any, Any> {
        val spec = JsonUtils.classpathToList(tool.specPath)
        val chainr = Chainr.fromSpec(spec)
        val output: Map<Any, Any> = chainr.transform(input) as Map<Any, Any>
        return output
    }
}