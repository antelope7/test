package linxiang.com.polymorphism;

import linxiang.com.logger.Logger;
import sun.rmi.runtime.Log;

class Glyph{
    void draw(){
        Logger.d("Glyph.draw()");
    }
    Glyph(){
        Logger.d("Glyph before draw");
        draw();
        Logger.d("Glyph after draw");
    }
}

class RoundGlyph extends Glyph{
    private int radius = 1;
    RoundGlyph(int r){
        radius = r;
        Logger.d("RoundGlyph.RoundGlyph(). radius = "+radius);
    }
    void draw(){
        Logger.d("RoundGlyph.draw(), radius = "+radius);
    }
}


public class PolyConstructors {
    public static void main(String[] args){
        new RoundGlyph(10);
    }
}
