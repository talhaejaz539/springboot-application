
        async function fetchMainHeading() {
            const apiUrl = '/mainHeading';
            try {
                const response = await fetch(apiUrl);
                if (!response.ok) {
                    throw new Error('Network response was not ok.');
                }
                const data = await response.text();
                console.log(data);
                document.getElementById('main-heading').textContent = data;
            } catch (error) {
                console.error('Error fetching data:', error);
            }
        }

        // Initial fetch main heading
        fetchMainHeading()

        // Function to fetch items from backend and populate the table
        function fetchItems() {
            const itemsTable = document.getElementById('itemTable').getElementsByTagName('tbody')[0];
            itemsTable.innerHTML = ''; // Clear existing rows
            // Example data for demonstration
            const itemsUrl = '/allItems'
            fetch(itemsUrl)
                .then(response => {
                    // Check if the response is successful
                    if (!response.ok) {
                        throw new Error('Network response was not ok.');
                    }
                    // Parse JSON data from the response
                    return response.json();
                })
                .then(items => {
                    console.log(items);

                    if(items.length == 0) {
                        const row = itemsTable.insertRow();
                        row.innerHTML = `<p style="font-weight: bold; height: 50px; vertical-align: bottom;">No Items in Stock</p>`;
                    } else {
                        items.forEach(item => {
                            const row = itemsTable.insertRow();
                            row.innerHTML = `
                            <td>${item.itemId}</td>
                            <td>${item.description}</td>
                            <td>${item.price}</td>
                            <td>${item.quantity}</td>
                            <td>${item.creationDate}</td>
                            <td>
                                <button class="btn" onclick="openUpdateModal(${item.itemId}, '${item.description}', ${item.price}, ${item.quantity})">Edit</button>
                                <button class="btn" onclick="deleteItem(${item.itemId})">Delete</button>
                            </td>
                            `;
                        });
                    }
                })
        }

        // Function to fetch customers from backend and populate the table
        function fetchCustomers() {
            const customersTable = document.getElementById('customerTable').getElementsByTagName('tbody')[0];
            customersTable.innerHTML = ''; // Clear existing rows
            // Example data for demonstration
            const customersUrl = '/allCustomers'
            fetch(customersUrl)
                .then(response => {
                    // Check if the response is successful
                    if (!response.ok) {
                        throw new Error('Network response was not ok.');
                    }
                    // Parse JSON data from the response
                    return response.json();
                })
                .then(customers => {
                    console.log(customers);

                    if(customers.length == 0) {
                        const row = customersTable.insertRow();
                        row.innerHTML = `<p style="font-weight: bold; height: 50px; vertical-align: bottom;">No Customer Registered</p>`;
                    } else {
                        customers.forEach(customer => {
                            const row = customersTable.insertRow();
                            row.innerHTML = `
                            <td>${customer.customerId}</td>
                            <td>${customer.name}</td>
                            <td>${customer.email}</td>
                            <td>${customer.phone}</td>
                            <td>${customer.address}</td>
                            <td>${customer.salesLimit}</td>
                            <td>${customer.amountPayable}</td>
                            <td>
                                <button class="btn" onclick="openUpdateModal(${customer.customerId}, '${customer.name}', ${customer.email}, ${customer.phone}, ${customer.address}, , ${customer.salesLimit})">Edit</button>
                                <button class="btn" onclick="deleteItem(${customer.customerId})">Delete</button>
                            </td>
                            `;
                        });
                    }
                })
        }

