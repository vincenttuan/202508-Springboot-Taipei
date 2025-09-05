function TodoItem({index, todo, changeCompleted}) {

    return(
        <li key={todo.id}
            className={`list-group-item d-flex justify-content-between align-items-center ${
                todo.completed ? 'list-group-item-success' : ''
            }`}
        >
            {index} - {todo.id} - {todo.text} - 
            <input className="me-2" type="checkbox" checked={todo.completed} onChange={() => changeCompleted(todo.id)} />
        </li>
    )

}

export default TodoItem;