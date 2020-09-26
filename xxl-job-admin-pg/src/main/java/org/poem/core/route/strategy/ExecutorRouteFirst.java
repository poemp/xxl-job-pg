package org.poem.core.route.strategy;

import org.poem.core.route.ExecutorRouter;
import org.poem.biz.model.ReturnT;
import org.poem.biz.model.TriggerParam;

import java.util.List;

/**
 * Created by xuxueli on 17/3/10.
 */
public class ExecutorRouteFirst extends ExecutorRouter {

    @Override
    public ReturnT<String> route(TriggerParam triggerParam, List<String> addressList){
        return new ReturnT<String>(addressList.get(0));
    }

}
