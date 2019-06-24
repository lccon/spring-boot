package com.lc;

import com.lc.domain.Article;
import io.searchbox.client.JestClient;
import io.searchbox.core.Index;
import io.searchbox.core.Search;
import io.searchbox.core.SearchResult;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBoot08ElasticsearchApplicationTests {

	@Autowired
	private JestClient jestClient;

	@Test
	public void addJestEsData() {
		// 保存es文档
		Article article = new Article();
		article.setId(2L);
		article.setAuthor("李四");
		article.setTitle("day day up");
		article.setContent("加油努力向前");

		// 构建一个索引功能
		Index build = new Index.Builder(article).index("lc").type("news").id(String.valueOf(article.getId())).build();

		try {
			jestClient.execute(build);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void jestSearchData() {
		//查询表达式
		String content = "{\n" +
							"\t\"query\" : {\n" +
							"\t\t\"match\" : {\n" +
							"\t\t\t\"content\" : \"加油\"\n" +
							"\t\t}\n" +
							"\t}\n" +
							"}";
		//构建搜索功能
		Search build = new Search.Builder(content).addIndex("lc").addType("news").build();
		try {
			SearchResult execute = jestClient.execute(build);
			System.out.println(execute.getJsonString());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
