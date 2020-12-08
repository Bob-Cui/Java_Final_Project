package main.java.CBGui.SpecificStage;

public class B  implements Role{
    @Override
    public void hit() {
        System.out.println("用刀");
    }

    public static void main(String[] args) {

        Role a = new A();
        a.hit();
        Role b = new B();
        b.hit();


    }

}
