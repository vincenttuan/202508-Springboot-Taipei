/**
 * 有五種食物
 * 餅乾 150卡
 * 蛋糕 300卡
 * 水果 80卡
 * 記錄吃了幾種食物並計算大卡
 */

import { useState } from "react";

function App17() {
    // 定義食物及熱量
    const food1 = { name: "餅乾", calories: 150 };
    const food2 = { name: "蛋糕", calories: 300 };
    const food3 = { name: "水果", calories: 80 };

    // 利用 useState 來記錄每種食物的份數 
    const [count1, setCount1] = useState(0);
    const [count2, setCount2] = useState(0);
    const [count3, setCount3] = useState(0);
    
    // 總熱量
    const [calories, setCalories] = useState(0);
    
    // 吃指定食物
    function eatFood(foodNumber) {
        switch(foodNumber) {
            case 1: // 餅乾
                setCount1(count1 + 1);
                setCalories(calories + food1.calories);
            case 2: // 蛋糕
                setCount2(count2 + 1);
                setCalories(calories + food2.calories);
            case 3: // 水果
                setCount3(count3 + 1);
                setCalories(calories + food3.calories);
        }
    }

    function reset() {
        setCount1(0);
        setCount2(0);
        setCount3(0);
        setCalories(0);
    }

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

