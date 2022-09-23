package qrxedu.lcseries.leedcode382;

/**
 * @author qiu
 * @version 1.8.0
 */
public class TestDemo {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        node1.next = node2;
        node2.next = node3;
        Solution solution = new Solution(node1);
        System.out.println(solution.getRandom());
        System.out.println(solution.getRandom());
        System.out.println(solution.getRandom());

    }
}
