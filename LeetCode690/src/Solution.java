import java.util.List;

/*
You are given a data structure of employee information, which includes the employee's unique id, his importance value and his direct subordinates' id.

For example, employee 1 is the leader of employee 2, and employee 2 is the leader of employee 3. They have importance value 15, 10 and 5, respectively. Then employee 1 has a data structure like [1, 15, [2]], and employee 2 has [2, 10, [3]], and employee 3 has [3, 5, []]. Note that although employee 3 is also a subordinate of employee 1, the relationship is not direct.

Now given the employee information of a company, and an employee id, you need to return the total importance value of this employee and all his subordinates.
 */
class Solution {
    public int getImportance(List<Employee> employees, int id) {
        int value = 0;
        for (Employee employee:employees) {
            if (employee.id == id){
                for (int subid:employee.subordinates) {
                    value += getImportance(employees, subid);
                }
                value += employee.importance;
                break;
            }
        }
        return value;
    }
}