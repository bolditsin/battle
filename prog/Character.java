package battle2;

public class Character {
    String name;
    int str;
    int dex;
    int intel;
    int hp;
    int att= (int)(Math.random()*6);
    public Character(){

    }

    public int meleeAttack(){
        return str+att;
    }
}
