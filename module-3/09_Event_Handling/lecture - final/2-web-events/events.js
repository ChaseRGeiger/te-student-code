/*
  The DOMContentLoaded event fires when the HTML and CSS have
  been completely loaded into the DOM, making the page ready to
  manipulate.
*/
document.addEventListener('DOMContentLoaded', () => {

    addHandleMouseEvents();
    handleKeyboardEvents();
    handleFormEvents();
    handleEventPropagationDemo();


})


function addHandleMouseEvents() {
    // click 
    // Only triggers for left click in Chrome, but all buttons in other browsers
    const clickDiv = document.getElementById('clickdiv');
    clickDiv.addEventListener('click', () => {
        swapBackground(clickDiv, 'blue-background');
    });

    // double click
    const dblClickDiv = document.getElementById('dblclickdiv');
    dblClickDiv.addEventListener('dblclick', () => {
        swapBackground(dblClickDiv, 'red-background');
    });

    // mouse down
    document.getElementById('mousedowndiv').addEventListener('mousedown', (e) => {
        showMouseButtonText(e.which);
    });

    /* 
        Enter/Over
        mouseenter - triggers when the mouse enters the box of the element
        mouseover - triggers when the mouse enters the box of the element 
                    or the box of any of its children
    */
    const mouseEnterDiv = document.getElementById('mouseenterdiv');
    mouseEnterDiv.addEventListener('mouseenter', () => {
        mouseEnterDiv.classList.add('blue-background');
    });

    /*
        Leave/Out
        mouseleave - triggers when the mouse leaves the box of the element
        mouseout - triggers when the mouse leaves the box of the element
                   or the box of any of its children
    */
    mouseEnterDiv.addEventListener('mouseleave', () => {
        mouseEnterDiv.classList.remove('blue-background');
    });
}


function handleKeyboardEvents() {

    /*
        keydown triggers when a key is pressed down.
        It fires for every key on the keyboard, including those that don't
        produce characters (Esc, Backspace, arrows, etc.)
    */
    const keydownInput = document.getElementById('keydownInput');
    keydownInput.addEventListener('keydown', (e) => {
        keydownInput.value = `The ${e.key} (${e.keyCode}) key is down - every key fires this event`;
        e.preventDefault();
    });

    /*
        keyup triggers when a key is released.
        It fires for every key on the keyboard, including those that don't
        produce characters (Esc, Backspace, arrows, etc.)
    */
    const keyupInput = document.getElementById('keyupInput');
    keyupInput.addEventListener('keyup', (e) => {
        keyupInput.value = `The ${e.key} (${e.keyCode}) key was released - every key fires this event`;
        e.preventDefault();
    });

    /*
        keyup triggers when a key is pressed (like keydown).
        It fires for only keys that produce characters.
    */
    const keypressInput = document.getElementById('keypressInput');
    keypressInput.addEventListener('keypress', (e) => {
        keypressInput.value = `The ${e.key} (${e.keyCode}) key was pressed - keys that don't create characters don't fire this event.`;
        e.preventDefault();
    });
}

function handleFormEvents() {
    const result = document.getElementById('changeResult');

    /*
      The change event fires when the contents of a form element changes. 
      The change event does not fire for a text field, but the key events
      can be used.  
    */
    document.getElementById('checkboxchange').addEventListener('change', () => {
        result.innerText = "You clicked the checkbox";
    });

    const selectChange = document.getElementById('selectchange');
    selectChange.addEventListener('change', ()=> {
        result.innerText = `You selected ${selectChange.value}`;
    });

    /*
        The focus event fires when an form element is selected to recieve input, 
        such as clicking on it or navigating to it with the keyboard.
    */
    const focusInput = document.getElementById('focusInput');
    focusInput.addEventListener('focus', () => {
        focusInput.style.backgroundColor = "Red";
    });

    /*
        The blur event fires when the user navigates away from a form element.
    */
    const blurInput = document.getElementById('blurInput');
    blurInput.addEventListener('blur', () => {
        blurInput.style.backgroundColor = "Blue";
    });

    /*
        The submit event fires when a form is submitted.
        Form submissions should be listened for using submit and not the click
        of the submit button. 
    */
    document.getElementById('formsubmit').addEventListener('submit', (e) => {
        const numberSubmitted = document.querySelector('input[name=number]').value;
        document.querySelector('.formresult').innerText = `You submitted ${numberSubmitted}`;
        // If the form should not continue with the submission, eventObj.preventDefault() will stop it.
        e.preventDefault();
    });
}


function handleEventPropagationDemo() {
    /*
      Event Propagation
    */
   const parentDiv = document.querySelector(".parentdiv");
   const childDiv = document.querySelector(".childdiv");

   parentDiv.addEventListener("click", (e) => {
       parentDiv.style.backgroundColor = "Orange";
   });
   childDiv.addEventListener('click', (e) => {
       childDiv.style.backgroundColor = "Green";
       e.stopPropagation();
   });
}




function swapBackground(element, className) {
    if (element.classList.contains(className)) {
        element.classList.remove(className);
    } else {
        element.classList.add(className);
    }
}

function showMouseButtonText(buttonId) {
    let button = "";
        
    switch (buttonId) {
        case 1:  // left button
            button = "Left";
            break;
        case 2: // middle button
            button = "Middle";
            break;
        case 3: // right button
            button = "Right";
            break; 
    }
    alert(`You clicked the ${button} button`);
}