import { useState } from 'react'
import './App.css'

// useState 的應用
function App() {

  const [todos, setTodos] = useState(['吃早餐', '做運動', '寫程式', '玩遊戲']);

  const [todo, setTodo] = useState('');


  return (
    <>
      <h1>My Todo List</h1>
      <div>
        <input type="text" value={todo} />
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