import { useState, useEffect } from "react";

const API_URL = "http://localhost:3000/posts";

function App19() {
    const [posts, setPosts] = useState([]);
    const [form, setForm] = useState({id: "", title: "", views: ""});

    const fetchPosts = async() => {
        const res = await fetch(API_URL);
        const data = await res.json();
        console.log(data);
        setPosts(data);
    }

    // 網頁載入完畢之後要執行某個方法
    useEffect(() => {
        fetchPosts();
    }, [])

    return(
        <div className="pure-form">
            <h1>貼(PO)文管理-使用 fetch</h1>
            標題: <input name="title" placeholder="請輸入標題" value={form.title} /><p />
            點閱: <input name="views" placeholder="請輸入瀏覽量" value={form.views} /><p />

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
                    {
                        posts.map((post) => (
                            <tr key={post.id}>
                                <td>{post.id}</td>
                                <td>{post.title}</td>
                                <td>{post.views}</td>
                                <td><button className="pure-button pure-button-primary">編輯</button></td>
                                <td><button className="pure-button pure-button-primary">刪除</button></td>
                            </tr>
                        ))
                    }
                    
                </tbody>
            </table>

        </div>
    )
}

export default App19;
