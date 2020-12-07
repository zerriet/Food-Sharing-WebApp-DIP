//showing video inside JS file, access video and audio

//const { create } = require("domain");
const socket = io('/') //socket.io basically links script.js to server.js, whenever we reload our page we connect to our server, 
const videoGrid = document.getElementById('video-grid'); //links to video grid in room.ejs, getting reference to video grid
const myVideo = document.createElement('video'); //creates a new video element, our own camera stream links to this element
myVideo.muted = true; //ensures you are not hearing your own voice


const name = prompt('Enter your name:')
const myName = name;
//appendMessage('You joined')
socket.emit('new-user', name)

socket.on('new-user-connected', name => {
    //appendMessage(`${name} connected`)
    PresentToaster(name + ' connected')
  })


const iceServers = [ //public TURN/STUN servers that creates connections for peer to peer communication
    { url: 'stun:stun.l.google.com:19302' },
    { url: "stun:eu-turn4.xirsys.com" },
    {
        url: 'turn:numb.viagenie.ca',
        credential: 'Screwyou1!',
        username: 'zerriet@gmail.com'
    },
    {
        url: 'turn:numb.viagenie.ca',
        credential: 'muazkh',
        username: 'webrtc@live.com'
    },
    {
        url: 'turn:192.158.29.39:3478?transport=udp',
        credential: 'JZEOEt2V3Qb0y27GRntt2u2PAYA=',
        username: '28224511:1379330808'
    },
    {
        url: 'turn:192.158.29.39:3478?transport=tcp',
        credential: 'JZEOEt2V3Qb0y27GRntt2u2PAYA=',
        username: '28224511:1379330808'
    },
    {
        url: 'turn:turn.bistri.com:80',
        credential: 'homeo',
        username: 'homeo'
    },
    {
        url: 'turn:turn.anyfirewall.com:443?transport=tcp',
        credential: 'webrtc',
        username: 'webrtc'
    },
    {
        url: 'turn:13.250.13.83:3478?transport=udp',
        credential: 'YzYNCouZM1mhqhmseWk6',
        username: 'YzYNCouZM1mhqhmseWk6'
    },
    {
        url: 'turn:relay.backups.cz',
        credential: 'webrtc',
        username: 'webrtc'
    },
    {
        url: 'turn:relay.backups.cz?transport=tcp',
        credential: 'webrtc',
        username: 'webrtc'
    },
];


var peer = new Peer({ //creating a new peer on our side, peerJS wraps browser implementation for peer to peer communication
    path: '/peerjs',
    host: '/',
    port: '443',
    config: {
        iceServers: iceServers
    }
    //3030 because local host 3030
});
// change
/*var peer = new Peer({
config: {
iceServers: iceServers
}
}, {
path: '/peerjs',
host: '/',
port: '443' //3030 because local host 3030
}); //create a peer*/
/*var peer = new Peer(undefined, {
    path: '/peerjs',
    host: '/',
    port: '443',
    config: {
        'iceServers': [
            { url: 'stun:stun.l.google.com:19302' }
        ]
    }
}); //create a peer*/


