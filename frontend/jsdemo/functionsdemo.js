// I Scope Creation : outer[x:undef, inner:undef], inner[x:undef]
// II Execution : outer[x:10, inner:fn], inner[x:undef]
var outer = function(){
    var x = 10;
    console.log('This is an outer function');
    var inner = function(){
        console.log(x + 5);  // Accessing outer function's variable x
        console.log('This is an inner function');
        var x = 20;
    };
    return inner;
}
// var result = outer();
// result();
outer()();