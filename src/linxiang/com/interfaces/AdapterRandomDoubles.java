package linxiang.com.interfaces;

import linxiang.com.logger.Logger;

import java.nio.CharBuffer;
import java.util.Scanner;

/**
 * Created by liulinxiang on 2017/5/26.
 */
public class AdapterRandomDoubles extends RandomDoubles implements Readable {
    private int count;

    public AdapterRandomDoubles(int count){
        this.count = count;
    }
    public int read(CharBuffer cb){
        if(count-- == 0){
            return -1;
        }
        String re = Double.toString(next()) + " ";
        cb.append(re);
        return re.length();
    }
    public static void main(String[] args){
        Scanner s = new Scanner(new AdapterRandomDoubles(7));
        while (s.hasNextDouble()){
            Logger.d(Double.toString(s.nextDouble()) + " ");
        }
    }
}
