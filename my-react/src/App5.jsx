// 按鈕事件
function App5() {
    const clickMe = function() {
        alert('Click me');
    }
    const clickMe2 = (e) => {
        alert('Click me2');
    }
    return (
        <>
            <button onClick={clickMe}>按我一下</button>
            <button onClick={clickMe2}>按我一下</button>
        </>
    )
}
export default App5
