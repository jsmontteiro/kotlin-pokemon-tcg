package br.com.montteiro.tcgpokemon

import android.app.Application
import br.com.montteiro.tcgpokemon.di.AppModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import pokemontcg.features.cards.BuildConfig
import timber.log.Timber

class PokemonTcgApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        setupKoin()
        setupTimber()
    }

    private fun setupKoin() {
        startKoin {
            this.androidContext(this@PokemonTcgApplication)
            modules(
                AppModule.getModules()
            )
        }
    }

    private fun setupTimber() {
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }
}