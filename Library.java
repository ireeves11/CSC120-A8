/* This is a stub for the Library class */
import java.util.ArrayList;
import java.util.Hashtable;
public class Library extends Building{

  /**
   * two private attribute
   */
  private Hashtable<String, Boolean> collection;

  /**
   * Library constructor (with compliance to Building)
   * @param name String, name of Library (super)
   * @param address String, location (super)
   * @param nFloors int, floors in library (super)
   * @param hasElevator boolean, if the library has an elevator
   */
  public Library(String name, String address, int nFloors) {
    super(name, address, nFloors);
    collection = new Hashtable();
  }

  /**
   * Adds a title to the library's collection if library doesn't already have it
   * @param title new title being added to collection
   */
  public void addTitle(String title){

    if(!this.containsTitle(title)){
      this.collection.put(title,true);
    }
    else{
      throw new RuntimeException("This title is already in the library!");
    }
  }

  /**
   * Removes a title from the library's catalogue, given the library had it in the first place
   * @param title name of title being removed from collection
   * @return String, the name of the title that was removed
   */
  public String removeTitle(String title){

    if(this.containsTitle(title)){
      this.collection.remove(title);
      return title;
    }
    else{
      throw new RuntimeException("The library never had this title!");
    }
  }

  /**
   * Changes the value of key:title to false, checking it out of the library
   * unless the title was already checked out
   * @param title the book being checked out
   */
  public void checkOut(String title){
    if(this.isAvailable(title)){
      collection.replace(title, true, false);
    }
    else{
      throw new RuntimeException("This title is not available right now");
    }
  }

  /**
   * returns a book to the library, changing the value of key:title to true
   * unless the title hadn't actually been checked out from the library
   * @param title the book being checked back in
   */
  public void returnBook(String title){
    if(!this.isAvailable(title)){
      collection.replace(title,false,true);
    }
    else{
      throw new RuntimeException("This title is never left the library!");
    }
  }

  /**
   * checks to see if the library contains a specific title
   * @param title book being searched for
   * @return boolean, true if collection contains the title, false otherwise
   */
  public boolean containsTitle(String title){
    return collection.containsKey(title);
  }

  /**
   * Overload, checks to see if all items in an ArrayList are at the library
   * @param titles Arraylist of titles
   * @return if all the titles in the list are at the library
   */
  public boolean containsTitle(ArrayList<String> titles){
    for(int i = 0; i < titles.size(); i++){
      if(!collection.containsKey(titles.get(i))){
        return false;
      }
    }
    return true;
  }

  /**
   * checks to see if a title is available for checkout at the library
   * @param title book being searched for
   * @return boolean true if the book is available, false otherwise
   */
  public boolean isAvailable(String title){
    if(this.containsTitle(title)){
      return collection.get(title);
    }
    else{
      throw new RuntimeException("The library does not contain this title!");
    }
  }

  /**
   * checks to see if a list of titles are available for checkout
   * @param titles ArrayList<String> list of titles
   * @return ArrayList<Boolean> that details whether each book is available, corresponding
   * to their position in titles
   */
  public ArrayList<Boolean> isAvailable(ArrayList<String> titles){
    if(this.containsTitle(titles)){
      ArrayList<Boolean> available = new ArrayList();
      for(int i = 0; i < titles.size(); i++){
        available.add(this.isAvailable(titles.get(i)));
      }
      return available;
    }
    else{
      throw new RuntimeException("Not all the titles in this list are at the library!");
    }
  }

  /**
   * prints the list of books in the library's collection and if they are available
  */
  public void printCollection(){
    System.out.println(collection.toString());
  }

  @Override
  public void showOptions() {
    System.out.println("Available options at " + this.name + ":\n + enter() \n + exit() \n + goUp() \n + goDown()\n + goToFloor(n)\n + removeTitle(title)\n + addTitle(title)()\n + checkOut(title)\n + returnBook(String title)\n + containsTitle(title)\n + isAvailable(title)\n + printCollection()");
  }

  @Override
  public void goToFloor(int floorNum) {
    if (this.activeFloor == -1) {
      throw new RuntimeException("You are not inside this Building. Must call enter() before navigating between floors.");
    }
    if (floorNum < 1 || floorNum > this.nFloors) {
      throw new RuntimeException("Invalid floor number. Valid range for this Building is 1-" + this.nFloors +".");
    }
    if(floorNum == this.activeFloor){
      throw new RuntimeException("You're already on this floor!");
    }
    System.out.println("You are now on floor #" + floorNum + " of " + this.name);
    this.activeFloor = floorNum;
  }  
    
    //You gotta test everything man!
    public static void main(String[] args) {
      Library tml = new Library ("Thomas Memorial Library", "6 Scott Dyer Rd, Cape Elizabeth", 3);
      tml.addTitle("Interview with a Vampire");
      tml.addTitle("Priory of the Orange Tree");
      ArrayList<String> books = new ArrayList();
      books.add("Priory of the Orange Tree");
      books.add("Interview with a Vampire");
      tml.checkOut("Interview with a Vampire");
      books.add("Project Hail Mary");
      System.out.println(tml.containsTitle(books));
      try {
        System.out.println(tml.isAvailable(books));
      } catch (Exception e) {
        System.out.println(e.getLocalizedMessage());
      }
      //tml.printCollection();
      tml.enter();
      tml.goToFloor(3);
      tml.goToFloor(1);
    }
    
  }
