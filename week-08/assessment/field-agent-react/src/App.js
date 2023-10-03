import { useState } from "react";
import { Route, Routes } from 'react-router-dom';

import AgentForm from "./components/AgentForm";
import AgentList from "./components/AgentList";
import Landing from "./components/Landing";
import Nav from "./components/Nav";
import ConfirmDelete from './components/ConfirmDelete';
import NotFound from "./components/NotFound";

// const componentMap = {
//   "form": AgentForm,
//   "list": AgentList,
//   "landing": Landing
// }

function App() {

  // TODO: Implement React Router V6.
  // const [view, setView] = useState("landing");
  // const Component = componentMap[view];

  // // TODO: Add routes for update and delete.

  // // TODO: Add a ConfirmAgentDelete component that renders with the delete route.
  // // The delete route should contain an agent id. 
  // // Use that id to fetch a single agent, display their name, 
  // // and then either delete or cancel. 
  // // If the agent isn't found. Redirect to the AgentList route.

  // return (
  //   <main className="container">
  //     <Nav view={view} setView={setView} />
  //     <Component setView={setView} />
  //   </main>
  // );

  // const [view, setView] = useState("landing");
  // const Component = componentMap[view];
  return (
    <main className="container">
      <Nav />
      <Routes>
        <Route path="/" element={<Landing />} />
        <Route path="/list" element={<AgentList />} />
        <Route path="/form" element={<AgentForm />} />
        <Route path="/agents">
          <Route path="edit/:id" element={<AgentForm/>} />
          <Route path="delete/:id" element={<ConfirmDelete />} />
        </Route>
        <Route path="*" element={<NotFound />} />
      </Routes>
    </main>
  );
}

export default App;
