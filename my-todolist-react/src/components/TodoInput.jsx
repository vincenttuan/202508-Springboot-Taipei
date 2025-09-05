function TodoInput({todo, handleChange, handleClick}) {

    return(
        <div className="input-group mb-3">
            <input className="form-control" type="text" value={todo} onChange={handleChange} />
            <button className="btn btn-primary" onClick={handleClick}>Add</button>
        </div>
    )

}

export default TodoInput;