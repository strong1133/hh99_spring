$(document).ready(function(){
    backHome()
})

function backHome(){
    $('#home').on('click', function (){
        window.location.href = "/"
    })
}