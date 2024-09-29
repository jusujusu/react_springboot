import React from 'react';
import {Link} from "react-router-dom";

const BoardList = ({boardList}) => {
    return (
        <div>
            {/*제목*/}
            <h1>게시글 목록</h1>
            {/*글쓰기로 가는 링크*/}
            <Link to="/boards/insert">글쓰기</Link>
            <table>
                <thead>
                <tr>
                    <th align='100'>번호</th>
                    <th align='100'>제목</th>
                    <th align='100'>작성자</th>
                    <th align='100'>등록일자</th>
                </tr>
                </thead>
                <tbody>
                {/*
                .map( (변수이름설정) =>
                    ()를 사용하는 경우 return 생략
                    {}를 사용하는 경우 return 작성
                )
                .map(() => ())
                .map(() => {return ()})
                */}
                {boardList.map((board) => (
                    <tr>
                        <td align='center'>{board.id}</td>
                        <td align='left'>
                            <Link to={`/boards/${board.id}`}>{board.title}</Link>
                        </td>
                        <td align='center'>{board.writer}</td>
                        <td align='center'>{board.regDate}</td>
                    </tr>
                ))}
                </tbody>
            </table>
        </div>
    );
};

export default BoardList;