import kotlin.system.exitProcess
fun main() {
    var singleplayer = false
    var guess: String
    var life = 9
    var secretWord = ""

    println("Welcome to hangman! Choose a gamemode:\n 1) Singleplayer (A random word gets choosen by the computer)\n 2) Multiplayer (Another player can choose a word.)")
    var mainMenuInput = readln()
    singleplayer = when(mainMenuInput.toInt()) {
        1 -> true
        2 -> false
        else -> {
            println("ERR: Illegal input! Only use 1 or 2!")
            exitProcess(0)
        }
    }

    var randomWord = if(singleplayer){
        val possibleWords = listOf("account", "football", "cricket", "adjustment", "advertisement", "agreement", "brother", "butter", "business", "chance", "competition", "distance", "education", "experience", "government", "politics", "democracy", "anarchy", "communism", "dictatorship", "harmony", "hate", "history", "instrument", "guitar", "humor", "industry", "invention", "laugh", "knowledge", "mountain", "observation", "linux", "windows", "organization", "punishment", "reaction", "representative", "selection", "smash", "cringe", "hangman", "hospital", "police", "library", "monkey", "muscle", "stomach", "umbrella", "academy", "streaming", "privacy", "piracy", "france", "germany", "europe", "party", "spider", "solider")
        possibleWords.random()
    } else {
        println("Choose your word: ")
        readln()
    }

    for (i in 1 .. 100)
        println("\b")

    println("A word has been chosen!\nIts ${randomWord.length} letters long.")

    secretWord = "_".repeat(randomWord.length)
    val sb = StringBuilder(secretWord)

    while(life != 0) {
        println(sb.toString())

        println("\nGuess a letter or the whole word: ")
        guess = readln()
        if(guess.length > 1 && guess.equals(randomWord, ignoreCase = true)) {
            println("$randomWord was the correct word! Congratulations! You won!")
            life = 0
        } else if(guess.length == 1 && randomWord.contains(guess, ignoreCase = true)) {
            println("You found a letter!")
            for(i in 0..< randomWord.length){
                if(randomWord[i].equals(guess[0], ignoreCase = true))
                    sb[i] = guess[0]
            }
        }
        else {
            println("Wrong!")
            life--
            println("You have $life lives left.")
            if(life == 0)
                println("You lost!\nThe word was $randomWord")

        }

        if(sb.toString().equals(randomWord, ignoreCase = true)) {
            println("$randomWord\nCongratulations! You won!")
            life = 0
        }
    }
}