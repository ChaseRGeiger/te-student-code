// add pageTitle
const pageTitle = 'My Shopping List';

// add groceries
const groceries = ['Bread', 'Eggs', 'Milk', 'Soap', 'Pasta', 'Rice',
 'Steak', 'Chicken', 'Pork', 'Toothpaste'];

/**
 * This function will get a reference to the title and set its text to the value
 * of the pageTitle variable that was set above.
 */
function setPageTitle() {
  document.getElementById('title').innerText = pageTitle;
}

/**
 * This function will loop over the array of groceries that was set above and add them to the DOM.
 */
function displayGroceries() {
  let groceryContainer = document.getElementById('groceries');
  groceries.forEach(grocery =>{
    let listElementGrocery = document.createElement('li');
    listElementGrocery.innerText = grocery;
    groceryContainer.insertAdjacentElement('beforeend', listElementGrocery);
  });
}

/**
 * This function will be called when the button is clicked. You will need to get a reference
 * to every list item and add the class completed to each one
 */
function markCompleted() {
  const groceryListElements = document.querySelectorAll('li');
  for(let i = 0; i < groceryListElements.length; i++){
    groceryListElements[i].classList.add('completed');
  }
}

setPageTitle();

displayGroceries();

// Don't worry too much about what is going on here, we will cover this when we discuss events.
document.addEventListener('DOMContentLoaded', () => {
  // When the DOM Content has loaded attach a click listener to the button
  const button = document.querySelector('.btn');
  button.addEventListener('click', markCompleted);
});
