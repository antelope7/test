package linxiang.com.interfaces.filters;

/**
 * Created by liulinxiang on 2017/5/25.
 */
public class Waveform {
    private static long counter;
    private final long id  = counter++;
    public String toString(){
        return "Waveform "+id;
    }
}
