package com.es.instance1;

import com.google.common.collect.Lists;
import org.apache.commons.lang.StringUtils;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.MatchQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.Optional;

/**
 * @description:
 * @author: fandp
 * @create: 2020-03-25 16:49
 **/
@RestController
public class CloudDiskController {
    @Autowired
    private CloudDiskDao cloudDiskDao;

    // springboot 整合 es 查询
    // 根据id查询文档信息
    @RequestMapping("/findById/{id}")
    public Optional<CloudDiskEntity> findById(@PathVariable String id) {
        return cloudDiskDao.findById(id);
    }

    // 实现分页查询
    @RequestMapping("/search")
    public List<CloudDiskEntity> search(String name, String describe,
                                        @PageableDefault(page = 0, value = 2) Pageable pageable) {
        // 1.创建查询对象
        BoolQueryBuilder boolQuery = QueryBuilders.boolQuery();
        if (!StringUtils.isEmpty(name)) {
            //模糊查询  一定要安装Ik中文插件
            MatchQueryBuilder matchQuery = QueryBuilders.matchQuery("name", name);
            boolQuery.must(matchQuery);
        }
        if (!StringUtils.isEmpty(describe)) {
            MatchQueryBuilder matchQuery = QueryBuilders.matchQuery("describe", describe);
            boolQuery.must(matchQuery);
        }
        // 2.调用查询接口
        Iterable<CloudDiskEntity> search = cloudDiskDao.search(boolQuery, pageable);
        // 3.将迭代器转换为集合
        return Lists.newArrayList(search);
    }
}
