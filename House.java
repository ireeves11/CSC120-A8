/* This is a stub for the House class */
import java.util.ArrayList;

public class House extends Building{

  /**
   * three additional private attributes
   */

  private ArrayList<Student> residents;
  private boolean hasDiningRoom;
  private boolean hasElevator;

  /**
   * House constructor (with compliance to Building)
   * @param name name of House (super)
   * @param address address of House (super)
   * @param nFloors number of floors in House (super)
   * @param diningRoom if it has a dining room 
   * @param hasElevator boolean, if the library has an elevator
   */
  public House(String name, String address, int nFloors, boolean diningRoom, boolean elevator) {
    super(name, address, nFloors);
    this.hasDiningRoom = diningRoom;
    this.residents = new ArrayList();
    this.hasElevator = elevator;
  }

  /**
   * Overloaded default house constructor, no information given
   */
  public House(){
    super();
    this.hasDiningRoom = false;
    this.residents = new ArrayList();
    this.hasElevator = false;
  }

  /**
   * Overloaded house constructor that also takes a list of students already living in the house at construction
   */
  public House(String name, String address, int nFloors, boolean diningRoom, boolean elevator, ArrayList<Student> residents){
    this(name, address, nFloors, diningRoom, elevator);
    this.residents = new ArrayList();
    this.residents = residents;
  } 

  /**
   * checks if the House has a dining room
   * @return boolean value of hasDiningRoom attribute
   */
  public boolean hasDiningRoom(){
    return this.hasDiningRoom;
  } 

  /**
   * checks how many residents there are in the house
   * @return number of residents
   */
  public int nResidents(){
    return residents.size();
  }

  /**
   * Adds a resident if input student didn't already live there
   * @param s student moving into house
   */
  public void moveIn(Student s){
    if(!this.isResident(s)){
      residents.add(s);
    }
    else{
      throw new RuntimeException("This student already lives here!");
    }
  }

  /**
   * removes a student if the student lived in the house
   * @param s student moving out
   * @return the student being removed from the house
   */
  public Student moveOut(Student s){
    if(this.isResident(s)){
      return residents.remove(residents.indexOf(s));
    }
    else{
      throw new RuntimeException("This student never lived here!");
    }
  }

  /**
   * checks if a student is a resident of the house
   * @param s student under scrutiny
   * @return bool if the studen lives at the house
   */
  public boolean isResident(Student s){
    return residents.contains(s);
  } 

  @Override
  public void showOptions() {
    System.out.println("Available options at " + this.name + ":\n + enter() \n + exit() \n + goUp() \n + goDown()\n + goToFloor(n)\n + hasDiningRoom()\n + nResidents()\n + moveIn(s)\n + moveOut(s)\n + isResident(s)");
  }
  
  @Override
  public void goToFloor(int floorNum) {
    if (this.activeFloor == -1) {
      throw new RuntimeException("You are not inside this Building. Must call enter() before navigating between floors.");
    }
    if (floorNum < 1 || floorNum > this.nFloors) {
      throw new RuntimeException("Invalid floor number. Valid range for this Building is 1-" + this.nFloors +".");
    }
    if(!hasElevator && (floorNum > (this.activeFloor+1) || floorNum < (this.activeFloor-1))){
      throw new RuntimeException("You can only go to non-adjacent floors if your house has an elevator!");
    }
    if(floorNum == this.activeFloor){
      throw new RuntimeException("You're already on this floor!");
    }
    System.out.println("You are now on floor #" + floorNum + " of " + this.name);
    this.activeFloor = floorNum;
  }
  
  public static void main(String[] args) {
    Student belle = new Student("Belle", "what are you, a cop?", 2029);
    Student vee = new Student("Vee", "just a little guy", 2029);    
    ArrayList<Student> people = new ArrayList();
    people.add(belle);
    people.add(vee);
    House chase = new House();
    House albright = new House("Albright", "7 Bedford Terrace, Northamption", 4, false, false, people);
    System.out.println(albright.nResidents());
    albright.showOptions();
    albright.enter();
    try {
        albright.goToFloor(3);
    } catch (Exception e) {
      System.out.println(e.getLocalizedMessage());
    }
  }
}
