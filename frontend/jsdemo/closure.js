// create a js closure to store the count
var counter = (function() {
    // private variable to store the count
  var count = 0;
  return function() {
    return count++;
  };
})();


// use the closure to increment the count
console.log(counter()); // logs: 0
console.log(counter()); // logs: 1
console.log(counter()); // logs: 2

// create another closure to store the count
