// 物件陣列 map
function App7() {
    // 物件陣列
    const items = [
        {id:1 , name:'Apple', price:20},
        {id:2 , name:'Banana', price:30},
        {id:3 , name:'Orange', price:40},
    ]

    return (
        <>
            {
                items.map((item, index) => (
                    <div>
                        {item.name} {item.price}
                    </div>
                ))
            }        
        </>
    )
}

export default App7;
