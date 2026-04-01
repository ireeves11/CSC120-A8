/* This is a stub for the Library class */
import java.util.Hashtable;
public class Library extends Building{

    /**
     * one private attribute
     */
    private Hashtable<String, Boolean> collection;

    /**
     * Library constructor (with compliance to Building)
     * @param name String, name of Library (super)
     * @param address String, location (super)
     * @param nFloors int, floors in library (super)
     */
    public Library(String name, String address, int nFloors) {
      super(name, address, nFloors);
      collection = new Hashtable();
      System.out.println("You have built a library: 📖");
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
     * prints the list of books in the library's collection and if they are available
     */
    public void printCollection(){
      System.out.println(collection.toString());
    }
    
    //You gotta test everything man!
    public static void main(String[] args) {
      Library tml = new Library ("Thomas Memorial Library", "6 Scott Dyer Rd, Cape Elizabeth", 2);
      tml.addTitle("Interview with a Vampire");
      tml.addTitle("Priory");
      try {
          tml.checkOut("Priory");
      } catch (Exception e) {
        System.out.println(e.getLocalizedMessage());
      }
      try {
          System.out.println(tml.isAvailable("Hunger Games"));
      } catch (Exception e) {
        System.out.println(e.getLocalizedMessage());
      }
      tml.printCollection();
    }
  
  }
