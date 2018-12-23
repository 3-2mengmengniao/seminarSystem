var stompClient = null;

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
    var socket = new SockJS('/gs-guide-websocket');
    stompClient = Stomp.over(socket);
    stompClient.connect({}, function (frame) {
        setConnected(true);
        console.log('Connected: ' + frame);
        stompClient.subscribe('/topic/addQuestion', function (greeting) {
            showGreeting(greeting);
        });
        stompClient.subscribe('/topic/addQuestion', function (greeting) {
            showNext();
        });
        stompClient.subscribe('/topic/selectQuestion', function (greeting) {
            showGreeting("提问中");
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
    stompClient.send("/app/QA", {}, JSON.stringify({'teamId': $("#teamId").attr("name"),"seminarId": $("#seminarId").attr("name")}));
}

function nextGroup() {
    stompClient.send("/app/nextGroup", {}, JSON.stringify({"seminarId": $("#seminarId").attr("name")}));
}

function selectQuestion() {
    stompClient.send("/app/selectQuestion", {}, JSON.stringify({"seminarId": $("#seminarId").attr("name")}));
}

function showGreeting(message) {
    $("#greetings").html(message);
}

function showNext() {
    var currentLi=$('tr.group').filter('.active').next();
    $(currentLi).addClass('active');
    $(currentLi).siblings().removeClass('active');
}

$(function () {
    connect();
    $("form").on('submit', function (e) {
        e.preventDefault();
    });
    $( "#connect" ).click(function() { connect(); });
    $( "#disconnect" ).click(function() { disconnect(); });
    $( "#QAbutton" ).click(function() { sendQuestion(); });
    $( "#restart" ).click(function() { nextGroup(); });
    $( "#select" ).click(function() { selectQuestion(); });
});