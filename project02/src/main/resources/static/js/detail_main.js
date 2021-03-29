$(document).ready(function () {
    backHome()
    getId()
    showHide()
    deleteArticle()
    $('.comment__card-box').empty();

})

function getId() {
    let id = location.search.split('=')[1]
    getDetail(id)
    getComment(id)
}

function backHome() {
    $('#home').on('click', function () {
        window.location.href = "/"
    })
}

function getDetail(id) {
    let idx = id
    $.ajax({
        type: 'GET',
        url: `/api/detail/${idx}`,
        success: function (response) {
            addDetail(response['id'], response['username'], response['title'], response['contents'], response['modifiedAt'])
        }
    })
}

function addDetail(id, username, title, contents, modifiedAt) {
    let tempHtml = `<div class ="detail">
    <div class="content-header">
          <h1 class="title">${title}</h1>
          <p class="post-author">
            <span class="username">${username}</span> <span class="post-date">| ${modifiedAt}</span>
          </p>
          <hr />
        </div>
        <div class="content-body">
          <p class="contents">
            ${contents}
          </p>
        </div>
    </div>`
    $('.content__container').append(tempHtml)
}

function showHide() {
    $('#edit').on('click', function () {
        $('.detail').hide()
        $('.detail__edit').show()
        let title = $('.title').text()
        let contents = $('.contents').text().trim()
        let author = $('.post-author').text().trim()
        $('.post-author-edit').text(author)
        $('.detail-input').val(title)
        $('.detail-textarea').val(contents)
    })
    $('.cancel').on('click', function () {
        $('.detail').show()
        $('.detail__edit').hide()
        $('.detail-input').val('')
        $('.detail-textarea').val('')
    })
}

function editArticle() {
    let id = location.search.split('=')[1]
    let title = $('.detail-input').val();
    let contents = $('.detail-textarea').val();
    let username = $('.username').text()
    if (title == '') {
        alert("수정하실 제목을 적어 주세요!")
        return
    }
    if (contents == '') {
        alert("수정하실 내용을 적어 주세요!")
        return;
    }
    let data = {'username': username, 'title': title, 'contents': contents}
    $.ajax({
        type: "PUT",
        url: `/api/articles/${id}`,
        contentType: 'application/json',
        data: JSON.stringify(data),
        success: function (response) {
            alert("수정이 완료되었습니다!")
            window.location.reload();
        }
    })
}

function deleteArticle() {
    $('#delete').on('click', function () {
        let id = location.search.split('=')[1]
        $.ajax({
            type: "DELETE",
            url:`/api/articles/${id}`,
            success:function (response){
                alert("삭제 되었습니다.")
                window.location.href = "/"
            }
        })
    })
}

function create_comment() {
    let article_id = location.search.split('=')[1]
    let username = $('.username').text();
    let contents = $('.post__comment-textarea').val();
    if (!username || $('.link-signup').text() == '로그인 하러 가기') {
        alert("로그인을 하셔야 댓글을 달수 있습니다!")
        return;
    }
    if (contents == '') {
        alert("댓글을 적어주세요!!")
        return
    }
    let data = {'article_id':article_id, 'username':username, 'contents':contents};

    $.ajax({
        type:'POST',
        url:'/api/comments',
        contentType: 'application/json',
        data: JSON.stringify(data),
        success: function (response){
            alert('댓글이 성공적으로 작성되었습니다!')
            window.location.reload();
        }

    })
}


function getComment(id) {
    let index = id
    $.ajax({
        type: 'GET',
        url: `/api/comment/${index}`,
        success: function (response) {
            for(let i=0; i< response.length; i++){
                console.log(response['comments'][i])
                // let comment = response[i];
                // let tempHtml = addComments(comment)
                // $('.comment__card-box').append(tempHtml);
            }
        }
    });
}

function addComments(comment){
    return `<div class="comment__card">
                <div class="comment__card-header">
                  ${comment.username}<span class="comment-date">${comment.modifiedAt}</span>
                </div>
                <div class="comment__card-body">
                  <div class="comment">${comment.contents}</div>
                  <div class="comment-btn">
                    <i class="far fa-edit"></i>
                    <i class="fas fa-trash-alt"></i>
                  </div>
                </div>
              </div>`;

}