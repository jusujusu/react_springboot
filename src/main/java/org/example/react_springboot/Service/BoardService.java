package org.example.react_springboot.Service;

import org.example.react_springboot.DTO.BoardDTO;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BoardService {

    //게시글 목록
    public List<BoardDTO> list() throws Exception;
    //게시글 조회
    public BoardDTO select(Long id) throws Exception;
    //게시글 등록
    public Long insert(BoardDTO boardDTO) throws Exception;
    //게시글 수정
    public Long update(BoardDTO boardDTO) throws Exception;
    //게시글 삭제
    public void delete(Long id) throws Exception;
    //조회수 증가
    public void updateCount(Long id) throws Exception;

}
