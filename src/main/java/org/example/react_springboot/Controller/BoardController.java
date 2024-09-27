package org.example.react_springboot.Controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.react_springboot.DTO.BoardDTO;
import org.example.react_springboot.Service.BoardService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/boards")
public class BoardController {

    private final BoardService boardService;

    /*// restController 메소드
    //@Mapping()
    public ResponseEntity<{반환할 DTO}> 메소드명 () {
        메소드 작성....
        메소드로 나온 값을 변수에 저장

        //성공 시 반환
        return ResponseEntity<>(변수, HttpStatus.OK);
    }*/


    // 게시글 목록
    @GetMapping()
    public ResponseEntity<List<BoardDTO>> list() {
        log.info("[GET] - /boards - 게시글 목록");
        try {
            List<BoardDTO> dtoList = boardService.list();
            if (dtoList == null) {
                log.info("조회된 게시글 없음");
                return null;
            } else {
                log.info("게시글 수 : " + dtoList.size());
                return new ResponseEntity<>(dtoList, HttpStatus.OK);
                // 같은 메소드
                //return ResponseEntity.status(HttpStatus.OK).body(dtoList);
            }
        } catch (Exception e) {
            log.error(null, e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    //게시글 상세 정보
    @GetMapping("/{id}")
    public ResponseEntity<BoardDTO> getOne(@PathVariable("id") Long id) {
        log.info("[GET] - /boards/" + id + " - 게시글 조회");

        try {
            BoardDTO dto = boardService.select(id);

            if (dto == null) {
                dto = new BoardDTO();
                dto.setTitle("데이터 없음");
                return new ResponseEntity<>(dto, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(dto, HttpStatus.OK);
            }
        } catch (Exception e) {
            log.error(null, e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    // 게시글 등록
    @PostMapping()
    public ResponseEntity<?> create(@RequestBody BoardDTO boardDTO) {
        log.info("[POST] - /boards - 게시글 등록");
        try {
            Long result = boardService.insert(boardDTO);
            if (result > 0) {
                return new ResponseEntity<>("게시글 등록 완료", HttpStatus.CREATED);  // 201
            } else {
                return new ResponseEntity<>("게시글 등록 실패", HttpStatus.OK);
            }
        } catch (Exception e) {
            log.error(null, e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    //게시글 수정
    //@PutMapping("/{id}")
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id,
                                    @RequestBody BoardDTO boardDTO) {
        log.info("[PUT] - /boards - 게시글 수정");
        try {
            Long result = boardService.update(boardDTO);
            if (result > 0) {
                return new ResponseEntity<>("게시글 수정 성공", HttpStatus.OK);
            } else {
                return new ResponseEntity<>("게시글 수정 실패", HttpStatus.OK);
            }
        } catch (Exception e) {
            log.error(null, e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //게시글 삭제
    @DeleteMapping("{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        log.info("[DELETE] - /boards/" + id + " - 게시글 삭제");
        try {
            boardService.delete(id);
            return ResponseEntity.status(HttpStatus.OK).build();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
