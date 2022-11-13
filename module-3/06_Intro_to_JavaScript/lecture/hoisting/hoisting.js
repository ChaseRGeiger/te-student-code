message = "This works because of hoisting";

showMessage();

// variable declaration is hoisted - this is one of the reasons we DON'T USE VAR
// let and const are not hoisted!!
var message;

// simple functions are hoisted
function showMessage() {
    console.log(message);
}


/*
ORDER THIS SCRIPT RUNS IN AFTER HOISTING

var message;
function showMessage() {
    console.log(message);
}
message = "This works because of hoisting";
showMessage();

*/