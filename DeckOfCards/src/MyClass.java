

/**
 * You can declare class in java by declaring
 * the access modifier (in this case "public"),
 * the "class" keyword
 * the name of the class (in this case "MyClass")
 */
public class MyClass {
    int age;
    String name;

    /**
     * This is how to declare a constructor
     * The method name of the constructor should match the class name
     * The constructor must not have return type
     */
    MyClass() {
        //constructor is used to initialized
        //the properties of the object
        this.name = "John";
        this.age = 19;
    }


    /**
     * This is a static method
     */
    static void myStatic() {
        System.out.println("This is a static method!");
    }

    /**
     * This is a non-static method
     */
    public void nonStatic() {
        System.out.println("This is a non static method!");
    }


    //This is a class attribute
    int myVar = 10;


    /**
     * You can create an object in java by
     * declaring a variable (in this case "sampleObj")
     * the name of the class as the datatype (in this case "MyClass")
     * using the key word "new"
     * calling the class in this case "MyClass()"
     */

//    public static void main(String[] args) {
//
//        //Calling a static method
//        myStatic();
//
//        //calling a non static method
//        MyClass sampleObj = new MyClass();
//        sampleObj.nonStatic();
//
//
//        //This is how to access class attribute
////        System.out.println(sampleObj.myVar);
//
//        //This is how you modify the class attributes
//        sampleObj.myVar = 45;
//        System.out.println(sampleObj.myVar);
//    }
}

