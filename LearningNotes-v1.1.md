ExpenseTracker v1.1
│
├── 1. Main：程序入口
│   ├── main()
│   ├── Scanner：接收用户输入
│   ├── switch：处理菜单选项
│   ├── inputExpense()：创建消费对象
│   ├── 启动时加载历史数据
│   └── 退出时保存数据
│
├── 2. Expense：消费实体
│   ├── date       -> 日期
│   ├── category   -> 类别
│   ├── amount     -> 金额
│   ├── note       -> 备注
│   ├── 构造方法
│   ├── getter 方法
│   └── toString()
│
├── 3. ExpenseManager：业务管理
│   ├── ArrayList<Expense>
│   ├── addExpense()
│   ├── showAllExpenses()
│   ├── showCategoryTotal()
│   └── getExpenses()
│
└── 4. ExpenseFileStorage：文件持久化
│
├── saveExpenses()
│   ├── FileWriter：打开字符输出通道
│   ├── BufferedWriter：缓冲写入
│   ├── write()：写入字段
│   └── newLine()：换行
│
├── loadExpenses()
│   ├── File：检查文件是否存在
│   ├── FileReader：打开字符输入通道
│   ├── BufferedReader：逐行读取
│   ├── readLine()：读取一行
│   ├── split("\\|", -1)：拆分字段
│   ├── Double.parseDouble()：转换金额
│   ├── new Expense()：恢复对象
│   └── expenses.add()：加入集合
│
└── readFileLines()
└── 测试读取和字符串拆分


最重要的数据流
启动程序
|
v
loadExpenses()
|
v
读取文本 -> 拆分字段 -> 转换金额
|
v
创建 Expense 对象
|
v
加入 ExpenseManager 的 ArrayList
|
v
用户操作：添加 / 查看 / 统计
|
v
saveExpenses()
|
v
更新 expenses.txt