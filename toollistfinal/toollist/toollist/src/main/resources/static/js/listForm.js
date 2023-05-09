
// select the Submit button inside the modal
//const submitBtn = document.querySelector('#submitBtn');

let today = new Date().toISOString().slice(0, 10);
document.querySelector('#dateInput').setAttribute("min", today)
function submitClick(){
// add a click event listener to the Submit button
//submitBtn.addEventListener('submit', (event) => {
  // prevent the default form submission behavior
//  event.preventDefault();

  // select the input fields and get their values
  const name = document.querySelector('#titleInput').value;
  const description = document.querySelector('#descriptionInput').value;
  const date = document.querySelector('#dateInput').value;

  // TODO: do validation on the input fields here

  // call the addCustomer function from productController.js to add the new customer
  addCustomer(name, description, date);


}