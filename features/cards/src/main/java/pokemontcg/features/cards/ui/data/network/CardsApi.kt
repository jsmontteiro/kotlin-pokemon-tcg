package pokemontcg.features.cards.ui.data.network

import pokemontcg.features.cards.ui.data.network.schemas.ListCardResponseSchema
import retrofit2.Response
import retrofit2.http.GET

internal interface CardsApi {

    @GET("cards")
    suspend fun listCards(): Response<ListCardResponseSchema>
}