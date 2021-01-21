package com.example.hwrecyclerview

import java.lang.StringBuilder

class Person(val age: Int,
             val name: String,
             var mom: Person?,
             var dad: Person?,
             val siblings: ArrayList<Person>
){


    override fun toString(): String {
        val objectString = StringBuilder()

        objectString.append("Person(name=${this.name}, age=${this.age}, ")

        this.dad?.let {
            objectString.append("dad=${it.toString()}, ")
        } ?: objectString.append("dad=null, ")
        this.mom?.let {
            objectString.append("mom=${it.toString()}, ")
        } ?: objectString.append("mom=null, ")

        this.siblings?.let {
            objectString.append("siblings=[")
            it.forEach {
                objectString.append("${it.name},")
            }
            objectString.append("], ")
        }



        return objectString.toString()
    }

}

