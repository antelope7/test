package linxiang.com.interfaces;

import linxiang.com.logger.Logger;

import java.nio.CharBuffer;
import java.util.Random;
import java.util.Scanner;

/**
 * Created by liulinxiang on 2017/5/26.
 */
public class RandomWords implements Readable{

    private static Random rand = new Random(47);
    private static final char[] capitals =
            "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
    private static final char[] lowers =
            "abcdefghijklmnopqrstuvwxyz".toCharArray();
    private static final char[] vowels =
            "aeiou".toCharArray();

    private int count;

    public RandomWords(int count){
        this.count = count;
    }
    public int read(CharBuffer cb){
        Logger.d("begin");
        if(count-- == 0){
            return -1;
        }
        cb.append(capitals[rand.nextInt(capitals.length)]);

        Logger.d(Integer.toString(cb.length()));
        for (int i = 0; i < 4; i++) {
            cb.append(vowels[rand.nextInt(vowels.length)]);
            cb.append(lowers[rand.nextInt(lowers.length)]);
            Logger.d(Integer.toString(cb.length()));


        }
        cb.append(" ");
        Logger.d(Integer.toString(cb.length()));


        return -10;
    }

    public static void main(String[] args){
        Scanner s = new Scanner(new RandomWords(10));
        while (s.hasNext()){
            Logger.d(s.next());
        }
    }
}
