document.addEventListener("DOMContentLoaded", function() {
    getProduct();
    getCategories();
});

const getProduct=() => {
    fetch("http://localhost:8082/products").then((response) => {
        return response.json();
    }).then((data)=>{

        let products="";
        
        data.map(product => {
            products+=`<div class="col-lg-3 col-sm-6 col-12">`;
            products+=`<div class="card mb-4">`;
            products+=`<div class="card-body">`;
            products+=`<h5 class="card-title">${product.name}.  <span class="badge bg-secondary">${product.category?.name}</span></h5>`;
            products+=`<p class="card-text">Price: ${product.price}</p>`;
            products+=`<a href="#" class="btn btn-primary">View</a>`;
            products+=`</div>`;
            products+="</div>";
            products+="</div>";
        });
        
        document.getElementById("products").innerHTML = products;
    }).catch((error) => {
        console.log(error);
    });
};

const getCategories=() => {
    fetch("http://localhost:8082/categorys").then((response) => {
        return response.json();
    }).then((data)=>{
        let getCategoryList=document.getElementById("categories");

        data.map(category => {
            let listItem=document.createElement("li");
            listItem.innerHTML = category.name;
            listItem.onclick= getCategoriesById(category.id);
            getCategoryList.appendChild(listItem);
        });


    }).catch((error) => {
        console.log(error);
    });
}

const getCategoriesById=(categoryId) => {
    fetch("http://localhost:8082/categories/{categoryId}/products").then((response) => {
        return response.json();
    }).then((data)=>{
        let products="";
        
        data.map(product => {
            products+=`<div class="col-lg-3 col-sm-6 col-12">`;
            products+=`<div class="card mb-4">`;
            products+=`<div class="card-body">`;
            products+=`<h5 class="card-title">${product.name}.  <span class="badge bg-secondary">${product.category?.name}</span></h5>`;
            products+=`<p class="card-text">Price: ${product.price}</p>`;
            products+=`<a href="#" class="btn btn-primary">View</a>`;
            products+=`</div>`;
            products+="</div>";
            products+="</div>";
        });
        
        document.getElementById("products").innerHTML = products;
    }).catch((error) => {
        console.log(error);
    });
}
