package org.example.react_springboot.DTO;

import lombok.*;

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
}
