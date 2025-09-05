import './App.css'

// 陣列應用
function App() {

  const todos = ['吃早餐', '做運動', '寫程式', '玩遊戲']

  return (
    <>
      <h1>My Todo List</h1>
      <div>
        <input type="text" />
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