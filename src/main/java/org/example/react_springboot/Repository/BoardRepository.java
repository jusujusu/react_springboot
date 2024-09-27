package org.example.react_springboot.Repository;

import org.example.react_springboot.Entity.BoardEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface BoardRepository extends JpaRepository<BoardEntity, Long> {

    //게시글 조회수 증가
    @Modifying
    @Query("update BoardEntity b set b.views = b.views+1 where b.id = :id")
    public void updateCount(Long id);


}
