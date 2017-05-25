package linxiang.com.polymorphism;


import linxiang.com.logger.Logger;

/**
 * Created by liulinxiang on 2017/5/25.
 */
class Actor{
    public void act(){}

}

class HappyActor extends Actor{
   public void act(){
       Logger.d("HappyActor");
   }
}

class SadActor extends Actor{
    public void act(){
        Logger.d("SadActor");
    }
}

class Stage{
    private Actor actor = new HappyActor();
    public void change() {
        actor = new SadActor();
    }
    public void performPlay(){
        actor.act();
    }
}

public class Transmogrify {
    public static void  main(String[] args){
        Stage stage = new Stage();
        stage.performPlay();
        stage.change();
        stage.performPlay();
    }
}

