/**
 * The </code>NearEarthObject</code> class is an object used to hold information on near earth objects from NASA's database.
 * @author Robert Wong
 *    email: robert.c.wong@stonybrook.edu
 *    Stony Brook ID: 115226159
 *    Recitation: R02
 */
import java.util.Date;
import java.text.SimpleDateFormat;
public class NearEarthObject{
    private int referenceID;
    private String name;
    private double absoluteMagnitude;
    private double averageDiameter;
    private boolean isDangerous;
    private Date closestApproachDate;
    private double missDistance;
    private String orbitingBody;
    private String formattedDate;

    /**
     * Default Constructor.
     * @param referenceID Unique the ID of the NEO.
     * @param name Unique name of the asteroid or orbital body.
     * @param absoluteMagnitude Absolute brightness of the asteroid or orbital body in the sky.
     * @param minDiameter Estimated minimum diameter of the asteroid or orbital body in kilometers. This parameter should be used in conjunction with the maxDiameter parameter to calculate and initialize the averageDiameter member variable.
     * @param maxDiameter Estimated maximum diameter of the asteroid or orbital body in kilometers. This parameter should be used in conjunction with the minDiameter parameter to calculate and initialize the averageDiameter member variable.
     * @param isDangerous Boolean value indicating whether the astroid or orbital body is a potential impact threat.
     * @param closestDateTimestamp Unix timestamp representing the date of closest approach. Note that this can be used to directly construct the closestApproachDate member variable, as the Date class provides a constructor taking a timestamp as a parameter.
     * @param missDistance Distance in kilometers at which the asteroid or orbital body will pass by the Earth on the date of it's closest approach.
     * @param orbitingBody Planet or other orbital body which this NEO orbits.
     */
    public NearEarthObject(int referenceID, String name, double absoluteMagnitude, double minDiameter, double maxDiameter, boolean isDangerous, long closestDateTimestamp, double missDistance, String orbitingBody){
        this.referenceID = referenceID;
        this.name = name;
        this.absoluteMagnitude = absoluteMagnitude;
        this.averageDiameter = (maxDiameter + minDiameter) / 2.00;
        this.isDangerous = isDangerous;
        this.closestApproachDate = new Date(closestDateTimestamp);
        this.missDistance = missDistance;
        this.orbitingBody = orbitingBody;
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy");
        String formattedDate = dateFormat.format(closestApproachDate);
        this.formattedDate = formattedDate;
    }

    /**
     * Returns the referenceID.
     * @return The referenceID of the NearEarthObject.
     */
    public int getReferenceID(){
        return referenceID;
    }

    /**
     * Sets the reference ID.
     * @param referenceID ReferenceID to be set.
     */
    public void setReferenceID(int referenceID){
        this.referenceID = referenceID;
    }
    
    /**
     * Returns the name.
     * @return The name of the NearEarthObject.
     */
    public String getName(){
        return name;
    }
    
    /**
     * Sets the name.
     * @param name The name to be set.
     */
    public void setName(String name){
        this.name = name;
    }
    

    /**
     * Gets the absolute magnitude.
     * @return The absolute magnitude.
     */
    public double getAbsoluteMagnitude(){
        return absoluteMagnitude;
    }
    
    /**
     * Sets the absolute magnitude.
     * @param absoluteMagnitude The absolute magnitude to be set.
     */
    public void setAbsoluteMagnitude(double absoluteMagnitude){
        this.absoluteMagnitude = absoluteMagnitude;
    }
    
    /**
     * Gets the average diameter.
     * @return The average diameter.
     */
    public double getAverageDiameter(){
        return averageDiameter;
    }
    
    /**
     * Sets the average diameter.
     * @param averageDiameter The average diameter to be set.
     */
    public void setAverageDiameter(double averageDiameter){
        this.averageDiameter = averageDiameter;
    }
    
    /**
     * Checks if the NearEarthObject is dangerous.
     * @return If the NEO is Dangerous.
     */
    public boolean isDangerous(){
        return isDangerous;
    }
    
    /**
     * Sets the danger of the NearEarthObject
     * @param isDangerous The danger status to be set.
     */
    public void setDangerous(boolean isDangerous){
        this.isDangerous = isDangerous;
    }
    
    /**
     * Gets the closest approach date.
     * @return The closest aproach date.
     */
    public Date getClosestApproachDate(){
        return closestApproachDate;
    }
    
    /**
     * Sets the closest approach date.
     * @param closestApproachDate The closest approach date to be set.
     */
    public void setClosestApproachDate(Date closestApproachDate){
        this.closestApproachDate = closestApproachDate;
    }
    
    /**
     * Gets the miss distance.
     * @return The miss distance.
     */
    public double getMissDistance(){
        return missDistance;
    }
    
    /**
     * Sets the miss distance.
     * @param missDistance The miss distance to be set.
     */
    public void setMissDistance(double missDistance){
        this.missDistance = missDistance;
    }
    
    /**
     * Gets the orbiting body.
     * @return The orbiting body.
     */
    public String getOrbitingBody(){
        return orbitingBody;
    }
    
    /**
     * Sets the orbiting body.
     * @param orbitingBody The orbiting body to be set.
     */
    public void setOrbitingBody(String orbitingBody){
        this.orbitingBody = orbitingBody;
    }
}