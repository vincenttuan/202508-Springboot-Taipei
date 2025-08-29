/**
 * 有五種食物
 * 餅乾 150卡
 * 蛋糕 300卡
 * 水果 80卡
 * 記錄吃了幾種食物並計算大卡
 */

function App17() {
    return(
        <>
            <h1>多樣點心模擬器</h1>
            <h2>攝取熱量: 0 卡</h2>
            <ul>
                <li>餅乾 : 0 份</li>
                <li>蛋糕 : 0 份</li>
                <li>水果 : 0 份</li>
            </ul>
            <p />
            <button>吃餅乾 (+150卡)</button>
            <button>吃蛋糕 (+300卡)</button>
            <button>吃水果 (+80卡)</button>
            <button>清除 (歸 0)</button>
        </>
    )
}

export default App17;

