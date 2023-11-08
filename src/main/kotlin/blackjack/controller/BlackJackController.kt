package blackjack.controller

import blackjack.domain.Player
import blackjack.domain.TrumpCard
import blackjack.dsl.BlackJackDsl
import blackjack.view.InputView
import blackjack.view.OutputView

class BlackJackController {

    fun start() {
        val trumpCard = TrumpCard.init()
        val playerNames = InputView.inputPlayerName()
        val players = playerNames.map {
            initPlayer(it, trumpCard)
        }
        OutputView.printInitCard(players)
        OutputView.printPlayersCard(players)
        players.forEach {
            while (InputView.inputHitOrStand(it)) {
                it.playerCard.add(trumpCard.draw())
                OutputView.printPlayerCard(it)
            }
        }
        OutputView.printPlayerResult(players)
    }

    private fun initPlayer(playerName: String, trumpCard: TrumpCard): Player {
        return Player(
            playerName,
            BlackJackDsl.initPlayerCard {
                init(trumpCard)
            }
        )
    }
}
