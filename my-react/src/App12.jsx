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

