/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DynasT.Analysis.Classes;

/**
 *
 * @author t4r0
 */
public class Symbol {
    
    public int symbol = -1;
    public Object value;
    public Symbol(int symbol, Object value)
    {
        this.symbol = symbol;
        this.value = value;
    }
}
