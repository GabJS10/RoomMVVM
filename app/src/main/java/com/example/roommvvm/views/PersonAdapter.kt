package com.example.roommvvm.views

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.roommvvm.R
import com.example.roommvvm.repository.room.entity.Person
import com.bumptech.glide.Glide


class PersonAdapter(private val context: Context,
    private val updateButtonClickInterface: UpdateButtonClickInterface,
    private val deleteButtonClickInterface: DeleteButtonClickInterface
): RecyclerView.Adapter<PersonAdapter.PersonViewHolder>() {
    inner class PersonViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val ivPhoto = itemView.findViewById<ImageView>(R.id.ivPhoto)
        val tvName = itemView.findViewById<TextView>(R.id.tvName)
        val tvCity = itemView.findViewById<TextView>(R.id.tvCity)
        val tvPhone = itemView.findViewById<TextView>(R.id.tvPhone)
        val btnUpdate = itemView.findViewById<ImageView>(R.id.btnUpdate)
        val btnDelete = itemView.findViewById<ImageView>(R.id.btnDelete)

    }

    private val persons = ArrayList<Person>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonViewHolder {

        return PersonViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_person_list, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return persons.size
    }

    override fun onBindViewHolder(holder: PersonViewHolder, position: Int) {
        val person = persons[position]
        Log.d("Person", person.toString())
        holder.tvName.text = person.name
        holder.tvCity.text = person.city
        holder.tvPhone.text = person.phone

        if (person.photo != "") {
            Log.d("Person", person.photo.toString())
            Glide.with(holder.ivPhoto.context).load(person.photo).into(holder.ivPhoto)
        }



        holder.btnUpdate.setOnClickListener {
            updateButtonClickInterface.onUpdateButtonClick(person)
        }

        holder.btnDelete.setOnClickListener {
            deleteButtonClickInterface.onDeleteButtonClick(person.id)
        }

    }

    fun updateList(newList: List<Person>) {
        persons.clear()
        persons.addAll(newList)
        notifyDataSetChanged()
    }
}

interface UpdateButtonClickInterface {
    fun onUpdateButtonClick(person: Person)
}

interface DeleteButtonClickInterface {
    fun onDeleteButtonClick(id: Int)
}