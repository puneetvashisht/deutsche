function Person(name, age) {
    this.name = name;
    this.age = age;
    this.greet = function() {
        console.log('Hello, ' + this.name);
    }
}

var person1 = new Person('John Doe', 30);
person1.greet();