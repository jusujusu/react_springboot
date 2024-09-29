//게시글 목록 화면 컴포넌트
import {Link} from "react-router-dom";
import * as boards from '../apis/boards'
import {useEffect, useState} from "react";
import axios from "axios";
import BoardList from "../components/BoardList.jsx";

// 게시글 목록
const BoardListContainer = () => {

    // 게시글 목록 state 설정
    const [boardList, setBoardList] = useState([]);


    // 게시글 목록 데이터
    // 비동기식 방식을 이용해 가져옴
    const getBoardList = async () => {
        const response = await boards.list();
        console.log(response.data);
        setBoardList(response.data);

    };




    // 받아온 게시글을 마운팅 되었을때 실행되도록
    useEffect(() => {
        getBoardList();
    }, []);



    return (
        <div>
            {/*게시글 조회 임시링크*/}
            {/*<Link to="/boards/10">게시글 조회(10)</Link>*/}
            <BoardList boardList={boardList}></BoardList>
        </div>
    );
};

export default BoardListContainer;