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
    const [todo, setTodo] = useState(''); // 存放代辦事項(給表單用)

    useEffect(() => {
        // 取得所有代辦事項
        fetchTodos()
            .then(setTodos)
            .catch((error) => console.error('error:', error));
    }, []);


    return (
    <div className='container mt-5'>
      <h1 className='text-center mb-4'>My Todo List</h1>
      <TodoList todos={todos} />
    </div>
  )

}

export default App;