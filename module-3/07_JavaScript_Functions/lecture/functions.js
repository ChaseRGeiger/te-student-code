function unknownParameters(){
    console.log(arguments.length)
    console.table(arguments)

    //Arguments is an object

    const argumentsArray = Array.from(arguments)
    return argumentsArray
}

function paramWithRestArgs(...args){
    console.table(args)

}

function spreadOperatorExample(){
    let nums = [1,2,3,4,5]
    paramWithRestArgs(...nums)
}



const doubleSum = (x,y) => {
    return (x + y) * 2
}

const squareNum = x => x * x


let array = [1,2,3,4,5,7,8,9,10,11,12,13,14,15]

function forEachExamples(){
    array.forEach(element => console.log(element))

    let sum = 0
    array.forEach(element => sum += element)
    console.log(`Sum of the array is ${sum}`)


}

function reduceExamples(){
    let sum = array.reduce((ongoingSum, currentValue) => {
        return ongoingSum + currentValue
    })
    console.log(sum)
}

function filterExamples(){
    const evensOnly = array.filter(currentValue => currentValue % 2 === 0)

    console.log(evensOnly)
}

function mapExamples(){
    const everyNumberDoubled = array.map(currentValue => currentValue * 2)
}

const fizzArr = [1,2,3,4,5,6,7,8,9,10,11,12,13,14,15]
function fizzBuzzWithMap(){
    let fizzBuzzedResult = fizzArr.map(currentValue => {
        if(!(currentValue % 3) && !(currentValue % 5)){
            return "FizzBuzz"
        }
        if(!(currentValue % 3)){
            return "Fizz"
        }
        if(!(currentValue % 5)){
            return "Buzz"
        }
        return currentValue
    })

    console.log(fizzBuzzedResult)
}

/*
    for an array of nums, find sum of all multiplied by 10, 
    but only for numbers that arent a multiple of 3
*/

function chainingFunctionalMethods(numbers){
    let filteredArr = numbers.filter(currentValue => currentValue % 3)
    let mappedArr = filteredArr.map(currentValue => currentValue * 10)
    let finalArr = mappedArr.reduce((sum, currentValue) => {
        return sum + currentValue
    }, 0)

    console.log(finalArr)
}

function findExample(){
    const foundValue = array.find(currentValue => currentValue === 9)

    console.log(foundValue)
}

function findIndexExample(){
    const findIndex = array.findIndex(currentValue => currentValue === 9)

    console.log(findIndex)
}
