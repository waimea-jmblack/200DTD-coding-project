import kotlin.random.Random

data class Player(var score: Int = 0, var gold: Int = 0, var explorers: Int = 10)

fun main() {
    val players = listOf(Player(), Player())
    println("Welcome to Explorers Valley!")
    println("Reach a score of 20 points to win!")

    while (players.none { it.score >= 20 }) {
        players.forEachIndexed { index, player ->
            playerTurn(player, "Player ${index + 1}")
            if (player.score >= 20) {
                println("Congratulations, Player ${index + 1}! You win with a score of ${player.score}!")
                return
            }
        }
    }
}

fun playerTurn(player: Player, playerName: String) {
    println("\n$playerName's turn: Score: ${player.score}, Gold: ${player.gold}, Explorers: ${player.explorers}")
    println("Choose an action:  1=Guess or  2=Hard Challenge")

    when (readLine()?.toIntOrNull()) {
        1 -> guessNumber(player)
        2 -> hardChallenge(player)
        else -> println("Invalid choice, try again.")
    }
}

fun guessNumber(player: Player) {
    val targetNumber = Random.nextInt(1, 3) + 1
    println("Guess a number (1 or 2): ")

    if (readLine()?.toIntOrNull() == targetNumber) {
        player.score += 5
        player.gold += 10
        println("Correct! You gain 5 points and 10 gold.")
    } else {
        println("Wrong! The number was $targetNumber.")
        if (Random.nextBoolean()) {
            player.explorers -= 1
            println("You lost 1 explorer! Remaining: ${player.explorers}")
        } else {
            println("You keep your explorers!")
        }
    }
}

fun hardChallenge(player: Player) {
    val targetNumber = Random.nextInt(1, 4)
    println("Hard Challenge! Guess a number (1-3): ")

    if (readLine()?.toIntOrNull() == targetNumber) {
        player.explorers += 3
        player.gold += 30
        player.score += 10
        println("Correct! You gain 3 explorers, 30 gold, and 10 points.")
    } else {
        println("Wrong! The number was $targetNumber.")
        player.explorers -= 1
        player.gold = maxOf(0, player.gold - 20) // Prevent negative gold
        println("You lost 1 explorer and 20 gold. Gold remaining: ${player.gold}.")
    }
}
