import TodoItem from "./TodoItem";

function TodoList({todos, changeCompleted, onDelete}) {
    return(
        <ul className="list-group">
        {
            todos.map((todo, index) => (
                <TodoItem key={todo.id} index={index} todo={todo} changeCompleted={changeCompleted} onDelete={onDelete} />
            ))
        }
        </ul>
    )

}

export default TodoList;