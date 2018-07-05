package com.kuranado.blog.repository.es;

import com.kuranado.blog.domain.es.EsBlog;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * @Author: Xinling Jing
 * @Date: 2018/7/5 0005 下午 2:07
 */
public interface EsBlogRepository extends ElasticsearchRepository<EsBlog, String> {

    Page<EsBlog> findByTitleOrSummaryOrContent(String title, String summary, String content, Pageable pageable);

}
