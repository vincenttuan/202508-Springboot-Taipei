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
                        index={index} id={item.id} name={item.name} price={item.price}
                    </div>
                ))
            }        
        </>
    )
}

export default App7;
