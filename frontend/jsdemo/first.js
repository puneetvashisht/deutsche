console.log('Hello, World!');

function foo(){
    console.log('This is a function');
}

foo();

// function sum(a, b){
//     return a + b;
// }
// var sum = function(a, b){
//     return a + b;
// };
var sum = (a, b) =>  a + b;

console.log(sum(2, 3));