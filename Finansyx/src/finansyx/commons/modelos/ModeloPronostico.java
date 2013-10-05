/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package finansyx.commons.modelos;
import javax.swing.table.AbstractTableModel;
import finansyx.commons.Pronosticos.*;
/**
 *
 * @author t4r0
 */
public class ModeloPronostico extends AbstractTableModel
{
    private ModelManager modelo = new ModelManager();
    private String filas[] = {"a","A","b", "c", "Sxy", "r", "r^2"};
    public ModeloPronostico(ModelManager manager)
    {
        this.modelo = manager;
    }
    
     @Override
    public int getRowCount()
     {
         return filas.length;
     }
     
    @Override
    public int getColumnCount() {
        return modelo.Size();
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        
        switch (rowIndex) {
            case 0: 
                return modelo.get(columnIndex).geta();
            case 1:
                return modelo.get(columnIndex).getA();
            case 2:
                 return modelo.get(columnIndex).getb();
            case 3:
                 return modelo.get(columnIndex).getc();
            case 4:
                 return modelo.get(columnIndex).getSXY();
            case 5:
                 return modelo.get(columnIndex).getr();
            case 6:
                 return modelo.get(columnIndex).getr2();
        }
        return null;
    }
    
    @Override
    public String getColumnName(int column) {
        return modelo.get(column).getNombre();
    }
}
