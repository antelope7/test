package linxiang.com.polymorphism;

import linxiang.com.logger.Logger;

/**
 * Created by liulinxiang on 2017/5/25.
 */
class Meal{
    Meal(){
        Logger.d(Sandwich.TAG,"Meal()");}
}

class Lunch extends Meal{
    Lunch(){
        Logger.d(Sandwich.TAG,"Lunch()");
    }
}

class PortableLunch extends Lunch{
    PortableLunch(){
        Logger.d(Sandwich.TAG,"PortableLunch()");
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
