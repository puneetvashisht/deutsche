console.log('starting...');

var foo = function(){
    return new Promise((resolve, reject) => {
        setTimeout(() => {
            console.log('This is a function');
            resolve("success")
        }
        , 5000); 
    })
    
}
// var result = foo();
// console.log(result);
// foo()
// .then(result => result[0])
// .then(data => console.log('This is the result' , data))
// .catch(error => console.log('Error occurred:', error));


const test = async () => {
    try {
        const result = await foo();
        console.log('This is the result' , result);
    } catch (error) {
        console.log('Error occurred:', error);
    }
}
test();

console.log('finishing...');
