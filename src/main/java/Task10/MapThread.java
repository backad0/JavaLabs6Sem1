package Task10;

import Task11.MyThread;

public class MapThread extends Thread{
    private final MyHashMap<Integer> map;
    private int flag;
    private int i;

    public MapThread(int i, MyHashMap<Integer> map, int flag) {
        this.i = i;
        this.map = map;
        this.flag = flag;
    }

    @Override
    public void run() {
        switch (flag) {
            case (1):
                map.put(i, i);
                map.put(i+10, i);
                map.put(i+20, i);
                break;
            case (2):
                System.out.println(Thread.currentThread().getName()+ " " + map.get(i));
                System.out.println(Thread.currentThread().getName()+ " " + map.get(i+10));
                System.out.println(Thread.currentThread().getName()+ " " + map.get(i+20));
                break;
            case (3):
                map.remove(i);
                map.remove(i+10);
                break;
        }
       /* System.out.println(map.get(i+1));
        System.out.println(map.get(i+2));
        System.out.println(map.get(i+3));*/
    }
}
