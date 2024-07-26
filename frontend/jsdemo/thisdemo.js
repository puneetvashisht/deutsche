// this in arrow function in javascript
function greet(a, b) {
    console.log('Hello, my name is ' + this.name);
    console.log(a, b);
}

const person = {
    name: 'John',
    sayHello: greet
};

const anotherPerson = {
    name: 'Alice'
};

greet(); 
person.sayHello(); 
greet.call(anotherPerson);
greet.bind(anotherPerson);

// difference between bind and call
greet.bind(anotherPerson)(5,7); // returns 'Alice'

// difference between apply and call
greet.call(anotherPerson, 5, 7); // returns 'Hello, my name

const greetArrow = (a, b) => {
    console.log('Hello, my name is ' + this.name);
    console.log(a, b);
};

greetArrow(5,7); 
person.greetArrow(5,7); 
