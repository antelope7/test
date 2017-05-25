package linxiang.com.interfaces;

import linxiang.com.logger.Logger;

/**
 * Created by liulinxiang on 2017/5/25.
 */


interface Instrument{
    int VALUE = 5;
    void play(Note n);
    void adjust();
}

class Wind implements Instrument{
    public void play(Note n){
        Logger.d(this +".play() "+ n);
    }
    public String toString(){
        return "Wind";
    }
    public void adjust(){
        Logger.d(this + ".adjust()");
    }
}

class Percussion implements Instrument{
    public void play(Note n){
        Logger.d(this +".play() "+n);
    }
    public String toString(){
        return "Percussion";
    }
    public void adjust(){
        Logger.d(this + ".adjust()");
    }
}

public class Music5 {
    static void tune(Instrument i){
        i.play(Note.MIDDLE_C);
    }
    static void tuneAll(Instrument[] is){
        for (Instrument i:is)
            tune(i);
    }
    public static void main(String[] args){
        Instrument[] orchestra = {
                new Wind(),
                new Percussion()
        };
        tuneAll(orchestra);
    }


}
