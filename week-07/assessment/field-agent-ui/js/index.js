const DISPLAY_NONE = "d-none";

const form = document.querySelector("form");
let currentView = "landing";

function changeView(view) {
    for (const element of document.querySelectorAll(`.${currentView}`)) {
        element.classList.add(DISPLAY_NONE);
    }
    for (const element of document.querySelectorAll(`.${view}`)) {
        element.classList.remove(DISPLAY_NONE);
    }
    currentView = view;
}

/*
COMMENTING OUT THE PREVIOUS CODEBLOCKS AND WORKING ON NEW ONES, BECAUSE I KEEP BREAKING CODES.
*/

// TODO: Populate an existing agent into the HTML form.
// function showUpdate() {

//     //alert("Implement update!");
// }

function showUpdate(agentId) {
    // const confirmUpdate = confirm(`Are you sure you want to update the agent  with ID: ${agentId}?`);
    fetch(`http://localhost:8080/api/agent/${agentId}`)
        .then(response => {
            if (response.ok) {
                return response.json();
            } else {
                console.error('Failed to fetch agent data for update');
            }
        }) 
        .then(agent => {
            document.getElementById("agentId").value = agent.agentId;
            document.getElementById("firstName").value = agent.firstName;
            document.getElementById("middleName").value = agent.middleName || ""; //middle name can be null
            document.getElementById("lastName").value = agent.lastName;
            document.getElementById("dob").value = agent.dob;
            document.getElementById("heightInInches").value = agent.heightInInches;
            changeView("form");
        })
        .catch(error => {
            console.error(error);
        });
}



// TODO: Populate an existing agent into a delete confirmation view. 
// The confirmation view should allow for a delete or cancel.
// Cancel returns to the agent list view.
function confirmDelete(agentId) {
    const confirmDeletion = confirm(`Are you sure you want to delete the agent with ID: ${agentId}?`);
    
    if (confirmDeletion) {
        // Delete Requests to the API.
        fetch(`http://localhost:8080/api/agent/${agentId}`, {
            method: 'DELETE'
        })
        .then(response => {
            if (response.ok) { //Action upon successful deletion
                showList();
            } else {
                console.error('Failed to delete agent');
            }
        })
        .catch(error => {
            console.error(error);
        });
    }
   // alert(`Implement delete! Agent ID: ${agentId}`);
}

// TODO: create a function that deletes an agent when the
// delete confirmation view is confirmed. Confirmation can be a form submission
// or a button click.

function populateAgents(agents) {

    const table = document.querySelector(".list > table");
    const tbody = table.querySelector("tbody");
    const warning = document.querySelector(".list > div");

    if (agents.length === 0) {
        table.classList.add(DISPLAY_NONE);
        warning.classList.remove(DISPLAY_NONE);
        return;
    }

    let html = "";
    for (const agent of agents) {
        // TODO: This embedded HTML explicitly attaches a function call for update and delete.
        // Complete the confirmDelete and showUpdate functions.

        //reformatting date
        const dob = new Date(agent.dob);
        const newDob = `${dob.getMonth() + 1}/${dob.getDate()}/${dob.getFullYear()}`; //Via Google.

        // Format the height as feet'inches
        const feet = Math.floor(agent.heightInInches / 12);
        const inches = agent.heightInInches % 12;
        const newHeight = `${feet}'${inches}"`;


        html += `<tr>
            <td>${agent.firstName}${agent.middleName ? " " + agent.middleName : ""} ${agent.lastName}</td>
            <td>${newDob}</td>
            <td>${newHeight}</td>
            <td>
                <button type="button" class="btn btn-danger me-2" onClick="confirmDelete(${agent.agentId})">Delete</button>
                <button type="button" class="btn btn-info" onClick="showUpdate(${agent.agentId})">Edit</button> 
            </td>
        </tr>`;
    } //Edited  <button type="button" class="btn btn-info" onClick="showUpdate(${agent.agentId})">Edit</button> to give agentId

    tbody.innerHTML = html;
}

function fetchAgents() {
    fetch("http://localhost:8080/api/agent")
        .then(response => {
            if (response.ok) {
                return response.json();
            }
            return Promise.reject();
        })
        .then(agents => populateAgents(agents))
        .catch(console.error);
}

function showList() {
    fetchAgents();
    changeView("list");
}

function showValidationSummary(errors) {
    let html = '<ul class="mb-0">';
    for (const err of errors) {
        html += `<li>${err}</li>`;
    }
    html += '</ul>';
    const validationSummary = document.getElementById("validationSummary");
    validationSummary.classList.remove(DISPLAY_NONE);
    validationSummary.innerHTML = html;
}

function hideValidationSummary() {
    document.getElementById("validationSummary").classList.add(DISPLAY_NONE);
}

// TODO: Modify this function to allow for update.
// Don't create two different forms for create and update.
// function submitForm(evt) {

//     evt.preventDefault();
//     evt.stopPropagation();
//     hideValidationSummary();

//     if (form.checkValidity()) {

//         const agent = {
//             firstName: document.getElementById("firstName").value,
//             middleName: document.getElementById("middleName").value,
//             lastName: document.getElementById("lastName").value,
//             dob: document.getElementById("dob").value,
//             heightInInches: document.getElementById("heightInInches").value
//         };


//         const config = {
//             method: "POST", 
//             headers: {
//                 "Content-Type": "application/json"
//             },
//             body: JSON.stringify(agent)
//         };
     

//         fetch("http://localhost:8080/api/agent", config)
//             .then(response => {
//                 if (response.ok) {
//                     showList();
//                 } else {
//                     return response.json();
//                 }
//             })
//             .then(errors => {
//                 if (errors) {
//                     showValidationSummary(errors);
//                 }
//             })
//             .catch(console.error);
//     }
// }

function submitForm(evt) {
    evt.preventDefault();
    evt.stopPropagation();
    hideValidationSummary();

    const agent = {
        agentId: document.getElementById("agentId").value,
        firstName: document.getElementById("firstName").value,
        middleName: document.getElementById("middleName").value,
        lastName: document.getElementById("lastName").value,
        dob: document.getElementById("dob").value,
        heightInInches: document.getElementById("heightInInches").value
    };

    const isUpdate = agent.agentId !== ""; // If agentId is present, it's an update; otherwise, it's a create.

    const config = {
        method: isUpdate ? "PUT" : "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(agent)
    };

    const apiUrl = isUpdate ? `http://localhost:8080/api/agent/${agent.agentId}` : "http://localhost:8080/api/agent";

    fetch(apiUrl, config)
        .then(response => {
            if (response.ok) {
                showList();
            } else {
                return response.json();
            }
        })
        .then(errors => {
            if (errors) {
                showValidationSummary(errors);
            }
        })
        .catch(console.error);
}

// event handlers

document.getElementById("linkAgents")
    .addEventListener("click", evt => {
        evt.preventDefault();
        showList();
    });

document.getElementById("linkAgencies")
    .addEventListener("click", evt => {
        evt.preventDefault();
    });

document.querySelector(".list button")
    .addEventListener("click", () => {
        changeView("form");
    });

form.addEventListener("submit", submitForm);

document.querySelector("form button[type=button]")
    .addEventListener("click", () => {
        showList();
    });