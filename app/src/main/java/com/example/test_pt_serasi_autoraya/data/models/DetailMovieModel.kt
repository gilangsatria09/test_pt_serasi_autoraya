import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json

@Serializable
data class DetailMovieModel (
    val adult: Boolean,

    @SerialName("backdrop_path")
    val backdropPath: String,

    @SerialName("belongs_to_collection")
    val belongsToCollection: BelongsToCollectionModel?,

    val budget: Int,
    val genres: List<GenreModel>,
    val homepage: String,
    val id: Int,

    @SerialName("imdb_id")
    val imdbID: String,

    @SerialName("original_language")
    val originalLanguage: String,

    @SerialName("original_title")
    val originalTitle: String,

    val overview: String,
    val popularity: Double,

    @SerialName("poster_path")
    val posterPath: String,

    @SerialName("production_companies")
    val productionCompanies: List<ProductionCompanyModel>,

    @SerialName("production_countries")
    val productionCountries: List<ProductionCountryModel>,

    @SerialName("release_date")
    val releaseDate: String,

    val revenue: Int,
    val runtime: Int,

    @SerialName("spoken_languages")
    val spokenLanguages: List<SpokenLanguageModel>,

    val status: String,
    val tagline: String,
    val title: String,
    val video: Boolean,

    @SerialName("vote_average")
    val voteAverage: Double,

    @SerialName("vote_count")
    val voteCount: Int
)
