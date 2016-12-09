package mail.polis;

/**
 * Created by dysha_000 on 09.12.2016.
 */
import java.util.LinkedHashMap;
import java.util.Map;

public class lfu1{
    public lfu1(int capacity) { this.startCapacity = capacity; }
    private static LinkedHashMap<Integer, cache> cacheMap = new LinkedHashMap<Integer, cache>();
    private static int startCapacity = 10;
    class cache
    {
        private String data;
        private int freq;

        public String getData() {return data;}
        public void setData(String data) {this.data = data;}

        public int getFrequency() {return freq;}
        public void setFrequency(int frequency) {this.freq = frequency;}
    }

    public void addCacheEntry(int key, String data)
    {
        if(!isFull()) {
            cache tmp = new cache();
            tmp.setData(data);
            tmp.setFrequency(0);

            cacheMap.put(key, tmp);
        }
        else {
            int KeyRemove = getLFUKey();
            cacheMap.remove(KeyRemove);

            cache tmp = new cache();
            tmp.setData(data);
            tmp.setFrequency(0);

            cacheMap.put(key, tmp);
        }
    }

    public int getLFUKey()
    {
        int key = 0;
        int minFreq = Integer.MAX_VALUE;

        for(Map.Entry<Integer, cache> entry : cacheMap.entrySet())
        {
            if(minFreq > entry.getValue().freq)
            {
                key = entry.getKey();
                minFreq = entry.getValue().freq;
            }
        }
        return key;
    }

    public String getCacheEntry(int key)
    {
        if(cacheMap.containsKey(key)) {
            cache temp = cacheMap.get(key);
            temp.freq++;
            cacheMap.put(key, temp);
            return temp.data;
        }
        return null;
    }

    public static boolean isFull()
    {
        if(cacheMap.size() == startCapacity)
            return true;

        return false;
    }
}