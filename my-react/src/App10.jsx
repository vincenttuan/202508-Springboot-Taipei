function App10() {
    // 全班成績
    const students = [
        {id:1, name:'小明', scores: {chinese: 80, math: 70, english: 90}},
        {id:2, name:'小華', scores: {chinese: 60, math: 85, english: 75}},
        {id:3, name:'小美', scores: {chinese: 95, math: 88, english: 92}},
        {id:4, name:'小強', scores: {chinese: 70, math: 65, english: 80}}
    ];

    // 以 <table>印出
    // 學號(id) 姓名(name) 國文(chinese) 數學(math) 英文(english) 個人平均
    // 最後印出全班平均

    // 全班平均
    const classAvg = students.reduce((sum, student) => 
        sum + (student.scores.chinese + student.scores.math + student.scores.english)/3, 0) / students.length;

    return(
        <>
            <h1>期末成績</h1>
            <h2>班平均: {classAvg.toFixed(1)}</h2>
            <table border="1">
                <thead>
                    <tr>
                        <th>學號(id)</th><th>姓名(name)</th><th>國文(chinese)</th>
                        <th>數學(math)</th><th>英文(english)</th><th>個人平均</th>
                    </tr>
                </thead>
                <tbody>
                    {
                        students.map((student) => {
                            const avg = (student.scores.chinese + student.scores.math + student.scores.english)/3;
                            return (
                                <tr key={student.id}>
                                    <td>{student.id}</td>
                                    <td>{student.name}</td>
                                    <td>{student.scores.chinese}</td>
                                    <td>{student.scores.math}</td>
                                    <td>{student.scores.english}</td>
                                    <td>{avg.toFixed(1)}</td>
                                </tr>
                            )
                        })
                    }
                </tbody>
            </table>
        </>
    )
}

export default App10;