var stompClient = null;
var send=false;
var user=$('#usertype').attr("name");

function setConnected(connected) {
    $("#connect").prop("disabled", connected);
    $("#disconnect").prop("disabled", !connected);
    if (connected) {
        $("#conversation").show();
    }
    else {
        $("#conversation").hide();
    }
    $("#greetings").html("");
}

function connect() {
    var socket = new SockJS('/queueServer');
    stompClient = Stomp.over(socket);
    stompClient.connect({}, function (frame) {
        setConnected(true);
        if(send===false)
        {
            stompClient.send("/app/buildRoom", {}, JSON.stringify({"seminarId": $("#seminarId").attr("name")}));
            send=true;
        }
        console.log('Connected: ' + frame);
        stompClient.subscribe('/user/'+$("#seminarId").attr("name")+'/addQuestion', function (greeting) {
            console.log("enter");
            console.log(greeting);
            showGreeting(greeting);
        });
        stompClient.subscribe('/user/'+$("#seminarId").attr("name")+'/nextGroup', function (greeting) {
            if(user=="student")
            {
                showNext();
            }
        });
        stompClient.subscribe('/user/'+$("#seminarId").attr("name")+'/selectQuestion', function (greeting) {
            showGreeting("提问中");
        });
        stompClient.subscribe('/user/'+$("#seminarId").attr("name")+'/endSeminar', function (greeting) {
            if(user=="student")
            {
                endFunction();
            }
        });
    });
}

function disconnect() {
    if (stompClient !== null) {
        stompClient.disconnect();
    }
    setConnected(false);
    console.log("Disconnected");
}

function sendQuestion() {
    stompClient.send("/app/QA", {}, JSON.stringify({'studentId': $("#studentId").attr("name"),'teamId': $("#teamId").attr("name"),"seminarId": $("#seminarId").attr("name")}));
}

function endSeminar() {
    stompClient.send("/app/endSeminar", {}, JSON.stringify({"seminarId": $("#seminarId").attr("name")}));
}

function nextGroup() {
    stompClient.send("/app/nextGroup", {}, JSON.stringify({"seminarId": $("#seminarId").attr("name")}));
}

function selectQuestion() {
    stompClient.send("/app/selectQuestion", {}, JSON.stringify({"seminarId": $("#seminarId").attr("name")}));
}

function endFunction() {
    window.location.href="/student/course/seminar/score?seminarId="+$("#seminarId").attr("name");
}

function showGreeting(message) {
    console.log(message.body);
    $("#greetings").html(message.body);
}

function showNext(){
    var currentTr=$('tr.group').filter('.active').next();
    var groupIndex= $(currentTr).index();
    var allTr= $('tr.group');
    $(allTr).eq(groupIndex).addClass('active');
    $(allTr).eq(groupIndex).siblings().removeClass('active');
    window.location.reload();
}

    connect();
    $("form").on('submit', function (e) {
        e.preventDefault();
    });

