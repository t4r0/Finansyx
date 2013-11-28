/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package finansyx.commons.modelos;

import finansyx.commons.FlujoDeCaja.FlujoDeCaja;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author t4r0
 */
public class ModeloFlujo extends AbstractTableModel{

    private FlujoDeCaja flujo = new FlujoDeCaja();
       private String filas[] = {"","Factura","Escudo"};
    public ModeloFlujo( FlujoDeCaja initialValues)
    {
        flujo = initialValues;
    }

    public FlujoDeCaja getFlujo() {
        return flujo;
    }

    public void setFlujo(FlujoDeCaja flujo) {
        this.flujo = flujo;
    }    
    
    @Override
    public int getRowCount() {
        return flujo.getGastos().size();
    }

    @Override
    public int getColumnCount() {
        return 13;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
       switch (columnIndex)
       {
           case 0:
               return flujo.getGastos().get(rowIndex).getTitulo();
           case 1:
               return flujo.getGastos().get(rowIndex).hasFactura();
           case 2:
               return flujo.getGastos().get(rowIndex).isEscudo();
           default:
           {
               if (rowIndex == this.getRowCount() - 1)
                 return flujo.getUAI().getAt(columnIndex-3);
               return flujo.getGastos().get(rowIndex).getAt(columnIndex-3);
           }
       }
    }
    
    @Override
    public Class getColumnClass(int column) {
        switch(column)
        {
            case 0:
                return String.class;
            case 1:
            case 2:
                return Boolean.class;
            default:
                return Double.class;                    
        }
    }
    
     @Override
    public String getColumnName(int column) {
        if(column >= filas.length)
            return (column - 2 + 2013) + "";
       return filas[column];
    }
}
