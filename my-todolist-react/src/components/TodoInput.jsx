function TodoInput({todo, handleChange, handleClick}) {

    return(
        <div>
            <input type="text" value={todo} onChange={handleChange} />
            <button onClick={handleClick}>Add</button>
        </div>
    )

}

export default TodoInput;