package com.example.todofacile

object Constants {
    const val BLOCKING_WORD: String = "!NOT"
    private var members = mutableListOf<AddTaskListener>()

    fun addMember(atl: AddTaskListener) {
        members.add(atl)
    }

    fun addInstance(titleText: String, a1: String, c1: Int, a2: String, c2: Int, a3: String, c3: Int) {
        for (member in members)
            member.addInstance(titleText, a1, c1, a2, c2, a3, c3)
    }
}