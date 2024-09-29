import axios from "axios";

//export를 이용해 외부로
/*export const 메소드명 = (파라미터) => {
   axios.메소드 (url);
}*/

// 목록
export const list = () => axios.get("/api/boards");

// 조회

export const select = (id) => axios.get(`/api/boards/${id}`);

//등록
export const insert = (title, writer, content) => axios.post("/api/boards", {title, writer, content});

//수정
export const update = (id, title, writer, content) => axios.post(`/api/boards/${id}`, {id, title, writer, content});

//삭제
export const remove = (id) => axios.delete(`/api/boards/${id}`)