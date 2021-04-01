public class Tile {

    private int food;

    private boolean beeHive;

    private boolean hornetNest;

    private boolean inThePath;

    private Tile nextTileToHive;

    private Tile nextTileToNest;

    private HoneyBee whichBee;

    private SwarmOfHornets allTheHornets;



    public Tile () {
        this.allTheHornets = new SwarmOfHornets ();
    }


    public Tile (int f, boolean beeHive, boolean hornetNest, boolean inThePath, Tile nextTileToHive, Tile nextTileToNest, HoneyBee whichBee, SwarmOfHornets allTheHornets) {
        this.food = f;
        this.beeHive = beeHive;
        this.hornetNest = hornetNest;
        this.inThePath = inThePath;
        this.nextTileToHive = nextTileToHive;
        this.nextTileToNest = nextTileToNest;
        this.whichBee = whichBee;
        this.allTheHornets = allTheHornets;

    }

    public boolean isHive() {
        return this.beeHive;
    }

    public boolean isNest() {
        return this.hornetNest;
    }

    public void buildHive() {
        this.beeHive = true;
    }

    public void buildNest() {
        this.hornetNest = true;
    }

    public boolean isOnThePath() {
        return this.inThePath;
    }

    public Tile towardTheHive() {
        return this.nextTileToHive;
    }

    public Tile towardTheNest() {
        return this.nextTileToNest;
    }

    public void createPath(Tile towardsHive, Tile towardsNest) {
        this.nextTileToHive = towardsHive;
        this.nextTileToNest = towardsNest;
        this.inThePath = true;

    }

    public int collectFood() {
        return this.food;
    }

    public void storeFood(int f) {
        this.food += f;
    }

    public HoneyBee getBee() {
        return this.whichBee;
    }

    public Hornet getHornet() {
        Hornet toReturn = allTheHornets.getFirstHornet();
        return toReturn;

    }

    public int getNumOfHornets() {
        return allTheHornets.sizeOfSwarm ();
    }

    public boolean addInsect(Insect i) {
        if ((i instanceof HoneyBee) && (this.whichBee == null) && (!this.hornetNest)){
            this.whichBee = (HoneyBee) i;
            i.setPosition(this);
            return true;
        }
        if ((i instanceof Hornet) && (this.beeHive || this.hornetNest || this.inThePath)) {
            if (allTheHornets == null) {
                this.allTheHornets =  new SwarmOfHornets();
            }
            this.allTheHornets.addHornet((Hornet)i);
            i.setPosition(this);
            return true;
        }

        return false;



    }


    public boolean removeInsect(Insect i) {
        if ((i instanceof HoneyBee) && (this.whichBee == i)) {
            this.whichBee = null;
            return true;
        }
        if ((i instanceof Hornet) && (this.allTheHornets.removeHornet((Hornet)i))){ //check if this is actually removing the hornet
            return true;
        }
        return false;
    }




}
