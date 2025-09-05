function TodoList({todos, changeCompleted}) {
    return(
        <ul>
        {
            todos.map((todo, index) => (
                <li key={todo.id}>
                {index} - {todo.id} - {todo.text} - 
                <input type="checkbox" checked={todo.completed} onChange={() => changeCompleted(todo.id)} />
                </li>
            ))
        }
        </ul>
    )

}

export default TodoList;