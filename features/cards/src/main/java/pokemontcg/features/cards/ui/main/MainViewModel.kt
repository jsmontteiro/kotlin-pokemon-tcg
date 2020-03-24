package pokemontcg.features.cards.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import pokemontcg.features.cards.model.Card
import pokemontcg.features.cards.usecase.ListCardsUseCase
import pokemontcg.libraries.ui_components.BaseViewModel

internal class MainViewModel(private val listCardsUseCase: ListCardsUseCase) : BaseViewModel() {

    private val _cards = MutableLiveData<List<Card>>()
    val cards: LiveData<List<Card>> = _cards

    private var isInitialized = false

    init {
        if (!isInitialized) {
            isInitialized = true
            doAsyncWork {
                _cards.value = listCardsUseCase.execute(null)
            }
        }
    }
}