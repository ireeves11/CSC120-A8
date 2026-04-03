import java.util.ArrayList;

public class CampusMap {

    ArrayList<Building> buildings;

    /* Default constructor, initializes empty ArrayList */
    public CampusMap() {
        buildings = new ArrayList<Building>();
    }

    /**
     * Adds a Building to the map
     * @param b the Building to add
     */
    public void addBuilding(Building b) {
        System.out.println("Adding building...");
        buildings.add(b);
        System.out.println("-->Successfully added " + b.getName() + " to the map.");
    }

    /**
     * Removes a Building from the map
     * @param b the Building to remove
     * @return the removed Building
     */
    public Building removeBuilding(Building b) {
        System.out.println("Removing building...");
        buildings.remove(b);
        System.out.println("-->Successfully removed " + b.getName() + " to the map.");
        return b;
    }

    public String toString() {
        String mapString = "DIRECTORY of BUILDINGS";

        for (int i = 0; i < this.buildings.size(); i ++) {
            mapString += "\n  " + (i+1) + ". "+ this.buildings.get(i).getName() + " (" + this.buildings.get(i).getAddress() + ")";
        }
        return mapString;
    }

    public static void main(String[] args) {
        CampusMap myMap = new CampusMap();
        Student belle = new Student("Belle", "what are you, a cop?", 2029);
        Student vee = new Student("Vee", "just a little guy", 2029);

        ArrayList<Student> people = new ArrayList();
        people.add(belle);
        people.add(vee);

        //my two overloaded house constructors
        House albright = new House("Albright", "9 Bedford Terrace Northampton, MA 01063", 4, false, false, people);
        House duckett = new House();

        //building the rest of the other buildings- no new overloaded constructors here
        House baldwin = new House("Baldwin", "5 Bedford Terrace Northampton, MA 01063", 4, false, false);
        House chase = new House("Chase", "Across the Street Northampton, MA 01063", 4, true, true);
        Cafe cc = new Cafe("CC Cafe", "Elm St Northampton, MA 01063", 4, 10, 10, 10, 10);
        Library neilson = new Library("Neilson Library", "Middle of Campus Northampton, MA 01063", 4);
        Cafe compass = new Cafe("Compass Cafe", "Middle of Campus, MA 01063", 4, 25, 2, 5, 3);

        //creating a lists of books to demonstrate my overloaded library methods
        ArrayList<String> books = new ArrayList();
        books.add("Project Hail Mary");
        books.add("Algospeak");

        ArrayList<String> books1 = new ArrayList();
        books1.add("Among the Burning Flowers");
        books1.add("Everything is Tuberculosis");
        books1.add("When You Reach Me");
        books1.add("Algospeak");

        //Adding titles to neilson library and checking one out
        neilson.addTitle("Project Hail Mary");
        neilson.addTitle("Algospeak");
        neilson.checkOut("Algospeak");

        //showing my two overloaded methods in Library - isAvailable(titles) can throw an exception, but I know it wont with 
        //how I set it up, so just trust
        System.out.println("I want to see if the library has the following books: " + books);
        System.out.println(neilson.containsTitle(books));
        System.out.println("I want to see which of those books are available!");
        System.out.println(neilson.isAvailable(books));
        System.out.println("Looks like only Project Hail Mary is available.\n");

        System.out.println("Does it have all these books too?: " + books1);
        System.out.println(neilson.containsTitle(books1));
        System.out.println("I guess not... maybe the system is lying to me and they're available!");
        try {
            neilson.isAvailable(books1);
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
        }
        System.out.println("Maybe it wasn't lying...\n");

        //showing my overloaded methods in Cafe
        //getStock() is just a way to show how many coffees, sugars, creams, and cups the cafe has in stock (and shows that sellCoffee works!)
        System.out.println("Mmmmm I could really go for a cup of coffee");
        System.out.println("Stock: " + cc.getStock());
        System.out.println("I'm in a rush! No time for an actual order, I just need Generic Coffee™ so I can get to the office!");
        cc.sellCoffee();
        System.out.println("Stock: " + cc.getStock());
        System.out.println("My boss sent me on a coffee run for 5 people! Ugh! Only Melissa told me her order, so they're all getting what she's getting.");
        cc.sellCoffee(6,2,3,5);
        System.out.println("Stock: " + cc.getStock());
        System.out.println("Wow, they had to do a LOT of restocking for that order\n");

        //Adding all my buildings to the campus map
        myMap.addBuilding(new Building("Ford Hall", "100 Green Street Northampton, MA 01063", 4));
        myMap.addBuilding(new Building("Bass Hall", "4 Tyler Court Northampton, MA 01063", 4));
        myMap.addBuilding(duckett);
        myMap.addBuilding(albright);
        myMap.addBuilding(baldwin);
        myMap.addBuilding(cc);
        myMap.addBuilding(neilson);
        myMap.addBuilding(new Building("McConnell Hall", "Over there Northampton, MA 01063", 4));
        myMap.addBuilding(new Building("Seeley Hall", "Somewhere Northampton, MA 01063", 4));
        myMap.addBuilding(compass);
        myMap.addBuilding(chase);

        System.out.println("\n" + myMap);
    }
    
}
