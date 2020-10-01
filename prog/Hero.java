package battle2;



public class Hero extends Character
{
    public Hero(String name, int str, int dex, int intel, int hp)
    {
        this.name= name;
        this.str= str;
        this.dex= dex;
        this.intel= intel;
        this.hp= hp;
    }
    int castCharge(){
        return ((str+att)*2);
    }
}

