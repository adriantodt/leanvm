package net.adriantodt.leanvm.exceptions

import net.adriantodt.leanvm.StackTrace

public class MismatchedFunctionArgsException(
    message: String, trace: List<StackTrace>,
) : LeanRuntimeException(message, trace) {
    override val leanExceptionName: String
        get() = "mismatchedFunctionArgsException"
}

