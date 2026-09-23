/*class SnapshotArray {
    private HashMap<Integer,Integer> map;
    private List<Map<Integer,Integer>> snaps;
    private int snap_id;

    public SnapshotArray(int length) {
        map=new HashMap<>();
        snaps=new ArrayList<>();
        snap_id=0;
        
    }
    
    public void set(int index, int val) {
        map.put(index,val);
        
        
    }
    
    public int snap() {
        snaps.add(new HashMap<>(map));
        return snap_id++;
        
    }
    
    public int get(int index, int snap_id) {
        return snaps.get(snap_id).getOrDefault(index,0);
        
    }
}*/
import java.util.*;

class SnapshotArray {
    private TreeMap<Integer, Integer>[] records;
    private int snapId;

    public SnapshotArray(int length) {
        records = new TreeMap[length];
        for (int i = 0; i < length; i++) {
            records[i] = new TreeMap<>();
            records[i].put(0, 0); // initial value = 0 at snap 0
        }
        snapId = 0;
    }
    
    public void set(int index, int val) {
        records[index].put(snapId, val);
    }
    
    public int snap() {
        return snapId++;
    }
    
    public int get(int index, int snap_id) {
        return records[index].floorEntry(snap_id).getValue();
    }
}


/**
 * Your SnapshotArray object will be instantiated and called as such:
 * SnapshotArray obj = new SnapshotArray(length);
 * obj.set(index,val);
 * int param_2 = obj.snap();
 * int param_3 = obj.get(index,snap_id);
 */