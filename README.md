# MyClassManager  
#### 关于本地开发  
可直接导入该项目于本地，修改配置文件中的数据库连接信息，导入附带数据库结构的SQL文件可直接生成所有表  
**当你克隆项目到本地后可使用如下账号进行登录**
- **SuperManager**  
教师页账号：admin  
密码：123456  
- **普通教师**  
教师页账号：jojo  
密码：123456  
- **学生**  
学生页账号：laoliang
密码：123456  

#### 项目介绍  
- 关于项目，对于学习 `SSM` 是一个挺不错的练手项目，可以让你在烦恼的业务逻辑中保持一颗纯洁的❤  
- 开发前的一些准备工作，以及思考项目整体结构与思路  
- 记录开发过程中遇到的一些难题以及 `BUG`  
- 思考整个项目有哪些可以优化的地方，以及有哪些可以增加的功能  

## 页面展示  
null  
## 项目需求  
#### 项目背景 
对于初学 `SSM` 开发的朋友来说，最好的一个学习方式就是拿一个功能俱全的项目来练练手，通过自己的重构项目来发现其中的潜在难题，并且也能很好的在编码过程中总结和发现问题、解决问题。使用 `SSM` 开发的班级管理系统，简单并且实用，适合做练手项目。  
#### 功能需求    
###### 学生页面  
- 
- 
###### 教师后台页面  
- 
-   
#### 安装部署需求  
- 打成 war 包后使用 tomcat 部署  
## 项目设计  
#### 总体设计  
- 本项目用到的技术和框架  
1. 项目构建： [Maven](https://maven.apache.org)  
2. Web 框架：[Spring](https://spring.io)   
3. 数据库 ORM：[MyBatis](https://www.mybatis.org/mybatis-3/zh/index.html)  
4. 数据库连接池：[Druid](https://github.com/alibaba/druid)  
5. 数据库：[MySQL](https://mysql.com)  
6. 分页插件：[PageHelper](https://github.com/pagehelper/Mybatis-PageHelper)  
7. 模板引擎：[JSP](https://www.oracle.com/technetwork/java/index-jsp-138231.html)  
8. 前端框架：[Bootstrap](https://getbootstrap.com)  
- 本项目中的关键点  
1. 采用 SSM 开发，数据库使用连接池加 ORM 框架的模式。  
2. 整体系统采用后台管理+学生个人中心的方式搭建，后台管理用于管理班级学生，学生头像审核。  
- 环境 
  
|工具|名称|  
|--|--|  
|IDE|[IntelliJ IDEA](https://jetbrains.com/idea/)|  
|语言|JDK1.8、HTML、css、js|  
|数据库|[MySQL5.7](https://mysql.com)|  
|项目框架|SSM|  
|ORM|[MyBatis](https://www.mybatis.org/mybatis-3/zh/index.html)|  
|安全框架|SpringSecurity|  
|项目构建|[Maven](https://maven.apache.org)|  
|运行环境|[Ubuntu18.04](http://releases.ubuntu.com/18.04/)| 
- 结构设计  
对于熟悉 Spring 开发的朋友来说，相信对此结构也不会陌生。平时的开发过程中，结构设计是重要的环节，特别是协作开发的时候，明细的分包，模块化，可减少代码提交时的冲突。并且明确的结构有助于我们快速的寻找所对应的类。  
## 业务设计  

## 打包、部署和运行  
- 将本项目打成 `war` 包，使用下面的命令可以生成 war 包，也可以使用 IDE 直接生成 war 包  
```shell
$ jar -cvf classmanager.war ./classmanager  
```  
- 使用 [Tomcat](http://tomcat.apache.org) 部署到云端或本地  
## 数据库设计  
  
## 开发流程  
###### 数据库 CRUD  
- `controller` 层中编写前端接口，接受前端参数  
- `service` 层中编写所需业务接口，供 controller 层调用  
- 实现 service 层中的接口，并注入 `mapper` 层中的 SQL 接口  
- 采用 `MyBatis` 的 `JavaConfig` 方式编写 SQL 语句。由于并没有使用 `MyBatis` 的逆向功能，需要自己动手写所有 `SQL` 语句  
- 关于事务的实现，在配置中开启事务，并在 service 层需要实现事务的业务接口上使用 `@Transactional` 注解  
###### 页面与展示  
- 作为一名后端开发，对于 css 的功力有所欠缺，这里我使用了 Bootstrap 框架，极大的减少了页面开发的难度  
- 前端页面与后端的交互主要是在 controller 包中，并使用了 JSP 渲染页面  
- 自定义异常处理页面，实现自动跳转到 404、403 页面  
###### 其他功能  

## 总结  
#### 开发中遇到的难点  
- 
