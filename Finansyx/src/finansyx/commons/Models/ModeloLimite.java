/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package finansyx.commons.models;

import finansyx.commons.Finances.Finances;
import finansyx.commons.Prognostication.ModelManager;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author t4r0
 */
public class ModeloLimite extends AbstractTableModel{
    
    private ModelManager modelo = new ModelManager();
    private String filas[] = {"Lim+","Pronostico","Lim-"};
    
    public ModeloLimite(ModelManager manager)
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
        return 11;
    }
    
     @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        if(columnIndex == 0)
            return filas[rowIndex];       
        switch (rowIndex) {
            case 0: 
                return Finances.Round(modelo.UpperLimit(columnIndex), 2);
            case 1:
                return Finances.Round(modelo.Calcular(columnIndex), 2);
            case 2:
                 return Finances.Round(modelo.LowerLimit(columnIndex),2);
        }
        return null;
    }
     
   @Override
    public String getColumnName(int column) {
        if(column == 0)
            return "";
       return (column + 2013) + "";
    }
}
