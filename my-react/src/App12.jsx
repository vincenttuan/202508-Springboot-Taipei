import StudentTable from "./Student"
// 父組件 
function App12() {
    const students = [
        {id:1, name:'小明', score:55},
        {id:2, name:'小美', score:78},
        {id:3, name:'小華', score:92},
        {id:4, name:'阿強', score:40},
    ];

    // 計算平均
    const avgScore = students.reduce((sum, student) => sum + student.score, 0) / students.length;

    return(
        <>
            <h1>學生成績列表</h1>
            <StudentTable students={students} avgScore={avgScore} />
        </>
    )
}

export default App12
