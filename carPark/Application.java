import java.util.*;
/**
 * @Assignment 1
 * @classDescription Car class returns value of member variables;
 * @Junhyek Hyun <102524337>
 * @version  1.6;
 */

public class Application {
    private static Scanner input = new Scanner(System.in);//Scanner object;
    private int option; //option integer 
    private CarPark carpark = new CarPark();// carpark object;
    private static Application app = new Application(); // Application object;
    private Slots slots = new Slots(); //slots object;
    private Car car = new Car(); //car object;

    /*
     *
     *  @main method  starts the program;
     */

    public static void main(String[] args) {
        app.options(); //implement the program;
    }

    /*
     *
     *  option method invokes the other methods; 
     */

    public void options(){
        while(true){
            switch(inputMenu()){
                case 1:
                addSlot();
                break;
                case 2:
                carpark.listSlots();
                break;
                case 3:
                deletSlots();
                break;
                case 4:
                parkCar();
                break;
                case 5:
                findCar();
                break;
                case 6:
                removeCar();
                break;
                case 7:
                System.out.println("System out");
                return;
                default:
                System.out.println("System cannot recognise the input.\n Please click between 1 and 7");
                break;
            }
        }
    }

    /*
     *
     *  method used for displaying a menu. Returns the getInteger method return value; 
     */

    private int inputMenu(){
        //int option; // option for storing user input.
        System.out.println("==============");
        System.out.println("1. Add Slot");
        System.out.println("2. List Slot");
        System.out.println("3. Delet Slot");
        System.out.println("4. Park A Car");
        System.out.println("5. Find Car by Slot");
        System.out.println("6. Remove Car");
        System.out.println("7. Exit");
        System.out.println("==============");

        System.out.println("please enter the given number");
        return getInteger();
    }

    /*
     *
     *  method used for transforming string value to integer.
     *  @exception  exception throws when other than integer is inputted;
     */ 

    public int getInteger(){

        try {
            option = input.nextInt();
        }
        catch (InputMismatchException e) {
            System.out.println("Warning: Please enter number. Do not enter other things than numbers.");
        }
        input.nextLine();//discard a token;
        return option;
    }

    /*
     *
     *  method is used for returning slot id, otherwise null is returned;
     *  @pattern given;
     *  @return slot id OR null;
     *  @param prompt;
     */
    public String getSlotIdString(String prompt){

        System.out.println(prompt);
        String  value = input.nextLine(); //Assigning String value;

        do{ 
            // validator;
            if(value.matches("^[A-Z][0-9][0-9-]$")){
                return value;
            }   
            else {
                System.out.println("Type is not correct. Please try again.");
                value = input.nextLine();
            }
        } while(!value.matches("^[A-Z][0-9][0-9-]$"));
        return null;
    }

    /*
     *
     *  This method is used for getting slot type: returns String value of Visitor or Staff, otherwise null;
     *  @param prompt;
     *  @pattern applied;
     *  @return value OR null;
     */

    public String getSlotType(String prompt){

        System.out.println(prompt);
        String value = input.nextLine();
        //validator 
        do{
            if (value.matches("^[V]$")) {
                return "Visitor"; 
            } else if (value.matches("^[S]$")){
                return "Staff"; 
            } else {
                System.out.println("Type is not correct. Please enter V for visitor or S for Staff.");
                value = input.nextLine();
            }
        } while(!value.matches("^[V]$") || !value.matches("^[S]$"));
        return null;
    }   

    /*
     *  Method is used for returning car registration number; if car is not assigned yet, None string value returns. Otherwise, null;
     *  @param prompt;
     *  @return value OR null;
     *  @pattern applied;
     */

    public String getRegNumString(String prompt){

        System.out.println(prompt);
        System.out.println("enter 'N' if there is no car");
        String value = input.nextLine(); //String value by user input;
        //validator;
        do {
            if (value.matches("^[A-Z][0-9][0-9][0-9][0-9]$")){
                return value;
            } 
            else{
                System.out.println("Type is not correct. Please enter Captial letter followed by 4 digits or enter if no car.");
                value = input.nextLine();
            }
        } while(!value.matches("^[A-Z][0-9][0-9][0-9][0-9]$"));
        return null;
    }

