$(document).ready(function(){
    backHome()
})

function backHome(){
    $('#home').on('click', function (){
        window.location.href = "/"
    })
}

function getDetail(){
    $.ajax({
        type:'GET',
        url:'/api/articles/{id}',
        success: function (response){
            for(let i=0; i<response.length; i++){
                let articles = response[i]
                addDetail(articles['id'], articles['username'], articles['title'], articles['contents'], articles['modifiedAt'])
                console.log()
            }
        }
    })
}
function addDetail(id, username, title, contents, modifiedAt ){
    console.log(id, username, title, contents, modifiedAt)
}