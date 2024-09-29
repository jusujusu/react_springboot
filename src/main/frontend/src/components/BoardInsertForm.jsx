import React from 'react';

const BoardInsertForm = () => {
    return (
        <div>
            <h1>게시글 등록</h1>
            <table>
                <tbody>
                <tr>
                    <td>제목</td>
                    <td>
                        <input type='text' value={} onChange={}/>
                    </td>
                </tr>
                <tr>
                    <td>작성자</td>
                    <td>
                        <input type='text' value={} onChange={}/>
                    </td>
                </tr>
                <tr>
                    <td>내용</td>
                    <td>
                        <textarea cols="40" rows="10"
                                  value={} onChange={}/>
                    </td>
                </tr>
                </tbody>
            </table>
        </div>
    );
};

export default BoardInserForm;