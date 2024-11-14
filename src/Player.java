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
        System.out.println(enemy.name + " now has " + enemy.health + " health left.\n");
    }
    public void heal() {
        int healAmount = 20;
        health += healAmount;
        if (health > 100) {
            health = 100; // Cap health at 100
        }
        System.out.println(name + " heals for " + healAmount + " health and now has " + health + " health.\n");
    }
}