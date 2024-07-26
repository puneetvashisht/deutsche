const DropdownItem = ({ text, whenItemClicked }) => {

    const handleItemClick = () => {
        console.log(text +'selected'  );
        whenItemClicked(text);
    };

    return (
        <li onClick={handleItemClick} className="dropdown-item">{text}</li>
    );
};
export default DropdownItem;