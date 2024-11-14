/* This is a stub for the House class */
import java.util.ArrayList;


public class House extends Building {

  private ArrayList<String> residents;
  private boolean hasDiningRoom = false;

  public House(String name, String address, int nFloors, boolean hasDiningRoom) {
    super(name, address, nFloors);
    this.hasDiningRoom = hasDiningRoom; 
    this.residents = new ArrayList<String>();
    System.out.println("You have built a house: 🏠");
  }

  public boolean hasDiningRoom(){
    return this.hasDiningRoom;
  }

  public int nResidents(){
    return residents.size();
  }

  public void moveIn(String name) {
    //Check if already a resident
    if (this.residents.contains(name)) {
      throw new RuntimeException(name + " is already a resident of " + this.getName());
    }
    // Otherwise, add them to the list of residents
    this.residents.add(name);
  }

  public String moveOut(String name) {
    // Throw an exception if student is not a resident of the hall
    if (!this.residents.contains(name)) {
      throw new RuntimeException(name + " is not a resident of " + this.getName());
    }
    // Otherwise, remove student from the residents list and return their name
    this.residents.remove(name);
    return name;
  }

  public boolean isResident(String person){
    if (this.residents.contains(person)) { return true; }
    else { return false; }
  }

  public String toString(){
    String s = super.toString();
    String a = "does not";
    if (this.hasDiningRoom()){ a = "does"; }
    s += ". This House " + a + " have a dining room" ;
    s += ". This hall has " + this.nResidents() + " residents.";
    return s;
  }

  public static void main(String[] args) {
    House emersonHouse = new House("Emerson", "1 Paradise Rd, Northampton, MA 01063", 4, false);
    System.out.println(emersonHouse.toString());
    emersonHouse.moveIn("Sarah");
    emersonHouse.moveIn("Lia");
    System.out.println(emersonHouse.toString());
    System.out.println(emersonHouse.moveOut("Lia") + " moved out of " + emersonHouse.getName());
    System.out.println(emersonHouse.toString());

  }

}