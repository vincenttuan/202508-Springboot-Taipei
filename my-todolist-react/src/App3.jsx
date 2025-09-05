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

  return (
    <>
      <h1>My Todo List</h1>
      <div>
        <input type="text" value={todo} onChange={handleChange} />
        <button>Add</button>
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