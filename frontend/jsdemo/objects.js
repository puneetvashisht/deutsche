var person = {
    name: 'John Doe',
    age: 30,
    greet: function() {
        console.log('Hello,'+ this.name);
    }
}

person.greet();
console.log(person.name);
person.address = {
    street: '123 Main St',
    city: 'New York'
};
console.log(person.address.street);
