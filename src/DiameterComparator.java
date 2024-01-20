/**
 * The </code>DiameterComparator</code> class is a comparator to compare diameters of NearEarthObjects.
 * @author Robert Wong
 *    email: robert.c.wong@stonybrook.edu
 *    Stony Brook ID: 115226159
 *    Recitation: R02
 */
public class DiameterComparator implements java.util.Comparator<NearEarthObject>{

    /**
     * Compares diameters of NearEarthObjects.
     */
    public int compare(NearEarthObject left, NearEarthObject right){
        if(left.getAverageDiameter() == right.getAverageDiameter()){
            return 0;
        }
        else if(left.getAverageDiameter() > right.getAverageDiameter()){
            return 1;
        }
        else{
            return -1;
        }
    }
}
