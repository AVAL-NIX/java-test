package 数据结构集合AA.自己手动实现一个阻塞队列;

import java.util.LinkedList;
import java.util.List;

public class BlockingList {


    List<String> list = new LinkedList<>();

    int limist = 10;

    public synchronized void set(String value) throws Exception{
        if(list.size() == this.limist){
            wait();
        }
        if(list.size() == 0){
            notifyAll();
        }

        this.list.add(value);
    }


    public synchronized String get() throws Exception{
        if(list.size() == 0){
            wait();
        }
        if(list.size() == this.limist){
            notifyAll();
        }
        return this.list.remove(0);
    }

    public static void main(String[] args) {
        BlockingList blockingList = new BlockingList();

    }
}
