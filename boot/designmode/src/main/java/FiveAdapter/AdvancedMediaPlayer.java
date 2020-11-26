package FiveAdapter;

/**
 * 适配器模式接口
 *
 * @author zx
 * @date 2019/6/25
 */
public interface AdvancedMediaPlayer {
    void playVlc(String fileName);

    void playMp4(String fileName);
}
