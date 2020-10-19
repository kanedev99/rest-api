package vinova.kane.touristguide.net

import io.reactivex.Single
import retrofit2.http.GET
import vinova.kane.touristguide.model.Place

interface ApiService {
    @GET("/")
    fun getPlaces(): Single<List<Place>>
}