/* TodoList REST Api

src/
├── api_services/
│   └── todo_services.js
│
├── components/
│   ├── TodoInput.jsx
│   ├── TodoItem.jsx
│   └── TodoList.jsx
└── App6.jsx

*/

import { useState, useEffect } from "react";
import './App.css'
import TodoInput from './components/TodoInput';
import TodoList from './components/TodoList';
import 'bootstrap/dist/css/bootstrap.min.css'; // 引入 Bootstrap css 樣式
import { fetchTodos, addTodo, updateTodo, deleteTodo } from './api_services/todo_services';

function App() {
    const [todos, setTodos] = useState([]); // 存放所有代辦事項(給列表用)
    const [text, setText] = useState(''); // 存放代辦事項(給表單用)

    useEffect(() => {
        // 取得所有代辦事項
        fetchTodos()
            .then(setTodos)
            .catch((error) => console.error('error:', error));
    }, []);

    // 新增代辦事項
    const handleAdd = async () => {
        if(!text) return;
        const newTodo = {text: text, completed: false};
        const addedTodo = await addTodo(newTodo);
        setTodos([...todos, addedTodo]);
        setText('');
    }

    const handleChange = (e) => {
        setText(e.target.value);
    }

    // 修改代辦事項
    const handleUpdate = async(id) => {
        // 根據 id 找到要變更的 todo
        const updatedTodo = todos.find((todo) => todo.id === id);
        // 是否有找到資料
        if(!updatedTodo) return;
        // 變更 completed 狀態更新(地端更新)
        updatedTodo.completed = !updatedTodo.completed;
        // 調用 updateTodo 方法進行更新(雲端更新)
        await updateTodo(updatedTodo);
        // 重新渲染
        setTodos([...todos])
    }

    // 刪除代辦事項
    const handleDelete = async (id) => {
        await deleteTodo(id)
                .then((data) => {
                    setTodos(todos.filter((todo) => todo.id !== id));
                    console.log(data);
                })
                .catch((error) => console.error('error:', error));
    }

    return (
    <div className='container mt-5'>
      <h1 className='text-center mb-4'>My Todo List</h1>
      <TodoInput todo={text} handleChange={handleChange} handleClick={handleAdd} />
      <TodoList todos={todos} changeCompleted={handleUpdate} onDelete={handleDelete} />
    </div>
  )

}

export default App;