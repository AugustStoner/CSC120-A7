/* This is a stub for the Cafe class */
public class Cafe extends Building{

    private int nCoffeeOunces; // The number of ounces of coffee remaining in inventory
    private int nSugarPackets; // The number of sugar packets remaining in inventory
    private int nCreams; // The number of "splashes" of cream remaining in inventory
    private int nCups; // The number of cups remaining in inventory

    public Cafe(String name, String address, int nFloors, int nCoffeeOunces, int nSugarPackets, int nCreams, int nCups) {
        super(name, address, nFloors);
        this.nCoffeeOunces = nCoffeeOunces;
        this.nSugarPackets = nSugarPackets;
        this.nCreams = nCreams;
        this.nCups = nCups;
        System.out.println("You have built a cafe: ☕");
    }

    public void sellCoffee(int size, int sugarPackets, int Cream) {
        if (this.nCoffeeOunces<size){
            restock(40, 20, 20, 5);
        }
        if (this.nSugarPackets<sugarPackets){
            restock(40, 20, 20, 5);
        }
        if (this.nCreams<Cream){
            restock(40, 20, 20, 5);
        }
        if (this.nCups<1){
            restock(40, 20, 20, 5);
        }
        this.nCoffeeOunces -= size;
        this.nSugarPackets -= sugarPackets;
        this.nCreams -= Cream;
        this.nCups -= 1;
        this.printInventory();
    }

    private void restock(int nCoffeeOunces, int nSugarPackets, int nCreams, int nCups){
        this.nCoffeeOunces += nCoffeeOunces;
        this.nSugarPackets += nSugarPackets;
        this.nCreams += nCreams;
        this.nCups += nCups;
    }

    private void printInventory(){
        System.out.println(this.getName() + " has " + this.nCoffeeOunces + " oz coffee, " + this.nSugarPackets + " sugar packets, " + this.nCreams + " cream, and " + this.nCups + " cups in stock.");
    }
    
    public static void main(String[] args) {
        Cafe compass = new Cafe("Compass Cafe", "7 Elm St, Northampton, MA 01063", 1, 40, 20, 20, 10);
        compass.sellCoffee(12, 3, 5);
        compass.sellCoffee(12, 0, 3);
        compass.sellCoffee(24, 4, 2);
        compass.sellCoffee(12, 3, 3);
    }
    
}
