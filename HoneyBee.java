public abstract class HoneyBee extends Insect {


    private int foodCost;


    public HoneyBee(Tile position, int hp, int foodCost) {
        super(position, hp);
        this.foodCost = foodCost;


    }

    public int getCost() {
        return this.foodCost;

    }


    public boolean equals (Object o) {
        if (super.equals(o) && this.foodCost == ((HoneyBee)o).foodCost){
            return true;
        }
        return false;
    }




}