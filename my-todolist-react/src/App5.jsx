/* TodoList 拆分模組練習
src/
├── components/
│   ├── TodoInput.jsx
│   ├── TodoItem.jsx
│   └── TodoList.jsx
├── App5.jsx
├── App.css
*/
import { useState } from 'react'
import './App.css'
import TodoInput from './components/TodoInput';
import TodoList from './components/TodoList';
import 'bootstrap/dist/css/bootstrap.min.css'; // 引入 Bootstrap css 樣式

// useState + 物件陣列的應用
function App() {

  const [todos, setTodos] = useState([
    {id: 1, text:'吃早餐', completed: true},
    {id: 2, text:'做運動', completed: false},
    {id: 3, text:'寫程式', completed: true},
    {id: 4, text:'玩遊戲', completed: false}
  ]);

  const [todo, setTodo] = useState('');

  const handleChange = (e) => {
    // 設定 todo 的內容就是欄位所輸入的內容
    setTodo(e.target.value);
  };

  const handleClick = (e) => {
    // 若 todo 沒資料則離開
    if(!todo) return; 
    // 取得目前最大的 id 值並加 1
    const newId = todo.length > 0 ? Math.max(...todos.map((t) => t.id)) + 1 : 1;
    // 新的 todo 物件
    const newTodo = {id: newId, text: todo, completed: false};
    // 在原本的 todo 資料後面加上新的 newTodo
    setTodos([...todos, newTodo]);
    // todo 清空
    setTodo('');
  };

  const changeCompleted = (id) => {
    setTodos(
      todos.map((todo) => todo.id === id ? {...todo, completed: !todo.completed} : todo)
    )
  }

  // 刪除代辦事項
  const handleDelete = (id) => {
    setTodos(todos.filter((todo) => todo.id !== id));
  }

  return (
    <div className='container mt-5'>
      <h1 className='text-center mb-4'>My Todo List</h1>
      <TodoInput todo={todo} handleChange={handleChange} handleClick={handleClick} />
      <TodoList todos={todos} changeCompleted={changeCompleted} onDelete={handleDelete} />
    </div>
  )
}

export default App