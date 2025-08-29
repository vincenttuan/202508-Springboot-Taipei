// 渲染
function App14() {
    let count = 0;

    function handleClick() {
        count++;
        document.getElementById('count').textContent = count; // 手動資料渲染
    }

    return(
        <>
            <div id='count'>0</div>
            <button onClick={handleClick}>按我一下</button>
        </>
    )
}

export default App14;
