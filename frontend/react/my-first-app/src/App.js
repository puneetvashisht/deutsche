import logo from './logo.svg';
import './App.css';
import Message from './Message';
import Badge from './Badge';
import Clock from './Clock';
// import ViewEmployees from './ViewEmployees';
import ViewEmployees from './ViewEmployees';
function App() {
  return (
    <div>
      <h2>Container component</h2>
      <Message />
      <Badge caption="Inbox"></Badge>
      <Badge caption="Sent"></Badge>
      <Clock/>
      <ViewEmployees/>
    </div>
  );
}

export default App;
