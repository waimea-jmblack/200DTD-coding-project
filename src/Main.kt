/**
 * ------------------------------------------------------------------------
 * Explorers of the Valley
 * Level 2 programming project
 *
 * by James Black
 *
 *The game is about chance and strategy. You and another player both start with 10 explorers. With a goal of getting 15 explorers and 100 gold, without losing all your explorers.
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
 * Meaning that if the opposition gets their number wrong and the user got it right while betting against them,
 * gets the reward while the opposition loses the set amount, and vice versa.
 *
 * Note: I might not include this last paragraph as it might be too hard and tedious to code into the already complicated game.;
 * ------------------------------------------------------------------------
 */


import kotlin.random.Random

data class Player(var gold: Int = 0, var explorers: Int = 10)

fun main() {
    println("----------------------------------------------------------------------")
    println("Welcome to Explorers Valley! Collect 15 explorers and 100 gold to win!")
    println("Good luck players :)")

    val players = initializePlayers()
    var currentPlayerNum = 0

    while (true) {
        val currentPlayer = players[currentPlayerNum]
        val currentPlayerName = "Player ${currentPlayerNum + 1}"

        // Player takes their turn
        playerTurn(currentPlayer, currentPlayerName)

        // Has the player won?
        if (currentPlayer.explorers >= 15 && currentPlayer.gold >= 100) {
            println("Congratulations, $currentPlayerName!")
            println("You win with ${currentPlayer.explorers} explorers and ${currentPlayer.gold} gold!")
            break
        }

        // Go to next player
        currentPlayerNum++

        // Have we got to the last player?
        if (currentPlayerNum == players.size) {
            // Yes, so back to the first
            currentPlayerNum = 0
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

//-----------------------------------Easy Challenge-----------------------------------//
fun guessNumber(player: Player) {

    val target = Random.nextInt(1, 3)

    // Asking for the player to guess between 1-2 for an easy question
    println("---------------")
    println("Easy Challenge ")
    println("Guess a number (1 or 2): ")
    val guess = readLine()?.toIntOrNull()

    // If correct
    if (guess == target) {
        player.explorers += 1
        player.gold += 10
        println("Correct! Gain 1 explorer and 10 gold.")

    // If incorrect
    } else {
        println("Wrong! It was $target")
        if (Random.nextBoolean()) {
            println("Lost 1 explorer!")
            player.explorers--
        }
        else {
            println("Kept explorers!")
        }
    }
}

//-----------------------------------Hard Challenge-----------------------------------//
fun hardChallenge(player: Player) {
    val target = Random.nextInt(1, 4)

    // Asking for the player to guess between 1-3 for a hard question
    println("---------------")
    println("Hard Challenge ")
    println("Guess a number (1-3): ")
    val guess = readLine()?.toIntOrNull()

    // If correct...
    if (guess == target) {
        player.explorers += 3
        player.gold += 30
        println("Correct! Gain 3 explorers and 30 gold.")

    // If incorrect...
    } else {
        println("Wrong! It was $target. Lost 1 explorer and 20 gold.")
        player.explorers--
        player.gold = maxOf(0, player.gold - 20)
    }
}
