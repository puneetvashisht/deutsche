import { useState , useEffect} from "react";
function Clock() {
    const [date, setDate] = useState(new Date());

    // its called up on component mount
    useEffect(() => {
        setInterval(() => {
            setDate(new Date());
        }, 1000);
    }, []);

    return (
        <div>
            <h2>Current Date and Time:</h2>
            <h3> {date.getHours()} : {date.getMinutes()} : {date.getSeconds()}</h3>
        </div>
    );
}

export default Clock;