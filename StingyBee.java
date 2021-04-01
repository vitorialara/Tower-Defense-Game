public class StingyBee extends HoneyBee {

    private int attackDamage;


    public StingyBee(Tile position, int attackDamage) {
        super(position, 10, 1);
        this.attackDamage = attackDamage;


    }

    public boolean equals (Object o) {
        if (super.equals(o) && this.attackDamage == ((StingyBee)o).attackDamage){
            return true;
        }
        return false;
    }



    public boolean takeAction() {
        Tile t = this.getPosition();

        if ((! this.getPosition().isHive()) && (!this.getPosition().isOnThePath())) {
            return false;
        }
        else {

            while ((!t.isNest()) ) {
                if (this.getPosition().getHornet() != null) {
                    Hornet toSting = t.getHornet();
                    toSting.takeDamage(attackDamage);
                    return true;
                }

                t = t.towardTheNest();

            }

            return false;
        }

    }




}
