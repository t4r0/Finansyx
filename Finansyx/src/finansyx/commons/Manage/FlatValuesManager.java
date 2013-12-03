/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package finansyx.commons.Manage;

import finansyx.commons.Rules.FlatValuesRule;

/**
 *
 * @author t4r0
 */
public class FlatValuesManager extends DataManager {
    
    public FlatValuesManager(){}
    
    public FlatValuesManager(Double value, int limit)
    {
        super(new FlatValuesRule(value, limit));
    }
}
