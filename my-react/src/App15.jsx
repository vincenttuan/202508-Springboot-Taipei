// 利用 useState 自動渲染
import { useState } from "react";

function App15() {
    // 設定一個 count 變數, 外界可以透過 setCount 來改變內容
    // count 變數的預設值 = 0
    const [count, setCount] = useState(0);

    function handleClick() {
        setCount(count + 1);
    }

    return(
        <>
            <div>{count}</div>
            <button onClick={handleClick}>按我一下</button>
        </>
    )
}

export default App15;
