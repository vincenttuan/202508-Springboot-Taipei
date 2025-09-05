function TodoItem({index, todo, changeCompleted}) {

    return(
        <li key={todo.id}>
            {index} - {todo.id} - {todo.text} - 
            <input type="checkbox" checked={todo.completed} onChange={() => changeCompleted(todo.id)} />
        </li>
    )

}

export default TodoItem;