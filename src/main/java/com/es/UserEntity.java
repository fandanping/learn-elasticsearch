package com.es;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import java.lang.annotation.Documented;

/**
 * @description:
 * @author: fandp
 * @create: 2020-03-24 14:14
 **/
@Document(indexName = "fandatabase", type = "user")
@Data
public class UserEntity {
    @Id
    private String id;
    private String name;
    private int sex;
    private int age;
}
