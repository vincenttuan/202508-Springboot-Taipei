// JSX = Javascript + HTML
// App3() 表示是一個 react 組件, 字首一定要大寫
// return() <-- 裡面只能放單一標籤
//              若要放多標籤則必須使用<> ... </>或<div> ... </div>來圈住標籤
// 組件可分為父子二種
// 建立組件有二種寫法
// 1. function
// 2. () => 函數式 

// 子組件 1
function Hello() {
    return (<h1>Hello</h1>)
}

// 子組件 2
const World = () => {
    return (<h1>World</h1>)
}

// 父組件
function App3() {
    return(
        <>
            <Hello />
            <World />
        </>
    )
}

export default App3
