package com.codennamdi.selfpromoapp

import java.io.Serializable

data class Message(
    val contactName: String,
    val contactNumber: String,
    val myDisplayName: String,
    val includeJunior: Boolean,
    val jobTitle: String?,
    val immediateStart: Boolean,
    val availableDate: String?
) : Serializable {
    fun getJobDescription() = if (includeJunior) "a junior $jobTitle" else "an $jobTitle"

    fun getAvailability() = if (immediateStart) "immediately" else "from $availableDate"
}