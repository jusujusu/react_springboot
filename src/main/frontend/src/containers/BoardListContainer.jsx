//게시글 목록 화면 컴포넌트
import {Link} from "react-router-dom";

const BoardListContainer = () => {
    return (
        <div>
            {/*제목*/}
            <h1>게시글 목록</h1>
            {/*글쓰기로 가는 링크*/}
            <Link to="/boards/insert">글쓰기</Link>
            <hr/>
            {/*게시글 조회 임시링크*/}
            <Link to="/boards/10">게시글 조회(10)</Link>
        </div>
    );
};

export default BoardListContainer;