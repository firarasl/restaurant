function getCartItems(){
    var cartItems=localStorage.getItem("cartItems");
    document.getElementById("cart-items").innerHTML=cartItems;
}

/* ***********************************************************************************************/



function addToCart(){
    var cartItems=localStorage.getItem("cartItems");
    cartItems++;
    localStorage.setItem("cartItems",cartItems);
    getCartItems();
}


/* ***********************************************************************************************/


function pagination(totalPages){
    var currentPage=localStorage.getItem("currentPage");
    var text="";
    if(currentPage!=1){
        var prev=currentPage-1;
        text="<a onclick='particularPage("+prev+")'>&laquo;</a>";
    }

for (i = 1; i <= totalPages; i++) {
 text +="<a onclick='particularPage("+i+")'>"+i+"</a>";
}
    if(currentPage!=totalPages){
        var next=1+ parseInt(currentPage);

        text+="<a onclick='particularPage("+next+")'>&raquo;</a>";
    }
    
document.getElementById("pagination").innerHTML = text;
}


/* ***********************************************************************************************/



function particularPage(i){
    localStorage.setItem("currentPage", i);
    console.log(i);
    ajaxFilling(i-1);
}

/* ***********************************************************************************************/




function ajaxFilling(start){
    $.ajax({
    url: "http://localhost:8080/menu/"+categoryId,
    data: {
        start: start,
        limit: 10
        }, 
    success: function(data){
        var totalPages=data.totalPages;
        pagination(totalPages);
        fillBooks(data.content);
    }, error: function (e) {
    console.log(e.message);
}
})
}
/* ***********************************************************************************************/

function ajaxStoreInfo(){
    $.ajax({
    url: "http://localhost:8080/bookStore-info",
    success: function(data){
        $("#store-info").append(
          "<p>"+data.address+"<br><strong>"+data.director+
            "</strong><br><a href='mailto:"+ data.email +"'><i class='fa fa-envelope' aria-hidden='true'></i>   "+ data.email +
                "</a></p><a class='number' href='tel:"+ data.phone +
                "'><i class='fa fa-phone' aria-hidden='true'></i>"+ data.phone +"</a>"
        )
    }, error: function (e) {
    console.log(e.message);
}
})
}

/* ***********************************************************************************************/


function fillBooks(content){
    $("#books").empty();

    for(i=0; i<content.length; i++){
    $("#books").append(
"<div class='col-xl-6 col-md-6 col-lg-6'><div class='single_delicious d-flex align-items-center'><div class='thumb'><img width='100px' height='100px' src='img/book/"+content[i].photoName+
"' alt=''></div><div class='info'><h3>"+content[i].name+"</h3><p>"+content[i].description+
"</p><p><strong>"+ content[i].author.name +" | "+ content[i].category.name+
"</strong> </p> <span> $"+content[i].price+"</span><a onclick='addToCart()' class='boxed-btn3'>Add to cart</a></div></div></div>");           
console.log(content[i]);
}
    
}
