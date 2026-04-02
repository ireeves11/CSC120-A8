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
    public Cafe(String name, String address, int nFloors, int coffee, int sugar, int cream, int cups) {
        super(name,address,nFloors);
        this.nCoffeeOunces = coffee;
        this.nSugarPackets = sugar;
        this.nCreams = cream;
        this.nCups = cups;
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
     * Overloaded sellCoffee that sells multiple cups of the same order of coffee at a time
     * @param size number of oz going into each cup of coffee
     * @param nSugarPackets number of sugar packets going into each coffee
     * @param nCreams number of creams going into each coffee
     * @param cups number of cups of coffee being sold
     */
    public void sellCoffee(int size, int nSugarPackets, int nCreams, int cups){
        while(size*cups > this.nCoffeeOunces || nSugarPackets*cups > this.nSugarPackets || nCreams*cups > this.nCreams || cups > this.nCups){
            this.restock(5,5,5,5);
        }
        this.nCoffeeOunces -= size*cups;
        this.nSugarPackets -= nSugarPackets*cups;
        this.nCreams -= nCreams*cups;
        this.nCups -= cups;
    }

    /**
     * Sells one 8 oz black coffee, the most basic order you could get
     */
    public void sellCoffee(){
        if(8 > this.nCoffeeOunces || 1 > this.nCups){
            this.restock(8,0,0,1);
        }
        this.nCoffeeOunces -= 8;
        this.nCups -= 1;
    }

    @Override
    public void showOptions() {
        System.out.println("Available options at " + this.name + ":\n + enter() \n + exit() \n + goUp() \n + goDown()\n + goToFloor(n)\n + sellCoffee()");
    }

    @Override
    public void goToFloor(int floorNum) {
        if (this.activeFloor == -1) {
            throw new RuntimeException("You are not inside this Building. Must call enter() before navigating between floors.");
        }
        if (floorNum < 1 || floorNum > this.nFloors) {
            throw new RuntimeException("Invalid floor number. Valid range for this Building is 1-" + this.nFloors +".");
        }
        if(floorNum > (this.activeFloor+1) || floorNum < (this.activeFloor-1)){
            throw new RuntimeException("You can only go to adjacent floors");
        }
        if(floorNum == this.activeFloor){
            throw new RuntimeException("You're already on this floor!");
        }
        System.out.println("You are now on floor #" + floorNum + " of " + this.name);
        this.activeFloor = floorNum;
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
        Cafe compass = new Cafe("Compass Cafe", "10 Elm Street, Northampton", 2, 8,5,5,5);
        compass.sellCoffee();
        compass.sellCoffee(8,2,2,2);
        System.out.println(compass.getStock());
        compass.showOptions();

    }
    
}

