/**
 * 一杯水 250cc
 * 每按下一次表示喝了一杯 +1
 * 目標是 3000cc
 * 要顯示目前所喝的水量與目標量
 * 
 */

function App16() {
    return(
        <>
            <h1>飲水紀錄</h1>
            <div>
                已喝了 0 / 3000 cc
            </div>
            <button>喝一杯水 (250cc)</button>
            <button>清除記錄 (歸 0)</button>
        </>
    )
}

export default App16;