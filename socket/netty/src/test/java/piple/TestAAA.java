package piple;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.*;
import io.netty.channel.embedded.EmbeddedChannel;
import org.junit.Test;
import server.piple.Inpiple.SimpleInA;
import server.piple.Inpiple.SimpleInB;
import server.piple.Inpiple.SimpleInC;

/**
 * @author zhengxin
 * @date 2021/9/2
 *
 * JUnit 断言
 * 什么是断言？刚开始我也很困惑，后来搞了大半天才明白断言就是"判断"。
 *
 * Junit所有的断言都包含在 Assert 类中。
 *
 * 这个类提供了很多有用的断言方法来编写测试用例。只有失败的断言才会被记录。Assert 类中的一些有用的方法列式如下：
 *
 * void assertEquals(boolean expected, boolean actual):检查两个变量或者等式是否平衡
 * void assertTrue(boolean expected, boolean actual):检查条件为真
 * void assertFalse(boolean condition):检查条件为假
 * void assertNotNull(Object object):检查对象不为空
 * void assertNull(Object object):检查对象为空
 * void assertSame(boolean condition):assertSame() 方法检查两个相关对象是否指向同一个对象
 * void assertNotSame(boolean condition):assertNotSame() 方法检查两个相关对象是否不指向同一个对象
 * void assertArrayEquals(expectedArray, resultArray):assertArrayEquals() 方法检查两个数组是否相等
 * JUnit 注解
 * @Test:这个注释说明依附在 JUnit 的 public void 方法可以作为一个测试案例。
 * @Before:有些测试在运行前需要创造几个相似的对象。在 public void 方法加该注释是因为该方法需要在 test 方法前运行。
 * @After:如果你将外部资源在 Before 方法中分配，那么你需要在测试运行后释放他们。在 public void 方法加该注释是因为该方法需要在 test 方法后运行。
 * @BeforeClass:在 public void 方法加该注释是因为该方法需要在类中所有方法前运行。
 * @AfterClass:它将会使方法在所有测试结束后执行。这个可以用来进行清理活动。
 * @Ignore:这个注释是用来忽略有关不需要执行的测试的。
 * JUnit 加注解执行过程
 * beforeClass(): 方法首先执行，并且只执行一次。
 * afterClass():方法最后执行，并且只执行一次。
 * before():方法针对每一个测试用例执行，但是是在执行测试用例之前。
 * after():方法针对每一个测试用例执行，但是是在执行测试用例之后。
 * 在 before() 方法和 after() 方法之间，执行每一个测试用例。
 * JUnit 执行测试
 * 测试用例是使用 JUnitCore 类来执行的。JUnitCore 是运行测试的外观类。要从命令行运行测试，可以运行java org.junit.runner.JUnitCore。对于只有一次的测试运行，可以使用静态方法 runClasses(Class[])。
 *
 * JUnit 套件测试
 * 测试套件意味着捆绑几个单元测试用例并且一起执行他们。在 JUnit 中，@RunWith和@Suite注释用来运行套件测试。
 *
 *
 */
public class TestAAA {

    @Test
    public void serverRun(){

        ChannelInitializer c = new ChannelInitializer<EmbeddedChannel>() {
            @Override
            protected void initChannel(EmbeddedChannel ch) throws Exception {
                ch.pipeline().addLast(new SimpleInA());
                ch.pipeline().addLast(new SimpleInB());
                ch.pipeline().addLast(new SimpleInC());
            }
        };

        EmbeddedChannel embeddedChannel = new EmbeddedChannel(c);
        ByteBuf buf = Unpooled.buffer();
        buf.writeInt(1);
        //向通道写一个
        embeddedChannel.writeInbound(buf);
    }

}


