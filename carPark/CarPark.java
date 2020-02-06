import java.util.*;
/**
 * @Assignment 1
 * @classDescription Car class returns value of member variables;
 * @Junhyek Hyun <102524337>
 * @version  1.6;
 */
public class CarPark {

    private ArrayList<Slots> slotsList; //storing slot information and car registration number. If car is not parked, it shows null value;
    /*
     *  @Constructor initializing ArrayList;
     *
     */ 
    public CarPark(){
        slotsList = new ArrayList<Slots>();
    }

    /*
     *  Method is used for adding slots objects to ArrayList;
     *
     */ 
    public void addSlot(Slots slots){
        slotsList.add(slots);       
    }

    /*
     * method displays all data assigned to ArrayList;
     *
     */ 
    public void listSlots(){

        for (Slots i : slotsList) {
            System.out.println(i.toString()); 
        } // getting all elements from the slotsList array and convert them to String;

    }

    /*
     *
     * method removes required slot;
     * @method invoked from Application Class;
     */ 
    public void removeSlot(Slots slotsToRemove) {
        slotsList.remove(slotsToRemove);
    }

    /*
     *method finds car number;
     *@return regNum OR null;
     *@method invoked from Application class;
     *@param regNum;
     */
    public String findCarByNum(String regNum){
        for(Slots i : slotsList)
        {
            if (i.toRegNumber().equals(regNum)) 
            {
                return regNum;
            }
        }
        return null;
    }

    /*
     * method finds slot id;
     * @param regNum;
     * @method is invoked from Application class;
     * @return slot id OR null;
     *
     */
    public String findSlotWithCarNum(String regNum)
    {
        for(Slots i : slotsList)
        {
            if(i.toRegNumber().equals(regNum))
            {
                return i.getSlotNumber();
            }
        }
        return null;
    }

    /*
     *  Method is used for finding a car registration number with a specific request(parameter). 
     *  @param regNum;
     *  @return object i OR null;
     *  @method invoked from Application Class;
     */     
    public Slots findCarbyRegNum (String regNum){
        for (Slots i : slotsList) {
            if (i.toRegNumber().equals(regNum)) 
                return i;
        } //if statement ends
        return null;
    }

    /*
     *  methods is used for finding slots through car registration name;
     *  @param regNum - car registration number;
     *  @method invoked from Application Class;
     */ 
    public Slots findSlot(String regNum){
        for (Slots i : slotsList) {
            if (i.getSlotNumber().equals(regNum)) //getSlotNumber
                return i;
        }
        return null;
    }

    /*
     *
     * method is used for checking if car is occupied in a slot;
     * @return object i OR null;
     * @method invoked from Application Class;
     */
    public Slots findCarOccupied(){
        for(Slots i : slotsList){
            if (i.getIfCarOccupied() != false) 
                return i; // return i object when car occupied
        }
        return null; //not occupied by a car;
    }

    /*
     *
     * method is used for getting car owner's name; 
     * @param regNum - Car registration number;
     * @return owner name OR String "Onwer not Found";
     * @method invoked from Application Class;
     */
    public String getOwnerName(String regNum){
        for(Slots i : slotsList)
        {
            if (i.toRegNumber().equals(regNum)) 
            {
                return i.getOwnerName();//invoke method in Slots Class;
            }
        }
        return "Owner not Found";
    }

    /*
     *
     * method finds if slot is occupied or not through checking slot id;
     * @return true OR false;
     * @method invoked from Application Class;
     */
    public boolean findCarViaSlots(String slotId)
    {
        for (Slots i : slotsList) 
        {
            if (i.getSlotNumber().equals(slotId) && i.getIfCarOccupied()) 
            {
                return  true;
            }
        }
        return false;
    }
}
