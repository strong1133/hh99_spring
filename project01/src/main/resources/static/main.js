$(document).ready(function(){
    showhide()
})

function showhide(){
    $('#posting-pen').on('click', function(){
        $('.contents__container').hide();
        $('.posting__contianer').show();
    })

    $('#cancel-btn').on('click', function(){
        $('.posting__contianer').hide();
        $('.contents__container').show();

        $('.input-name').val('')
        $('.input-title').val('')
        $('.posting-textarea').val('')
    })
}