public class Hornet extends Insect{

    private int attackDamage;




    public Hornet(Tile position, int hp, int attackDamage) {
        super(position, hp);
        this.attackDamage = attackDamage;


    }


    public boolean equals (Object o) {
        if (super.equals(o) && this.attackDamage == ((Hornet)o).attackDamage){
            return true;
        }
        return false;
    }



    public boolean takeAction() {
        if (this.getPosition().getBee() != null) {
            this.getPosition().getBee().takeDamage(this.attackDamage);
            return true;
        }
        else if (!this.getPosition().isHive()) {
            this.setPosition(this.getPosition().towardTheHive());
            this.getPosition().addInsect(this);
            //this.getPosition().removeInsect(this);

            return true;
        }
        else {
            return false;
        }

    }











}
