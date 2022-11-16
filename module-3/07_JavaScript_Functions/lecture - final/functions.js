/*
    Working with an unknown number of parameters
*/
function unknownParameters() {
    console.log(arguments.length);
    console.table(arguments);

    // Arguments looks like an array, but it is an object of a different type
    // Array.from() can be used to convert it to an array
    const argumentsAsArray = Array.from(arguments);
    return argumentsAsArray;
}

function paramWithRestArgs(...args) {
    console.table(args);
}

/*
    The Spread Operator
*/

function spreadOperatorExample() {
    let nums = [1,2,3,4,5];
    paramWithRestArgs(...nums);

    let name = "John Fulton";
    paramWithRestArgs(...name);

    addLetters(...name);
}

function addLetters(a, b, c) {
    console.log(a + b + c);
}

/*
    Anonymous Functions
*/
// Named function
function doubleTheSum(x, y) {
    return (x + y) * 2;
}

// anonymous function stored in a variable
const doubleSum = function (x, y) {
    return (x + y) * 2;
}

let anotherName = doubleSum;

// functions can be passed to another function
function takesFunctionAsParameter(func) {
    console.log(func(2,4));
}

// Function defined using the arrow operator
const twiceTheSum = (x, y) => {
    return (x + y) * 2;
}

takesFunctionAsParameter(twiceTheSum);

takesFunctionAsParameter( (x, y) => {
    return (x + y) * 3;
} );



// function doubleTheSum(x, y) {
//     return (x + y) * 2;
// }

// const doubleTheSum = function (x, y) {
//     return (x + y) * 2;
// }

// const doubleTheSum = (x, y) => {
//     return (x + y) * 2;
// }


const nums = [1,2,3,4,5,6,7,8,9,10];

function forEachExamples() {

    nums.forEach( element => {
        console.log(element);
    });

    let sum = 0;
    nums.forEach( element => {
        sum += element;
    });
    console.log(`Sum of the array is ${sum}`);

    nums.forEach( (currentElement, index) => {
        console.log(`${currentElement}  is at index ${index}`);
    });

}

const tasks = ['scrub the floor', 'do dishes', 'clean ceiling', 'pickup socks'];

function reduceExamples() {

    let sum = nums.reduce( (ongoingSum, currentValue) => {
        return ongoingSum + currentValue;
    }, 0);
    console.log(sum);

    let taskList = tasks.reduce( (taskList, currentValue, index) => {
        taskList += `${index + 1}) ${currentValue} \n`;
        return taskList;
    }, '');
    console.log(taskList);


}

function filterExamples() {
    // Filter odd numbers out of the array
    const evenNumbersOnly = nums.filter( currentValue => {
        return currentValue % 2 === 0;
    });

    console.table(evenNumbersOnly);

    // Filter all tasks that do not include the letter s
    const tasksWithAnS = tasks.filter( (task) => {
        return task.includes('s') || task.includes('S');
    });
    console.table(tasksWithAnS);
}


function mapExamples() {
    const everyNumberDoubled = nums.map( currentNum => {
        return currentNum * 2;
    });
    console.table(everyNumberDoubled);

    const taskListAllUpper = tasks.map( task => {
        return task.toUpperCase();
    });
    console.table(taskListAllUpper);
}

const fizzArr = [1,2,3,4,5,6,7,8,9,10,11,12,13,14,15];
function fizzBuzzWithMap() {
    let fizzBuzzedResult = fizzArr.map( value => {
        if (!(value % 3) && !(value % 5)) {
            return "FizzBuzz";
        }
        if (!(value % 3)) {
            return "Fizz";
        }
        if (!(value % 5)) {
            return "Buzz";
        }
        return value;
    });
    console.log(fizzBuzzedResult);
}

/*
    For an Array of numbers, find the sum of all numbers in the array multiplied
    by 10, but only for number that are not a multiple of 3    
*/
function chainingFunctionalMethods(numbers) {
    // First get all the numbers that are not a multiple of 3
    return numbers.filter( currentNumber => {
        return currentNumber % 3;
    }).map( currentValue => {
        return currentValue * 10;
    }).reduce( (sum, currentValue) => {
        return sum + currentValue;
    }, 0);
}


function findExample() {
    // Find the number 9
    const foundValue = fizzArr.find( currentElement => currentElement === 9 );
    console.log(foundValue);
}

function findIndexExample() {
    // Find the index of the number 9
    const foundValue = fizzArr.findIndex( currentElement => currentElement === 9 );
    console.log(foundValue);
}

/**
 * 
 * @param {Object} person an object describing a person
 */
function thisTakesAnObject(person) {

}

function findMin() {
    const arr = [12, 205, 3, 42, 58];
    const reducedValue = arr.reduce( (currentMin, currentValue) => {
        if (currentValue < currentMin) {
            return currentValue;
        } else {
            return currentMin;
        }
    });
    console.log("Min: " + reducedValue);
}


// int accumulator = arr[0];

// for (int i = 1; i < arr.length; i++) {
//     accumulator = getNextValue(accumulator, arr[i];)
// }

// public int getNextValue(int accumulator, int currentValue) {
//     return accumulator + currentValue;
// }