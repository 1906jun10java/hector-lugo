
window.onload = function(){
    
        sendAjaxGet('http://localhost:8082/Project1/session',getBasicInfo);

        document.getElementById('pendingButton').onclick=function(){
            sendAjaxGet('http://localhost:8082/Project1/pending?userID='+globalID,getPendingList);
        };
        document.getElementById('seeMyEmployees').onclick=function(){
            sendAjaxGet('http://localhost:8082/Project1/employeeList',getMyEmployeeList);
        }
        document.getElementById('hideMyEmployees').onclick=function(){
            document.getElementById('myEmployeeTable').style.visibility='hidden';
            document.getElementById('individualEmployee').style.visibility='hidden';
            document.getElementById('employeeRequestDetails').style.visibility='hidden';
        }
        document.getElementById('AcceptRequest').onclick=function(){
            sendAjaxGet('http://localhost:8082/Project1/updateRequest?status=1&rID='+requestID,requestUpdateAccepted);
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
        
        }
        
    }

    function getPendingList(xhr) {
        
        let pendingList = JSON.parse(xhr.responseText);
        
        console.log(pendingList);
        
        let x=document.getElementById("pendingR").childNodes.length-1;
        for(i=x;i<pendingList.length;i++){

            if(pendingList[i]===undefined){
            }
            
            else{
            let element=document.createElement('li');
            element.id='pendingListElement '+i;
            let elementstxt=document.createTextNode('Pending offer# '+pendingList[i].rID+
            '------Amount Requested: '+pendingList[i].ammount);
            element.appendChild(elementstxt);
            document.getElementById("pendingR").appendChild(element);

            
        }
        }
        
        
    }

    function getMyEmployeeList(xhr) {
        let employeeList = JSON.parse(xhr.responseText);

        document.getElementById('myEmployeeTable').style.visibility='visible'
        console.log(employeeList);

        let x=document.getElementById("tbody").childNodes.length-1;

        for(i=x;i<employeeList.length;i++){
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
            let curretnID=employeeRequests[i].rID;
            document.getElementById('individualEmployee').style.visibility='visible'

            let x=document.getElementById("myEmployeependingR").childNodes.length-1;

            for(i=x;i<employeeRequests.length;i++){
                let currentOfferID=employeeRequests[i].rID;
                if(employeeRequests[i]===undefined){
                }
                
                else{
                let element=document.createElement('li');
                element.id='employeePendingListElement '+i;
                let elementstxt=document.createTextNode('Pending offer# '+employeeRequests[i].rID+
                '------Amount Requested: '+employeeRequests[i].ammount);
                element.appendChild(elementstxt);
                document.getElementById("myEmployeependingR").appendChild(element);
                element.onclick=function(){
                    document.getElementById('employeeRequestDetails').style.visibility='visible'

                }
                
            }
            }

        }
    



    
