import java.util.*;

/**
 * 对于给定的整数，求出删除该整数中的1个数字后得到的最小值
 * 举例说，1214 ，得到的结果是114
 * 两种方法实现，一种用ArrayList，一种用Arrays类
 */
/**ArrayList实现**/
public class DelMin {
    private static String num;
    private static String del_num;
    private static ArrayList num_al = new ArrayList();

    private DelMin() {
        int begin = 0;
        int len = num.length();
        while (begin < len) {
            num_al.add(num.substring(begin, begin + 1));
            begin++;
        }
    }

    public static void main(String[] args) {
        System.out.println("请输入一个整数：");
        Scanner s = new Scanner(System.in);
        num = s.nextLine();
        num.trim();
        System.out.println("请输入要删除的数字：");
        del_num = s.nextLine();
        del_num.trim();


        s.close();
        DelMin delMin = new DelMin();
        delMin.delAndSort();
    }

    private void delAndSort() {
        if (num_al.contains(del_num)) {
            num_al.remove(del_num);
            Collections.sort(num_al);
            StringBuilder result = new StringBuilder();
            for (Object i : num_al) {
                result.append(i);
            }
            System.out.println(result.toString());
        } else System.out.println("整数中没有这个数字");
    }

}

/**Arrays类实现**/
class DelMin2{
    private static String num;
    private static String del_num;

    public static void main(String[] args){
        System.out.println("请输入一个整数：");
        Scanner s = new Scanner(System.in);
        num = s.nextLine();
        num.trim();
        System.out.println("请输入要删除的数字：");
        del_num = s.nextLine();
        del_num.trim();
        s.close();
        DelMin2 delMin2 = new DelMin2();
        delMin2.delAndSort();
    }

    /**
     * 不可使用Arrays.asList().contains()和Arrays.asList().remove()实现删除
     * char数组为一个对象，asList()后List中只有一个元素
     * */
    private void delAndSort(){
        if(num.indexOf(del_num)>=0) {
            /**Replace操作后num不变**/
            char[] num_array = num.replaceFirst(del_num,"").toCharArray();
            Arrays.sort(num_array);
            System.out.println(num_array);
        }else System.out.println("整数中没有这个数字");
    }

}

