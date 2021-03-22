$(document).ready(function () {
    backHome()
    getId()
})

function getId() {
    let id = location.search.split('=')[1]
    return getDetail(id)
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
    let tempHtml = `<div class="content-header">
          <h1>${title}</h1>
          <p class="post-author">
            ${username} <span class="post-date">| ${modifiedAt}</span>
          </p>
          <hr />
        </div>
        <div class="content-body">
          <p>
            ${contents}
          </p>
        </div>`
    $('.content__container').append(tempHtml)

}