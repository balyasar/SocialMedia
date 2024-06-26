package com.yasar.document;

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
public class UserProfile {
    @Id
    private String id;
    private Long authId;
    private String userName;
    private String name;
    private String surname;
    private String fullName;
    private String about;
    private String webSite;
    private Integer age;
    private String phone;
    private String profileURL;
    private String avatar;

}
