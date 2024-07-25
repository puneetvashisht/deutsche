import { useState , useEffect} from "react";
const ViewEmployees = () => {
    const [employees, setEmployees] = useState([]);
    const [loading, setLoading] = useState(true);

    // Fetch data on component mount and whenever the data changes (employees array)
    useEffect(() => {
        fetch('http://localhost:8000/employees')
            .then(response => response.json())
            .then(data => {
                setEmployees(data);
                setLoading(false);
            })
            .catch(error => console.error('Error:', error));
    }, []);

    const deleteEmployee = (id) => {
        fetch(`http://localhost:8000/employees/${id}`, {
            method: 'DELETE',
        })
       .then(response => response.json())
       .then(data => {
         const updatedEmployees = employees.filter(employee => employee.id!== id);
         setEmployees(updatedEmployees);
    })
    }

    if (loading) {
        return <h2>Loading...</h2>;
    }

    let employeeList = employees.map(employee => 
         (
            <tr key={employee.id}>
                <td>{employee.id}</td>
                <td>{employee.name}</td>
                <td>{employee.department}</td> 
                <td><button onClick={()=>deleteEmployee(employee.id)} className="btn btn-danger"> X </button></td> 
            </tr>
        )
    )

    return (
        <div>
            <h2>Employees</h2>
            <table className="table">
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Department</th>
                    <th>Actions</th>
                </tr>
                {employeeList}
            </table>
        </div>
    );
};

export default ViewEmployees;