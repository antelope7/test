package linxiang.com.interfaces;

import linxiang.com.logger.Logger;

import java.util.Arrays;

/**
 * Created by liulinxiang on 2017/5/25.
 */
class Processor{
    public String name(){
        return getClass().getSimpleName();
    }
    Object process(Object input){
        return input;
    }
}

class Upcase extends Processor{
    String process(Object input){
        return ((String)input).toUpperCase();
    }
}

class Downcase extends Processor{
    String process(Object input){
        return ((String)input).toLowerCase();
    }
}

class Splitter extends Processor{
    String process(Object input){
        return Arrays.toString(((String)input).split(" "));
    }
}

public class Apply {
    public static void process(Processor p,Object s){
        Logger.d("Using Processor "+p.name());
        Logger.d((String)p.process(s));
    }
    public static String s =
            "Disaggreement with beliefs is by definition incorrect";
    public static void main(String[] args){
        process(new Upcase(),s);
        process(new Downcase(),s);
        process(new Splitter(),s);
    }
}
