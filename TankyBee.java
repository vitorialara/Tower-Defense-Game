public class TankyBee extends HoneyBee{

    private int attackDamage;
    private int armor;


    public TankyBee(Tile position, int attackDamage, int armor) {
        super(position, 30, 3);
        this.attackDamage = attackDamage;
        this.armor = armor;

    }


    public boolean equals (Object o) {
        if ((super.equals(o) && (this.attackDamage == ((TankyBee)o).attackDamage)) && (this.armor == ((TankyBee)o).attackDamage)){
            return true;
        }
        return false;
    }

    public boolean takeAction() {

        if (this.getPosition().getHornet() == null) {
            return false;
        }
        else {
            this.getPosition().getHornet().takeDamage(attackDamage);
            return true;
        }

    }

    public void takeDamage(int damageReceived) {
        double newDamage =  (double)100/(100 + armor);
        super.takeDamage((int)(newDamage * damageReceived));
    }
}
