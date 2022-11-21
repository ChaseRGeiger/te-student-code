/*
* Add Events and functions to move the Ship and Win the game
*/
const obstacles = ['pirate', 'iceberg'];
const directions = ['up','right','down', 'left'];
let clock;

// Creates the Grid -- this should only occur after the DOM loads
document.addEventListener('DOMContentLoaded', () =>{
    createGrid();

    document.querySelector('body').addEventListener('keyup', (event) =>{
        if(event.key.toLowerCase() === 'd'){
            moveShipRight();
        }
        if(event.key.toLowerCase() === 'a'){
            moveShipLeft();
        }
        if(event.key.toLowerCase() === 's'){
            moveShipDown();
        }
        if(event.key.toLowerCase() === 'w'){
            moveShipUp();
        }
    });

    document.getElementById('resetButton').addEventListener('click', (event) =>{
        resetGame();
        event.preventDefault();

    })
});


/*
  Move the Ship 
*/
function moveShipRight() {
    const ship = getShipLocation();
    const right = ship.nextElementSibling;
    moveShip(ship, right);
}

function moveShipLeft() {
    const ship = getShipLocation();
    const left = ship.previousElementSibling;
    moveShip(ship, left);
}

function moveShipDown() {
    const ship = getShipLocation();
    const newRow = ship.parentElement.nextElementSibling;
    const down = getElementAtSameIndex(ship, newRow);
    moveShip(ship, down);
    

}

function moveShipUp() {
    const ship = getShipLocation();
    const newRow = ship.parentElement.previousElementSibling;
    const up = getElementAtSameIndex(ship, newRow);
    moveShip(ship, up);

}

function moveShip(oldLocation, newLocation){
    if(isWin(newLocation)){
        win();
    } else if(isLoss(newLocation)){
        lose('You hit an obstacle!');
    } else if(canMoveToNewElement(newLocation)){
        oldLocation.classList.remove('boat');
        newLocation.classList.add('boat');
    }

}

function getElementAtSameIndex(ship, newParentRow){
    let elementAtIndex = null;

    if(newParentRow != null){
        const index = Array.from(ship.parentNode.children).indexOf(ship);
        elementAtIndex = newParentRow.childNodes[index];
    }

    return elementAtIndex;
}

function canMoveToNewElement(newLocation){
    if(!newLocation || newLocation.classList.contains('pirate') || newLocation.classList.contains('iceberg')){
        return false;
    }

    return true;
}



function getShipLocation() {
    // Get the return the current location of the ship
    return document.getElementById('frame').querySelector('.boat');
 
}





/*
  Win Conditions
*/

function isWin(newLocation){
    return (newLocation && newLocation.classList.contains('treasure'));
   
}

function win(){
    const announcement = document.querySelector('h1.announce');
    announcement.classList.add('winText');
    announcement.innerText = 'You Win!';
    getShipLocation().classList.remove('boat');
}


/*
    Loss Conditions
*/

function isLoss(newLocation){
    return newLocation && (newLocation.classList.contains('pirate') || newLocation.classList.contains('iceberg'));
}

function lose(message){
    const announcement = document.querySelector('h1.announce');
    announcement.innerText = message;
    getShipLocation().classList.remove('boat');


    const ship = getShipLocation();
    ship.classList.add('boat_explosion');
    // setTimeout(callbackMethod, millisecondsToWait)
    setTimeout(() =>{
        ship.classList.remove('boat_explosion');
        ship.classList.add('boat_sunk');
    }, 250);
}




/**
 * Reset the Game
 */
function resetGame() {

    //Reset the boat

    

    //Create the obstacles
    createObstacles();



    //Place the player and the treasure
    const frame = document.getElementById('frame');
    frame.firstElementChild.firstElementChild.classList.add('boat');

    frame.lastElementChild.lastElementChild.classList.add('treasure')



    //Inform the player they can start
    document.querySelector('h1.announce').innerText = 'Play!';

    

    
}

function resetBoat(){
    const ship = getShipLocation();
    if(ship){
        ship.classList.remove('boat');
    }

    const sunkenShip = document.getElementById('frame').querySelector('.boat_sunk');
    if(sunkenShip){
        sunkenShip.classList.remove('boat_sunk');
    }
}


/*
    Setup the Game
*/

function createObstacles(){
    const rows = document.querySelectorAll('div.row');
    rows.forEach( (row, rowIndex) =>{
        const cells = row.children;
        Array.from(cells).forEach((cell, cellIndex) =>{
            if(!(cellIndex === 0 && rowIndex === 0)&&
            !(cellIndex === cells.length - 1 && rowIndex === rows.length - 1)){
                addObstacles(cell);
            }
        })
    })
}
/**
 * Creates the game grid
 */
function createGrid() {

    // Get a Reference to the game board 
    const frame = document.getElementById('frame');
    
    
    for (let i = 0; i < 10 ; i++) {
        buildRow(frame); 
    }
    resetGame();
}

/**
 * Builds the grid rows
 * @param {HTMLElement} frame 
 */
function buildRow(frame) {
    // Create a Div to be the row
    const row = document.createElement('div');
    // Add the row class to the row div
    row.classList.add('row');
    // Append the row div to the game board (frame)
    frame.appendChild(row);
   
    for (let i = 0; i < 10 ; i++) {
        buildSquare(row, i); 
    }    
}

/**
 * Builds the grid squares 
 * @param {HTMLElement} row 
 * @param {int} count 
 */
function buildSquare(row, count) {
   // Create a Div for the game board square
    const square = document.createElement('div');

   // Add the square class to the div
    square.classList.add('square')
   // Insert the square at the end of the row
    row.insertAdjacentElement('beforeend', square)
}




/**
 * Adds random obstacles to a game cell
 * 
 * @param {HTMLElement} cell 
 */
function addObstacles(cell) {
    // remove any existing pirates or icebergs
    cell.classList.remove('pirate')
    cell.classList.remove('iceberg')

    const rand = getRandomNumber(100, false);

    if (rand > 85) {
        // Add iceberg here
        cell.classList.add('iceberg')
 
    } else if (rand > 80) {
        // Add pirates here
        cell.classList.add('pirate')

    } 
}


/*
  Move the Pirates
*/





function getRandomNumber(top, zeroBased) {
    let randNumber = (Math.floor(Math.random() * top) + 1);
    return zeroBased ? randNumber - 1: randNumber;
}
