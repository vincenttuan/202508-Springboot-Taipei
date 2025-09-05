import TodoItem from "./TodoItem";

function TodoList({todos, changeCompleted}) {
    return(
        <ul className="list-group">
        {
            todos.map((todo, index) => (
                <TodoItem index={index} todo={todo} changeCompleted={changeCompleted} />
            ))
        }
        </ul>
    )

}

export default TodoList;