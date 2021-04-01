public abstract class Insect {



    private Tile position;
    private int hp;




    public Insect(Tile position, int hp ) {
        this.hp = hp;
        if (! position.addInsect(this)) {
            throw new IllegalArgumentException("The insect can not be positioned at this tile!");
        }
        else {
            this.position = position;
        }
    }






    public final Tile getPosition() {
        return this.position;

    }

    public final int getHealth() {
        return this.hp;

    }

    public void setPosition(Tile position) {
        this.position = position;

    }

    public void takeDamage(int damageReceived) {
        if (this instanceof HoneyBee && this.position.isHive()) {
            this.hp -= (int)(0.9 * damageReceived);
        }
        else{
            this.hp -= damageReceived;
        }
        if (this.getHealth() < 0) {
            this.position.removeInsect(this);
        }
    }


    public abstract boolean takeAction();

    public boolean equals (Object o) {
        if (((o instanceof HoneyBee) && (this instanceof HoneyBee)) || ((o instanceof Hornet) && (this instanceof Hornet))) {
            if ((this.hp == ((Insect)o).getHealth()) && (this.position == ((Insect)o).getPosition())) {
                return true;
            }
        }
        return false;
    }



}