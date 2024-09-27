package org.example.react_springboot.Service;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.react_springboot.DTO.BoardDTO;
import org.example.react_springboot.Entity.BoardEntity;
import org.example.react_springboot.Repository.BoardRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class BoardServiceImpl implements BoardService {
    // repository
    private final BoardRepository boardRepository;
    // modelmapper
    private final ModelMapper modelMapper;


    //목록
    @Override
    public List<BoardDTO> list() throws Exception {
        // 모든 boardEntity를 list로 저장
        List<BoardEntity> boardEntityList = boardRepository.findAll();
        List<BoardDTO> boardDTOS = boardEntityList.stream()
                .map(boardEntity -> modelMapper.map(boardEntity, BoardDTO.class))
                .collect(Collectors.toList());
        return boardDTOS;
    }

    //조회
    @Override
    public BoardDTO select(Long id) throws Exception {
        // 게시글을 조회
        Optional<BoardEntity> optionalEntity = boardRepository.findById(id);

        // 게시글이 존재하지 않으면 예외 발생
        BoardEntity entity = optionalEntity.orElseThrow(() -> new EntityNotFoundException("게시글이 존재하지 않습니다. ID: " + id));

        // 조회수 증가
        updateCount(id);
        log.info(id + " 게시글 조회 시작");

        // DTO로 변환
        BoardDTO boardDTO = modelMapper.map(entity, BoardDTO.class);
        log.info("화면으로 보낼 boardDTO : " + boardDTO);

        return boardDTO;
    }

    //조회수 증가
    @Override
    public void updateCount(Long id) throws Exception {
        // 조회수 증가
        boardRepository.updateCount(id);
        log.info(id + " 게시글 조회수 증가");
    }

    //등록
    @Override
    public Long insert(BoardDTO boardDTO) throws Exception {
        BoardEntity boardEntity = modelMapper.map(boardDTO, BoardEntity.class);
        BoardEntity savedBoardEntity = boardRepository.save(boardEntity);
        return savedBoardEntity.getId();
    }

    //수정
    @Override
    public Long update(BoardDTO boardDTO) throws Exception {
        //수정할 아이디 검색
        Optional<BoardEntity> temp = boardRepository.findById(boardDTO.getId());

        //존재하면 수정
        if (temp.isPresent()) {
            //기존의 entity의 값을 가져옴
            BoardEntity existingEntity = temp.get();
            //modlemapper를 이용해 기존 entity에 dto 값을 맵핑
            modelMapper.map(boardDTO, existingEntity);
            //db에 저장
            boardRepository.save(existingEntity);
            log.info("수정된 boardEntity : " + existingEntity);
            return existingEntity.getId();
        }
        return null;
    }

    //삭제
    @Override
    public void delete(Long id) throws Exception {
      boardRepository.deleteById(id);
    }

}
