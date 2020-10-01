package battle2;

public class Villain extends Character{
    int comb= (int)(Math.random()*10);
    public Villain(String name, int str, int dex, int intel, int hp)
    {
        this.name= name;
        this.str= str;
        this.dex= dex;
        this.intel= intel;
        this.hp= hp;

    }
    int castCombustion(){
        return intel+comb+14;
    }

}
