// 陣列
function App6() {
    const fruits = ['Apple', 'Banana', 'Orange'];
    // key 是用來幫助 React 來識別每個元素的唯一性
    const fruits2 = [
        <li key='0'>0-Apple</li>,
        <li key='1'>1-Banana</li>,
        <li key='2'>2-Orange</li>
    ]
    // 使用 map 來走訪並渲染 fruits
    const fruits3 = fruits.map((fruit, index) => (<li key={index}>{index}-{fruit}</li>))

    return(
        <>
            {fruits}
            {fruits2}
            {fruits3}
        </>
    )

}

export default App6
