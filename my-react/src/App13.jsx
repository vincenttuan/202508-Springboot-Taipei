// 組件間參數的傳遞
// 子組件 
function CircleArea({r}) {
    const pi = 3.1415926;
    const area = r * r * pi;
    return (<div>{area}</div>)
}

function Beverage({name, price}) {
    return (<div>飲料名稱:{name} 價格:{price}</div>)
}

function Drink(props) {
    return (<div>飲料名稱:{props.name} 價格:{props.price}</div>)
}

function App13() {
    return (
        <>
            <CircleArea r="10" />
            <CircleArea r="25" />
            <Beverage name="奶茶" price="15" />
            <Drink name="啤酒" price="40" />
        </>
    )
}

export default App13;
