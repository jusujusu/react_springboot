//게시글 등록화면 컴포넌트
import {Link} from "react-router-dom";

const BoardInsertContainer = () => {
    return (
        <div>
            {/*제목*/}
            <h1>게시글 등록</h1>
            {/*목록으로 가는 링크*/}
            <Link to="/boards">목록</Link>
        </div>
    );
};

export default BoardInsertContainer;