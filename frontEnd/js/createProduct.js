document.addEventListener("DOMContentLoaded", function() {
    getCategories();
});

const getCategories=() => {
    fetch("http://localhost:8082/categorys").then((response) => {
        return response.json();
    }).then((data)=>{

        // console.log(data);
        // let categories="";

        // data.map(category => {
        //     categories+=`<option value="${category.id}">${category.name}</option>`;
        // });

        // document.getElementById("categoryId").innerHTML = categories;
        let selectCategory=document.getElementById("categoryId");

        data.map(category => {
            let option=document.createElement("option");
            option.value=category.id;
            option.text=category.name;
            selectCategory.appendChild(option);
        });


    }).catch((error) => {
        console.log(error);
    });
}

const crateProduct=(event) => {
    event.preventDefault();

    let name=document.getElementById("name").value;
    let price=document.getElementById("price").value;
    let qty=document.getElementById("qty").value;
    let categoryId=document.getElementById("categoryId").value;

    let data={
        "name":name,
        "price":price,
        "qty":qty,
        "categoryId":categoryId
    }

    fetch("http://localhost:8082/products",{
        method: "POST",
        body: JSON.stringify(data),
        headers: {
            "Content-Type": "application/json"
        }
    }).then((response) =>{
        return response.json();
    }).then((data) =>{
        window.location.href="file:///Users/dewmithmihisara/self-study/spring-boot/frontEnd/index.html";
    }).catch((error) =>{
        console.log(error);
    });
}