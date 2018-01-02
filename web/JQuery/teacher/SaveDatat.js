function saveDatat() {
    // object from teacehr
    Teacher();
    $.ajax({
        type:"POST",
        url:"api/teacherresource",
        contentType:'application/json',
        dataType:'json',
        success:function (msg) {
            alert(msg)
        }
    })
}
