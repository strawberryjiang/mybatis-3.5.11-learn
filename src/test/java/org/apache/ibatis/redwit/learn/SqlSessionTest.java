package org.apache.ibatis.redwit.learn;

import org.apache.ibatis.domain.blog.Author;
import org.apache.ibatis.domain.blog.mappers.AuthorMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;

/**
 * @description:
 * @author: yangjiang
 * @create: 2022-07-11 10:09
 **/
public class SqlSessionTest {

  @Test
  public void test01() throws IOException {
    String resource = "resources/redwit/mybatis-conf.xml";
    InputStream inputStream = Resources.getResourceAsStream(resource);
    SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    try (SqlSession session = sqlSessionFactory.openSession()) {
      AuthorMapper mapper = session.getMapper(AuthorMapper.class);
      Author author = mapper.selectAuthor(101);
      System.out.println(author);
    }

  }
}
