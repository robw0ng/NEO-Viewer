/**
 * The </code>MissDistanceComparator</code> class is a comparator to compare miss distance of NearEarthObjects.
 * @author Robert Wong
 *    email: robert.c.wong@stonybrook.edu
 *    Stony Brook ID: 115226159
 *    Recitation: R02
 */
public class MissDistanceComparator implements java.util.Comparator<NearEarthObject>{

    /**
     * Compares miss distances of NearEarthObjects.
     */
    public int compare(NearEarthObject left, NearEarthObject right){
        if(left.getMissDistance() == right.getMissDistance()){
            return 0;
        }
        else if(left.getMissDistance() > right.getMissDistance()){
            return 1;
        }
        else{
            return -1;
        }
    }
}
