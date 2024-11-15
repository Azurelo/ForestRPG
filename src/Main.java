import java.util.Scanner;
import java.util.Random;
public class Main
{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        boolean playAgain;

        do {
            // Game start introduction
            System.out.println("\nYou wake up in the middle of a dark forest. The air is thick with the scent of moss and the sound of distant growls sends a chill down your spine.");
            System.out.println("With no memory of how you got here, you hear the rustling of leaves and know you must prepare for whatever lies ahead.");
            System.out.print("Enter your name, brave adventurer: ");
            String playerName = scanner.nextLine();

            Player player = new Player(playerName);
            System.out.println("\nWelcome, " + player.name + ". Your adventure begins now!");

            // Encounter with an enemy
            Enemy enemy = new Enemy("Goblin", 50, 20);
            System.out.println("\nSuddenly, a wild " + enemy.name + " jumps out from behind the trees, its eyes glinting with malice!");
            System.out.println("Prepare for battle!\n");

            // Battle loop
            while (player.health > 0 && enemy.health > 0) {
                System.out.println("Choose an action:");
                System.out.println("1. Attack");
                System.out.println("2. Heal");
                System.out.println("3. Run");
                int choice = scanner.nextInt();

                if (choice == 1) {
                    player.attack(enemy);
                    if (enemy.health > 0) {
                        enemy.attack(player);
                    } else {
                        System.out.println("You have defeated the " + enemy.name + "!\n");
                        break;
                    }
                } else if (choice == 2) {
                    player.heal();
                    enemy.attack(player);
                } else if (choice == 3) {
                    System.out.println(player.name + " attempts to run away!");
                    int escapeChance = random.nextInt(2); // 50% chance to escape
                    if (escapeChance == 1) {
                        System.out.println("You successfully escape the forest and live to tell the tale. You win!");
                        break;
                    } else {
                        System.out.println("You failed to escape! The " + enemy.name + " attacks while you're vulnerable.");
                        enemy.attack(player);
                    }
                } else {
                    System.out.println("Invalid choice. Please choose 1 to attack, 2 to heal, or 3 to run.");
                }

                if (player.health <= 0) {
                    System.out.println("You have been defeated by the " + enemy.name + ". Your journey ends here.");
                }
            }

            // Ask if the player wants to restart
            System.out.println("\nDo you want to play again? (yes/no)");
            scanner.nextLine();
            String response = scanner.nextLine().trim().toLowerCase();
            playAgain = response.equals("yes");

        } while (playAgain);

        System.out.println("Thank you for playing! Goodbye.");
        scanner.close();
    }
}
