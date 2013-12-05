/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package finansyx.commons.Prognostication;



/**
 *
 * @author t4r0
 */
public class Trending {
    public static final int ERROR = -1;
    public static final int FLAT = 0;
    public static final int INCREASING = 1;
    public static final int DECREASING = 2;
    public static final int CONCAVE_UPWARD = 3;
    public static final int CONCAVE_DOWNWARD = 4;
    public static final int ALTERNANT = 5;
    
    public static int findTrending(Iterable<Double> numbers)
    {
        int current = 0;
        int trending = FLAT;
        Boolean through = false;
        for(Double i : numbers)
        {
            if(i > current)
            {
                if(trending == FLAT)
                    trending = INCREASING;
                else
                {
                    if(trending == DECREASING && ! through)
                    {
                        trending = CONCAVE_UPWARD;
                        through = true;
                    }
                    if(trending == DECREASING && through)
                        trending = ALTERNANT;       
                }
            }
            
            if (i < current)
            {
                if(trending == FLAT)
                    trending = DECREASING;
                else
                {
                    if(trending == INCREASING && ! through)
                    {
                        trending = CONCAVE_DOWNWARD;
                        through = true;
                    }
                    if(trending == DECREASING && through)
                        trending = ALTERNANT;
                }                
            } 
            
            if (i == current)
            {
                if(through)
                    trending = ALTERNANT;
            }
        }
        return trending;
    }
}
