package pokemontcg.features.cards.ui.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.cards_activity_main.*
import pokemontcg.features.cards.R
import pokemontcg.libraries.ui_components.extensions.createLoadingDialog
import pokemontcg.libraries.ui_components.extensions.showMessage

class MainActivity : AppCompatActivity() {
    private val cardsAdapter = CardsAdapter()
    private val viewModel: MainViewModel by lazy {
        ViewModelProvider(this).get(MainViewModel::class.java)
    }

    private val loadingDialog by lazy {
        createLoadingDialog()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.cards_activity_main)


        setupView()
        setupObserver()
    }

    private fun setupView() {
        main_rvCards.adapter = cardsAdapter
    }

    private fun setupObserver() {

        viewModel.showError.observe(this, Observer { showMessage(it) })

        viewModel.isLoading.observe(this, Observer {
            if (it == true)
                loadingDialog.show()
            else
                loadingDialog.hide()
        })

        viewModel.cards.observe(this, Observer {
            cardsAdapter.submitList(it)
        })
    }

}