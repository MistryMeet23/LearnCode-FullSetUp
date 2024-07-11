function showLanguage(){  
    $.ajax({
        url:"./adminView/viewAllLanguage.php",
        method:"post",
        data:{record:1},
        success:function(data){
            $('.allContent-section').html(data);
        }
    });
}

function selectlanguage(){
    var x  = document.getElementById("language").value;

    $.ajax({
        url:"./adminView/homefetch.php",
        method:"POST",
        data:{
            id: x
        },
        success:function(data){
            $('#ans').html(data);
        }
    });
}

function showLanguageDetails(){  
    $.ajax({
        url:"./adminView/LanguageDatalist.php",
        method:"post",
        data:{record:1},
        success:function(data){
            $('.allContent-section').html(data);
        }
    });
}

function showUsers(){
    $.ajax({
        url:"./adminView/viewUsers.php",
        method:"post",
        data:{record:1},
        success:function(data){
            $('.allContent-section').html(data);
        }
    });
}