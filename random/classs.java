
class A {
    int a = 9;
    int b = 1;

    void add() {
        System.out.println(a + b);
    }
}

class B extends A {

    void sub() {
        System.out.println(a - b);
    }
}

public class classs {

    public static void main(String[] args) {
        
        A obj = new A();
        obj.add();
        // obj.sub();

        B obj1 = new B();
        obj1.add();
        obj1.sub();

        A obj2 = new B();
        obj2.add();
       // obj2.sub();

      // B obj3 = new A();
      //  obj3.add();
      //  obj3.sub();

    }

}
