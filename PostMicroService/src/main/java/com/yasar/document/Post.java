package com.yasar.document;

import com.yasar.utility.EState;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data // get, set, toString
@AllArgsConstructor // parametreli constructorların tümü
@NoArgsConstructor // default constructor
@Builder
@Document
public class Post {
    @Id
    private String id;
    private Long authId;
    private String userName;
    private String imageUrl;
    private String comment;
    private Long date;
    private Long likeCount;
    private Long commentCount;
    private EState state;
}
