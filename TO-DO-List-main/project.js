var form = document.getElementById('addForm');
var itemList = document.getElementById('items');



form.addEventListener('submit', addEvent);
itemList.addEventListener('click', removeEvent);

function addEvent(e) {
    e.preventDefault();
    var item = document.getElementById('item').value;

    var newItem = document.createElement('li');
    newItem.className = 'list-group-item';
    newItem.appendChild(document.createTextNode(item));

    var deletebtn = document.createElement('button');
    deletebtn.className = 'btn btn-danger btn-sm float-right delete';
    deletebtn.appendChild(document.createTextNode('X'));
    newItem.appendChild(deletebtn);

    itemList.appendChild(newItem);
    item.value = "";
}

function removeEvent(e) {
    if (e.target.classList.contains('delete')) {
        if (confirm('delete karna hai?')) {
            var li = e.target.parentElement;
            itemList.removeChild(li);
        }
    }
}


function myFunction() {
    var input, filter, ul, li, a, i, textValue;
    input = document.getElementById('filter');
    filter = input.value.toUpperCase();
    ul = document.getElementById('items');
    li = ul.getElementsByTagName('li');

    for (i = 0; i < li.length; i++) {
        textValue = li[i].textContent || li[i].innerText;
        console.log(textValue);
        if (textValue.toUpperCase().includes(filter)) {
            li[i].style.display = "";
        } else {
            li[i].style.display = "none";
        }
    }
}
