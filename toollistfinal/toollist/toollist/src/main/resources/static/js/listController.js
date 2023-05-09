/*
   ProductController perform action to the products to be displayed


   (1) Display all products to be retrieved from the back-end
   (2) Add product to the product list (send the new project to the back-end)
   --- edit an existing product detail
   -- remove an existing product from the product list
*/


//development APIs
const addAPI= 'http://localhost:8080/list/add';
const displayAPI = 'http://localhost:8080/list/all';
let productController = [];


function displayList()
{
      //fetch data from database using the REST API endpoint from Spring Boot
      fetch(displayAPI)
          .then((resp) => resp.json())
          .then(function(data) {
              console.log(data);
              data.forEach(function (list, index) {
                  const listObj = {
                      name: list.title,
                      description: list.description,
                      date: list.date
                 };
                  productController.push(listObj);
            });

            renderProductPage();
          })
          .catch(function(error) {
              console.log(error);
          });
}

function renderProductPage() {
    let display = `
            <table class="table table-striped mb-5" style="border:2px solid #000">
                <tr>
                    <th>Title</th>
                    <th>Description</th>
                    <th>Date</th>
                </tr>
           `;

   for (let i = 0; i < productController.length; i++ ) {
       display += `
          <tr>
                    <td>${productController[i].title} </td>
                    <td>${productController[i].description} </td>
                    <td>${productController[i].date} </td>
           </tr>
       `
   }

 display += `</table>`;
   document.querySelector("#row").innerHTML= display;


} //End of renderProductPage function

//4) Add new product to the product list when user clicks on the submit button from the productform.html

function addCustomer(title, description, date)
{
// FormData is an object provided by the browser API for us to send the data over to the backend
   const formData = new FormData();
   formData.append('title', title);
   formData.append('description', description);
   formData.append('date', date);

  fetch(addAPI, {
        method: 'POST',
        body: formData
        })
        .then(function(response) {
            console.log(response.status); // Will show you the status
            if (response.ok) {
//               location.reload();
                alert("Successfully Added Product!")
            }
            else {
               alert("Something went wrong. Please try again")
            }
        })
        .catch((error) => {
            console.error('Error:', error);
            alert("Error adding item to Product")
        });
}
