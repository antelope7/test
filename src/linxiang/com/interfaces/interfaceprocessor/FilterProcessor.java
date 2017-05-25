package linxiang.com.interfaces.interfaceprocessor;

import linxiang.com.interfaces.filters.*;

/**
 * Created by liulinxiang on 2017/5/25.
 */
public class FilterProcessor {
    public static void main(String[] args){
        Waveform w = new Waveform();
        Apply.process(new FilterAdapter(new LowPass(1.0)),w);
        Apply.process(new FilterAdapter(new HighPass(2.0)),w);
        Apply.process(new FilterAdapter(new BandPass(3.0,4.0)),w);
    }
}

class FilterAdapter implements Processor{
    Filter filter;
    public FilterAdapter(Filter filter){
        this.filter = filter;
    }
    public String name() {
        return filter.name();
    }
    public Waveform process(Object input){
        return filter.process((Waveform)input);
    }
}
