package com.example.nexpartyapp

import Adapter.EventAdapter
import Beans.Event
import Database.AppDatabase
import Interface.EventDao
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import org.w3c.dom.Text

class Event : AppCompatActivity() {

//    var txtEvents: TextView? = null
    lateinit var listEvents : List<Event>
    lateinit var recyclerView: RecyclerView
    lateinit var eventAdapter : EventAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_events)
        //almacenamos la lista creada
        listEvents = AppDatabase.getInstance(this).eventsDao().eventList()
        eventAdapter = EventAdapter(listEvents)

        //recibimos info del evento creado
        val bundle = intent.extras
        var eventName = bundle?.getString("eventName")
        var eventDate = bundle?.getString("eventDate")

        //declaracion de boton para ir al create event layout
        val btnGoToCreateEvent = findViewById<TextView>(R.id.btnGoToCreateEvent)



        setRecyclerView(listEvents!!)

        btnGoToCreateEvent.setOnClickListener{
            val activate = Intent(this, com.example.nexpartyapp.CreateEvent::class.java)
            startActivity(activate)
        }

    }


    fun setRecyclerView(eventAux: List<Event>){

        recyclerView = findViewById(R.id.recyclerViewEvents)
        recyclerView.adapter = eventAdapter
        recyclerView.layoutManager = LinearLayoutManager(this)

    }


}