package linxiang.com.interfaces.interfaceprocessor;

/**
 * Created by liulinxiang on 2017/5/25.
 */
public interface Processor {
    String name();
    Object process(Object input);
}
