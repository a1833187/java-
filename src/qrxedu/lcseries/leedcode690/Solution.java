package qrxedu.lcseries.leedcode690;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Solution {
    public int count = 0;
    public int getImportance(List<Employee> employees, int id) {
        if(employees == null||employees.size() == 0){
            return 0;
        }
        Map<Integer,Employee> map = new HashMap<>();
        for(Employee employee:employees){
            map.put(employee.id,employee);
        }
        dfs(map,id);
        return count;
    }
    public void dfs(Map<Integer,Employee> map,int id){
        Employee e = map.get(id);
        if(e == null){
            return;
        }
        count+=e.importance;
        for(int i : e.subordinates){
            dfs(map,i);
        }

    }
}
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
}
