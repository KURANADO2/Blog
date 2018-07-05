package com.kuranado.blog.controller;

import com.kuranado.blog.domain.es.EsBlog;
import com.kuranado.blog.repository.es.EsBlogRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author: Xinling Jing
 * @Date: 2018/7/5 0005 下午 2:44
 */
@RestController
@RequestMapping("blogs")
public class BlogController {

    @Autowired
    private EsBlogRepository esBlogRepository;

    @GetMapping
    public List<EsBlog> list(@RequestParam(value = "title", required = false, defaultValue = "") String title,
            @RequestParam(value = "summary", required = false, defaultValue = "") String summary,
            @RequestParam(value = "content", required = false, defaultValue = "") String content,
            @RequestParam(value = "page", required = false, defaultValue = "0") int page,
            @RequestParam(value = "size", required = false, defaultValue = "10") int size) {
        Pageable pageable = PageRequest.of(page, size);

        Page<EsBlog> esBlogPage = esBlogRepository.findByTitleOrSummaryOrContent(title, summary, content, pageable);
        return esBlogPage.getContent();
    }

}
