import React, { useEffect, useRef, useState } from'react';
import DropdownItem from './DropdownItem';
const Dropdown = () => {

    const [isOpen, setIsOpen] = useState(false);
    const [cuisines, setCuisines] = useState(['Indian', 'Mexican', 'Italian', 'American', 'Chinese']);
    const [caption, setCaption] = useState('Select a cuisine');

    const dropdownRef = useRef(123);

    // useEffect(() => {
    //     console.log('Initial render or update');
    //     // fetch('https://example.com/api/cuisines/'+caption)

    // }, [caption])
    

    const handleItemClick = (text) => {
        console.log(text +'selected in the parent'  );
        setCaption(text);
        setIsOpen(false);
    };

    const captureValue = () => {
        console.log(dropdownRef.current.value);
    } 

    let cuisineList = cuisines && cuisines.map((cuisine, index) => (
        <DropdownItem key={index} text={cuisine} whenItemClicked={handleItemClick}></DropdownItem>
    ));

    return (
        <div className="dropdown">
            <input ref={dropdownRef}  type="text" className="form-control" placeholder="Search for cuisine"/>
            <button onClick={captureValue}>Test</button>
             <pre>{dropdownRef.current}</pre>
           
            <button onClick={()=> setIsOpen(!isOpen)} className="btn btn-secondary dropdown-toggle" type="button" data-bs-toggle="dropdown" aria-expanded="false">
                {caption}
            </button>
            <ul className={isOpen?'dropdown-menu show': 'dropdown-menu'}>
                {cuisineList}
            </ul>
        </div>
    );
};

export default Dropdown;