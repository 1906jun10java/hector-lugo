
window.onload = function(){
    
    sendAjaxGet('http://localhost:8082/Project1/session',getBasicInfo);

    document.getElementById('pendingButton').onclick=function(){
        sendAjaxGet('http://localhost:8082/Project1/pending?userID='+globalID,getPendingList);
    };


    document.getElementById('resolvedButton').onclick=function(){
        sendAjaxGet('http://localhost:8082/Project1/resolved?userID='+globalID,getMyResolved);
    };



    document.getElementById('seeMyEmployees').onclick=function(){
        sendAjaxGet('http://localhost:8082/Project1/employeeList',getMyEmployeeList);
    }
    document.getElementById('hideMyEmployees').onclick=function(){
        document.getElementById('myEmployeeTable').style.visibility='hidden';
        
    }

    document.getElementById('seeAllEmpl').onclick=function(){
        sendAjaxGet('http://localhost:8082/Project1/allEmployees',allEmployees);
    }

    document.getElementById('hideAllEmployees').onclick=function(){
        document.getElementById('allEmployeeTable').style.visibility='hidden';
        
    }

    document.getElementById('allResolved').onclick=function(){
        sendAjaxGet('http://localhost:8082/Project1/allResolved',getAllResolved);
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
            document.getElementById('managerStuff').style.visibility='visible';
        }
    
    document.getElementById('employeeID').innerText="ID: "+basicInfo.employeeID;
    document.getElementById('managerName').innerText="Your manager is: "+basicInfo.managerName;
    document.getElementById('address').innerText="Address: "+basicInfo.address;
    document.getElementById('name').innerText="Hello "+basicInfo.name;
    document.getElementById('email').innerText="Email: "+basicInfo.email;
    document.getElementById('address').onclick=function(){
        document.getElementById('changeAddress').style.visibility='visible';
        
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

        if(pendingList[i]===undefined){
        }
        
        else{
        let currentID=pendingList[i];

        let element=document.createElement('li');
        element.id='pendingListElement '+i;
        let elementstxt=document.createTextNode('Pending offer# '+pendingList[i].rID+
        '------Amount Requested: '+pendingList[i].ammount);
        element.appendChild(elementstxt);
        document.getElementById("pendingR").appendChild(element);
        let x=document.createElement('div');
        
    }
    }

    function produceImgSeeHideButtons(currentid,parent){
       let imgB= document.createElement("input");
       imgB.value="img";
     

       let closeB= document.createElement("input");
       imgB.value="close";

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

        if(pendingList[i]===undefined){
        }
        
        else{
        
        let element=document.createElement('li');
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

        if(pendingList[i]===undefined){
        }
        
        else{


        let element=document.createElement('li');
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
        
       


        document.getElementById("allRRequests").appendChild(element);

        
    }
    }
    
}

function allEmployees(xhr){
   
        let employeeList = JSON.parse(xhr.responseText);
    
        document.getElementById('allEmployeeTable').style.visibility='visible'
        console.log(employeeList);
    
       
    
        let p=document.getElementById("tbodyAll");
        let c=p.lastChild;
        while(c){
            p.removeChild(c);
            c=p.lastChild;
        }
        for(i=0;i<employeeList.length;i++){
            let trElement=document.createElement('tr');
            
            trElement.id='EmployeeRow '+i;
    
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

    document.getElementById('myEmployeeTable').style.visibility='visible'
    console.log(employeeList);

   

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
        

        document.getElementById('individualEmployee').style.visibility='visible'

        let x=document.getElementById("myEmployeependingR").childNodes.length-1;

        for(i=x;i<employeeRequests.length;i++){
            
            if(employeeRequests[i]===undefined){
            }
            
            else{
            let element=document.createElement('li');
            element.id='employeePendingListElement '+employeeRequests[i].rID;
            let elementstxt=document.createTextNode('Pending offer# '+employeeRequests[i].rID+
            '------Amount Requested: '+employeeRequests[i].ammount);
            element.appendChild(elementstxt);
            document.getElementById("myEmployeependingR").appendChild(element);
            let currentID=employeeRequests[i].rID;
            element.onclick=function(){
                requestID=currentID;
                document.getElementById('employeeRequestDetails').style.visibility='visible'

            }
            
        }
        }

    }


function requestUpdateAccepted(){
    document.getElementById('employeeRequestDetails').style.visibility='hidden'
}

