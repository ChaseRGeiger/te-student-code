const clickedText = "You did it!  You clicked the Shinny Red Button!!";

document.addEventListener('DOMContentLoaded', () => {

    const theShinnyRedButton = document.querySelector("input[type='button']");
    
    theShinnyRedButton.addEventListener('click', (eventObj) => {
        alert(clickedText);
        console.log(eventObj);
    });

});