//        // Initial fetch of items when the page loads
//        fetchItems();
//
//        // Initial fetch of customers when the page loads
//        fetchCustomers();

        // Function to open Create Modal
        function openCreateModal() {
            document.getElementById('createModal').style.display = 'block';
        }

        function openCreateCustomerModal() {
            document.getElementById('createCustomerModal').style.display = 'block';
        }

        // Function to close Create Modal
        // document.getElementById('closeCreateModal').onclick = function() {
        //     document.getElementById('createModal').style.display = 'none';
        // }
        //
        // document.getElementById('closeCreateCustomerModal').onclick = function() {
        //     document.getElementById('createCustomerModal').style.display = 'none';
        // }

        // Function to open Update Modal and pre-fill data
        function openUpdateModal(id, description, price, quantity) {
            document.getElementById('updateId').value = id;
            document.getElementById('updateDescription').value = description;
            document.getElementById('updatePrice').value = price;
            document.getElementById('updateQuantity').value = quantity;
            document.getElementById('updateModal').style.display = 'block';
        }

        // Function to close Update Modal
        document.getElementById('closeUpdateModal').onclick = function() {
            document.getElementById('updateModal').style.display = 'none';
        }

        // Function to handle Create form submission
        document.getElementById('createForm').onsubmit = function(event) {
            event.preventDefault();
            const description = document.getElementById('description').value;
            const price = parseInt(document.getElementById('price').value);
            const quantity = parseInt(document.getElementById('quantity').value);

            // Create item object
            const item = {
                description: description,
                price: price,
                quantity: quantity
            };

            // Make API call to create item
            sendItemToBackend(item);

            function sendItemToBackend(item) {
                // Example URL for backend endpoint
                const backendUrl = '/addItem';

                // Make a POST request to send item data to backend
                fetch(backendUrl, {
                    method: 'POST',
                    headers: {
                        'Content-Type': 'application/json'
                    },
                    body: JSON.stringify(item)
                })
                .then(response => {
                    if (!response.ok) {
                        throw new Error('Failed to add item');
                    }
                    // Reset form fields
                    document.getElementById('createForm').reset();
                    // Close modal after successful creation
                    document.getElementById('createModal').style.display = 'none';
                    // Refresh the table after Creation
                    fetchItems();
                    displayMessage('Item added successfully.', 2000);
                })
                .catch(error => {
                    console.error('Error:', error);
                    alert('Failed to add item');
                });
            }
        }

        // Function to handle Update form submission
        document.getElementById('updateForm').onsubmit = function(event) {
            event.preventDefault();
            const itemId = parseInt(document.getElementById('updateId').value);
            const description = document.getElementById('updateDescription').value;
            const price = parseFloat(document.getElementById('updatePrice').value);
            const quantity = parseInt(document.getElementById('updateQuantity').value);

            // Create item object
            const item = {
                description: description,
                price: price,
                quantity: quantity
            };

            // Make API call to update item
            sendItemToBackend(item);

            function sendItemToBackend(item) {
                // Make a PUT request to send item data to backend
                fetch(`/updateItemById?id=${itemId}`, {
                    method: 'PUT',
                    headers: {
                        'Content-Type': 'application/json'
                    },
                    body: JSON.stringify(item)
                })
                .then(response => {
                    if (!response.ok) {
                        throw new Error('Failed to update item');
                    }
                    // Close modal after successful update
                    document.getElementById('updateModal').style.display = 'none';
                    // Refresh the table after Update
                    fetchItems();
                    displayMessage('Item updated successfully.', 2000);
                })
                .catch(error => {
                    console.error('Error:', error);
                    alert('Failed to update item');
                });
            }
        }

        // Function to handle Delete operation
        function deleteItem(itemId) {

            if(confirm("Are you sure you want to delete this item?")) {
                // want to check yes or no

                // Make API call to delete item
                fetch(`/deleteItemById?id=${itemId}`, {
                    method: 'DELETE',
                    headers: {
                        'Content-Type': 'application/json'
                    },
                })
                    .then(response => {
                        if (!response.ok) {
                            throw new Error('Network response was not ok.');
                        }
                        return response.json();
                    })
                    .then(data => {
                        console.log('Item deleted successfully:', data);
                        displayMessage('Item deleted successfully.', 2000); // Display for 2 seconds
                        // Refresh the table after deletion
                        fetchItems();
                    })
                    .catch(error => {
                        console.error('Error deleting item:', error);
                        displayMessage('Error deleting item.', 2000);
                    });
            }
        }

        // Function to display a message on the screen for a specified duration
        function displayMessage(message, duration) {
            const messageElement = document.createElement('div');
            messageElement.innerText = message;
            messageElement.style.position = 'fixed';
            messageElement.style.top = '20px';
            messageElement.style.right = '20px';
            messageElement.style.padding = '10px';
            messageElement.style.background = '#333';
            messageElement.style.color = '#fff';
            messageElement.style.borderRadius = '5px';
            document.body.appendChild(messageElement);
            setTimeout(() => {
                document.body.removeChild(messageElement);
            }, duration);
        }

