function App19() {
    return(
        <div>
            <h1>貼(PO)文管理-使用 fetch</h1>
            標題: <input name="title" placeholder="請輸入標題" /><p />
            點閱: <input name="views" placeholder="請輸入瀏覽量" /><p />

            <button>修改貼文</button>
            <button>新增貼文</button>
            <p />
            <table border="1" align="center">
                <thead>
                    <tr>
                        <th>id</th><th>title</th><th>views</th><th>編輯</th><th>刪除</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>1</td>
                        <td>My title</td>
                        <td>999</td>
                        <td><button>編輯</button></td>
                        <td><button>刪除</button></td>
                    </tr>
                </tbody>
            </table>

        </div>
    )
}

export default App19;
