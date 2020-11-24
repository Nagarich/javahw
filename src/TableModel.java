import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

public class TableModel extends AbstractTableModel{

    private int columnCount = 5;
    private ArrayList<String[]> dataAarrayList;

    public TableModel(){
        dataAarrayList = new ArrayList<String[]>();
        for (int i=0;i<dataAarrayList.size();i++)
            dataAarrayList.add(new String[getColumnCount()]);

    }

    public void addDate(String[] row, JFrame parentsForm){
        String[] rowTable = new String[getColumnCount()];
        rowTable = row;
        dataAarrayList.add(rowTable);

    }

    @Override
    public String getColumnName(int index) {
        switch (index){
            case 0: return  "id";
            case 1: return  "name";
            case 2: return  "date";
            case 3: return  "value";
            case 4: return  "gate";
        }
        return "";
    }


    @Override
    public int getRowCount() {
        return dataAarrayList.size();
    }

    @Override
    public int getColumnCount() {
        return columnCount;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        String[] row = dataAarrayList.get(rowIndex);
        return row[columnIndex];
    }

}
