function DeleteT(){
    var id= $('id').value;

    $.ajax({
        crossDomain:true,
        type:"DELETE",
        url:"api/teacher",
        data:id,
        async:true,
        cache:false,
        success:function(msg){
            alert("Deleted !!!");
        },
        error: function(xhr, status , error){
            alert(xhr.responseText + status);
        }
    });
}