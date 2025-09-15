/**
 * WEB API TodoList REST CRUD
 * ------------------------------------------------------
 * GET     localhost:8080/todolist/      取得所有代辦事項
 * POST    localhost:8080/todolist/      新增代辦事項
 * PUT     localhost:8080/todolist/{id}  修改指定代辦事項
 * DELETE  localhost:8080/todolist/{id}  刪除指定代辦事項
 * ------------------------------------------------------
 */
const BASE_URL = 'localhost:8080/todolist';

// 取得所有代辦事項
export const fetchTodos = async() => {
    const response = await fetch(BASE_URL);
    const result = await response.json();
    if(result.success) {
        return result.data; // 返回所有資料紀錄
    }
    throw new Error(result.message);
};

// 新增代辦事項
export const addTodo = async(todo) => {
    const response = await fetch(BASE_URL, {
        method: 'POST',
        headers: {
            'Content-type': 'application/json'
        },
        body: JSON.stringify(todo)
    });
    const result = await response.json();
    if(result.success) {
        return result.data; // 返回新增成功的資料
    }
    throw new Error(result.message);
};

// 修改指定代辦事項
export const updateTodo = async(updateTodo) => {
    const response = await fetch(`${BASE_URL}/${updateTodo.id}`, {
        method: 'PUT',
        headers: {
            'Content-type': 'application/json'
        },
        body: JSON.stringify(todo)
    });
    const result = await response.json();
    if(result.success) {
        return result.data; // 返回修改成功的資料
    }
    throw new Error(result.message);
};


// 刪除指定代辦事項
export const deleteTodo = async(id) => {
    const response = await fetch(`${BASE_URL}/${id}`, {
        method: 'DELETE'
    });
    const result = await response.json();
    if(response.success) {
        return true;
    }
    throw new Error(result.message);
};