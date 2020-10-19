package vinova.kane.touristguide.model

data class Place(
    val id: String,
    val images: String,
    val latitude: Double,
    val longitude: Double,
    val name: String,
    val snippet: String
)