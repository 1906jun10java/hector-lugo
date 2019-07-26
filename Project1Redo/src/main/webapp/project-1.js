
window.onload = function(){
    
    sendAjaxGet('http://localhost:8082/Project1/session',getBasicInfo);

    document.getElementById('seePendingRequest').onclick=function(){
        document.getElementById('pendingR').style.display='block';
        sendAjaxGet('http://localhost:8082/Project1/pending?userID='+globalID,getPendingList);
    };


    document.getElementById('resolvedButton').onclick=function(){
        document.getElementById('a-r-r').style.display='block';
        sendAjaxGet('http://localhost:8082/Project1/resolved?userID='+globalID,getMyResolved);
    };

    document.getElementById('closeMyResolvedRequest').onclick=function(){
        document.getElementById('a-r-r').style.display='none';
       
    };



    document.getElementById('seeMyEmployees').onclick=function(){
        document.getElementById('myEmployeeTable').style.display='block';
        sendAjaxGet('http://localhost:8082/Project1/employeeList',getMyEmployeeList);



    }
    document.getElementById('seeAddress').onclick=function(){
        document.getElementById('userUpdateAddress').style.display='block';
        
    }

    document.getElementById('closeAddress').onclick=function(){
        document.getElementById('userUpdateAddress').style.display='none';
        
    }



    document.getElementById('seeEmail').onclick=function(){
        document.getElementById('userUpdateEmail').style.display='block';
        
    }

    document.getElementById('closeEmail').onclick=function(){
        document.getElementById('userUpdateEmail').style.display='none';
        
    }


    document.getElementById('seePassword').onclick=function(){
        document.getElementById('userUpdatePassword').style.display='block';
        
    }

    document.getElementById('closePassword').onclick=function(){
        document.getElementById('userUpdatePassword').style.display='none';
        
    }


    document.getElementById('seeMakeRequest').onclick=function(){
        document.getElementById('updateRequest').style.display='block';
        
    }

    document.getElementById('closeMakeRequest').onclick=function(){
        document.getElementById('updateRequest').style.display='none';
        
    }
/*
    document.getElementById('seePendingRequest').onclick=function(){
        document.getElementById('pendingR').style.display='block';
        
    }
*/
    document.getElementById('closePendingRequest').onclick=function(){
        document.getElementById('pendingR').style.display='none';
        
    }


    

   













  

    document.getElementById('hideMyEmployees').onclick=function(){
        document.getElementById('myEmployeeTable').style.display='none';
        
    }



    


    document.getElementById('hideAllEmployees').onclick=function(){
        document.getElementById('allEmployeeTable').style.display='none';
        
    }

    document.getElementById('hideemployee detailed info').onclick=function(){
        document.getElementById('employeeRequestDetails').style.display='none';
        document.getElementById('myEmployeependingR').style.display='none';
        
    }
    document.getElementById('show detailed info').onclick=function(){
        document.getElementById('employeeRequestDetails').style.display='block';
        document.getElementById('myEmployeependingR').style.display='block';
        
    }







    document.getElementById('seeAllEmpl').onclick=function(){
        document.getElementById('allEmployeeTable').style.display='block';
        document.getElementById('myEmployeependingR').style.display='block';
        sendAjaxGet('http://localhost:8082/Project1/allEmployees',allEmployees);
    }



    document.getElementById('hideAllEmployees').onclick=function(){
        document.getElementById('allEmployeeTable').style.display='none';
        
    }

    document.getElementById('allResolved').onclick=function(){
        document.getElementById('allRRequests').style.display='block';
        sendAjaxGet('http://localhost:8082/Project1/allResolved',getAllResolved);
    }

    document.getElementById('closeAllResolvedRequest').onclick=function(){
        document.getElementById('allRRequests').style.display='none';
        
    }



    document.getElementById('AcceptRequest').onclick=function(){
       
        sendAjaxGet('http://localhost:8082/Project1/updateRequest?status=1&rID='+requestID,requestUpdateAccepted);
    }

    document.getElementById('RejectRequest').onclick=function(){
        sendAjaxGet('http://localhost:8082/Project1/updateRequest?status=-1&rID='+requestID,requestUpdateAccepted);
    }
}

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
}
var globalID;

function getBasicInfo(xhr) {
    
    let basicInfo = JSON.parse(xhr.responseText);
    globalID=basicInfo.employeeID;
    console.log(basicInfo);
    
    if(basicInfo.session===null){
        window.location = "http://localhost:8082/Project1/login"
    }
    else{
        if(basicInfo.isManager===1){
            document.getElementById('managerStuff').style.display="block";
        }
    
    document.getElementById('employeeID').innerText="ID: "+basicInfo.employeeID;
    document.getElementById('managerName').innerText="Your manager is: "+basicInfo.managerName;
    document.getElementById('address').innerText="Address: "+basicInfo.address;
    document.getElementById('name').innerText="Hello "+basicInfo.name;
    document.getElementById('email').innerText="Email: "+basicInfo.email;
    document.getElementById('address').onclick=function(){
        document.getElementById('changeAddress').style.display="block";
        
    }

    

    
    }
    
}

