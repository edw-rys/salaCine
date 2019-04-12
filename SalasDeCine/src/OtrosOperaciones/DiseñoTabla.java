package OtrosOperaciones;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.SwingConstants;
/**
 *
 * @author Edw
 */
public class DiseñoTabla extends  DefaultTableCellRenderer{

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        table.getTableHeader().setBackground(Color.BLACK);
        setHorizontalAlignment(SwingConstants.CENTER);
        if(table.getValueAt(row, 2).equals("GENERAL")){
            setBackground(new Color(52,149,19));
            setForeground(Color.black);
        }else{
            if(table.getValueAt(row, 2).equals("VIP")){
                setBackground(new Color(212,175,55)); 
                setForeground(Color.black);
        }else{
                if(table.getValueAt(row, 2).equals("BLACKBOX")){
                 setBackground(new Color(240,64,52));
                 setForeground(Color.white);}
                else{
                     
                     setBackground(new Color(52,149,19));  
                     setForeground(Color.black);
                }
        }
        }                
        return super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
