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
                break;
            case 2: // 蛋糕
                setCount2(count2 + 1);
                setCalories(calories + food2.calories);
                break;
            case 3: // 水果
                setCount3(count3 + 1);
                setCalories(calories + food3.calories);
                break;
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
            <h2>攝取熱量: {calories} 卡</h2>
            <ul>
                <li>{food1.name} : {count1} 份</li>
                <li>{food2.name} : {count2} 份</li>
                <li>{food3.name} : {count3} 份</li>
            </ul>
            <p />
            <button onClick={() => eatFood(1)}>吃{food1.name} (+{food1.calories}卡)</button>
            <button onClick={() => eatFood(2)}>吃{food2.name} (+{food2.calories}卡)</button>
            <button onClick={() => eatFood(3)}>吃{food3.name} (+{food3.calories}卡)</button>
            <button onClick={reset}>清除 (歸 0)</button>
        </>
    )
}

export default App17;

