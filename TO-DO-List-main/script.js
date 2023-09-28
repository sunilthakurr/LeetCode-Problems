// Traversing DOM
// var itemList = document.getElementById('items');
//parent Node
// console.log(itemList.parentNode);
// itemList.parentNode.style.backgroundColor = 'lightgrey';
// console.log(itemList.parentElement);

//Child Nodes
// console.log(itemList.childNodes); //return child nodes as well as text nodes(spaces)
// console.log(itemList.children); // return child nodes only
// itemList.children[1].style.backgroundColor = 'yellow';
// console.log(itemList.nextSibling);
// console.log(itemList.nextElementSibling);


// Events

// function buttonClick() {
//     alert('hello');
// }

// var button = document.querySelector('#btn');
// button.addEventListener('click', addEvent);

// function addEvent(e) {
//     // var item = document.getElementsByClassName('title')
//     // item[1].innerText = 'changed';


// console.log(e);
// console.log(e.target);
// console.log(e.value);
// console.log(e.clientX);
// console.log(e.clientY);
// console.log(e.offsetX);
// console.log(e.offsetY);
// console.log(e.ctrlKey); //while ctrl is pressed or not
// console.log(e.altKey);
// console.log(e.shiftKey);


// }

var form = document.getElementById('addForm');
var button = document.querySelector('#btn');
// form.addEventListener('submit', runEvent); // submit event always works on form
// var i = 1;
// button.addEventListener('click', runEvent);
// button.addEventListener('dblclick', runEvent);
// button.addEventListener('mousedown', runEvent);  //works when mouse btn is clicked
// button.addEventListener('mouseup', runEvent); //works when you release mouse click

function runEvent(e) {
    // e.preventDefault();
    // console.log(i++);

    console.log("Event type : " + e.type); //return event type
}
