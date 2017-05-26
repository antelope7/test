package linxiang.com.interfaces;

import linxiang.com.logger.Logger;

import java.util.Random;

/**
 * Created by liulinxiang on 2017/5/26.
 */
public class RandomDoubles {
    private static Random rand = new Random(47);
    public double next() {return rand.nextDouble();}
    public static void main(String[] args){
        RandomDoubles rd = new RandomDoubles();
        for (int i = 0; i < 7; i++) {
            Logger.d(Double.toString(rd.next()));
        }
    }
}