    /*
     *  method used for returning owner's name;
     *  @param  prompt;
     *  @return value;
     */ 

    public String getOwnerName(String prompt){
        System.out.println(prompt);
        String value = input.nextLine();
        return value;
    }

    /*
     *  Method is used for creating slots;
     *  get slotId, slotType from methods getSlotIdString and getSlotType;
     */

    public void addSlot(){

        String choice = "choice";

        do
        {
            String slotId = getSlotIdString("Enter Slot ID."); //slot ID;
            String slotType = getSlotType("Enter Slot Type, for visitors, V or for staff, S"); // boolean value slot type identifying visitor and staff;
            boolean isOccupied = false; // false assigned to make slot empty;

            carpark.addSlot(new Slots(slotId, slotType, isOccupied, new Car()));
            System.out.println("Enter 'Y' to continue");
            choice = input.nextLine();
        } while(choice.equalsIgnoreCase("Y"));
    }

    /*
     *  Method is used for finding a car and display car number, slot number, and owner name;
     *   
     */

    public void findCar(){ 

        String findCar = getRegNumString("Enter car registration number you wish to find."); // return value as a car registration number;
        String carNumber = carpark.findCarByNum(findCar);//return value as a car registration number;
        String slotFound = carpark.findSlotWithCarNum(findCar); // return value as a slot id;
        String getOnwer = carpark.getOwnerName(findCar); // return value as a owner name;

        if(carNumber != null)
        {
            System.out.println("Car with " + carNumber + "registration number found! " + "slot number: " + slotFound + "owner name: " + getOnwer);
        } else if (findCar == null) 
        {
            System.out.println("You are entering unregistered car"); //prevent NullPointException;
        } 
        else if (carNumber.equals("empty"))
        {
            System.out.println("The slot is empty");
        }
        else
        {
            System.out.println("not Found");
        }

    }   

    /*
     *  Method is used for deleting slots by slot id;
     *  
     */

    public void deletSlots(){
        String scan; // get assigned by the return value of getSlotIdString method;
        scan = getSlotIdString("Enter the slot id you wish to delet."); // return slot id;
        Slots slt = carpark.findSlot(scan); //checking through array and assign to slt variable. 
        Slots isOccupied = carpark.findCarOccupied();//checking through array if there is a car registration number. if there is, it is occupied.

        if(slt == null){
            System.out.println("Slot doesn't exist.");
        } else if (isOccupied != null){//if occupied
            System.out.println("Sorry, the slot is occupied");
        } 
        else {
            System.out.println(slt.toString());
            carpark.removeSlot(slt);
            System.out.println("slot deleted.");
        }
    }

    /*
     *  Method is used for parking a car into a slot specified;
     *
     */ 
    public void parkCar(){
        String find;
        find = getSlotIdString("Enter the slot id you wish to park a car.");
        String parkACar; 

        Slots slt = carpark.findSlot(find);//checking through array if there is a car registration number. if there is, it is occupied.
        boolean isOccupied = carpark.findCarViaSlots(find);//checking if occupied or not;

        if(slt == null){
            System.out.println("slot does not exist.");
        } else if(isOccupied != false){
            System.out.println("it has been occupied. Try other slot.");
        } 
        else {          

            parkACar = getRegNumString("Enter the registration id you wish to park");
            String ownerName = getOwnerName("Please enter the car owner's name.");

            slt.partACar(new Car(ownerName, parkACar));
            slt.setCarOccupied(true); 

        }
    }

    /*
     *
     * method is used for checking if car is occupied in a slot;
     */
    public void removeCar(){
        String find;// get assigned by a return value of getRegNumString method;
        find = getRegNumString("Enter a car registration number you wish to delete.");// return car registration number;
        String foundCar = carpark.findCarByNum(find);// return a specific car registration number;

        if (foundCar == null){
            System.out.println("Car is not found");
        } else {
            slots.removeCar("empty");
            System.out.println("remove car success!");
        }

    }
}   