package com.leandergebhardt.clgenerator

import java.io.Serializable

data class Message(
    val contactName: String,
    val contactNumber: String,
    val displayName: String,
    val includeJunior: Boolean,
    val jobTitle: String?,
    val immidateStart: Boolean,
    val startDate: String?,
) : Serializable {

    fun getFullJobDescription() = if (includeJunior) "a Junior $jobTitle" else "an $jobTitle"

    fun getAvailability() = if(immidateStart) "immediate" else "from $startDate"

}