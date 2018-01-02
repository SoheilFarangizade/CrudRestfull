function saveDatat() {
    // object from teacehr
    student();
    $.ajax({
        type:"POST",
        url:"api/student",
        contentType:'application/json',
        dataType:'json',
        success:function (msg) {
            alert(msg)
        }
    })
}
