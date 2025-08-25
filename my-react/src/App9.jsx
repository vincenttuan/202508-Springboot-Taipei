/*
隨堂練習
商品資料如下:
    { id: 1, name: '蘋果', price: 40, category: '水果', qty:2 },
    { id: 2, name: '洗髮精', price: 120, category: '日用品', qty:4 },
    { id: 3, name: '香蕉', price: 55, category: '水果', qty:6 },
    { id: 4, name: '牙膏', price: 45, category: '日用品', qty:8 }
請利用 react 將上述商品資料透過 jsx + <table> 標籤呈現
*/

function App9() {
    const products = [
        { id: 1, name: '蘋果', price: 40, category: '水果', qty:2 },
        { id: 2, name: '洗髮精', price: 120, category: '日用品', qty:4 },
        { id: 3, name: '香蕉', price: 55, category: '水果', qty:6 },
        { id: 4, name: '牙膏', price: 45, category: '日用品', qty:8 }
    ];

    return(
        <>
            <h1>商品列表</h1>
            <table border="1">
                <thead>
                    <tr>
                        <th>ID</th><th>種類</th><th>名稱</th><th>價格</th><th>數量</th><th>小計</th>
                    </tr>
                </thead>
                <tbody>
                    {
                        products.map((product) => {
                            const subTotal = product.price * product.qty;
                            return (
                                <tr key={product.id}>
                                    <td>{product.id}</td>
                                    <td>{product.category}</td>
                                    <td>{product.name}</td>
                                    <td>{product.price}</td>
                                    <td>{product.qty}</td>
                                    <td>{subTotal}</td>
                                </tr>
                            )
                        })
                    }
                </tbody>
            </table>
        </>
    )
}

export default App9;
