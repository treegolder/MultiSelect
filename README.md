#  **毕设师生双选系统**
---
#### 本项目旨在提供师生双选服务，基于springboot、spring data jpa、vue、mysql 8.0.17、IDEA 开发 后续将基于docker部署在Linux服务器上
---

###### 目标实现：学生选择毕设方向，查看自己所选修的课程及成绩，选择导师。教师设定人数上限，为方向和课程添加权重，查看已选择学生。
---
### 2020.03.16
+ 完成实体类设计，实体关系如下：

   学生(many) to 课程(many)
   
   教师(one) to 学生(many)
   
   ~~方向(many) to 课程(many)~~
   
~~基于thymeleaf模板引擎，实现教师端：登录、为方向及课程添加权重、为方向设定最低分(threshold)、设定学生上限等功能。~~
    
### 2020.03.17
+ 规范代码

### 2020.05.30
#### 春招结束，找到实习啦，项目重新写（泪），要期末了，可能写不完了（泪）
+ 使用token、加密，重新实现登录功能
+ 修改实体类
+ 简化功能

### 2020.06.02
#### 更新教师端功能
+ 添加方向，为方向添加课程，为课程添加权重
+ 设定可选学生上限、修改人数上限
+ 查看已选学生、内定学生、删除学生
+ 将所有学生按教师指定的方向的全部课程的权重计算成绩，排序（倒序）






