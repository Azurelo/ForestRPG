public class Enemy {
    String name;
    int health;
    int attackPower;

    public Enemy(String name, int health, int attackPower) {
        this.name = name;
        this.health = health;
        this.attackPower = attackPower;
    }

    public void attack(Player player) {
        System.out.println(name + " attacks " + player.name + "!");
        player.health -= attackPower;
        System.out.println(player.name + " now has " + player.health + " health left.\n");
    }
}
