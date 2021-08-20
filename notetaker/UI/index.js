function login(){
    console.log("login");
    var url = "http://localhost:8080";
    var user = $('#username').val();
    var pass = $('#password').val();
    data={
        username: user,
        password:pass
    }
    $.ajax({
        method: "POST",
        url: url+"/login",
        // datatype : "application/json",
        contentType: "application/json",
        data: JSON.stringify(data),
        success : function( msg ) {
          alert(msg);
       }
    });

}