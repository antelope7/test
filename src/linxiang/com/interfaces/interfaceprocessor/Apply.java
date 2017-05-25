package linxiang.com.interfaces.interfaceprocessor;

import linxiang.com.logger.Logger;

/**
 * Created by liulinxiang on 2017/5/25.
 */
public class Apply {
    public static  void process(Processor p,Object s){
        Logger.d("using processor "+p.name());
        Logger.d(p.process(s).toString());
    }
}