var counter=0;


function getPendingList(xhr) {
    
    let pendingList = JSON.parse(xhr.responseText);
    
    console.log(pendingList);
    let p=document.getElementById("pendingR");
    let c=p.lastChild;
    while(c){
        p.removeChild(c);
        c=p.lastChild;
    }
    
    for(i=0;i<pendingList.length;i++){
        let currentID=pendingList[i].rID;
        if(pendingList[i]===undefined){
        }
        
        else{
        

        let element=document.createElement('li');
        element.className="list-group-item";
        element.id='pendingListElement '+i;
        let elementstxt=document.createTextNode('Pending offer# '+pendingList[i].rID+
        '------Amount Requested: '+pendingList[i].ammount);
        element.appendChild(elementstxt);
        document.getElementById("pendingR").appendChild(element);
        let x=document.createElement('div');
        
        element.appendChild(x);

        element.onclick=function (){
            counter++
            x.id="imgDiv"+counter;
            let p=x
        let c=p.lastChild;
         while(c){
        p.removeChild(c);
        c=p.lastChild;
    }
           
           makeImgButtons(x,currentID);

        }
        
    }
    }

   

    
    
}

function getMyResolved(xhr) {
    
    let pendingList = JSON.parse(xhr.responseText);
    
    console.log(pendingList);
    let p=document.getElementById("a-r-r");
    let c=p.lastChild;
    while(c){
        p.removeChild(c);
        c=p.lastChild;
    }
    
    for(i=0;i<pendingList.length;i++){
        let currentID=pendingList[i].rID;
        if(pendingList[i]===undefined){
        }
        
        else{
        
        let element=document.createElement('li');
        element.className="list-group-item";
        element.id='pendingListElement '+i;
            if(pendingList[i].status==1){
             let elementstxt=document.createTextNode('Accepted offer# '+pendingList[i].rID+
                '------Amount Requested: '+pendingList[i].ammount+'');
                element.appendChild(elementstxt);
            }
            else if(pendingList[i].status==-1){
                let elementstxt=document.createTextNode('Rejected offer# '+pendingList[i].rID+
                '------Amount Requested: '+pendingList[i].ammount);
                element.appendChild(elementstxt);
            }
        
        


        document.getElementById("a-r-r").appendChild(element);
        let x=document.createElement('div');
        x.id="imgDiv"+currentID;
        element.appendChild(x);

        element.onclick=function (){
            counter++
            x.id="imgDiv"+counter;

            let p=x
        let c=p.lastChild;
         while(c){
        p.removeChild(c);
        c=p.lastChild;
    }
           
           makeImgButtons(x,currentID);

        }
        
    }
    }
}

function getAllResolved(xhr) {
    
    let pendingList = JSON.parse(xhr.responseText);
    
    console.log(pendingList);
    let p=document.getElementById("allRRequests");
    let c=p.lastChild;
    while(c){
        p.removeChild(c);
        c=p.lastChild;
    }
    
    for(i=0;i<pendingList.length;i++){
       let currentID=pendingList[i].rID;
        if(pendingList[i]===undefined){
        }
        
        else{


        let element=document.createElement('li');
        element.className="list-group-item";
        element.id='pendingListElement '+i;
            if(pendingList[i].status==1){
                let elementstxt=document.createTextNode('Accepted offer# '+pendingList[i].rID+
                '------Amount Requested: '+pendingList[i].ammount+'------------Made by '+pendingList[i].employeeName+
                '---------------Resolved by '+pendingList[i].managerName);
                element.appendChild(elementstxt);
            }
            else if(pendingList[i].status==-1){
                let elementstxt=document.createTextNode('Accepted offer# '+pendingList[i].rID+
                '------Amount Requested: '+pendingList[i].ammount+'------------Made by '+pendingList[i].employeeName+
                '---------------Resolved by '+pendingList[i].managerName);
                element.appendChild(elementstxt);
            }
        
            p.appendChild(element);


            let x=document.createElement('div');
            
            element.appendChild(x);
    
            element.onclick=function (){
                counter++
                x.id="imgDiv"+counter;
                let p=x
            let c=p.lastChild;
             while(c){
            p.removeChild(c);
            c=p.lastChild;
        }
               
               makeImgButtons(x,currentID);
    
            }
            
        }
        }
    }
