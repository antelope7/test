package linxiang.com.interfaces.filters;

/**
 * Created by liulinxiang on 2017/5/25.
 */
public class HighPass extends Filter {
    double cutoff;
    public HighPass(double cutoff){
        this.cutoff = cutoff;
    }
    public Waveform process(Waveform input){
        return input;
    }

}
