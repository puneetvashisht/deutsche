import { useState , useEffect} from "react";
import { Link, useRouteMatch } from'react-router-dom';
import axios from 'axios';
const ViewCourses = () => {
    const [courses, setCourses] = useState([]);
    const [loading, setLoading] = useState(true);

    // Fetch data on component mount and whenever the data changes (employees array)
    const fetchCourses = async () => {
        const response = await axios.get('http://localhost:8000/api/v1/courses/');
        setCourses(response.data);
        setLoading(false);
    }


    useEffect(() => {
        fetchCourses();
        // const response = await axios.get('http://localhost:8000/employees');
        // setEmployees(response.data);
        // setLoading(false);

        // axios.get('http://localhost:8000/employees')
        // .then(response => {
        //     setEmployees(response.data);
        //     setLoading(false);
        // })

        // fetch('http://localhost:8000/employees')
        //     .then(response => response.json())
        //     .then(data => {
        //         setEmployees(data);
        //         setLoading(false);
        //     })
        //     .catch(error => console.error('Error:', error));
    }, []);

    const deleteCourse = (id) => {
        fetch(`http://localhost:8000/api/v1/courses/${id}`, {
            method: 'DELETE'
        })
       .then(response => response.json())
       .then(data => {
         const updatedEmployees = courses.filter(c => c.id!== id);
         setCourses(updatedEmployees);
    })
    }

    if (loading) {
        return <h2>Loading...</h2>;
    }

    let courseList = courses.map(course => 
         (
            <tr key={course.id}>
                <td>{course.id}</td>
                <td><Link to={`update/${course.id}`} className="btn btn-primary">{course.title}</Link></td>
                <td>{course.description}</td> 
                <td>{course.price}</td> 
                <td><button onClick={()=>deleteCourse(course.id)} className="btn btn-danger"> X </button></td> 
            </tr>
        )
    )

    return (
        <div>
            <h2>Courses</h2>
            <table className="table">
                <tr>
                    <th>ID</th>
                    <th>title</th>
                    <th>Description</th>
                    <th>Price</th>
                    <th>Actions</th>
                </tr>
                {courseList}
            </table>
        </div>
    );
};

export default ViewCourses;