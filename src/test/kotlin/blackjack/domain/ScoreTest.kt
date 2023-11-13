package blackjack.domain

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe

class ScoreTest : BehaviorSpec({
    given("점수가 21점이하가 주어지면") {
        val score = Score(21)
        `when`("버스트 여부를 확인하면") {
            val isBurst = score.burst()
            then("버스트가 아니다.") {
                isBurst shouldBe false
            }
        }
    }

    given("점수가 22점이상이 주어지면") {
        val score = Score(22)
        `when`("버스트 여부를 확인하면") {
            val isBurst = score.burst()
            then("버스트이다.") {
                isBurst shouldBe true
            }
        }
    }

    given("A 점수가 21, B점수가 20이 주어지면") {
        val scoreA = Score(21)
        val scoreB = Score(20)
        `when`("A와 B의 점수를 비교하면") {
            val isWin = scoreA.compareScore(scoreB)
            then("A가 이긴다.") {
                isWin shouldBe WinLose.WIN
            }
        }
    }

    given("A점수와 B점수가 동일하면") {
        val scoreA = Score(21)
        val scoreB = Score(21)
        `when`("A와 B의 점수를 비교하면") {
            val isWin = scoreA.compareScore(scoreB)
            then("비긴다.") {
                isWin shouldBe WinLose.DRAW
            }
        }
    }
})
