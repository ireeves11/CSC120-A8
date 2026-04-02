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

        myMap.addBuilding(new Building("Ford Hall", "100 Green Street Northampton, MA 01063", 4));
        myMap.addBuilding(new Building("Bass Hall", "4 Tyler Court Northampton, MA 01063", 4));
        myMap.addBuilding(new House());
        myMap.addBuilding(new House("Albright", "9 Bedford Terrace Northampton, MA 01063", 4, false, false, people));
        myMap.addBuilding(new House("Baldwin", "5 Bedford Terrace Northampton, MA 01063", 4, false, false));
        myMap.addBuilding(new Cafe("CC Cafe", "Elm St Northampton, MA 01063", 4, 10, 10, 10, 10));
        myMap.addBuilding(new Library("Neilson Library", "Middle of Campus Northampton, MA 01063", 4, false));
        myMap.addBuilding(new Building("McConnell Hall", "Over there Northampton, MA 01063", 4));
        myMap.addBuilding(new Building("Seeley Hall", "Somewhere Northampton, MA 01063", 4));
        myMap.addBuilding(new Cafe("Compass Cafe", "Middle of Campus, MA 01063", 4, 25, 2, 5, 3));
        myMap.addBuilding(new House("Chase", "Across the Street Northampton, MA 01063", 4, true, true));
        System.out.println(myMap);
    }
    
}
