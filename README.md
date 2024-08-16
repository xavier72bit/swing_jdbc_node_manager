# swing_jdbc_node_manager

Swing+JDBC的课设

IDE: IntelliJ IDEA
JDK: 1.8
DB: MySQL 8.0+

## 数据库

1. 创建数据库

```sql
create database swing_jdbc_node_manager;
CREATE USER 'swing_jdbc_node_manager'@'%' IDENTIFIED BY 'swing_jdbc_node_manager';
GRANT ALL PRIVILEGES ON `swing_jdbc_node_manager`.* TO 'swing_jdbc_node_manager'@'%' WITH GRANT OPTION;
```

2. 创建初始数据

将项目中的nodes_info.sql导入数据库

## 如何启动

1. 创建lib目录，下载mysql-connector-java-8.0.19.jar，并放入lib目录中
2. 进入idea的“项目结构”，点击左侧侧边栏的“模块”，然后点击“依赖”选项卡，导入lib目录中的mysql-connector-java-8.0.19.jar
3. 进入example.node.manager.jdbc，修改数据库连接配置
4. 运行example.node.manager.swing.Login类

## 运行截图

![](./static/main_page.jpg)