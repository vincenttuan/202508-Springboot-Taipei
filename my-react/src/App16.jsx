/**
 * 一杯水 250cc
 * 每按下一次表示喝了一杯 +1
 * 目標是 3000cc
 * 要顯示目前所喝的水量與目標量
 * 
 */
import { useState } from "react";

function App16() {
    const maxCC = 3000; // 目標 cc
    const cupCC = 250; // 一杯 cc
    const [cups, setCups] = useState(0); // 紀錄喝了幾杯

    // 已喝水量
    const drankCC = cups * cupCC;

    // 喝水(每次一杯)
    function drinkWater() {
        if(drankCC >= maxCC) return;
        setCups(cups + 1);
    }

    // 吐一杯水
    function drawWater() {
        if(drankCC <= 0) return;
        setCups(cups - 1);
    }

    // 清除
    function reset() {
        setCups(0);
    }

    return(
        <>
            <h1>飲水紀錄</h1>
            <div>
                已喝了 {drankCC} / {maxCC} cc
            </div>
            <button onClick={drinkWater}>喝一杯水 (250cc)</button>
            <button onClick={drawWater}>吐一杯水 (-250cc)</button>
            <button onClick={reset}>清除記錄 (歸 0)</button>
        </>
    )
}

export default App16;