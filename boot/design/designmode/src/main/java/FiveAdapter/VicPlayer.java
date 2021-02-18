package FiveAdapter;

/**
 * @author zx
 * @date 2019/6/25
 */
public class VicPlayer implements AdvancedMediaPlayer {

    @Override
    public void playVlc(String fileName) {
        System.out.println(" play : vic : " + fileName);

    }

    @Override
    public void playMp4(String fileName) {

    }
}
