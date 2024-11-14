/* This is a stub for the Library class */
import java.util.Hashtable;

public class Library extends Building{

    private final Hashtable<String, Boolean> collection;


    public Library(String name, String address, int nFloors) {
      super(name, address, nFloors);
      this.collection = new Hashtable<>();
      System.out.println("You have built a library: 📖");
    }
    
    class NotAvailableException extends RuntimeException {
      public NotAvailableException(String s){
          // Call constructor of parent Exception
          super(s);
      }
    }

    class NotContainedException extends RuntimeException {
      public NotContainedException(String s){
        // Call constructor of parent Exception
        super(s);
      }
    }
   

    // Methods (modify collection)

    public void addTitle(String title){
      // check that book is not already part of the collection
      try { 
        if (this.containsTitle(title)) {
          throw new NotContainedException(title + " is already part of " + this.getName() + "'s collection.");
        }
        this.collection.put(title, true);
        System.out.println(title + " was added to the " + this.getName() + " collection.");
      }
      catch (NotContainedException E) {
        System.out.println(E.getMessage());
      }
    }

    public String removeTitle(String title){
      // check that book is part of the collection
      // check that the book is available
      try {
        if (!this.containsTitle(title)) {
          throw new NotContainedException(title + " is not part of " + this.getName() + "'s collection.");
        }
        if (!this.isAvailable(title)) { 
          throw new NotAvailableException(title + " is not avaiable");
        }
        this.collection.remove(title, true); 
        return title;
      }
      catch(NotContainedException E) {
        throw new NotContainedException(title + " could not be removed from the collection, it is not part of the " + this.getName() + " collection.");
      }
      catch(NotAvailableException E) {
        throw new NotAvailableException(title + " could not removed from the collection, it is not currently available.");
      }
    }

    

    // Methods (modify value/status)

    public void checkOut(String title){
      // check that book is part of the collection 
      // check that book is available to check out
      try {
        if (!this.containsTitle(title)) {
          throw new NotContainedException(title + " is not part of " + this.getName() + "'s collection.");
        }
        if (!this.isAvailable(title)) { 
          throw new NotAvailableException(title + " is not avaiable");
        }
        this.collection.put(title, false);
        System.out.println(title + " was checked out.");
      }
      catch(NotContainedException E) {
        System.out.println(title + " could not be checked out, it is not part of the " + this.getName() + " collection.");
      }
      catch(NotAvailableException E) {
        System.out.println(title + " could not be checked out, it is not currently available.");
      }
    }

    public void returnBook(String title){
      // check that book is part of the collection
      //if (!this.containsTitle(title)) { throw RuntimeException(title + " is not part of " + this.getName() + "'s collection.");}
      // check that book has been checked out
      try {
        if (!this.containsTitle(title)) {
          throw new NotContainedException(title + " is not part of " + this.getName() + "'s collection.");
        }
        if (this.isAvailable(title)) { 
          throw new NotAvailableException(title + " is not checked out");
        }
        this.collection.put(title, true);
        System.out.println(title + " was returned.");
      }
      catch(NotContainedException E) {
        System.out.println(title + " could not be returned, it is not part of the " + this.getName() + " collection.");
      }
      catch(NotAvailableException E) {
        System.out.println(title + " could not be returned, it is not checked out.");
      }
      
    }


    // Methods (browsing)

    public boolean containsTitle(String title){
      // return true if key exists in collection
      return this.collection.containsKey(title);
    }

    public boolean isAvailable(String title){
      // return true if value is true, false otherwise
      return this.collection.get(title);
    }

    public void printCollection(){
      // prints out the entire collection in an easy-to-read way (including checkout status)
      System.out.println("Books in the " + this.getName() + " Collection:");
      this.collection.forEach((title, value) -> {
        if (this.isAvailable(title)) {
          System.out.println(title + " is available.");
        }
        else {
          System.out.println(title + " is checked out.");
        }
      });
    }

    public String toString() {
      return super.toString();
    }

    public static void main(String[] args) {
      Library neilson = new Library("Neilson Library", "7 Neilson Drive, Northampton, MA 01063", 4);
      neilson.addTitle("Goblin Mode by McKayla Coyle");
      neilson.addTitle("Uglies by Scott Westerfeld");
      neilson.addTitle("The Moth Keeper by K. O'Neill");
      neilson.printCollection();
    }
  
  }