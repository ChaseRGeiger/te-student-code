/*
* Add Events and functions to move the Ship and Win the game
*/
const obstacles = ['pirate', 'iceberg'];
const directions = ['up','right','down', 'left'];
let clock;

// Creates the Grid -- this should only occur after the DOM loads



/*
  Move the Ship 
*/
function moveShipRight() {

}

function moveShipLeft() {

}

function moveShipDown() {

}

function moveShipUp() {

}



function getShipLocation() {
    // Get the return the current location of the ship
 
}





/*
  Win Conditions
*/





/*
    Loss Conditions
*/




/**
 * Reset the Game
 */
function resetGame() {

    
}


/*
    Setup the Game
*/
/**
 * Creates the game grid
 */
function createGrid() {

    // Get a Reference to the game board 
    const frame;

    
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
    const row;
    // Add the row class to the row div

    // Append the row div to the game board (frame)
   
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
   const square;
   // Add the square class to the div
   
   // Insert the square at the end of the row
  
}




/**
 * Adds random obstacles to a game cell
 * 
 * @param {HTMLElement} cell 
 */
function addObstacles(cell) {
    // remove any existing pirates or icebergs


    const rand = getRandomNumber(100, false);

    if (rand > 85) {
        // Add iceberg here
 
    } else if (rand > 80) {
        // Add pirates here

    } 
}


/*
  Move the Pirates
*/



function getRandomNumber(top, zeroBased) {
    let randNumber = (Math.floor(Math.random() * top) + 1);
    return zeroBased ? randNumber - 1: randNumber;
}
