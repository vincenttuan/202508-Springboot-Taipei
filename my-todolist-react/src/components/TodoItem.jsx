function TodoItem({index, todo, changeCompleted, onDelete}) {

    return(
        <li key={todo.id}
            className={`list-group-item d-flex justify-content-between align-items-center ${
                todo.completed ? 'list-group-item-success' : ''
            }`}
        >
            {index} - {todo.id} - {todo.text} - 
            <input className="me-2" type="checkbox" checked={todo.completed} onChange={() => changeCompleted(todo.id)} />
            <button className="btn btn-danger btn-sm" onClick={() => onDelete(todo.id)}>X</button>
        </li>
    )

}

export default TodoItem;