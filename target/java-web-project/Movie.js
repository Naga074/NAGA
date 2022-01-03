// let Movies=[];
function getmoviedetails() {
    // alert("GET ALL USERS....");

    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function () {
        console.log("onready...")
        if (this.readyState == 4 && this.status == 200) {
            console.log("if")
            _displayItems(JSON.parse(xhttp.responseText));
            // user.push(JSON.parse(xhttp.responseText));
            console.log(xhttp.responseText);
        }
    };
    xhttp.open("GET", "http://localhost:9090/movieservlet", true);
    xhttp.send();
}
function _displayItems(data) {
    console.log("display....")
    const tBody = document.getElementById("movietable");
    tBody.innerHTML = "";
    console.log(tBody)
       const button = document.createElement("button");
    data.forEach((item) => {
         let editbutton=button.cloneNode(false);
         editbutton.innerText="venue";
         editbutton.setAttribute("onclick",`venue(${item.movie_id})`);
        //         let deleteButton = button.cloneNode(false);
        //         deleteButton.innerText = "Delete";
        //         deleteButton.setAttribute("onclick", 'deleteItem(${item.movie_id})');

        let tr = tBody.insertRow();
        //colunm 1
        // let td1 = tr.insertCell(0);
        // let movid = document.createTextNode(item.movie_id);
        // td1.appendChild(movid);
        // console.log("foreach...");
        //colunm 2
        let td1 = tr.insertCell(0);
        let movname = document.createTextNode(item.movie_title);
        td1.appendChild(movname);
        //colunm 3
        // let td3 = tr.insertCell(2);
        // let movdesc = document.createTextNode(item.description);
        // td3.appendChild(movdesc);
        //colunm 4
        let td2 = tr.insertCell(1);
        let movduration = document.createTextNode(item.duration);
        td2.appendChild(movduration);
        //colunm 5
        let td3 = tr.insertCell(2);
        let movlang = document.createTextNode(item.language);
        td3.appendChild(movlang);
        // colunm 6
        let td4 = tr.insertCell(3);
        let movreleasedate = document.createTextNode(item.relase_date);
        td4.appendChild(movreleasedate);
        //colunm 7
        let td5 = tr.insertCell(4);
        let movcity = document.createTextNode(item.genre);
        td5.appendChild(movcity);
        // //colunm 8
        let td6 = tr.insertCell(5);
        td6.appendChild(editbutton);
    });
    movietable = data;
}
function venue(id) {
    console.log(id)
    
    const objid={
        movie_id:id
    };
    console.log(objid);
    console.log("calling venue...");
    var xhttp=new XMLHttpRequest();
    xhttp.open("POST","/venueServlet",true);
    xhttp.setRequestHeader("Content-type", "application/json");
    console.log(JSON.stringify(objid));
    xhttp.send(JSON.stringify(objid));
    var url='http://localhost:9090/Venue.html';
    window.open(url)
    console.log()

};