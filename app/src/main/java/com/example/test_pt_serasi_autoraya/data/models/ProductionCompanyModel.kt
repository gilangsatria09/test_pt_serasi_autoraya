import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ProductionCompanyModel (
    val id: Int,

    @SerialName("logo_path")
    val logoPath: String?,

    val name: String,

    @SerialName("origin_country")
    val originCountry: String
)