let myVideoStream //video variable
navigator.mediaDevices.getUserMedia({//retrieval on audio and video stream
    video: true,
    audio: true
}).then(stream => { //boardcasting our stream to other users
    myVideoStream = stream;
    console.log(stream.id);
    if (window.location.href.includes('?open=true')) {
        myVideoStream['local45454'] = true;
        stream['local45454'] = true;
    }
    ApplyButtonsCheck();//function that differentiates hosts and participants for donation system
    addVideoStream(myVideo, stream); //adding our local video stream to actual UI so that it is visible

    peer.on('call', call => {//telephone, allows user to retreive my stream while i receive his stream
        call.answer(stream) //default method for peerJS library that sends other users our stream, similar to emitting value
        const video = document.createElement('video')//creating stream element for other user
        call.on('stream', userVideoStream => {
            addVideoStream(video, userVideoStream) //add video stream from other user
        })
    })

    socket.on('user-connected', (userId) => {//references user id generated

        console.log("user connected");//tells our console when a user is connected
        setTimeout(function () {
            connecToNewUser(userId, stream);
        }, 5000)//time needs to be provided for video and audio stream to be given permission, hence the delay

        //connecToNewUser(userId, stream);
    });

    let text = $('input')//creating a test element for our messages

    $('html').keydown((e) => {//shortcut for people to press enter when sending a message
        if (e.which == 13 && text.val().length !== 0) { //only enters key function when enter is pressed
            const data ={
                type: 'chatMessage',
                mData: { message: text.val(), userName: myName }
            }
            socket.emit('message', data); //socket.emit is for sending, socket.io is for receiving
            text.val('') //clears text field once enter is pressed
        }
    });
    $('#submitReviewsBtn').click(function() { //donation submitting, calls the function when the send button is clicked
        $('#alertRef')[0].style.display = 'none';//alert for empty entries
        const pointsVal = $('#pointsLabels').val();
        const donationsVal = $('#donationsLabels').val();//2 input values
        if (!pointsVal && !donationsVal) {
            $('#alertRef')[0].style.display = 'block';
            setTimeout(() => {
                $('#alertRef')[0].style.display = 'none';
            }, 3000);//3 seconds before alert dissapears
            return;
        }
        $('#donationsLabels').val('');
        const data = {
          type: 'ReviewsSubmitted',
          mData: {points: pointsVal, donations: donationsVal, userName: myName}//assigning donation and point values to 1 object
        }
        socket.emit('message', data);
        PresentToaster('Yay! Gift successfully sent. Thank you for your lovely gift!');
        $('#exampleModal').modal('toggle');
    });
    $('#openModalClicked').click(function() {//open modal for donations
        $('#pointsLabels').val('');//references for donation, clears the field from previously once opened
        $('#donationsLabels').val('');
    });

    socket.on('createMessage', data => {
        
        if (data && data.type === 'chatMessage') {
            //console.log('this is coming from server', message) //message comes from the server
            $('.messages').append(`<li class = "message"><b>${data.mData.userName}</b><br/>${data.mData.message}</li>`) // when every message, class message will have user and the message the user sends
            scrollToBottom()
        }
        if (data && data.type === 'ReviewsSubmitted') {//receivers or hosts end
            const { points, donations } = data.mData;
            const newPoints = +$('#PointsCount').html() + (+points);//counter adding our object data
            $('#PointsCount').html(newPoints);
            const newDonations = (+$('#DonationsCount').html()) + (+donations);
            $('#DonationsCount').html('');
            $('#DonationsCount').html(newDonations); //clears field before adding new object
            if (myVideoStream['local45454']) { //local45454 references hosts only
                PresentToaster('New points or donations received by ' + data.mData.userName, true);
            }
        }
        if (data && data.type === 'areYouTutor') { //differentiates between hosts and participants 
            if (window.location.href.includes('?open=true')) {
                const data = {
                    type: 'yesIamTutor',//references for hosts only
                    mData: myVideoStream.id
                }
                socket.emit('message', data);
            }
        }
        if (data && data.type === 'yesIamTutor') {
            var video = document.getElementById(data.mData);//if i am a host, app retrieves and parses my video data
            video.className = 'videoBig'; //assigning video big class
            var grid = $('#video-grid').children();
            const tablerow = $('#' + video.id);//groups videos together
            tablerow.prependTo('#video-grid')[0]; //prepend means attaching to the first element
            // $('#element1').insertAfter($('#element2'));
            // $(`#${video.id}`).insertAfter(`#${grid[0].id}`);
            // $(`#${video.id}`).swap(`#${grid[0].id}`);
            // debugger
        }


    })
}); //get video and audio off chrome, .then accesses the function

//promise is an event in the future that will be resolved or rejected


peer.on('open', id => {//tells a socket that i am connecting to this persons id
    //console.log(id);
    socket.emit('join-room', ROOM_ID, id);
});

//socket.emit('join-room', ROOM_ID); //emit room, takes reference from constant variabale ROOM_ID in room.ejs

/*socket.on('user-connected', (userId) => {
    connecToNewUser(userId, stream);
});*/

const connecToNewUser = (userId, stream) => {//for participants only
    //console.log(userId); //informs when a new user has connected
    const call = peer.call(userId, stream) //call user id, send him my stream, and I will recieve his stream
    const video = document.createElement('video')
    call.on('stream', userVideoStream => { //adding others video stream
        addVideoStream(video, userVideoStream) //other persons stream
        const data ={
            type: 'areYouTutor',
            mData: ''
        }
        socket.emit('message', data);//function for transferring any form of data
    })
};// other persons stream

