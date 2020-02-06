    
/**
 * @Assignment 1
 * @classDescription Car class returns value of member variables;
 * @Junhyek Hyun <102524337>
 * @version  1.6;
 */
public class Car {
    private String ownerName;// name of the owner;
    private String regNum; // car registration number;

    public Car(){
        //default constructor;
    }

    /*
     * @param owner name, car reigration number - regNum;
     * @constructor with parameter;
     * 
     */ 
    public Car(String ownerName, String regNum){
        this.ownerName = ownerName;
        this.regNum = regNum;

    }

    /*
     * getter method returns car registration number;
     *
     */ 
    public String getCarRegNum(){
        return regNum;
    }

    /*
     * setter method to initialize car registration number with "" value;
     *
     */ public void setCarRegNumNull(String emptyString){
        this.regNum = emptyString;
    }

    /*
     * getter method returns owner name;
     *
     */ public String getOwnerName(){
        return ownerName;
    }
}
