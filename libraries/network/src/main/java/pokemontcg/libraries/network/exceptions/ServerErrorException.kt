package mobile.libraries.network.exceptions

import pokemontcg.libraries.network.exceptions.MyNetworkException


class ServerErrorException(message: String?, cause: Throwable? = null) : MyNetworkException(message, cause)