import java.util.Scanner;
import java.util.InputMismatchException;

public class Main {
    public static void main(String[] args) {

        ExpenseManager manager=new ExpenseManager();
        Scanner scanner = new Scanner(System.in);
        int choice = -1;

        while (choice != 0) {
            System.out.println("===== 个人记账系统 =====");
            System.out.println("1. 添加消费");
            System.out.println("2. 查看所有消费");
            System.out.println("3. 查看分类统计");
            System.out.println("0. 退出系统");
            System.out.println("请选择：");

            choice = scanner.nextInt();
            /*
            1.
            nextInt读取choice后换行有个/n，要用nextLine处理掉，
            不然case1里的inputExpense的 String date = scanner.nextLine();
            读取的就是nextInt剩下的换行符/n，因为nextInt只读整数
             */
            scanner.nextLine();

            switch (choice) {
                case 1:
                    Expense expense = inputExpense(scanner);
                    manager.addExpense(expense);
                    break;
                case 2:
                    System.out.println("查看所有消费");
                    manager.showAllExpenses();
                    break;
                case 3:
                    System.out.println("查看分类统计");
                    manager.showCategoryTotal();
                    break;
                case 0:
                    System.out.println("退出系统");
                    break;
                default:
                    System.out.println("无效选项");
            }
        }
        scanner.close();//用完后再关掉



    }


        public static Expense inputExpense(Scanner scanner){
        //1.date
            System.out.println("请输入日期：");
            String date;
            /*
            我在思考为啥date不初始化？
            gpt：你可以记住一个实用原则：
            声明变量时，不必强行初始化；只要能保证在使用之前赋值即可。
            如果一个变量本来就应该从某个确定状态开始，那就主动初始化。
            这也体现了一个编程习惯：变量的初始值应该表达程序的真实意图，
            而不是单纯为了让代码看起来完整。
             */
            while(true){
                date = scanner.nextLine();
                if (date.isBlank()) {
                    System.out.println("日期不能为空，请重新输入");
                    continue;//跳过后续code，直接开一下一把。
                }
                break;
            }

        //2.category
            System.out.println("请输入消费类别：");
            String category;
            while(true){
                category = scanner.nextLine();
                if (category.isBlank()) {
                    System.out.println("消费类别不能为空，请重新输入");
                    continue;
                }
                break;
            }

        //3.amount
            /*
            2.数字输入异常，如果我输入的不是字符串呢？
            引入try和catch，死循环while（true），
            */
            double amount;
            while (true) {
                try {
                    System.out.println("请输入金额:");
                    amount = scanner.nextDouble();
                    scanner.nextLine();
                    if (amount<0){
                        System.out.println("数目不能小于0，请重新输入");
                        continue;
                    }
                    break;
                } catch (InputMismatchException e) {

                     /*
                    nextDouble() 读取失败时，不会自动把不匹配的输入消耗掉。
                    所以要加一个scanner.nextLine();清除掉错误的输入格式内容
                    */
                    scanner.nextLine();
                    System.out.println("金额格式错误，请重新输入：");
                }
            }

            //4.note
            //绷不住，日期和类别都不能空，就我备注能空？
            System.out.println("请输入备注：");
            String note = scanner.nextLine();

            /*6.Expense expense = new Expense(date, category, amount, note);
            return expense; 不用访问这个变量的方法或属性直接返回就行*/
            return new Expense(date, category, amount, note);
        }



    }

