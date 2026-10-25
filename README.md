# ExpenseTracker

一个基于 Java 的控制台个人记账系统，用于练习 Java 面向对象编程、集合、异常处理和文件 IO。

当前版本：**v1.1**

## 一、项目功能

- 添加消费记录
- 查看所有消费记录
- 按消费类别统计金额
- 校验日期、类别和金额等用户输入
- 将消费记录保存到本地文件
- 程序启动时自动加载历史消费记录
- 程序退出时保存当前全部消费记录

## 二、项目结构

```text
ExpenseTracker/
├── src/
│   ├── Main.java
│   ├── Expense.java
│   ├── ExpenseManager.java
│   ├── ExpenseFileStorage.java
│   └── expenses.txt
└── README.md
```

- `Main`：负责菜单、用户输入和程序运行流程。
- `Expense`：表示一笔消费，保存日期、类别、金额和备注。
- `ExpenseManager`：管理消费集合，提供添加、查看和分类统计功能。
- `ExpenseFileStorage`：负责消费记录的文件保存和读取。
- `expenses.txt`：用于持久化保存消费记录。

## 三、数据存储格式

每笔消费占一行，使用竖线 `|` 分隔字段。

```text
日期|类别|金额|备注
```

示例：

```text
2026-10-25|Food|25.0|早餐
2026-10-25|Transport|3.0|地铁
```

当前实现约定各字段中不包含 `|`，以保证读取时能够正确拆分。

## 四、程序运行流程

1. 创建 `ExpenseManager` 和 `ExpenseFileStorage` 对象。
2. 调用 `loadExpenses()` 读取历史记录。
3. 将读取的消费记录加入当前集合。
4. 用户通过控制台菜单添加、查看和统计消费。
5. 用户退出时，调用 `saveExpenses()` 保存当前全部记录。

## 五、主要学习知识点

### Java 基础与面向对象

- 类、对象、构造方法
- 封装与 getter 方法
- 方法调用、参数与返回值
- `static` 方法
- `toString()` 方法重写

### 集合与数据处理

- `ArrayList`
- 增强 `for` 循环
- `add()`、`addAll()`
- 字符串拼接
- `split()` 与字符串数组
- `Double.parseDouble()`

### 异常处理与文件 IO

- `try-catch`
- `IOException`
- `try-with-resources`
- `File` 与 `exists()`
- `FileWriter`、`BufferedWriter`
- `FileReader`、`BufferedReader`
- `write()`、`newLine()`、`readLine()`
- 文件不存在时返回空列表

## 六、当前版本的注意事项

- 文件路径使用相对路径 `src/expenses.txt`，依赖项目的运行工作目录。
- 当前异常处理为基础版本，后续可进一步完善读取失败时的处理。
- 文件数据格式暂不支持字段中包含分隔符 `|`。
- 当前版本使用本地文本文件，不涉及数据库。

## 七、后续学习方向

完成当前版本后，可以继续学习 Lambda、Stream、MySQL、JDBC、Maven、JUnit 和 Spring Boot，并根据实际需求规划后续版本。