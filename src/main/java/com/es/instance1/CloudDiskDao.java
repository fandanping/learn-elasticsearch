package com.es.instance1;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * @description:
 * @author: fandp
 * @create: 2020-03-25 16:48
 **/
public interface CloudDiskDao  extends ElasticsearchRepository<CloudDiskEntity, String> {
}
