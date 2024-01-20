/**
 * The </code>DateComparator</code> class is a comparator to compare dates of NearEarthObjects.
 * @author Robert Wong
 *    email: robert.c.wong@stonybrook.edu
 *    Stony Brook ID: 115226159
 *    Recitation: R02
 */
import java.util.Date;
public class DateComparator implements java.util.Comparator<NearEarthObject>{

    /**
     * Compares dates of NearEarthObjects.
     */
    public int compare(NearEarthObject left, NearEarthObject right){
        Date date1 = left.getClosestApproachDate();
        Date date2 = right.getClosestApproachDate();
        int result = date1.compareTo(date2);
        return result;
    }
}
