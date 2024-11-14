public class Player {
    String name;
    int health;
    int attackPower;

    public Player(String name) {
        this.name = name;
        this.health = 100;
        this.attackPower = 15;
    }

    public void attack(Enemy enemy) {
        System.out.println(name + " attacks " + enemy.name + "!");
        enemy.health -= attackPower;
        if (enemy.health <= 0) {
            // Ensure health does not go negative
            enemy.health = 0;
            System.out.println(enemy.name + "'s health has fully been depleted.\n");
        } else {
            System.out.println(enemy.name + " now has " + enemy.health + " health left.\n");
        }
    }
    public void heal() {
        int healAmount = 15;
        health += healAmount;
        if (health > 100) {
            health = 100; // Cap health at 100
        }
        System.out.println(name + " heals for " + healAmount + " health and now has " + health + " health.\n");
    }
}