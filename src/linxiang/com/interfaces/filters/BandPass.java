package linxiang.com.interfaces.filters;

/**
 * Created by liulinxiang on 2017/5/25.
 */
public class BandPass extends Filter {
    double lowCutoff,highCutoff;
    public BandPass(double lowCutoff, double highCutoff){
        this.highCutoff = highCutoff;
        this.lowCutoff = lowCutoff;
    }
    public Waveform process(Waveform input){
        return input;
    }
}
