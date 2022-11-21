let allItemsIncomplete = true;
const pageTitle = 'My Shopping List';
const groceries = [
  { id: 1, name: 'Oatmeal', completed: false },
  { id: 2, name: 'Milk', completed: false },
  { id: 3, name: 'Banana', completed: false },
  { id: 4, name: 'Strawberries', completed: false },
  { id: 5, name: 'Lunch Meat', completed: false },
  { id: 6, name: 'Bread', completed: false },
  { id: 7, name: 'Grapes', completed: false },
  { id: 8, name: 'Steak', completed: false },
  { id: 9, name: 'Salad', completed: false },
  { id: 10, name: 'Tea', completed: false }
];

/**
 * This function will get a reference to the title and set its text to the value
 * of the pageTitle variable that was set above.
 */
function setPageTitle() {
  const title = document.getElementById('title');
  title.innerText = pageTitle;
}

/**
 * This function will loop over the array of groceries that was set above and add them to the DOM.
 */
function displayGroceries() {
  const ul = document.querySelector('ul');
  groceries.forEach((item) => {
    const li = document.createElement('li');
    li.innerText = item.name;
    const checkCircle = document.createElement('i');
    checkCircle.setAttribute('class', 'far fa-check-circle');
    li.appendChild(checkCircle);
    ul.appendChild(li);
  });
}

function markComplete(item, logo){
  item.classList.add('completed');
  logo.classList.add('completed');
}

function toggleCompletion() {
  const groceryListElements = document.querySelectorAll('li');
  const logos = document.querySelectorAll('i');
  let toggle = document.getElementById('toggleAll');


  if(allItemsIncomplete){
    for(let i = 0; i < groceryListElements.length; i++){
      groceryListElements[i].classList.add('completed');
      logos[i].classList.add('completed');
    }
    allItemsIncomplete = false;
    toggle.innerText = 'Mark All Incomplete';
  }
  else{
    for(let i = 0; i < groceryListElements.length; i++){
      groceryListElements[i].classList.remove('completed');
      logos[i].classList.remove('completed');
    }
    toggle.innerText = 'Mark All Complete';
    allItemsIncomplete = true;
  }
}



function markItemIncomplete(item, logo){
  if(item.classList.contains('completed')){
    item.classList.remove('completed');
    logo.classList.remove('completed');
  }
}








document.addEventListener('DOMContentLoaded', () =>{
  setPageTitle();
  displayGroceries();

  const button = document.querySelector('.btn');
  button.addEventListener('click', toggleCompletion);

  const items = document.querySelectorAll('li');
  items.forEach(e =>{
    e.addEventListener('click', (event) =>{
      markComplete(event.target, e.firstElementChild);
    });
    e.addEventListener('dblclick', (event) =>{
      markItemIncomplete(event.target, e.firstElementChild);
    });
  });

});
