import React, { useState } from'react';
import DropdownItem from './DropdownItem';
const Dropdown = () => {

    const [isOpen, setIsOpen] = useState(false);
    const [cuisines, setCuisines] = useState(['Indian', 'Mexican', 'Italian', 'American', 'Chinese']);
    const [caption, setCaption] = useState('Select a cuisine');

    const handleItemClick = (text) => {
        console.log(text +'selected in the parent'  );
        setCaption(text);
        setIsOpen(false);
    };

    let cuisineList = cuisines.map((cuisine, index) => (
        <DropdownItem key={index} text={cuisine} whenItemClicked={handleItemClick}></DropdownItem>
    ));

    return (
        <div className="dropdown">
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