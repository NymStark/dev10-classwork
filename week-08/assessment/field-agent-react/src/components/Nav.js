import { Link } from 'react-router-dom';


// function Nav({ view, setView }) {

//     function handleAdd() {
//         setView("form");
//     }

//     function handleList(evt) {
//         evt.preventDefault();
//         setView("list");
//     }

//     return (
//         <div className="d-flex align-items-center">
//             <ul className="nav my-4">
//                 <li className="nav-item">
//                     <a id="linkAgents" href="#" className="nav-link" onClick={handleList}>Agents</a>
//                 </li>
//                 <li className="nav-item">
//                     <a id="linkAgencies" href="#" className="nav-link" onClick={evt => evt.preventDefault()}>Agencies</a>
//                 </li>
//             </ul>
//             {view !== "form" &&
//                 <div className="d-flex flex-grow-1 justify-content-end">
//                     <button id="btnAdd" className="btn btn-primary" onClick={handleAdd}>Add Agent</button>
//                 </div>}
//         </div>
//     );
// }

// export default Nav;

function Nav() {
    return (
        <div className="d-flex align-items-center">
            <ul className="nav my-4">
                <li className="nav-item">
                    {/* Use Link component to navigate to the "list" route */}
                    <Link to="/list" className="nav-link">Agents</Link>
                </li>
                <li className="nav-item">
                    {/* Add a placeholder link for "Agencies" */}
                    <Link to="/agencies" className="nav-link">Agencies</Link>
                </li>
            </ul>
            {/* The "Add Agent" button navigates to the "form" route */}
            <div className="d-flex flex-grow-1 justify-content-end">
                <Link to="/form" className="btn btn-primary">Add Agent</Link>
            </div>
        </div>
    );
}

export default Nav;