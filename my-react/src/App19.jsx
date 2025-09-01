function App19() {
    return(
        <div className="pure-form">
            <h1>貼(PO)文管理-使用 fetch</h1>
            標題: <input name="title" placeholder="請輸入標題" /><p />
            點閱: <input name="views" placeholder="請輸入瀏覽量" /><p />

            <button className="pure-button pure-button-primary">修改貼文</button>
            &nbsp;
            <button className="pure-button pure-button-primary">新增貼文</button>
            <p />
            <table className="pure-table pure-table-bordered" align="center">
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
                        <td><button className="pure-button pure-button-primary">編輯</button></td>
                        <td><button className="pure-button pure-button-primary">刪除</button></td>
                    </tr>
                </tbody>
            </table>

        </div>
    )
}

export default App19;
