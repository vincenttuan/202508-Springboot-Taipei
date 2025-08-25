/*
表頭: StudentTableHeader
表身: StudentTableBody
表尾: StudentTableFooter
主表: StudentTable(組合表頭+表身+表尾)
*/

// 子組件-表頭 StudentTableHeader
function StudentTableHeader() {
    return(
        <thead>
            <tr><th>ID</th><th>姓名</th><th>分數</th><th>及格</th></tr>
        </thead>
    )
}

// 子組件-表身 StudentTableBody
function StudentTableBody({students}) {
    return(
        <tbody>
            {
                students.map((student => {
                    const isPass = student.score >= 60;
                    return (
                        <tr key={student.id}>
                            <td>{student.id}</td>
                            <td>{student.name}</td>
                            <td align="right">{student.score}</td>
                            <td>{isPass ? "V" : "X"}</td>
                        </tr>
                    )
                }))
            }
        </tbody>
    )
}

// 子組件-表尾 StudentTableFooter
function StudentTableFooter({avgScore}) {
    <tfoot>
        <tr>
            <td colspan="2" align="right">平均</td>
            <td align="right">{avgScore.toFixed(1)}</td>
            <td></td>
        </tr>
    </tfoot>
}
