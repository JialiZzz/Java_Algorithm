public class Attribute {

    //首先，在java里，我们有类的概念，class
    //class里面有一些它的特性，叫attribute
    //比如说 person 类 有 age，name attribute
    //also, it has method to use like getName(), getAge()
    //usually,we cannot access attribute from outside class
    //because it is danger to expose it. we return value by passing it
    // to a method

    public static class Person {
        private String name;
        private int age;

        // constructor
        // why we have thing like constructor
        // because it is object oriented programming
        // we need to have a specific object with details
        //like for a specific person, he/she has name or other specific teature
        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }
        // how to modify the attribute?

    }

    public static void main(String[] args) {
        Person p = new Person("",13);
        p.age=12;
    }

}

