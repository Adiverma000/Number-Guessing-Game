# Number Guessing Game (Java)

A console-based Java application where players guess a randomly generated number within a limited number of attempts across multiple rounds.

## Features
* **Random Number Generation:** Generates a secret target number between `1` and `100` each round.
* **Interactive Feedback:** Tells the player whether their guess is **too high**, **too low**, or **correct**.
* **Attempt Limit:** Caps each round at **7 attempts** to keep gameplay challenging.
* **Input Validation:** Safely handles non-numeric inputs without crashing.
* **Multi-Round Gameplay:** Lets players play consecutive rounds and tracks cumulative progress.
* **Dynamic Scoring System:** Awards points based on efficiency (`(maxAttempts - attemptsUsed + 1) * 10`), alongside total rounds won.

## How to Run
1. Download `NumberGame.java`.
2. Open a terminal or IDE (IntelliJ IDEA, Eclipse, VS Code) in the file's directory.
3. Compile and run:
   ```bash
   javac NumberGame.java
   java NumberGame
