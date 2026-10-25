import java.util.ArrayList;
import java.util.HashMap;

public class ExpenseManager {
    //1.ArrayList：保存消费明细
    private final ArrayList<Expense> expenses = new ArrayList<>();

    public ArrayList<Expense> getExpenses(){
    return expenses;}

    //2.addExpense:添加消费
    public void addExpense(Expense expense) {
        expenses.add(expense);
        System.out.println("add "+expense+"成功");}

//3.showAllExpense：展示所有消费
    public void showAllExpenses(){
        for (Expense expense:expenses){
            expense.showInfo();
            System.out.println("----------");}}

//4.按类别统计金额
    public void showCategoryTotal(){
        //HashMap：按类别汇总金额。暂存类别与对应金额的汇总结果
        HashMap<String,Double> totals=new HashMap<>();
        for (Expense expense : expenses) {
            String category = expense.getCategory();
            double amount = expense.getAmount();
            totals.put(
                    category,
                    totals.getOrDefault(category, 0.0) + amount
            );
        }
        System.out.println(totals);
    }


}
