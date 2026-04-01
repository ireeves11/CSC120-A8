/* This is a stub for the House class */
import java.util.ArrayList;

public class House extends Building{

  /**
   * two additional private attributes
   */

  private ArrayList<Student> residents;
  private boolean hasDiningRoom;

  /**
   * House constructor (with compliance to Building)
   * @param name name of House (super)
   * @param address address of House (super)
   * @param nFloors number of floors in House (super)
   * @param diningRoom if it has a dining room 
   */
  public House(String name, String address, int nFloors, boolean diningRoom) {
    super(name, address, nFloors);
    this.hasDiningRoom = diningRoom;
    this.residents = new ArrayList();
    System.out.println("You have built a house: 🏠");
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
  
  public static void main(String[] args) {
    Student belle = new Student("Belle", "what are you, a cop?", 2029);
    Student vee = new Student("Vee", "just a little guy", 2029);
    House albright = new House("Albright", "7 Bedford Terrace, Northamption", 4, false);
    System.out.println(albright.hasDiningRoom());
    System.out.println(albright.nResidents());
    System.out.println(albright.isResident(belle));

    try {
      albright.moveIn(belle);
    } catch (Exception e) {
      System.out.println(e.getLocalizedMessage());
    }

    try {
      albright.moveIn(vee);
    } catch (Exception e) {
      System.out.println(e.getLocalizedMessage());
    }

    System.out.println(albright.isResident(belle));
    System.out.println(albright.nResidents());
  }

}
