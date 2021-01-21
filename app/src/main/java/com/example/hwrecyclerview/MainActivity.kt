package com.example.hwrecyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    val family: ArrayList<Triple<String, Int, Int>> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val me = getMe()
        familyToList(me)
        rv_family.adapter = FamilyAdapter(family.toList())
        rv_family.layoutManager = LinearLayoutManager(this)

    }

    private fun familyToList(person: Person, level: Int = 0) {
        family.add(Triple(person.name, person.age, level))
        person.siblings.forEach {
            family.add(Triple(it.name, it.age, level))
        }
        person.mom?.apply {
            familyToList(this, level + 1)
        }
        person.dad?.apply {
            familyToList(this, level + 1)
        }

    }


    private fun getMe(): Person {
        val me = Person(20, "Dima", null, null, arrayListOf())

        val dad = Person(45, "Dad", null, null, arrayListOf())
        val mom = Person(45, "Mom", null, null, arrayListOf())
        val aunt = Person(40, "Dad's sister", null, null, arrayListOf())
        val uncle = Person(40, "Dad's brother", null, null, arrayListOf())
        val aunt1 = Person(40, "Mom's sister", null, null, arrayListOf())

        val grandpa = Person(70, "Dad's father", null, null, arrayListOf())
        val grandma = Person(70, "Dad's mother", null, null, arrayListOf())
        val grandpa1 = Person(70, "Mom's father", null, null, arrayListOf())
        val grandma1 = Person(70, "Mom's mother", null, null, arrayListOf())

        val grandGrandMa = Person(95, "Mom's grandmother", null, null, arrayListOf())
        val grandGrandUncle = Person(90, "Mom's grandmother's brother", null, null, arrayListOf())

        val grandGrandMa1 = Person(95, "Dad's grandmother", null, null, arrayListOf())

        me.dad = dad
        me.mom = mom

        dad.siblings.apply {
            add(aunt)
            add(uncle)
        }
        aunt.siblings.apply {
            add(dad)
            add(uncle)
        }
        uncle.siblings.apply {
            add(dad)
            add(aunt)
        }
        mom.siblings.add(aunt1)
        aunt1.siblings.add(mom)

        dad.dad = grandpa
        dad.mom = grandma
        mom.dad = grandpa1
        mom.mom = grandma1
        aunt.dad = grandpa
        aunt.mom = grandma
        uncle.dad = grandpa
        uncle.mom = grandma
        aunt1.dad = grandpa1
        aunt1.mom = grandma1

        grandma1.mom = grandGrandMa
        grandpa.mom = grandGrandMa1

        grandGrandMa.siblings.add(grandGrandUncle)
        grandGrandUncle.siblings.add(grandGrandMa)

        return me
    }

}