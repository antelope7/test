package linxiang.com.interfaces.filters;

/**
 * Created by liulinxiang on 2017/5/25.
 */
public class Filter {
    public String name(){
        return getClass().getSimpleName();
    }
    public Waveform process(Waveform input){
        return input;
    }
}
