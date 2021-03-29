package FiveAdapter;

/**
 * @author zx
 * @date 2019/6/25
 */
public class Mp4Player implements AdvancedMediaPlayer {

    @Override
    public void playVlc(String fileName) {

    }

    @Override
    public void playMp4(String fileName) {
        System.out.println(" play : mp4 : " + fileName);
    }
}
