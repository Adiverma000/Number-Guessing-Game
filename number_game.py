import random

def play_number_game():
    min_range = 1
    max_range = 100
    max_attempts = 7
    total_score = 0
    rounds_won = 0

    print("=== Welcome to the Number Guessing Game! ===")
    print(f"Rules: Guess the number between {min_range} and {max_range}.")
    print(f"You have {max_attempts} attempts per round.\n")

    while True:
        target_number = random.randint(min_range, max_range)
        attempts_used = 0
        guessed_correctly = False

        while attempts_used < max_attempts:
            try:
                guess = int(input(f"Attempt {attempts_used + 1}/{max_attempts} - Enter your guess: "))
            except ValueError:
                print("Invalid input! Please enter a valid integer.")
                continue

            attempts_used += 1

            if guess == target_number:
                guessed_correctly = True
                round_score = (max_attempts - attempts_used + 1) * 10
                total_score += round_score
                rounds_won += 1
                print(f"Congratulations! You guessed the number in {attempts_used} attempts!")
                print(f"Round Score: +{round_score} points.")
                break
            elif guess < target_number:
                print("Too low! Try a higher number.")
            else:
                print("Too high! Try a lower number.")

        if not guessed_correctly:
            print(f"\nOut of attempts! The correct number was: {target_number}")

        print("\n--- Current Scoreboard ---")
        print(f"Rounds Won: {rounds_won}")
        print(f"Total Score: {total_score}")
        print("--------------------------")

        play_again = input("\nWould you like to play another round? (yes/no): ").strip().lower()
        if play_again not in ("yes", "y"):
            break
        print()

    print(f"\nThanks for playing! Final Score: {total_score} | Total Rounds Won: {rounds_won}")

if __name__ == "__main__":
    play_number_game()