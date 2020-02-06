
import java.util.*;

/**
 * @Assignment 1
 * @classDescription Car class returns value of member variables;
 * @Junhyek Hyun <102524337>
 * @version  1.6;
 */ 
public class Slots
{
    
    private String slotId; // slot Id;
    private String slotType; // slot type;
    private boolean isOccupied;// whether slot is occupied or not;
    private Car car; // Car object;

    /*
     *
     *  @constructor (default); 
     */
    public Slots(){
        
    }

    /*
     *
     *  @constructor initializing members; 
     *  @param slot - slot id , slotType - visitor or staff, isOccupied - occupied or not, Car object;
     */
    public Slots(String slot, String slotType, boolean isOccupied, Car car){
        //constructor with parameters;
        this.slotId = slot; // slot id initialized from Carpark class; 
        this.slotType = slotType;// slot type initialized from Carpark class; 
        this.isOccupied = isOccupied;// isOcuppied initialized from Carpark class;
        this.car = car; // car object initialized from Application class;
    }

    /*
     *
     *  getter method returns car registration number;
     *  @method in Car class is invoked;
     */
    public String toRegNumber(){
        return car.getCarRegNum();
    }

    /*
     * getter method returns slot id, owner type; 
     *
     */ 
    public String toString(){
        return "Slot ID: " + slotId + " owner Type: " + slotType + "." ;
    } 

    /*
     *
     * getter method returns String value slot id;
     */
    public String getSlotNumber(){
        return slotId;
    }

    /*  
     * getter method returns boolean value true or false;
     * 
     */ 
    public boolean getIfCarOccupied(){
        return isOccupied;
    } 

    /*
     *
     * @invoke method in Car class to assign null value;
     */
    public void removeCar(String emptyString){
        car.setCarRegNumNull(emptyString);
    }

    /*public String toStringOfCarRegNum(){
    return regNum;
    }*/

    public void setCarOccupied( boolean isoccupied){
        this.isOccupied = isOccupied;
    }

    /*
     * getter method returns String value slot type; 
     *
     */ 
    public String getSlotType(){
        return slotType;
    }

    /*
     *  getter method returns owner's name;
     *  @getOwnerName method in Car is invoked;
     *  
     */
    public String getOwnerName(){
        return car.getOwnerName();
    }

    /*
     *  method initializes Car constructor in Car class;
     *  @param car object;
     *  @partACar method invoked from Application class;
     *
     */
    public void partACar(Car car){
        this.car = car;
        System.out.println("Parking succeeded!");
    }
}
