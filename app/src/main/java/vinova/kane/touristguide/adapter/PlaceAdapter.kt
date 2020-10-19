package vinova.kane.touristguide.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_place.view.*
import vinova.kane.touristguide.R
import vinova.kane.touristguide.model.Place

class PlaceAdapter(private val listPlaces: ArrayList<Place>): RecyclerView.Adapter<PlaceAdapter.PlaceViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlaceViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_place, parent, false)
        return PlaceViewHolder(view)
    }

    override fun getItemCount(): Int = listPlaces.size

    override fun onBindViewHolder(holder: PlaceViewHolder, position: Int) {
        holder.bind(listPlaces[position])
    }

    class PlaceViewHolder(view: View): RecyclerView.ViewHolder(view){
        fun bind(place: Place){
            with(itemView){
                tv_place_name.text = place.name

                Glide.with(itemView.context)
                    .load(place.images)
                    .placeholder(R.drawable.no_image)
                    .into(iv_cover_photo)

            }
        }
    }

}