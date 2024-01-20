/**
 * The </code>ReferenceIDComparator</code> class is a comparator to compare referenceIDs of NearEarthObjects.
 * @author Robert Wong
 *    email: robert.c.wong@stonybrook.edu
 *    Stony Brook ID: 115226159
 *    Recitation: R02
 */
public class ReferenceIDComparator implements java.util.Comparator<NearEarthObject>{

    /**
     * Compares referenceIDs of NearEarthObjects.
     */
    public int compare(NearEarthObject left, NearEarthObject right){
        if(left.getReferenceID() == right.getReferenceID()){
            return 0;
        }
        else if(left.getReferenceID() > right.getReferenceID()){
            return 1;
        }
        else{
            return -1;
        }
    }
}
