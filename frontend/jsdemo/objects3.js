class Person {
    constructor(name, age) {
        this.name = name;
        this.age = age;
    }

    greet() {
        console.log('Hello, ' + this.name);
    }
}

const person1 = new Person('John Doe', 30);
person1.greet();