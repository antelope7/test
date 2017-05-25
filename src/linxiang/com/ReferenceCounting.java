package linxiang.com;

import linxiang.com.logger.Logger;

/**
 * Created by liulinxiang on 2017/5/25.
 */
class Shared{
    private int refcount = 0;
    private static long counter = 0;
    private final long id = counter++;
    public Shared(){
        Logger.d("Create "+this);
    }
    public void addRef(){refcount++;}
    protected void dispose(){
        if(--refcount == 0){
            Logger.d("Disposing "+this);
        }
    }
    public String toString(){
        return "Shard "+id;
    }
}

class Composing{
    private Shared shared;
    private static long counter = 0;
    private final long id = counter++;
    public Composing(Shared shared){
        Logger.d("Creating "+this);
        this.shared = shared;
        this.shared.addRef();
    }
    protected void dispose(){
        Logger.d("disposing "+this);
        shared.dispose();
    }
    public String toString(){
        return "Composing "+id;
    }
}

public class ReferenceCounting {
    public static void main(String[] args){
        Shared shared = new Shared();
        Composing[] composings = {
                new Composing(shared),
                new Composing(shared),
                new Composing(shared)
        };
        for (Composing c: composings
             ) {
            c.dispose();
        }
    }
}

