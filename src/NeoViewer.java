/**
 * The </code>NeoViewer</code> class is used to view the NeoDatabase.
 * @author Robert Wong
 *    email: robert.c.wong@stonybrook.edu
 *    Stony Brook ID: 115226159
 *    Recitation: R02
 */
import java.util.Scanner;
import javax.swing.*;
import javax.swing.table.*;
import java.text.SimpleDateFormat;
public class NeoViewer{
    static Scanner input = new Scanner(System.in);
    
    /**
     * Next integer line for scanner.
     * @return An integer.
     */
    public static int nextIntLine(){
        int num = input.nextInt();
        if(input.hasNextLine()){
            input.nextLine();
        }
        return num;
    }

    /**
     * The main method runs a menu driven application which creates a NeoDatabase instance and then prompts the user for a menu command selecting the operation. The required information is then requested from the user based on the selected operation. Following is the list of menu options and their required information:
     * @param arg
     */
    public static void main(String[] arg){
        boolean running = true;
        System.out.println("Welcome to NEO Viewer!");
        NeoDatabase database = new NeoDatabase();
        while(running){
            try{
                System.out.println("\nOption Menu:");
                System.out.print("  A) Add a page to the database\n  S) Sort the database\n" +
                "  P) Print the database as a table.\n  T) Display the database as a JTable\n  Q) Quit\n");
                System.out.print("\nSelect a menu option: ");
                String userInput = input.nextLine();
                if(userInput.equalsIgnoreCase("a")){
                    System.out.print("Enter the page to load: ");
                    int pageNum = nextIntLine();
                    String qUrl = database.buildQueryURL(pageNum);
                    database.addAll(qUrl);
                }
                else if(userInput.equalsIgnoreCase("s")){
                    System.out.print("\nR) Sort by referenceID\nD) Sort by diameter\n" +
                    "A) Sort by approach date\nM) Sort by miss distance\n");
                    System.out.print("\nSelect a menu option: ");
                    String sortChoice = input.nextLine();
                    if(sortChoice.equalsIgnoreCase("R")){
                        database.sort(new ReferenceIDComparator()); 
                    }
                    else if(sortChoice.equalsIgnoreCase("D")){
                        database.sort(new DiameterComparator());
                    }
                    else if(sortChoice.equalsIgnoreCase("A")){
                        database.sort(new DateComparator());
                    }
                    else if(sortChoice.equalsIgnoreCase("M")){
                        database.sort(new MissDistanceComparator());
                    }
                }
                else if(userInput.equalsIgnoreCase("p")){
                    database.printTable();
                } 
                else if(userInput.equalsIgnoreCase("t")){
                    NeoTableModel model = new NeoTableModel(database.getNeoList());
                    DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
                    centerRenderer.setHorizontalAlignment(JLabel.CENTER);

                    JTable table =  new JTable(model);
                    for (int i = 0; i < table.getColumnCount(); i++){
                        table.getColumnModel().getColumn(i).setCellRenderer(centerRenderer); //center aligned
                    }


                    TableColumn dateColumn = table.getColumnModel().getColumn(5);
                    TableColumn mdColumn = table.getColumnModel().getColumn(6);
                    TableColumn magnitudeColumn = table.getColumnModel().getColumn(2);
                    TableColumn diameterColumn = table.getColumnModel().getColumn(3);
                    dateColumn.setCellRenderer(new DateRenderer());
                    mdColumn.setCellRenderer(new MissDissRenderer());
                    magnitudeColumn.setCellRenderer(new MagnitudeRenderer());
                    diameterColumn.setCellRenderer(new DiameterRenderer());

                    TableRowSorter<NeoTableModel> sorter = new TableRowSorter<>(model);

                    sorter.setComparator(0, new ReferenceIDComparator());
                    sorter.setComparator(3, new DiameterComparator());
                    sorter.setComparator(5, new DateComparator());
                    sorter.setComparator(6, new MissDistanceComparator());
                    table.setRowSorter(sorter);
                    table.setAutoCreateRowSorter(true);

                    JScrollPane scrollPane = new JScrollPane(table);
                    table.setFillsViewportHeight(true);
                    JFrame frame = new JFrame("NEO Viewer Table");
                    frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    frame.add(scrollPane);
                    frame.pack();
                    frame.setVisible(true);
                }
                else if(userInput.equalsIgnoreCase("q")){
                    running = false;
                    System.out.println("Program terminating normally...");
                }  
            }
            catch(Exception e){
                e.printStackTrace();
            }
        }
    }
}

/**
 * Renderer for the Date in the JTable
 */
class DateRenderer extends DefaultTableCellRenderer{
    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("MM-dd-yyyy");
    
    public DateRenderer(){
        super();
        setHorizontalAlignment(JLabel.CENTER);
    }
    
    @Override
    public void setValue(Object value){
        if(value != null){
            value = DATE_FORMAT.format(value);
        }
        super.setValue(value);
    }
}

/**
 * Renderer for the miss distance in the JTable
 */
class MissDissRenderer extends DefaultTableCellRenderer{
    public MissDissRenderer(){
        super();
        setHorizontalAlignment(JLabel.CENTER);
    }

    public void setValue(Object value){
        if(value != null && value instanceof Double){
            setText(String.format("%.0f", (Double)value));
        }
        else{
            super.setValue(value);
        }
    }
}

/**
 * Renderer for the magnitude in the JTable
 */
class MagnitudeRenderer extends DefaultTableCellRenderer{
    public MagnitudeRenderer(){
        super();
        setHorizontalAlignment(JLabel.CENTER);
    }

    public void setValue(Object value){
        if(value != null && value instanceof Double){
            setText(String.format("%.1f", (Double)value));
        }
        else{
            super.setValue(value);
        }
    }
}

/**
 * Renderer for the diamter in the JTable
 */
class DiameterRenderer extends DefaultTableCellRenderer{
    public DiameterRenderer(){
        super();
        setHorizontalAlignment(JLabel.CENTER);
    }

    public void setValue(Object value){
        if(value != null && value instanceof Double){
            setText(String.format("%.3f", (Double)value));
        }
        else{
            super.setValue(value);
        }
    }
}