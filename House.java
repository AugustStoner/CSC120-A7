/* This is a stub for the House class */
import java.util.ArrayList;


public class House extends Building {

  private ArrayList<String> residents;
  private boolean hasDiningRoom;
  private boolean hasElevator;

  public House(String name, String address, int nFloors) {
    super(name, address, nFloors);
    this.residents = new ArrayList<>();
    this.hasDiningRoom = false;
    this.hasElevator = false;
    System.out.println("You have built a house: 🏠");
  }

  public House(String name, String address, int nFloors, boolean hasDiningRoom) {
    this(name, address, nFloors);
    this.hasDiningRoom = hasDiningRoom; 
    System.out.println("You have built a house: 🏠");
  }

  public House(String name, String address, int nFloors, boolean hasDiningRoom, boolean hasElevator) {
    this(name, address, nFloors);
    this.hasDiningRoom = hasDiningRoom; 
    this.hasElevator = hasElevator;
    System.out.println("You have built a house: 🏠");
  }


  public boolean hasDiningRoom(){
    return this.hasDiningRoom;
  }

  public boolean hasElevator(){
    return this.hasElevator;
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
    String b = "does not";
    if (this.hasDiningRoom()){ a = "does"; }
    if (this.hasElevator()){ b = "does"; }
    s += " This House " + a + " have a dining room." ;
    s += " This House " + b + " have an elevator." ;
    s += " This hall has " + this.nResidents() + " residents.";
    return s;
  }

  public void goToFloor(int floorNum) {
    if (this.activeFloor == -1) {
      throw new RuntimeException("You are not inside this Building. Must call enter() before navigating between floors.");
    }
    if (floorNum < 1 || floorNum > this.nFloors) {
      throw new RuntimeException("Invalid floor number. Valid range for this Building is 1-" + this.nFloors +".");
    }
    if (!this.hasElevator()){
      if (Math.abs(this.activeFloor - floorNum) > 1) {
        throw new RuntimeException("That floor is too far away, move one floor at a time.");
      }
    }
    System.out.println("You are now on floor #" + floorNum + " of " + this.name);
    this.activeFloor = floorNum;
  }

  public void showOptions(){
    super.showOptions();
    System.out.println(" + hasDiningRoom()\n + hasElevator()\n + nResidents()\n + moveIn(String name)\n + moveOut(String name)\n + isResident(String person)");
  }

  public static void main(String[] args) {
    House emersonHouse = new House("Emerson House", "1 Paradise Rd, Northampton, MA 01063", 4, false, false);
    System.out.println(emersonHouse.toString());
    emersonHouse.moveIn("Sarah");
    emersonHouse.moveIn("Lia");
    System.out.println(emersonHouse.toString());
    System.out.println(emersonHouse.moveOut("Lia") + " moved out of " + emersonHouse.getName());
    System.out.println(emersonHouse.toString());

    House comstockHouse = new House("Comstock House", "1 Mandelle Rd, Northampton, MA 01063", 3, true, true);
    House wilsonHouse = new House("Wilson House", "1 Paradise Rd, Northampton, MA 01063", 4);
    System.out.println(comstockHouse.toString());
    System.out.println(wilsonHouse.toString());
    emersonHouse.showOptions();
    emersonHouse.enter();
    emersonHouse.goUp();
    emersonHouse.goToFloor(3);
    comstockHouse.enter();
    comstockHouse.goToFloor(3);
  }

}