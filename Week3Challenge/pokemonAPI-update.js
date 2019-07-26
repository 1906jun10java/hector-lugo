var books=[];

window.onload = function(){
    document.getElementById("pokemon").onclick = function() {
        sendAjaxGet('https://api.pokemontcg.io/v1/cards?name=abra',showCardInfo);
    };

    
    document.getElementById('addB').onclick=function(){
      var newBook=new book(document.getElementById('addTitle').value,document.getElementById('addAuthor').value,
      document.getElementById('addGenre').value,document.getElementById('addCover').value )
    };


    document.getElementById('new').onclick=function(){
        var x=document.getElementById("booklist").childNodes.length-1;
        
        for(i=x;i<books.length;i++){

            if(books[i]===undefined){

            }
            
            else{
            let element=document.createElement('li');
            element.id=i;
            let elementstxt=document.createTextNode(books[i].title);
            
            element.appendChild(elementstxt);
    
            document.getElementById("booklist").appendChild(element);

            element.onclick=function(){
                document.getElementById("itemID").innerText='ID: '+element.id;
                document.getElementById("booktitle").innerText='Title: '+books[element.id].title;
                document.getElementById("authorbook").innerText='Author: '+books[element.id].author;
                document.getElementById("bookgenre").innerText='Genre: '+books[element.id].genre;
                document.getElementById("imgbook").src=books[element.id].coverimage;
                document.getElementById("remove").style.visibility='visible';
                document.getElementById("edit").style.visibility='visible';
            }
        }
        }
    };

    document.getElementById('remove').onclick=function(){
       
        var currentID=document.getElementById("itemID").innerText;
        var node=document.getElementById(currentID);
        node.remove();
        delete books[currentID];
        document.getElementById("itemID").innerText='';
                document.getElementById("booktitle").innerText='';
                document.getElementById("authorbook").innerText='';
                document.getElementById("bookgenre").innerText='';
                document.getElementById("imgbook").src='';
                document.getElementById("remove").style.visibility='hidden';
                document.getElementById("edit").style.visibility='hidden';

    };
    document.getElementById('edit').onclick=function(){
        var currentID=document.getElementById("itemID").innerText;
        var node=document.getElementById(currentID);
        document.getElementById("editPage").style.visibility='visible';
        document.getElementById('editB').onclick=function(){
            books[currentID].title=document.getElementById('edtiTitle').value;
            books[currentID].author=document.getElementById('editAuthor').value;
            books[currentID].genre=document.getElementById('editGenre').value;
            books[currentID].coverimage=document.getElementById('editCover').value;
            document.getElementById("editPage").style.visibility='hidden';

            
        
        }
        
    }
}






function book(title, author, genre, coverimage){
    this.title=title;
    this.author=author;
    this.genre=genre;
    this.coverimage=coverimage;

    addNewBookToArray(this);

}

function addNewBookToArray(book){
    books.push(book);
}




// perform Ajax call
// url represents the resource being requested
// func represents the callback function to be invoked when request is complete
function sendAjaxGet(url, func) {
   
    // step 1: obtain xhr object (Internet Explorer 5,6 don't have it...)
    let xhr = new XMLHttpRequest() || new ActiveXObject("Microsoft.HTTPRequest");
    // step 2: define onreadystatechange
    xhr.onreadystatechange = function() {
       
        // readyState of 4 means request is complete
        // status of 200 means ok
        if (this.readyState == 4 && this.status == 200) {
            func(this);
        }
    }
    // step 3: prepare the request
    xhr.open("GET", url, true);
    // step 4: send the request
    xhr.send(); 
    // IF WE WERE SENDING A POST REQUEST OR ANYTHING THAT USED THE BODY
    // IT WOULD GO AS AN ARGUMENT TO SEND()
}

function showCardInfo(xhr) {
    let pokeOBJ = JSON.parse(xhr.responseText);
    console.log(pokeOBJ);
   document.getElementById("name").innerText="Name: "+pokeOBJ.cards[0].name;
   document.getElementById("number").innerText="Pokedex Number: "+pokeOBJ.cards[0].nationalPokedexNumber;
   document.getElementById("series").innerText="Set: "+pokeOBJ.cards[0].set;
   document.getElementById("img").src=pokeOBJ.cards[1].imageUrlHiRes;
    
}

