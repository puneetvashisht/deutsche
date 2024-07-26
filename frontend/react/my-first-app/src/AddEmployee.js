import { useState , useEffect} from "react";
import Button from 'react-bootstrap/Button';
import Toast from "./Toast";
import { useParams, useHistory } from'react-router-dom';
const AddEmployee = () => {
    const [employee, setEmployee] = useState({
        name: '',
        department: '',
    });
    const [showAlert, setShowAlert] = useState(false);

    const { id } = useParams();

    const handleInputChange = (event) => {
        const { name, value } = event.target;
        setEmployee({ ...employee, [name]: value });
        // console.log(event.target.name, event.target.value);
    }

    const updateEmployee = () => {
        // console.log(title, description, tripdate);
        fetch('http://localhost:8000/employees/' + id, {
            method: 'PATCH',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(employee)
        })
        .then(res => {
            if(res.status === 200){
                // setMessage('Trip updated sucessfully!')
                setShowAlert(true);
                setEmployee({ name: '', department: '' });
                // history.push('/');
            }
        })
      }

    const addEmployee = () => {
        fetch('http://localhost:8000/employees', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(employee),
        })
        .then(response => response.json())
        .then(data => {
            console.log('Employee added successfully');
            setShowAlert(true);
            setEmployee({ name: '', department: '' });
        })
        .catch(error => console.error('Error:', error));
    }

    return (
        <div>
            <h2>Add Employee</h2>
            {showAlert && <Toast message="Employee added success!"></Toast>}
            {/* <h2>Id for update: </h2> */}
            <form>
                <div className="form-group"></div>
                <label for="name">Name:</label>
                <input type="text" className="form-control" id="name" name="name" value={employee.name} onChange={handleInputChange} required/>
                <div className="form-group"></div>
                <label for="department">Department:</label>
                <input type="text" className="form-control" id="department" name="department" value={employee.department} onChange={handleInputChange} required/>
                <div className="form-group"></div>
            </form>
            {/* <button onClick={addEmployee} className="btn btn-primary">Add</button>
             */}
             <Button variant="secondary" onClick={addEmployee}>Add</Button>  {/* Bootstrap 4 */}
             <Button variant="secondary" onClick={updateEmployee}>Update</Button>  {/* Bootstrap 4 */}
        </div>
    )
}

export default AddEmployee;