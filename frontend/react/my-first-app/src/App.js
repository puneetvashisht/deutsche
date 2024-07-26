import logo from './logo.svg';
import './App.css';
import Message from './Message';
import Badge from './Badge';
import Clock from './Clock';
// import ViewEmployees from './ViewEmployees';
import ViewEmployees from './ViewEmployees';
import AddEmployee from './AddEmployee';
import { Route, Routes, Link, Outlet } from 'react-router-dom';
import Toast from './Toast';
import About from './About';
function App() {
  return (
    <>
      <ul className="nav">
        <li className="nav-item">
          <Link className="nav-link active" aria-current="page" to="/">View Employees</Link>
        </li>
        <li className="nav-item">
          <Link className="nav-link" to="/add">Add Employee</Link>
        </li>
        <li className="nav-item">
          <Link className="nav-link" to="/aboutus">About Us</Link>
        </li>

      </ul>

      <div id="view-area">
        <Outlet></Outlet>
      </div>
        <Routes>
          <Route path="add" element={<AddEmployee />} />
          <Route path="aboutus" element={<About />} />
          <Route path="update/:id" element={<AddEmployee />} />
          <Route path="*" element={<NoMatch />} />
          <Route path="/" element={<ViewEmployees />}>
        </Route>
      </Routes>

      {/* <Message />
      <Badge caption="Inbox"></Badge>
      <Badge caption="Sent"></Badge>
      <Clock/> */}
      {/* <AddEmployee/>
      <hr></hr>
      <ViewEmployees/> */}
    </>
  );
}

export default App;


function NoMatch() {
  return (
    <div>
      <h2>Nothing to see here!</h2>
      <p>
        <Link to="/">Go to the home page</Link>
      </p>
    </div>
  );
}

