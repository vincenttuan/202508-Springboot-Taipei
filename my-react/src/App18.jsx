/**
 * 有五種食物
 * 餅乾 150卡
 * 蛋糕 300卡
 * 水果 80卡
 * 記錄吃了幾種食物並計算大卡
 */

import { useState } from "react";

function App18() {
    // 食物陣列(定義食物及熱量)
    const foods = [
        { name: "餅乾", calories: 150 },
        { name: "蛋糕", calories: 300 },
        { name: "水果", calories: 80 },
        { name: "巧克力", calories: 250 },
    ];

    // 利用 useState 來記錄每種食物的份數
    //const [counts, setCounts] = useState([0, 0, 0]);
    const [counts, setCounts] = useState(Array(foods.length).fill(0));

    // 總熱量
    const [calories, setCalories] = useState(0);

    // 吃指定食物
    function eatFood(i) {
        // 取得 counts 陣列資料
        //const currentCounts = Array.from(counts);
        const currentCounts = [...counts];
        currentCounts[i] += 1;

        setCounts(currentCounts);
        setCalories(calories + foods[i].calories);
    }

    // 清除/重置
    function reset() {
        setCounts(Array(foods.length).fill(0));
        setCalories(0);
    }

    
    return(
        <>
            <h1>多樣點心模擬器</h1>
            <h2>攝取熱量: {calories} 卡</h2>
            <ul>
                {
                    foods.map((food, i) => (
                        <li key={i}>{food.name} : {counts[i]} 份</li>
                    ))
                }
            </ul>
            <p />
            {
                foods.map((food, i) => (
                    <button onClick={() => eatFood(i)}>吃{food.name} (+{food.calories}卡)</button>
                ))
            }
            
            <button onClick={reset}>清除 (歸 0)</button>
        </>
    )
}

export default App18;

