import java.io.*;
import java.util.ArrayList;

public class ExpenseFileStorage {
    //1."文件写入"存储所有消费，写入本地文件txt
    public void saveExpenses(ArrayList<Expense> expenses) {
        try (BufferedWriter bWriter = new BufferedWriter(
                //BF:缓冲字符写入器,就是不写一行就交了,购物车一样,存点字符再一次性交了，提高效率
                new FileWriter("src/expenses.txt"))) {         //字符写入器
            for (Expense expense : expenses) {
                bWriter.write(expense.getDate()+"|"
                + expense.getCategory()+"|"
                + expense.getAmount()+"|"
                + expense.getNote());
                bWriter.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

        //2."文件读取"读取写入文件的字符，输出结果看看正误
        public void readFileLines() {
            try (BufferedReader reader =
                         new BufferedReader(
                                 new FileReader("src/expenses.txt"))) {

                String line;
                while ((line = reader.readLine()) != null) {
                    //字符串解析split，regex：正则表达式
                    String[] parts = line.split("\\|", -1);//拆分字符串
                    for(String part:parts){
                        System.out.println(part);
                    }
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    //3.读取文件并返回一个 ArrayList<Expense>
    public ArrayList<Expense> loadExpenses() {

        ArrayList<Expense> expenses = new ArrayList<>();

        //如果文件不存在，就直接返回一个空的消费列表，不再尝试读取文件。
        //这里的 ! 不是随便加的，它专门用于反转布尔判断
        File file = new File("src/expenses.txt");
        if (!file.exists()) {
            return expenses;
        }

        try (BufferedReader reader =
                     new BufferedReader(
                             new FileReader("src/expenses.txt"))) {

            String line;

            while ((line = reader.readLine()) != null) {
                //readLine()会读完一行后到下一行
                String[] parts = line.split("\\|", -1);
                // TODO：在这里完成字符串转数字、
                double amount = Double.parseDouble(parts[2]);//parse分析，把"2,0"--->2.0
                // 创建 Expense 对象，并添加到 expenses
                Expense expense = new Expense(
                        parts[0], parts[1], amount, parts[3]
                );
                expenses.add(expense);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return expenses;
    }
}
