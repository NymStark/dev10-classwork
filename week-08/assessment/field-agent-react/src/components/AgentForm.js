import { useState, useEffect } from "react";
import { useParams, useNavigate } from "react-router-dom"; // Import the useParams hook


// TODO: Modify this component to support update/edit.
// An update URL should have an agent id.
// Use that id to fetch a single agent and populate it in the form.

function AgentForm() {
    const { id } = useParams(); // Get the id parameter from the URL using useParams
    const nav = useNavigate();

    const [agent, setAgent] = useState({
        firstName: "",
        middleName: "",
        lastName: "",
        dob: "",
        heightInInches: ""
    });
    const [errors, setErrors] = useState([]);


    // Use the effect to fetch the agent data if an id is provided
    useEffect(() => {
        if (id) {
            fetch(`http://localhost:8080/api/agent/${id}`)
                .then((response) => {
                    if (response.ok) {
                        return response.json();
                    }
                    throw new Error("Failed to fetch agent data for update");
                })
                .then((agentData) => {
                    setAgent(agentData);
                })
                .catch((error) => {
                    console.error(error);

                });
        }
    }, [id]); // This effect will re-run whenever the id changes

    function handleChange(evt) {
        setAgent(previous => {
            const next = { ...previous };
            next[evt.target.name] = evt.target.value;
            return next;
        });
    }

    // TODO: Modify this function to support update as well as add/create.
    // function handleSubmit(evt) {
    //     evt.preventDefault();

    //     const config = {
    //         method: "POST",
    //         headers: {
    //             "Content-Type": "application/json"
    //         },
    //         body: JSON.stringify(agent)
    //     }

    //     fetch("http://localhost:8080/api/agent", config)
    //         .then(response => {
    //             if (response.ok) {
    //                 setView("list");
    //             } else {
    //                 return response.json();
    //             }
    //         })
    //         .then(errs => {
    //             if (errs) {
    //                 return Promise.reject(errs);
    //             }
    //         })
    //         .catch(errs => {
    //             if (errs.length) {
    //                 setErrors(errs);
    //             } else {
    //                 setErrors([errs]);
    //             }
    //         });
    // }

    function handleSubmit(evt) {
        evt.preventDefault();
        const apiUrl = id ? `http://localhost:8080/api/agent/${id}` : "http://localhost:8080/api/agent";

        const config = {
            method: id ? "PUT" : "POST", // Uses PUT for updates and POST for creates
            headers: {
                "Content-Type": "application/json",
            },
            body: JSON.stringify(agent),
        };

        fetch(apiUrl, config)
            .then((response) => {
                if (response.ok) {
                    nav("/list"); 
                } else {
                    return response.json();
                }
            })
            .then((errs) => {
                if (errs) {
                  setErrors(Array.isArray(errs) ? errs : [errs]);
                }
              })
              .catch((err) => {
                console.error(err);
                setErrors([err.message]); // Set errors as an array with the error message
            });
    }


    function handleCancel() {
        nav("/list");
    }

    return (
        <>
            <h1 className="display-6">{id ? "Update Agent" : "Add an Agent"}</h1>
            {errors && errors.length > 0 && <div className="alert alert-danger">
                {/* <ul className="mb-0">
                    {errors.map(err => <li key={err}>{err}</li>)}
                </ul> */}
                {/*
                reimplemented error handling
                Apparently React doesn't like us rendering Errors as objects
                
                */}

                <ul className="mb-0">
                    {errors.map((err, index) => (
                        <li key={index}>{err}</li>
                    ))}
                </ul>

            </div>}
            <form onSubmit={handleSubmit}>
                <div className="row mb-3">
                    <div className="col">
                        <label className="form-label" htmlFor="firstName">First Name</label>
                        <input id="firstName" name="firstName" type="text" className="form-control" required
                            onChange={handleChange} value={agent.firstName} />
                    </div>
                    <div className="col">
                        <label className="form-label" htmlFor="middleName">Middle Name</label>
                        <input id="middleName" name="middleName" type="text" className="form-control"
                            onChange={handleChange} value={agent.middleName} />
                    </div>
                </div>
                <div className="mb-3">
                    <label className="form-label" htmlFor="lastName">Last Name</label>
                    <input id="lastName" name="lastName" type="text" className="form-control" required
                        onChange={handleChange} value={agent.lastName} />
                </div>
                <div className="row mb-3">
                    <div className="col">
                        <label className="form-label" htmlFor="dob">DOB</label>
                        <input id="dob" name="dob" type="date" className="form-control" required
                            onChange={handleChange} value={agent.dob} />
                    </div>
                    <div className="col">
                        <label className="form-label" htmlFor="heightInInches">Height (inches)</label>
                        <input id="heightInInches" name="heightInInches" type="number" className="form-control"
                            required min="36" max="96"
                            onChange={handleChange} value={agent.heightInInches} />
                    </div>
                </div>
                <div className="mb-3">
                    <button type="submit" className="btn btn-primary me-2">
                        {id ? "Update" : "Save"} {/* Display "Update" or "Save" based on whether it's an update or create */}
                    </button>
                    {/* TODO: Change this button to a React Router Link. */}
                    <button
                        type="button"
                        className="btn btn-warning"
                        onClick={handleCancel}>
                        Cancel</button>
                </div>
            </form>
        </>
    );


}

export default AgentForm;