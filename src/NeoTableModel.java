/**
 * The </code>NeoTableModel</code> class is used to hold the table model of NEOs for a JTable.
 * @author Robert Wong
 *    email: robert.c.wong@stonybrook.edu
 *    Stony Brook ID: 115226159
 *    Recitation: R02
 */
import javax.swing.table.AbstractTableModel;
import java.util.LinkedList;
import java.util.Date;
public class NeoTableModel extends AbstractTableModel{
    private final String[] columnNames ={"ID", "Name", "Mag.", "Diameter", "Danger", "Close Date", "Miss Dist", "Orbits"};
    private final LinkedList<NearEarthObject> data;

    /**
     * Constructor for the table model.
     * @param data The data to be used to for the table model.
     */
    public NeoTableModel(LinkedList<NearEarthObject> data){
        this.data = data;
    }

    /**
     * Returns the row count of the data.
     * @return The row count.
     */
    @Override
    public int getRowCount(){
        return data.size();
    }

    /**
     * Returns the column count of the data.
     * @return The column count.
     */
    @Override
    public int getColumnCount(){
        return columnNames.length;
    }

    /**
     * Gets the columns class depending on the column's index.
     */
    @Override
    public Class<?> getColumnClass(int columnI){
        switch (columnI){
            case 0:
                return Integer.class;
            case 1:
                return String.class;
            case 2:
                return Double.class;
            case 3:
                return Double.class;
            case 4:
                return Boolean.class;
            case 5:
                return Date.class;
            case 6:
                return Double.class;
            case 7:
                return String.class;
            default:
                return Object.class;
        }
    }

    /**
     * Gets the value at a specific row index and column index to be used in the JTable
     * @return The object got.
     */
    @Override
    public Object getValueAt(int rowI, int columnI){
        NearEarthObject object = data.get(rowI);
        switch (columnI){
            case 0:
                return object.getReferenceID();
            case 1:
                return object.getName();
            case 2:
                return object.getAbsoluteMagnitude();
            case 3:
                return object.getAverageDiameter();
            case 4:
                return object.isDangerous();
            case 5:
                return object.getClosestApproachDate();
            case 6:
                return object.getMissDistance();
            case 7:
                return object.getOrbitingBody();
            default:
                throw new IndexOutOfBoundsException();
        }
    }

    /**
     * Gets the name of the column at a specific index.
     * @return The column's name.
     */
    @Override
    public String getColumnName(int column){
        return columnNames[column];
    }
}