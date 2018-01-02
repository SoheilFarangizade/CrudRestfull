function updatet() {
    Teacher();

    $.ajax({
        crossDomain:true,
        type:"PUT",
        url:"api/student",
        date:JSON.stringify(student()),
        async:true,
        chache:false,
        contentType:"Application/JSON",
        success:function(msg){
            alert('Data is Updated !!!!');
        },
        error:function(xhr, status, error){
            alert(xhr.responseText + status);
        }
    })
}