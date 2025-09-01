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

    const handleChange = (e) => {
        // 從事件物件 e 中取得目標元素(input)屬性的 name 與 value
        const {name, value} = e.target;
        // 呼叫 setForm 更新狀態
        // 利用展開運算子 ...prev 保留原本其他欄位的資料
        // 最後根據 name 來設定新的 value 進行該欄位的更新
        setForm((prev) => ({...prev, [name]: value}));
    };

    // 新增
    const addPost = async () => {
        await fetch(API_URL, {
            method: "POST",
            headers: {"Content-Type": "application/json"},
            body: JSON.stringify({title: form.title, views: Number(form.views)})
        });
        // 表單清空
        setForm({id: "", title: "", views: ""});
        // 重載資料
        fetchPosts();
    };

    // 編輯
    const editPost = (post) => {
        setForm({id: post.id, title: post.title, views: post.views});
    };

    // 修改
    const updatePost = async () => {
        await fetch(`${API_URL}/${form.id}`, {
            method: "PUT",
            headers: {"Content-Type": "application/json"},
            body: JSON.stringify({title: form.title, views: Number(form.views)})
        })
        // 表單清空
        setForm({id: "", title: "", views: ""});
        // 重載資料
        fetchPosts();
    };

    // 刪除 Delete
    const deletePost = async (id) => {
        await fetch(`${API_URL}/${id}`, {
            method: "DELETE"
        });
        // 重載資料
        fetchPosts();
    };

    // 網頁載入完畢之後要執行某個方法
    useEffect(() => {
        fetchPosts();
    }, [])

    return(
        <div className="pure-form">
            <h1>貼(PO)文管理-使用 fetch</h1>
            標題: <input name="title" placeholder="請輸入標題" value={form.title} onChange={handleChange} /><p />
            點閱: <input name="views" placeholder="請輸入瀏覽量" value={form.views} onChange={handleChange} /><p />

            <button className="pure-button pure-button-primary" onClick={updatePost}>修改貼文</button>
            &nbsp;
            <button className="pure-button pure-button-primary" onClick={addPost}>新增貼文</button>
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
                                <td><button className="pure-button pure-button-primary" onClick={() => editPost(post)}>編輯</button></td>
                                <td><button className="pure-button pure-button-primary" onClick={() => deletePost(post.id)}>刪除</button></td>
                            </tr>
                        ))
                    }
                    
                </tbody>
            </table>

        </div>
    )
}

export default App19;
