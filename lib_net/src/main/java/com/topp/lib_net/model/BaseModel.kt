package com.topp.lib_net.model

data class BaseModel<out T>(val code: String, val message: String, val data: T)