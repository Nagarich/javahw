import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;

public class Render extends DefaultTableCellRenderer {
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        if (value.equals("")==false) cell.setForeground(Color.magenta);

        if (isSelected)
            cell.setBackground(Color.yellow);
        else
            cell.setBackground(Color.WHITE);
        return cell;

    }
}
