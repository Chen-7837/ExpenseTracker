public class Expense {
    private final String date;
    private final String category;
    private final double amount;
    private final String note;

    public Expense(String date, String category, double amount, String note) {
        this.date = date;
        this.category = category;
        this.amount = amount;
        this.note = note;}

    //把一个对象变成适合阅读的字符串表示。
    @Override
    public String toString(){
        return "date:"+date+",  "
        +"category:"+category+",  "
        +"amount:"+amount+",  "
        +"note:"+note+",";
    }

    public void showInfo() {
        System.out.println("日期：" + date);
        System.out.println("类别：" + category);
        System.out.println("金额：" + amount);
        System.out.println("备注：" + note);}

    public String getDate(){
        return date;}

    public String getNote(){
        return note;}

    public String getCategory(){
        return category;}

    public double getAmount(){
        return amount;}


}
