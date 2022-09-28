package Adapter

import Beans.Event
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.nexpartyapp.R
import kotlinx.coroutines.NonDisposableHandle.parent


class EventAdapter (val eventList: List<Event>)
    :RecyclerView.Adapter<EventAdapter.EventViewHolder>()
{

    inner class EventViewHolder: RecyclerView.ViewHolder{

        val eventName: TextView
        val eventDate: TextView

        constructor(item: View): super(item){
            eventName = item.findViewById(R.id.viewEventName)
            eventDate = item.findViewById(R.id.viewEventDate)
        }
    }

    override fun onCreateViewHolder (parent: ViewGroup, viewType: Int): EventViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.event_item, parent,false)
        return EventViewHolder(view)
    }

    override fun onBindViewHolder(holder: EventViewHolder, position: Int) {

        val item = eventList[position]

        holder.eventName.text = item.name
        holder.eventDate.text = item.eventDate


    }

    override fun getItemCount(): Int {
        return eventList.size
    }


}
