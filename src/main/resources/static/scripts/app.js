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
        comeIn();
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
            showNotation(greeting);
        });
        stompClient.subscribe('/user/'+$("#seminarId").attr("name")+'/selectQuestion', function (question) {
            console.log(question);
                selectQ(question);

        });
        stompClient.subscribe('/user/'+$("#seminarId").attr("name")+'/endSeminar', function (greeting) {
            if(user=="student")
            {
                endFunction();
            }
        });
    });
}

function selectQ(question){
    var q=JSON.parse(question.body);
    var teamId=q.teamId;
    var classSerial=q.courseClassSerial;
    var teamSerial=q.teamSerial;
    var studentName=q.studentName;
    var qid=q.id;
    var greeting=classSerial+"-"+teamSerial+"&nbsp&nbsp"+studentName+"正在提问";
    showNotation(greeting);
    outputScore=	"<tr>\n"+
        "\t\t<td style=\"padding:0 10px;\">\n"+
        "\t\t\t\t<a style=\"font-size:17px;margin-top:-30px;\">"+classSerial+"-"+teamSerial+"&nbsp;"+studentName+"</a>\n"+
        "\t\t</td>\n"+
        " \t\t<td style=\"padding:0 10px;\">\n"+
        " \t\t\t\t<div class=\"form-group floating-control-group formFieldWrap\">\n"+
        "\t\t\t\t\t\t<form class=\"form-group floating-control-group formFieldWrap\" method=\"post\" action=\"/teacher/course/seminar/questionScore?questionId="+qid+"\" target='frame2'>"+
        " \t\t\t\t\t\t<input style=\"margin-bottom:3px;font-size:15px;padding-top:10px;\" type=\"text\" name='score' autocomplete=\"off\" class=\"my-form-control contactField requiredField\"  placeholder=\"请输入成绩 \">\n"+
        "\t\t\t\t\t\t<input type=\"submit\" style=\"border:none;background:none;z-index: 9999;width:27px;top:-35px;right:-40%;cursor:pointer;\">\n"+
        " \t\t\t\t</form><iframe name=\"frame2\" frameborder=\"0\" id=\"frame2\" style=\"display: none;\"></iframe>\n"+
        " \t\t\t\t</div>\n"+
        "\t\t</td>\n"+
        "</tr>";
    var allDiv= $('div.group');
    var groupIndex=$('li.group').filter('.active').index();
    $("table.append-col").eq(groupIndex).append(outputScore);
    $.each($(allDiv),function(){
        if($(this).index()<groupIndex){
            var divHeight=$(this).height();
            // alert(divHeight);
            $(this).css('margin-top','-'+divHeight+'px');
        }
        if($(this).index()>groupIndex){
            var divHeight=$(this).height()-20;
            // alert(divHeight);
            $(this).css('margin-top','-'+divHeight+'px');
        }
    })
};

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

function comeIn(){
    stompClient.send("/app/welcome", {}, JSON.stringify({"seminarId": $("#seminarId").attr("name")}));
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

function showNotation(message) {
    console.log(message.body);
    $("#notation").html(message.body);
}

function showNext(){
    // var currentTr=$('tr.group').filter('.active').next();
    // var groupIndex= $(currentTr).index();
    // var allTr= $('tr.group');
    // $(allTr).eq(groupIndex).addClass('active');
    // $(allTr).eq(groupIndex).siblings().removeClass('active');
    window.location.reload();
}


    connect();
    $("form").on('submit', function (e) {
        e.preventDefault();
    });

