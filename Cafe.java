/* This is a stub for the Cafe class */
public class Cafe extends Building{

    /**
     * four additional private attributes
     */
    private int nCoffeeOunces;
    private int nSugarPackets;
    private int nCreams;
    private int nCups;

    /**
     * Cafe constructor (with compliance to Building)
     * @param name name of building (super)
     * @param address location (super)
     * @param nFloors number of stories of the cafe (super)
     * @param coffee number of coffee oz in stock
     * @param sugar number of sugar packets in stock
     * @param cream number of creams in stock
     * @param cups number of cups in stock
     */
    private Cafe(String name, String address, int nFloors, int coffee, int sugar, int cream, int cups) {
        super(name,address,nFloors);
        this.nCoffeeOunces = coffee;
        this.nSugarPackets = sugar;
        this.nCreams = cream;
        this.nCups = cups;
        System.out.println( "You have built a cafe: ☕");
    }

    /**
     * this method adds the given values to the associated variables (ugh what are they called!)
     * @param nCoffeeOunces number of coffee oz being restocked
     * @param nSugarPackets number of sugars being restocked
     * @param nCreams number of creams being restocked
     * @param nCups number of cups being restocked
     */
    private void restock(int nCoffeeOunces, int nSugarPackets, int nCreams, int nCups){
        this.nCoffeeOunces += nCoffeeOunces;
        this.nSugarPackets += nSugarPackets;
        this.nCreams += nCreams;
        this.nCups += nCups;
    }

    /**
     * This method takes an order, which subtracts from the stock
     * If there is not enough of something in stock, it automatically 
     * restocks 5 of everything until there is enough for the order
     * @param size amount of coffee oz
     * @param nSugarPackets amount of sugar
     * @param nCreams amount of cream 
     */
    public void sellCoffee(int size, int nSugarPackets, int nCreams){
        while(size > this.nCoffeeOunces || nSugarPackets > this.nSugarPackets || nCreams > this.nCreams || this.nCups == 0){
            this.restock(5,5,5,5);
        }
        this.nCoffeeOunces -= size;
        this.nSugarPackets -= nSugarPackets;
        this.nCreams -= nCreams;
        this.nCups -= 1;
    }

    /**
     * (for personal testing)
     * returns how much of everything is in stock
     * @return a String detailing the remaining amount of coffee, sugar, cream, and cups
     */
    public String getStock(){
        return this.nCoffeeOunces + " coffees, " + this.nSugarPackets + " sugars, " + this.nCreams + " creams, and " + this.nCups + " cups";
    }

    public static void main(String[] args) {
        Cafe compass = new Cafe("Compass Cafe", "10 Elm Street, Northampton", 2, 5,5,5,5);
        compass.sellCoffee(6,1 ,11 );
        System.out.println(compass.getStock());
    }
    
}

