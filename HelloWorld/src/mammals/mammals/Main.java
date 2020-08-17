package mammals.mammals;

import birds.Bird;
import mammals.Mammal;
import mammals.felines.Cat;

public class Main {
    public static void main(String[] args) {
        Cat cat = new Cat();
        Bird bird = new Bird();
        Mammal mammal = new Mammal();

        //mammal.sing();  // bad.
       // cat.yell();  // bad
        bird.fly();
     //   cat.motherChild();
    }
}
