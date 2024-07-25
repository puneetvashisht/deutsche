console.log('starting...');

var foo = function(fn){
    setTimeout(() => {
        console.log('This is a function');
        fn("success")
    }
    , 5000); 
}
// var result = foo();
// console.log(result);
foo((result) => console.log(result));

console.log('finishing...');
