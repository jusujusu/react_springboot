//게시글 조회
import {Link, useParams} from "react-router-dom";

const BoardReadContainer = () => {
    //게시글 번호를 받아오는 hook
    const {no} = useParams();

    return (
        <div>
            <h1>게시글 조회</h1>
            {/*useParams로 받아온 게시글 번호*/}
            <h3>번호 : {no}</h3>
            {/*목록으로 이동하는 링크*/}
            <Link to="/boards">목록</Link>
            <hr/>
            {/*수정 페이지로 이동하는 링크*/}
            <Link to={`/boards/update/${no}`}>수정</Link>
        </div>
    );
};

export default BoardReadContainer;