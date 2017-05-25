package linxiang.com;

import linxiang.com.logger.Logger;

import static linxiang.com.Sandwich.TAG;

/**
 * Created by liulinxiang on 2017/5/25.
 */
class Meal{
    Meal(){
        Logger.d(TAG,"Meal()");}
}

class Lunch extends Meal{
    Lunch(){
        Logger.d(TAG,"Lunch()");
    }
}

class PortableLunch extends Lunch{
    PortableLunch(){
        Logger.d(TAG,"PortableLunch()");
    }
}


public class Sandwich extends PortableLunch {
    public final static String TAG = "Sandwich";
    Sandwich(){
        Logger.d(TAG,"Sandwich()");
    }
    public static void main(String[] args){
        new Sandwich();
    }
}