function allEmployees(xhr){
   
        let employeeList = JSON.parse(xhr.responseText);
    
        document.getElementById('allEmployeeTable').style.display="block"
        console.log(employeeList);
    
       
    
        let p=document.getElementById("tbodyAll");
        let c=p.lastChild;
        while(c){
            p.removeChild(c);
            c=p.lastChild;
        }
        console.log(employeeList.length);
        for(i=0;i<employeeList.length;i++){
            let trElement=document.createElement('tr');
            
            trElement.id='AllEmployeeRow '+i;
    
            document.getElementById("tbodyAll").appendChild(trElement);
            
            let tdName=document.createElement('td');
            tdName.appendChild(document.createTextNode(employeeList[i].name));
            document.getElementById(trElement.id).appendChild(tdName);
    
            let tdID=document.createElement('td');
            tdID.appendChild(document.createTextNode(employeeList[i].managerName));
            document.getElementById(trElement.id).appendChild(tdID);
    
            let tdAddress=document.createElement('td');
            tdAddress.appendChild(document.createTextNode(employeeList[i].email));
            document.getElementById(trElement.id).appendChild(tdAddress);
}
}


function getMyEmployeeList(xhr) {
    let employeeList = JSON.parse(xhr.responseText);

    document.getElementById('myEmployeeTable').style.display="block"
    

   

    let p=document.getElementById("tbody");
    let c=p.lastChild;
    while(c){
        p.removeChild(c);
        c=p.lastChild;
    }
    for(i=0;i<employeeList.length;i++){
        let trElement=document.createElement('tr');
        let currentID=employeeList[i].employeeID;
        trElement.id='EmployeeRow '+i;

        document.getElementById("tbody").appendChild(trElement);
        
        let tdName=document.createElement('td');
        tdName.appendChild(document.createTextNode(employeeList[i].name));
        document.getElementById(trElement.id).appendChild(tdName);

        let tdID=document.createElement('td');
        tdID.appendChild(document.createTextNode(employeeList[i].employeeID));
        document.getElementById(trElement.id).appendChild(tdID);

        let tdAddress=document.createElement('td');
        tdAddress.appendChild(document.createTextNode(employeeList[i].address));
        document.getElementById(trElement.id).appendChild(tdAddress);

        let tdPending=document.createElement('td');
        tdPending.appendChild(document.createTextNode('Pending Requests'));
        document.getElementById(trElement.id).appendChild(tdPending);
        tdPending.onclick=function(){

            document.getElementById("myEmployeependingR").display="block"
            sendAjaxGet('http://localhost:8082/Project1/pending?userID='+currentID,getMyEmployeePendingList);
        }

        

        }
    }

    var requestID;

    function getMyEmployeePendingList(xhr){
        let employeeRequests = JSON.parse(xhr.responseText);
        console.log(employeeRequests);
        

        let p=document.getElementById("myEmployeependingR");
        let c=p.lastChild;
        while(c){
        p.removeChild(c);
        c=p.lastChild;
    }
        

        document.getElementById('individualEmployee').style.disply="block"

        

        for(i=0;i<employeeRequests.length;i++){
            currentID=employeeRequests[i].rID;

            if(employeeRequests[i]===undefined){
            }
            
            else{
            let element=document.createElement('li');
            element.className="list-group-item"
            element.id='employeePendingListElement '+employeeRequests[i].rID;
            let elementstxt=document.createTextNode('Pending offer# '+employeeRequests[i].rID+
            '------Amount Requested: '+employeeRequests[i].ammount);
            element.appendChild(elementstxt);
            document.getElementById("myEmployeependingR").appendChild(element);
            let currentID=employeeRequests[i].rID;


           
                let x=document.createElement('div');
            
            
                
              element.appendChild(x);
              element.onclick=function(){
                requestID=currentID;
                counter++
                x.id="imgDiv"+counter;
                document.getElementById('employeeRequestDetails').style.display="block";
                document.getElementById('hideemployee detailed info').style.display="block";

                let p=x
                let c=p.lastChild;
                 while(c){
                p.removeChild(c);
                c=p.lastChild;
            }
                   
                   makeImgButtons(x,currentID);

            }
            
        }
        }

    }


    



function requestUpdateAccepted(){
    document.getElementById('employeeRequestDetails').style.visibility='hidden'
}

function makeImgButtons(parentElementWithId,currentID){
    let imgB=document.createElement('input');
    imgB.type="submit";
    imgB.value="See Img";
    imgB.className="btn btn-outline-dark";
    element=document.getElementById("imgDiv"+counter);
    element.appendChild(imgB);
    imgB.onclick=function(){
        requestID=currentID;
        sendAjaxGet('http://localhost:8082/Project1/img?rID='+requestID,imgButtonFunction)
    }



}

function imgButtonFunction(xhr){
    let imgJson = JSON.parse(xhr.responseText);

   img= document.createElement("img");

   if(imgJson.charAt(0)==='/'){
    img.src="data:image/jpg;base64,"+imgJson
   }
   else if(imgJson.charAt(0)==='i'){
    img.src="data:image/png;base64,"+imgJson
   }
   else if(imgJson.charAt(0)==='R'){
    img.src="data:image/gif;base64,"+imgJson
   }
   else if(imgJson.charAt(0)==='U'){
    img.src="data:image/webp;base64,"+imgJson
   }
   let x=document.getElementById("imgDiv"+counter
   );
   console.log(x);
   x.appendChild(img);
}

