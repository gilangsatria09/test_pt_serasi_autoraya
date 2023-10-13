import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ProductionCountryModel (
    @SerialName("iso_3166_1")
    val iso31661: String,

    val name: String
)