package org.example.react_springboot.DTO;

import lombok.*;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BoardDTO {

    private Long id;
    private String title;
    private String writer;
    private String content;
    private int views;           // 조회수

    private LocalDateTime regDate;
    private LocalDateTime modDate;
}
