package pokemontcg.features.cards.ui.data.network.schemas

import com.google.gson.annotations.SerializedName

internal class ListCardResponseSchema(
    @SerializedName("cards")
    val cards: List<CardSchema>
)