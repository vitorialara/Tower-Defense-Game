public class SwarmOfHornets {

    private Hornet[] hornets;
    private int amountOfHornets;



    public SwarmOfHornets () {
        this.amountOfHornets = 0;
        this.hornets = new Hornet[0];

    }



    public int sizeOfSwarm () {
        return amountOfHornets;

    }



    public Hornet[] getHornets() {
        return hornets;
    }



    public Hornet getFirstHornet() {
        if (this.amountOfHornets == 0) {
            return null;
        }
        else {
            return hornets[0];
        }

    }



    public void addHornet(Hornet h) {
        this.amountOfHornets ++;
        Hornet[] newHornets = new Hornet[this.amountOfHornets];
        for (int i = 0; i < hornets.length ; i++) {
            newHornets[i] = this.hornets[i];
        }
        newHornets[amountOfHornets -1] = h;
        this.hornets = newHornets;
    }





    public boolean removeHornet(Hornet h) {
        for (int i = 0; i < hornets.length; i++) {
            if (h == hornets[i]) {
                hornets[i] = null;
                removingNull(hornets);
                this.amountOfHornets --;

                return true;
            }

        }
        return false;
    }


    private void removingNull(Hornet[] toRemove){
        Hornet[] newHornets = new Hornet[this.sizeOfSwarm()-1];
        int i;
        for (i= 0; i < toRemove.length; i++) {
            if (toRemove[i] != null){
                newHornets[i] = toRemove[i];
            }
            else {
                break;
            }
        }
        int nullPosition;
        for (nullPosition = i +1 ; nullPosition < toRemove.length; nullPosition++) {
            newHornets[nullPosition-1] = toRemove[nullPosition];
        }
        this.hornets = newHornets;
    }


}
