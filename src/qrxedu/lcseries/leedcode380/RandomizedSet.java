package qrxedu.lcseries.leedcode380;

import java.util.*;

/**
 * @author qiu
 * @version 1.8.0
 */
public class RandomizedSet {
    public Map<Integer,Integer> map;
    public List<Integer> list;
    public Random random;
    public RandomizedSet() {
        map = new HashMap<>();
        list = new ArrayList<>();
        random = new Random();
    }

    public boolean insert(int val) {
        if(!map.containsKey(val)){
            int index = list.size();
            list.add(val);
            map.put(val,index);
            return true;
        }else{
            return false;
        }
    }

    public boolean remove(int val) {
        if(map.containsKey(val)){
            int index = map.get(val);
            int last = list.get(list.size()-1);
            //这里的变长数组和哈希表都应该是先 添  然后再删除
            //因为当只有1个元素的时候，就不要需要再添加了
            list.set(index,last);
            map.put(last,index);
            list.remove(list.size()-1);
            map.remove(val);

            return true;
        }else{
            return false;
        }

    }

    public int getRandom() {
        int index = random.nextInt(list.size());
        return list.get(index);
    }
}
