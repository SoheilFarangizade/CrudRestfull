function show() {

    student();
    $.ajax({
        type:"GET",
        url:"api/Teacher",
        async:true,
        crossDomain:true,
        cache:false,
        success:function(msg){
            $.each(msg,function(student,value){
                $("#stable").append($("<tr>").append("<td>"+value.id+"</td>"+"<td>"+value.name+"</td>"+"<td>"+value.dept+"</td>"+"<td>"+value.prof_id+"</td>"+));
                selected();
            });
        },
        error: function(xhr, status , error){
            alert(xhr.responseText  + status);
        }
    })
}

function selected(){
    var Index,table=document.getElementById("index");
    for(var i=2;i<index.rows.length;i++){
        table.rows[i].onclick=function(){
            Index=this.rowIndex;
            document.getElementById("id").value=this.cells[0].innerHTML;
            document.getElementById("name").value=this.cells[1].innerHTML;
            document.getElementById("dept").value=this.cells[2].innerHTML;
            document.getElementById("prof_id").value=this.cells[2].innerHTML;

        };
    }
}