/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package finansyx.commons.models;
import javax.swing.table.AbstractTableModel;
import finansyx.commons.Prognostication.*;
import finansyx.commons.Finances.Finances;
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
        return modelo.Size() + 1;
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        if(columnIndex == 0)
            return filas[rowIndex];
        int col = columnIndex - 1;
        switch (rowIndex) {
            case 0: 
                return Finances.Round(modelo.get(col).geta(), 4);
            case 1:
                return Finances.Round(modelo.get(col).getA(), 4);
            case 2:
                 return Finances.Round(modelo.get(col).getb(), 4);
            case 3:
                 return Finances.Round(modelo.get(col).getc(), 4);
            case 4:
                 return Finances.Round(modelo.get(col).getSXY(), 4);
            case 5:
                 return Finances.Round(modelo.get(col).getr(), 4);
            case 6:
                 return Finances.Round(modelo.get(col).getr2(), 4);
        }
        return null;
    }
    
    @Override
    public String getColumnName(int column) {
        if(column == 0)
            return "";
       return modelo.get(column-1).getName();
    }
}
