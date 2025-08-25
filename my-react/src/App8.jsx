// 物件陣列 map + filter 過濾
function App8() {
    // 物件陣列
    const items = [
        {id:1 , name:'Apple', price:20},
        {id:2 , name:'Banana', price:30},
        {id:3 , name:'Orange', price:40},
    ]

    // 陣列過濾 price > 25
    const filterItems = items.filter((item) => item.price > 25)

    return (
        <>
            {
                filterItems.map((item, index) => (
                    <div key={item.id}>
                        index={index} id={item.id} name={item.name} price={item.price}
                    </div>
                ))
            }        
        </>
    )
}

export default App8;
