package com.kuranado.blog.repository.es;

import com.kuranado.blog.domain.es.EsBlog;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Author: Xinling Jing
 * @Date: 2018/7/5 0005 下午 2:23
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class EsBlogRepositoryTest {

    @Autowired
    private EsBlogRepository esBlogRepository;

    @Before
    public void initRepositoryData() {
        // 清除数据
        esBlogRepository.deleteAll();
        // 重新添加测试数据
        esBlogRepository.save(new EsBlog("Had I not seen the Sun", "I could have borne the shade", "But Light a newer Wilderness. My Wilderness has made."));
        esBlogRepository.save(new EsBlog("There is room in the halls of pleasure", "For a long and lordly train", "But one by one we must all file on, Through the narrow aisles of pain."));
        esBlogRepository.save(new EsBlog("When you are old", "When your are old and grey and full of sleep", "And nodding by the fire, take down this book."));
    }

    @Test
    public void testFindByTitleOrSummaryOrContent() {
        // 封装分页请求
        Pageable pageable = PageRequest.of(0, 10);

        String title = "Sun";
        String summary = "is";
        String content = "down";

        Page<EsBlog> esBlogPage = esBlogRepository.findByTitleOrSummaryOrContent(title, summary, content, pageable);

        System.out.println("Start");
        for(EsBlog esBlog : esBlogPage) {
            System.out.println(esBlog.toString());
        }
        System.out.println("End");
    }

}
