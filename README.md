# ExpenseTracker

## 1. 项目介绍

ExpenseTracker 是一个使用 Java 编写的命令行个人记账系统，用于练习 Java 基础语法、面向对象编程和集合框架。

## 2. 项目功能

- 添加消费记录：日期、类别、金额、备注
- 查看所有消费明细
- 按消费类别统计总金额
- 对日期、类别和金额进行基本输入校验
- 使用菜单循环选择功能并退出程序

## 3. 项目结构

```text
ExpenseTracker/
├── Main.java
├── Expense.java
├── ExpenseManager.java
└── README.md
```

- `Main`：负责菜单显示、用户输入和程序流程控制。
- `Expense`：表示一笔消费，保存日期、类别、金额和备注。
- `ExpenseManager`：负责添加、展示消费记录和分类统计。

## 4. 核心数据流

```text
用户输入
    |
    v
Main.inputExpense()
    |
    v
创建 Expense 对象
    |
    v
ExpenseManager.addExpense()
    |
    v
ArrayList<Expense>
    |
    +----> 查看消费明细
    |
    +----> 遍历记录并按类别累加
                 |
                 v
          HashMap<String, Double>
                 |
                 v
             输出统计结果
```

## 5. 涉及的知识点

### Java 基础与面向对象
- 类、对象、构造方法、`this`
- `private`、`final`、`static`
- 实例方法与对象引用
- `toString()` 和 `@Override`
- 按职责划分类

### 流程控制与输入处理
- `while`、`switch`、`break`、`continue`
- `Scanner` 的常用读取方法
- `try-catch`
- `InputMismatchException`
- 输入校验与异常恢复

### 集合框架
- `ArrayList<Expense>` 保存消费明细
- `HashMap<String, Double>` 按类别汇总金额
- 增强 `for` 循环
- `getOrDefault()` 与金额累加

## 6. 当前局限

- 数据只保存在内存中，程序退出后不会保留。
- 尚未实现文件或数据库持久化。
- 菜单输入非整数时仍可能触发未处理的异常。
- 当前为命令行程序，没有图形界面或 Web 界面。

## 7. 项目总结

通过这个项目，练习了从用户输入、数据校验、对象创建、集合管理，到分类统计的完整流程。

本项目当前版本的核心功能已经完成，作为 Java 基础练习项目阶段性收尾。

版本：v1.0
