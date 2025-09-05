import { useState } from 'react'
import './App.css'

// useState 的應用
function App() {

  const [todos, setTodos] = useState(['吃早餐', '做運動', '寫程式', '玩遊戲']);

  const [todo, setTodo] = useState('');

  const handleChange = (e) => {
    // 設定 todo 的內容就是欄位所輸入的內容
    setTodo(e.target.value);
  };

  const handleClick = (e) => {
    // 若 todo 沒資料則離開
    if(!todo) return; 
    // 在原本的 todo 資料後面加上新的 todo
    setTodos([...todos, todo]);
    // todo 清空
    setTodo('');
  };

  return (
    <>
      <h1>My Todo List</h1>
      <div>
        <input type="text" value={todo} onChange={handleChange} />
        <button onClick={handleClick}>Add</button>
      </div>
      <ul>
        {
          todos.map((todo, index) => (
            <li key={index}>
              {index} - {todo}
            </li>
          ))
        }

      </ul>
    </>
  )
}

export default App