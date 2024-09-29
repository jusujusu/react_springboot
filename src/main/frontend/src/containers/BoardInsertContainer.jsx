//게시글 등록화면 컴포넌트
import {Link} from "react-router-dom";
import * as boards from '../apis/boards.js'

const BoardInsertContainer = () => {

    const onInsert = async (title,writer, content) => {
        try {
            const response = await boards.insert(title,writer,content);
            alert('등록 완료');
            console.log(response.data);

            //게시글 목록 이동
        } catch (e) {
            console.log(e);
        }
    }

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