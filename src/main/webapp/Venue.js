let url = "http://localhost:9090/venueServlet";
let users = [];
function ListAllVenue() {
  // alert("GET ALL USERS....");
  var xhttp = new XMLHttpRequest();
  xhttp.onreadystatechange = function () {
    if (this.readyState == 4 && this.status == 200) {
      _displayItems(JSON.parse(xhttp.responseText));
      // user.push(JSON.parse(xhttp.responseText));
      console.log(xhttp.responseText);
    }
  };
  xhttp.open("GET", url, true);
  xhttp.send();
}

function _displayItems(data) {
  console.log("display....")
  const tBody = document.getElementById("venuetable");
  tBody.innerHTML = "";
  console.log(tBody)
     const button = document.createElement("button");
    // herf=document.createElement()
  data.forEach((item) => {
       let editbutton=button.cloneNode(false);
       editbutton.innerText="venue";
       editbutton.setAttribute("onclick",`venue(${item.movie_id})`);
      //         let deleteButton = button.cloneNode(false);
      //         deleteButton.innerText = "Delete";
      //         deleteButton.setAttribute("onclick", 'deleteItem(${item.movie_id})');
      let tr = tBody.insertRow();
      let td1 = tr.insertCell(0);
      let venuename = document.createTextNode(item.venue_name);
      td1.appendChild(venuename);
      //colunm 3
      // let td3 = tr.insertCell(2);
      // let movdesc = document.createTextNode(item.description);
      // td3.appendChild(movdesc);
      //colunm 4
      let td2 = tr.insertCell(1);
      let showbutton1=button.cloneNode(false);
      var link=document.createElement("A");
      // link.setAttribute('href',"http://localhost:9090/seats.html");
      link.text=item.show_1
      console.log(link)
      showbutton1.innerText=item.show_1; 
      showbutton1.setAttribute("onclick",`showfun("${item.movie_id}","${item.show_1}")`); 
      td2.appendChild(showbutton1);    
      //COLUNM 3  
      let td3 = tr.insertCell(2);
      let showbutton2=button.cloneNode(false);
      var link=document.createElement("A");
      // link.setAttribute('href',"http://localhost:9090/seats.html");
      link.text=item.show_2
      console.log(link)
      showbutton2.innerText=item.show_2; 
      showbutton2.setAttribute("onclick",`showfun("${item.movie_id}","${item.show_2}")`); 
      td3.appendChild(showbutton2);
      // colunm 4
      let td4 = tr.insertCell(3);
      let showbutton3=button.cloneNode(false);
      var link=document.createElement("A");
      // link.setAttribute('href',"http://localhost:9090/seats.html");
      link.text=item.show_3
      console.log(link)
      showbutton3.innerText=item.show_3; 
      showbutton3.setAttribute("onclick",`showfun("${item.movie_id}","${item.show_3}")`); 
      td4.appendChild(showbutton3);
      //colunm 7
      let td5 = tr.insertCell(4);
      let showbutton4=button.cloneNode(false);
      var link=document.createElement("A");
      // link.setAttribute('href',"http://localhost:9090/seats.html");
      link.text=item.show_4
      console.log(link)
      showbutton4.innerText=item.show_4; 
      showbutton4.setAttribute("onclick",`showfun("${item.movie_id}","${item.show_4}")`); 
      td5.appendChild(showbutton4);
      // //colunm 8
      // let td6 = tr.insertCell(5);
      // td6.appendChild(editbutton);
  });
  movietable = data;
}
function showfun(id,show) {
  console.log(id)
  console.log(show)
   const showobj2={
        movie_id:id,
        show:show

      };
      console.log(showobj2)
    console.log("calling venue...");
    var xhttp=new XMLHttpRequest();
    // xhttp.open("POST","/venueServlet",true);
    // xhttp.setRequestHeader("Content-type", "application/json");
    console.log(JSON.stringify(showobj2));
    // xhttp.send(JSON.stringify(showobj2));
      var url='http://localhost:9090/seats.html';
      window.open(url)
}