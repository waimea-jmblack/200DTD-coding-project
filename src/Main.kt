/**
 * ------------------------------------------------------------------------
 * Explorers of the Valley
 * Level 2 programming project
 *
 * by James Black
 *
 *The game is about chance and strategy. You and another player both start with 10 explorers. With a goal of getting 20 explorers and 200 gold.
 * For the main quest the users will pick a number (either 1 or 2), then the computer picks a random number from these two numbers.
 * If the user guesses right, then they will be rewarded 10 gold. if they guess wrong they there will be a 50/50 chance they lose an explorer.
 * There will also be random hard challenges, that could offer high reward but higher risk as well.
 * One of these hard challenges will consist of the user picking 1 number out of 3, and if they user gets it right, they gain 3 explorers and 30 gold.
 * But if they get wrong then they would lose for example, 1 explorer and 20 gold.
 *
 * I am aiming to have 2 - 4 players to play my game at a time.
 *
 * the strategy of this game is that you could bet against the opposite player when it is their turn.
 * This will be done by you picking a different number that the opposition did not choose.
 * Meaning that if the opposition gets their number wrong and the user got it right while betting against them, gets the reward while the opposition loses the set amount, and vice versa.
 * ------------------------------------------------------------------------
 */


import kotlin.random.Random

data class Player(var gold: Int = 0, var explorers: Int = 10)

fun main() {
    println("----------------------------------------------------------------------")
    println("Welcome to Explorers Valley! Collect 15 explorers and 100 gold to win!")
    println("Good luck players :)")
    val players = initializePlayers()

    while (players.none { it.explorers >= 15 && it.gold >= 100 }) {
        players.forEachIndexed { index, player ->
            playerTurn(player, "Player ${index + 1}")
            if (player.explorers >= 15 && player.gold >= 100) {
                println("Congratulations, Player ${index + 1}! You win with ${player.explorers} explorers and ${player.gold} gold!")
                return
            }
        }
    }
}

fun initializePlayers(): List<Player> {
    println("Enter number of players (2-4):")
    val playerCount = readLine()?.toIntOrNull()?.coerceIn(2, 4) ?: 2
    return List(playerCount) { Player() }
}

fun playerTurn(player: Player, playerName: String) {
    println("\n$playerName's turn: Gold: ${player.gold}, Explorers: ${player.explorers}")
    if (Random.nextBoolean()) {
        guessNumber(player)
    } else {
        hardChallenge(player)
    }
}

fun guessNumber(player: Player) {
    val target = Random.nextInt(1, 3)
    println("Guess a number (1 or 2): ")
    val guess = readLine()?.toIntOrNull()

    if (guess == target) {
        player.explorers += 1
        player.gold += 10
        println("Correct! Gain 1 explorer and 10 gold.")
    } else {
        println("Wrong! It was $target. ${if (Random.nextBoolean()) "Lost 1 explorer!" else "Kept explorers!"}")
        if (Random.nextBoolean()) player.explorers--
    }
}

fun hardChallenge(player: Player) {
    val target = Random.nextInt(1, 4)
    println("Guess a number (1-3): ")
    val guess = readLine()?.toIntOrNull()

    if (guess == target) {
        player.explorers += 3
        player.gold += 30
        println("Correct! Gain 3 explorers and 30 gold.")
    } else {
        println("Wrong! It was $target. Lost 1 explorer and 20 gold.")
        player.explorers--
        player.gold = maxOf(0, player.gold - 20)
    }
}
