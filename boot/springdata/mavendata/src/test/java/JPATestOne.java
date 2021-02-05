import com.mavendata.Article;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.Date;

/**
 * @author zhengxin
 * @date 2021/2/2
 */
public class JPATestOne {


    @Test
    public void testsave() {
        // 1. 创建持久化工厂
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("springdata");
        //2. 创建持久化管理器
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        //3. 获取事务,并开启
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        //4. 操作
        Article article = new Article();
        article.setAuthor("郑新");
        article.setCreateTime(new Date());
        article.setTitle("测试标题");
        entityManager.persist(article);

        //提交
        entityTransaction.commit();

        // 6.关闭资源
        entityManager.close();
    }

    @Test
    public void query() {
        // 1. 创建持久化工厂
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("springdata");
        //2. 创建持久化管理器
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        //3. 获取事务,并开启
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        //4. 操作
        Article article =  entityManager.find(Article.class,1);
        System.out.println(article);
        //提交
        entityTransaction.commit();

        // 6.关闭资源
        entityManager.close();
    }


    @Test
    public void update() {
        // 1. 创建持久化工厂
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("springdata");
        //2. 创建持久化管理器
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        //3. 获取事务,并开启
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        //4. 操作
        Article article =  entityManager.find(Article.class,2);
        System.out.println(article);
        article.setTitle("修改后的标题");
        //提交
        entityTransaction.commit();

        // 6.关闭资源
        entityManager.close();
    }
    @Test
    public void del() {
        // 1. 创建持久化工厂
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("springdata");
        //2. 创建持久化管理器
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        //3. 获取事务,并开启
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        //4. 操作
        Article article =  entityManager.find(Article.class,1);
        entityManager.remove(article);
        //提交
        entityTransaction.commit();

        // 6.关闭资源
        entityManager.close();
    }

}
