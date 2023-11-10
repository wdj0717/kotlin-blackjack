package blackjack.domain

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe

class TrumpCardTest : BehaviorSpec({
    given("트럼프 카드를 생성한다.") {
        `when`("트럼프 카드를 생성하면") {
            val trumpCard = TrumpCard.init()
            then("트럼프 카드는 52장이다.") {
                trumpCard.size shouldBe 52
            }
        }
    }

    given("트럼프 카드를 2장을 생성하고") {
        val cards = Cards(
            mutableSetOf(
                Card(Suit.SPADE, Rank.ACE),
                Card(Suit.HEART, Rank.TWO)
            )
        )
        val trumpCard = TrumpCard(cards)
        `when`("카드를 한장 뽑으면") {
            val card = trumpCard.draw()
            then("뽑은 카드는 스페이드 A이다.") {
                card shouldBe Card(Suit.SPADE, Rank.ACE)
            }
            then("남은 트럼프 카드는 1장이다.") {
                trumpCard.size shouldBe 1
            }
        }
    }

    given("트럼프 카드를 2장을 생성하고") {
        val cards = Cards(
            mutableSetOf(
                Card(Suit.SPADE, Rank.ACE),
                Card(Suit.HEART, Rank.TWO)
            )
        )
        val trumpCard = TrumpCard(cards)
        `when`("초기 카드를 뽑으면") {
            val card = trumpCard.firstCardDraw()
            then("남은 트럼프 카드는 0장이다.") {
                trumpCard.size shouldBe 0
            }
        }
    }
})