function PresentToaster(message, info) { //applies toaster, generic functionality
    // $('button').click(function () {
    //     $('.toast').stop().fadeIn(400).delay(3000).fadeOut(500); //fade out after 3 seconds
    // });
    
    // $('.toast').stop().fadeIn(400).delay(3000).fadeOut(500);
    var priority = info ? 'info' : 'success';//color of toaster
    var title    = 'Success';
    $.toaster({ priority : priority, title : title, message : message });//providing values to our toaster
}

function ApplyButtonsCheck() {//differentiate for donation functionality
    if (myVideoStream['local45454']) {
        $('#pCheck')[0].style.display = 'block'; //donation and points for hosts
        $('#dCheck')[0].style.display = 'block';
    } else {
        $('#openModalClicked')[0].style.display = 'block'; //open modal for non hosts
    }
}
function addVideoStream(video, stream) {//my screen
    video.srcObject = stream;
    video.id = stream.id;
    video.addEventListener('loadedmetadata', () => {
        video.play();
    })
    if (stream['local45454']) {
        console.log('Is Tutor');
        video.className = 'videoBig';
    } else {
        video.className = 'videoSmall';
    }
    videoGrid.append(video);
} // this function is responsible for outputting my vdeo display or stream



/*let text = $('input')

$('html').keydown((e)  =>{
    if(e.which == 13 && text.val().length !==0) { //only enters key function when enter is pressed
        console.log(text.val())
        socket.emit('message', text.val()); //socket.emit is for sending, socket.io is for receiving
        text.val('') //clears text field once enter is pressed
    }
});

socket.on('createMessage', message =>{
    //console.log('this is coming from server', message) //message comes from the server
    $('ul').append(`<li class = "message"><b>user</b><br/>${message}</li>`) // when every message, class message will have user and the message the user sends
})*/

const scrollToBottom = () => { //function that allows chat to autoscroll downwards during overflow
    var d = $('.main__chat_window');
    d.scrollTop(d.prop("scrollHeight"))

}

//add a function for stop and mute buttons

//Mute our video
const muteUnmute = () => {
    console.log(myVideoStream)
    const enabled = myVideoStream.getAudioTracks()[0].enabled; //get current enabled audo track
    if (enabled) {
        myVideoStream.getAudioTracks()[0].enabled = false; //set audio to false
        setUnmuteButton(); //button icon changes depending on mute or unmute
    } else {
        setMuteButton();
        myVideoStream.getAudioTracks()[0].enabled = true;
    }
}
const CopyLinkToMeeting = () => {
    let nUrl = '';
    nUrl = window.location.href.split('?')[0] + '?open=false'; //whenever you press copy, it will always append = false
    const textArea = document.createElement('textarea');
    textArea.style.visibility = 'none';
    textArea.value = nUrl;
    document.body.appendChild(textArea);
    textArea.select(); //taking reference to our url
    textArea.setSelectionRange(0, 99999);
    document.execCommand('copy'); //if you want to copy anything, this is the default comand
    textArea.remove(); //once we copy, remove dummy element
    document.getElementById('copyBtn').innerHTML = 'Copied';
    setTimeout(() => {
        document.getElementById('copyBtn').innerHTML = 'Copy';
    }, 4000); //whenever we press copy, button changes to copied before reverting back
}

const setMuteButton = () => {
    const html = `
    <img src="https://img.icons8.com/color/48/000000/silenced.png"/>
    <span>Mute</span>
    `
    document.querySelector('.main__mute_button').innerHTML = html;
}

const setUnmuteButton = () => {
    const html = `
    <img src="https://img.icons8.com/color/48/000000/user-male.png"/>
    <span>Unmute</span>
    `
    document.querySelector('.main__mute_button').innerHTML = html;
}

const playStop = () => {
    //console.log(myVideoStream)
    let enabled = myVideoStream.getVideoTracks()[0].enabled;
    if (enabled) {
        myVideoStream.getVideoTracks()[0].enabled = false;
        setPlayVideo() //if video is enabled, disable
    } else {
        setStopVideo()
        myVideoStream.getVideoTracks()[0].enabled = true; //if video is disabled, enable video
    }
}

const setStopVideo = () => { //both setPlay
    const html = `
    <img src="https://img.icons8.com/color/48/000000/reviewer-male--v1.png"/>
    <span>Stop Video</span>
    `

    document.querySelector('.main__video_button').innerHTML = html;


}


const setPlayVideo = () => {
    const html = `
    <img src="https://img.icons8.com/color/48/000000/facepalm.png"/>
    <span>Play Video</span>
    `
    document.querySelector('.main__video_button').innerHTML = html;
}

