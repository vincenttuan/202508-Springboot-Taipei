/**
 * 有五種食物
 * 餅乾 150卡
 * 蛋糕 300卡
 * 水果 80卡
 * 記錄吃了幾種食物並計算大卡
 */

import { useState } from "react";

function App18() {
    // 定義食物及熱量
    const food1 = { name: "餅乾", calories: 150 };
    const food2 = { name: "蛋糕", calories: 300 };
    const food3 = { name: "水果", calories: 80 };

    
    return(
        <>
            <h1>多樣點心模擬器</h1>
            <h2>攝取熱量: 0 卡</h2>
            <ul>
                <li>xx : 份</li>
            </ul>
            <p />
            <button>吃xx (+0卡)</button>
            <button>清除 (歸 0)</button>
        </>
    )
}

export default App18;

