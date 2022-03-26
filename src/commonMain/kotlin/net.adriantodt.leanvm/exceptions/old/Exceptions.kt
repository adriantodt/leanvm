package net.adriantodt.leanvm.exceptions.old

import net.adriantodt.leanvm.StackTrace
import net.adriantodt.leanvm.types.LAny
import net.adriantodt.leanvm.types.LArray
import net.adriantodt.leanvm.types.LObject
import net.adriantodt.leanvm.types.LString

public object Exceptions {
    public fun create(type: String, description: String, stackTrace: List<StackTrace>): LObject {
        return LObject(
            LString("errorType") to LString(type),
            LString("description") to LString(description),
            LString("stackTrace") to LArray(stackTrace.mapTo(mutableListOf()) { LString(it.toString()) })
        )
    }

    public fun mismatchedArgs(stackTrace: List<StackTrace>): LObject {
        return create(
            "mismatchedArguments",
            "Invocation failed due to mismatched arguments.",
            stackTrace
        )
    }

    public fun notAFunction(type: String, stackTrace: List<StackTrace>): LObject {
        return create(
            "notAFunction",
            "Cannot invoke function for type '$type'.",
            stackTrace
        )
    }

    public fun noElementExists(element: String, stackTrace: List<StackTrace>): LObject {
        return create(
            "noElementExists",
            "Element '$element' does not exist.",
            stackTrace
        )
    }

    public fun unsupportedOperation(
        operation: String,
        leftType: String,
        rightType: String,
        stackTrace: List<StackTrace>,
    ): LObject {
        return create(
            "unsupportedOperation",
            "Cannot apply operation '$operation' for types '$leftType' and '$rightType'.",
            stackTrace
        )
    }

    public fun unsupportedOperation(operation: String, type: String, stackTrace: List<StackTrace>): LObject {
        return create(
            "unsupportedOperation",
            "Cannot apply operation '$operation' for type '$type'.",
            stackTrace
        )
    }

    public fun fromNative(e: Exception, stackTrace: List<StackTrace>): LAny {
        return create("nativeException", e.toString(), stackTrace)
    }
}
