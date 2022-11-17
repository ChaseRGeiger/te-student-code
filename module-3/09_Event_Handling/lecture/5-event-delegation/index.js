const colors = document.getElementById("colors");

document.addEventListener('DOMContentLoaded', () => {
	

	colors.addEventListener("click", event => {
		console.log(event.target.getAttribute('id'));
		if (event.target.nodeName.toLowerCase() === "li") {
			event.target.style.backgroundColor = event.target.innerText;
		}
	});

	document.getElementById('btnAddNewColor').addEventListener('click', addNewColor);

});




function addNewColor() {
	const newColor = document.createElement('li');
	const colorToAdd = document.getElementById('colorPicker').value;
	newColor.setAttribute("id", colorToAdd);
	newColor.innerText = colorToAdd;
	colors.appendChild(newColor);
}


