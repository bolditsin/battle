package homework6;

public class Cat extends Animal{
    public Cat(String name) {
        super(name);
        this.runLength = 200;
        this.jumpHeight = 2;
        this.species = "Кот";
    }
    @Override
    public void swim(int length){
        System.out.println("Кошки не умеют плавать");
    }
}
