package com.es.instance1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

/**
 * @description:
 * @author: fandp
 * @create: 2020-03-24 14:19
 **/
@SpringBootApplication
@EnableElasticsearchRepositories(basePackages = "com.es.instance1")
public class AppEs {

    public static void main(String[] args) {
        SpringApplication.run(AppEs.class, args);
    }
}
