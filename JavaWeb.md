---
title: JavaWeb
date: 2024-09-12 23:17:12
tags: 数据分析项目
categories: H04_数据分析与挖掘
description: 
top_img: 
opyright_author_href: 
copyright_url: false
copyright_info:
---



# 前言

视频：[黑马视频](https://www.bilibili.com/video/BV1m84y1w7Tb)



>**Web标准**也称为**网页标准**，由一系列的标准组成，大部分由W3C（ World Wide Web Consortium，万维网联盟）负责制定。由三个组成部分：
>
>- HTML：负责网页的结构（页面元素和内容）。
>
>- CSS：负责网页的表现（页面元素的外观、位置等页面样式，如：颜色、大小等）。
>
>- JavaScript：负责网页的行为（交互效果）。



# 1.`HTML&CSS`



# 2.`JavaScript&Vue`



# 3.`Vue&Element`



# 4.`Maven`

## 1.初识`Maven`

> Maven官网：https://maven.apache.org/

- 什么是Maven

  Maven是Apache旗下的一个开源项目，是一款用于管理和构建java项目的工具。

- Maven的作用

  1. 方便依赖管理

     - 方便快捷的管理项目依赖的资源(jar包)，避免版本冲突问题.

       使用maven进行项目依赖(jar包)管理，只需要在maven项目的pom.xml文件中，添加一段配置即可实现。

  2. 统一项目结构

     - 提供标准、统一的项目结构

       ```java
       my-project/
       ├── src/
       │   ├── main/					   # 实际项目资源
       │   │   ├── java/                  # 主程序Java源代码目录
       │   │   └──  resources/             # 主程序资源文件（配置文件目录）
       │   └── test/					   # 测试项目资源
       │       ├── java/                  # 测试Java源代码
       │       └──  resources/             # 测试资源文件
       ├── target/                        # 构建输出目录
       ├── pom.xml                        # 项目对象模型文件（项目配置文件）
       ├── LICENSE                        # 许可证文件
       ├── README.md                      # 项目说明文档
       └── .gitignore                     # Git版本控制忽略配置  
       ```

  3. 标准项目构建

     - maven提供了标准的、跨平台(Linux、Windows、MacOS) 的自动化项目构建方式



## 2.`Maven`概述

- Maven模型

  1. 项目对象模型 (Project Object Model)

     - 使用项目对象模型：将项目抽象成一个对象模型，有专属的坐标

       > 坐标，就是资源(jar包)的唯一标识，通过坐标可以定位到所需资源(jar包)位置
       >
       > ```Java
       > // 坐标由<groupId>,<artifactId>,<version>三个标签组成
       > ```

  2. 依赖管理模型(Dependency)

     - 是使用坐标来描述当前项目依赖哪些第三方jar包

  3. 构建生命周期/阶段(Build lifecycle & phases)

- Maven仓库 

  > 仓库：用于存储资源，管理各种jar包。
  >
  > 仓库的本质就是一个目录(文件夹)，这个目录被用来存储开发中所有依赖(就是jar包)和插件

  1. 本地仓库：自己计算机上的一个目录(用来存储jar包)
  2. 中央仓库：由Maven团队维护的全球唯一的。仓库地址：https://repo1.maven.org/maven2/
  3. 远程仓库(私服)：一般由公司团队搭建的私有仓库

   >当项目中使用坐标引入对应依赖jar包后，首先会查找本地仓库中是否有对应的jar包
   >
   >* 如果有，则在项目直接引用
   >
   >* 如果没有，则去中央仓库中下载对应的jar包到本地仓库
   >
   >如果还可以搭建远程仓库(私服)，将来jar包的查找顺序则变为： 本地仓库 --> 远程仓库--> 中央仓库

- Maven安装

  1. 下载

     下载地址：https://maven.apache.org/download.cgi

  2. 安装步骤

     Maven安装配置步骤：

     - 解压安装

       ```java
       目录结构： 
           
       bin目录 ： 存放的是可执行命令。（mvn 命令重点关注）
       conf目录 ：存放Maven的配置文件。（settings.xml配置文件后期需要修改）
       lib目录 ：存放Maven依赖的jar包。（Maven也是使用java开发的，所以它也依赖其他的jar包）
       ```

     - 配置仓库

       ```java
       1.bin同级目录创建mvn_repo目录（本地仓库，用来存储jar包）
       2.进入到conf目录下修改settings.xml配置文件 
       	1). 使用超级记事本软件，打开settings.xml文件，定位到53行
       	2). 复制<localRepository>标签，粘贴到注释的外面（55行）
       	3). 复制之前新建的用来存储jar包的路径，替换掉<localRepository>标签体内容
       3.配置阿里云私服
       	1). 使用超级记事本软件，打开settings.xml文件，定位到160行左右
       	2). 在<mirrors>标签下为其添加子标签<mirror>，内容如下：
               <mirror>  
                   <id>alimaven</id>  
                   <name>aliyun maven</name>  
                   <url>http://maven.aliyun.com/nexus/content/groups/public/</url>
                   <mirrorOf>central</mirrorOf>          
               </mirror>
       ```

     - 配置Maven环境变量

       ```
       1.创建MAVEN_HOME
       2.添加bin至PATH环境变量值中
       3.cmd中查看信息：
       	mvn -v
       ```



## 3. `IDEA`集成`Maven`

### 1.配置`Maven`环境 

- 当前工程设置 

  1. 选择 File  =>  Settings  =>  Build,Execution,Deployment  =>  Build Tools  =>  Maven

  2. 设置IDEA使用本地安装的Maven，并修改配置文件及本地仓库路径

     > Maven home path ：指定当前Maven的安装目录
     >
     > User settings file ：指定当前Maven的settings.xml配置文件的存放路径
     >
     > Local repository ：指定Maven的本地仓库的路径 (如果指定了settings.xml, 这个目录会自动读取出来, 可以不用手动指定)

  3. 配置工程的编译版本为17

     Build,Execution,Deployment  =>  Java Compiler  =>  project bytecode version

- 全局设置 

  1. 进入到IDEA欢迎页面。
  2. 重复当前工程设置的2和3步骤。



### 2.`Maven`项目创建

- 创建Maven项目 

  填写模块名称，坐标信息，点击finish，创建完成

- POM配置详解

  POM (Project Object Model) ：指的是项目对象模型，用来描述当前的maven项目。

  ~~~xml
  <?xml version="1.0" encoding="UTF-8"?>
  <project xmlns="http://maven.apache.org/POM/4.0.0"
           xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
           xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
      <!-- POM模型版本 -->
      <modelVersion>4.0.0</modelVersion>
  
      <!-- 当前项目坐标 -->
      <groupId>com.itheima</groupId>
      <artifactId>maven_project1</artifactId>
      <version>1.0-SNAPSHOT</version>
      
      <!-- 打包方式 -->
      <packaging>jar</packaging>
   
  </project>
  ~~~

  pom文件详解：

  1. <project> ：pom文件的根标签，表示当前maven项目
  2. <modelVersion> ：声明项目描述遵循哪一个POM模型版本
     - 虽然模型本身的版本很少改变，但它仍然是必不可少的。目前POM模型版本是4.0.0
  3. 坐标 ：<groupId>、<artifactId>、<version>
     - 定位项目在本地仓库中的位置，由以上三个标签组成一个坐标
  4. <packaging> ：maven项目的打包方式，通常设置为jar或war（默认值：jar）

- Maven坐标详解

  1. 什么是坐标？

     * Maven中的坐标是==资源的唯一标识== , 通过该坐标可以唯一定位资源位置
     * 使用坐标来定义项目或引入项目中需要的依赖

  2. Maven坐标主要组成

     * groupId：定义当前Maven项目隶属组织名称（通常是域名反写，例如：com.itheima）
     * artifactId：定义当前Maven项目名称（通常是模块名称，例如 order-service、goods-service）
     * version：定义当前项目版本号

     > **注意：**
     >
     > * 上面所说的资源可以是插件、依赖、当前项目。
     > * 我们的项目如果被其他的项目依赖时，也是需要坐标来引入的。

- 导入Maven项目

  1. **方式1：使用Maven面板，快速导入项目**

     打开IDEA，选择右侧Maven面板，点击 + 号，选中对应项目的pom.xml文件，双击即可

     > 说明：如果没有Maven面板，选择 View  =>  Appearance  =>  Tool Window Bars 

  2. **方式2：使用idea导入模块项目**

     - File  =>  Project Structure  =>  Modules  =>  +  =>  Import Module
     - 找到要导入工程的pom.xml



## 4. 依赖管理

- 依赖配置

  > 依赖：指当前项目运行所需要的jar包。一个项目中可以引入多个依赖
  >
  > 注意事项：
  >
  > 1. 如果引入的依赖，在本地仓库中不存在，将会连接远程仓库 / 中央仓库，然后下载依赖（这个过程会比较耗时，耐心等待）
  > 2. 如果不知道依赖的坐标信息，可以到mvn的中央仓库（https://mvnrepository.com/）中搜索

  1. 在pom.xml中编写<dependencies>标签

  2. 在<dependencies>标签中使用<dependency>引入坐标

  3. 定义坐标的 groupId、artifactId、version

     ```xml
     <dependencies>
         <!-- 第1个依赖 : logback -->
         <dependency>
             <groupId>ch.qos.logback</groupId>
             <artifactId>logback-classic</artifactId>
             <version>1.2.11</version>
         </dependency>
         <!-- 第2个依赖 : junit -->
         <dependency>
             <groupId>junit</groupId>
             <artifactId>junit</artifactId>
             <version>4.12</version>
         </dependency>
     </dependencies>
     ```

  4. 点击刷新按钮，引入最新加入的坐标

- 依赖传递

  1. 依赖具有传递性

     - 直接依赖：在当前项目中通过依赖配置建立的依赖关系

     - 间接依赖：被依赖的资源如果依赖其他资源，当前项目间接依赖其他资源

  2. 排除依赖

     - 排除依赖：指主动断开依赖的资源。（被排除的资源无需指定版本）

     ```xml
     <dependency>
         <groupId>com.itheima</groupId>
         <artifactId>maven-projectB</artifactId>
         <version>1.0-SNAPSHOT</version>
        
         <!--排除依赖, 主动断开依赖的资源-->
         <exclusions>
         	<exclusion>
                 <groupId>junit</groupId>
                 <artifactId>junit</artifactId>
             </exclusion>
         </exclusions>
     </dependency>
     ```

  3. 依赖范围

     > 在项目中导入依赖的jar包后，默认情况下，可以在任何地方使用。
     >
     > 如果希望限制依赖的使用范围，可以通过<scope>标签设置其作用范围。

     scope标签的取值范围：

     | **scope**值     | **主程序** | **测试程序** | **打包（运行）** | **范例**    |
     | --------------- | ---------- | ------------ | ---------------- | ----------- |
     | compile（默认） | Y          | Y            | Y                | log4j       |
     | test            | -          | Y            | -                | junit       |
     | provided        | Y          | Y            | -                | servlet-api |
     | runtime         | -          | Y            | Y                | jdbc驱动    |

- 生命周期

  1. 介绍

     Maven的生命周期就是为了对所有的构建过程进行抽象和统一。 生命周期包含了项目的清理，初始化，编译，测试，打包，集成测试，验证，部署和站点生成等几乎所有构建步骤。

     - Maven对项目构建的生命周期划分为3套（相互独立）：

       1. clean：清理工作。

       2. default：核心工作。如：编译、测试、打包、安装、部署等。

       3. site：生成报告、发布站点等。

     - 三套生命周期，主要关注以下几个：

       1. clean：移除上一次构建生成的文件
       2. compile：编译项目源代码
       3. test：使用合适的单元测试框架运行测试(junit)（测试的类名要有Test）
       4. package：将编译后的文件打包，如：jar、war等
       5. install：安装项目到本地仓库

     - 生命周期的顺序是：clean --> validate --> compile --> test --> package --> verify --> install --> site --> deploy 

       只需要关注：clean -->  compile --> test --> package  --> install 

       > 说明：在同一套生命周期中，执行后面的生命周期时，前面的生命周期都会执行。

  2. 执行

     - 在idea工具右侧的maven工具栏中，选择对应的生命周期，双击执行

     - 在DOS命令行中，通过maven命令执行

       ```shell
       mvn 生命周期
       ```



# 5.`SpringBootWeb`

> Spring官网:https://spring.io



## 1.`SpringBoot`基础 

### 1. `SpringBootWeb`快速入门

- 创建SpringBoot工程（需要联网）

  1. 基于Spring官方骨架，创建SpringBoot工程。
  2. 基本信息描述完毕之后，勾选web开发相关依赖。
  3. 点击Finish之后，就会联网创建这个SpringBoot工程。

- 定义请求处理类

  1. 在com.itheima这个包下创建一个子包controller

  2. 然后在controller包下新建一个类：HelloController

     ```java
     package com.itheima.controller;
     import org.springframework.web.bind.annotation.*;
     
     @RestController
     public class HelloController {
     
         @RequestMapping("/hello")
         public String hello(){
             System.out.println("Hello World ~");
             return "Hello World ~";
         }
         
     }    
     ```

- 运行测试

  1. 运行SpringBoot自动生成的引导类
  2. 打开浏览器，输入 `http://localhost:8080/hello`



### 2. `HTTP`协议

> **学习HTTP主要就是学习请求和响应数据的具体格式内容。**

#### 1.`HTTP`概述

- 介绍

  1. HTTP：Hyper Text Transfer Protocol(超文本传输协议)，规定了浏览器与服务器之间数据传输的规则。

     - http是互联网上应用最为广泛的一种网络协议 
     - http协议要求：浏览器在向服务器发送请求数据时，或是服务器在向浏览器发送响应数据时，都必须按照固定的格式进行数据传输

  2. 浏览器向服务器进行请求时：

     ```java
     请求行
     
     请求头（以key:value形式体现，key是固定的名字）
     ```

  3. 服务器向浏览器进行响应时：

     ```java
     相应行
     
     响应头（以key:value形式体现，key是固定的名字）
     ```

- 特点

  1. **基于TCP协议: **   面向连接，安全

     > TCP是一种面向连接的(建立连接之前是需要经过三次握手)、可靠的、基于字节流的传输层通信协议，在数据传输方面更安全

  2. **基于请求-响应模型:**   一次请求对应一次响应（先请求后响应）

     > 请求和响应是一一对应关系，没有请求，就没有响应

  3. **HTTP协议是无状态协议:**  对于数据没有记忆能力。每次请求-响应都是独立的

     > 无状态指的是客户端发送HTTP请求给服务端之后，服务端根据请求响应数据，响应完后，不会记录任何信息。
     >
     > - 缺点:  多次请求间不能共享数据
     > - 优点:  速度快
     >
     > 请求之间无法共享数据会引发的问题：
     >
     > - 如：京东购物。加入购物车和去购物车结算是两次请求
     > - 由于HTTP协议的无状态特性，加入购物车请求响应结束后，并未记录加入购物车是何商品
     > - 发起去购物车结算的请求后，因为无法获取哪些商品加入了购物车，会导致此次请求无法正确展示数据
     >
     > 使用会话技术(Cookie、Session)来解决这个问题。




#### 2.`HTTP`请求协议

> HTTP协议分为：请求协议和响应协议

- 请求协议：浏览器将数据以请求格式发送到服务器
  - 包括：**请求行**、**请求头** 、**请求体** 

- 响应协议：服务器将数据以响应格式返回给浏览器
  - 包括：**响应行** 、**响应头** 、**响应体** 

- 浏览器访问服务器的几种方式： 

  | 请求方式 | 请求说明                                                     |
  | :------: | :----------------------------------------------------------- |
  | **GET**  | 获取资源。<br/>向特定的资源发出请求。例：http://www.baidu.com/s?wd=itheima |
  | **POST** | 传输实体主体。<br/>向指定资源提交数据进行处理请求（例：上传文件），数据被包含在请求体中。 |
  | OPTIONS  | 返回服务器针对特定资源所支持的HTTP请求方式。<br/>因为并不是所有的服务器都支持规定的方法，为了安全有些服务器可能会禁止掉一些方法，例如：DELETE、PUT等。那么OPTIONS就是用来询问服务器支持的方法。 |
  |   HEAD   | 获得报文首部。<br/>HEAD方法类似GET方法，但是不同的是HEAD方法不要求返回数据。通常用于确认URI的有效性及资源更新时间等。 |
  |   PUT    | 传输文件。<br/>PUT方法用来传输文件。类似FTP协议，文件内容包含在请求报文的实体中，然后请求保存到URL指定的服务器位置。 |
  |  DELETE  | 删除文件。<br/>请求服务器删除Request-URI所标识的资源         |
  |  TRACE   | 追踪路径。<br/>回显服务器收到的请求，主要用于测试或诊断      |
  | CONNECT  | 要求用隧道协议连接代理。<br/>HTTP/1.1协议中预留给能够将连接改为管道方式的代理服务器在我们实际应用中常用的也就是 ：**GET、POST** |

  1. **GET方式的请求协议：**

     * 请求行 ：HTTP请求中的第一行数据。由：`请求方式`、`资源路径`、`协议/版本`组成（之间使用空格分隔）

       1. 请求方式：GET  
       2. 资源路径：/brand/findAll?name=OPPO&status=1
          * 请求路径：/brand/findAll
          * 请求参数：name=OPPO&status=1
            * 请求参数是以key=value形式出现
            * 多个请求参数之间使用`&`连接
          * 请求路径和请求参数之间使用`?`连接 			 
       3. 协议/版本：HTTP/1.1  

     * 请求头 ：格式为key: value形式 

       - http是个无状态的协议，所以在请求头设置浏览器的一些自身信息和想要响应的形式。

       常见的HTTP请求头有:

       ~~~
       Host: 表示请求的主机名
       
       User-Agent: 浏览器版本。 例如：Chrome浏览器的标识类似Mozilla/5.0 ...Chrome/79 ，IE浏览器的标识类似Mozilla/5.0 (Windows NT ...)like Gecko
       
       Accept：表示浏览器能接收的资源类型，如text/*，image/*或者*/*表示所有；
       
       Accept-Language：表示浏览器偏好的语言，服务器可以据此返回不同语言的网页；
       
       Accept-Encoding：表示浏览器可以支持的压缩类型，例如gzip, deflate等。
       
       Content-Type：请求主体的数据类型
       
       Content-Length：数据主体的大小（单位：字节）
       ~~~

     - 请求体 ：存储请求参数
       - GET请求的请求参数在请求行中，故不需要设置请求体

  2. **POST方式的请求协议：**	

     1. 请求行：包含请求方式、资源路径、协议/版本
        - 请求方式：POST
        - 资源路径：/brand
        - 协议/版本：HTTP/1.1
     2. 请求头  
     3. 请求体 ：存储请求参数 
        - 请求体和请求头之间是有一个空行隔开（作用：用于标记请求头结束）

- GET请求和POST请求的区别：

  | 区别方式     | GET请求                                                      | POST请求             |
  | ------------ | ------------------------------------------------------------ | -------------------- |
  | 请求参数     | 请求参数在请求行中。<br/>例：/brand/findAll?name=OPPO&status=1 | 请求参数在请求体中   |
  | 请求参数长度 | 请求参数长度有限制(浏览器不同限制也不同)                     | 请求参数长度没有限制 |
  | 安全性       | 安全性低。原因：请求参数暴露在浏览器地址栏中。               | 安全性相对高         |




#### 3.`HTTP`响应协议

- 格式介绍

  与HTTP的请求一样，HTTP响应的数据也分为3部分：**响应行**、**响应头** 、**响应体** 

  1. 响应行：响应数据的第一行。响应行由`协议及版本`、`响应状态码`、`状态码描述`组成

     * 协议/版本：HTTP/1.1
     * 响应状态码：200
     * 状态码描述：OK

  2. 响应头：响应数据的第二行开始。格式为key：value形式

     * http是个无状态的协议，所以可以在请求头和响应头中设置一些信息和想要执行的动作

     常见的HTTP响应头有:

     ~~~
     Content-Type：表示该响应内容的类型，例如text/html，image/jpeg ；
     
     Content-Length：表示该响应内容的长度（字节数）；
     
     Content-Encoding：表示该响应压缩算法，例如gzip ；
     
     Cache-Control：指示客户端应如何缓存，例如max-age=300表示可以最多缓存300秒 ;
     
     Set-Cookie: 告诉浏览器为当前页面所在的域设置cookie ;
     ~~~

  - 响应体： 响应数据的最后一部分。存储响应的数据
    - 响应体和响应头之间有一个空行隔开（作用：用于标记响应头结束）

- 响应状态码

  | 状态码分类 | 说明                                                         |
  | ---------- | ------------------------------------------------------------ |
  | 1xx        | **响应中** --- 临时状态码。表示请求已经接受，告诉客户端应该继续请求或者如果已经完成则忽略 |
  | 2xx        | **成功** --- 表示请求已经被成功接收，处理已完成              |
  | 3xx        | **重定向** --- 重定向到其它地方，让客户端再发起一个请求以完成整个处理 |
  | 4xx        | **客户端错误** --- 处理发生错误，责任在客户端，如：客户端的请求一个不存在的资源，客户端未被授权，禁止访问等 |
  | 5xx        | **服务器端错误** --- 处理发生错误，责任在服务端，如：服务端抛出异常，路由出错，HTTP版本不支持等 |

  参考: 资料/SpringbootWeb/响应状态码.md

  关于响应状态码，我们先主要认识三个状态码，其余的等后期用到了再去掌握：

  1. 200    ok   客户端请求成功
  2. 404  Not Found  请求资源不存在
  3. 500  Internal Server Error  服务端发生不可预期的错误



### 3.`WEB`服务器`Tomcat`

- 服务器概述

  1. **服务器硬件**

     在网络环境下，根据服务器提供的服务类型不同，可分为：文件服务器，数据库服务器，应用程序服务器，WEB服务器等。

  2. **服务器软件**

     - 服务器软件本质是一个运行在服务器设备上的应用程序
     - 能够接收客户端请求，并根据请求给客户端响应数据

- Web服务器

  > Web服务器是一个应用程序(软件)，对HTTP协议的操作进行封装，使得程序员不必直接对协议进行操作(不用程序员自己写代码去解析http协议规则)，让Web开发更加便捷。主要功能是"提供网上信息浏览服务"。

  **Web服务器软件使用步骤**

  1. 准备静态资源
  2. 下载安装Web服务器软件(Tomcat)
  3. 将静态资源部署到Web服务器上
  4. 启动Web服务器使用浏览器访问对应的资源

- Tomcat

  Tomcat服务器软件是一个免费的开源的web应用服务器。由于Tomcat只支持Servlet/JSP少量JavaEE规范，所以是一个开源免费的轻量级Web服务器。

  >JavaEE规范：   JavaEE => Java Enterprise Edition(Java企业版)
  >
  >JavaEE规范就是指Java企业级开发的技术规范总和。包含13项技术规范：JDBC、JNDI、EJB、RMI、JSP、Servlet、XML、JMS、Java IDL、JTS、JTA、JavaMail、JAF
  >
  >[Tomcat官网](https://tomcat.apache.org/)
  >
  >因为Tomcat支持Servlet/JSP规范，所以Tomcat也被称为Web容器、Servlet容器。JavaWeb程序需要依赖Tomcat才能运行。





## 2.`SpringBootWeb`请求响应

> - 请求
> - 响应
> - 分层解耦



### 1. 请求

- 简单参数

  > 简单参数：在向服务器发起请求时，向服务器传递的是一些普通的请求数据。

  1. 原始方式

     > Tomcat接收到http请求时：把请求的相关信息封装到HttpServletRequest对象中

     在Controller中，我们要想获取Request对象，可以直接在方法的形参中声明 HttpServletRequest 对象。然后就可以通过该对象来获取请求信息：

     ```json
     //根据指定的参数名获取请求参数的数据值
     String  request.getParameter("参数名")
     ```

     ```java
     @RestController
     public class RequestController {
         //原始方式
         @RequestMapping("/simpleParam")
         public String simpleParam(HttpServletRequest request){
             // http://localhost:8080/simpleParam?name=Tom&age=10
             // 请求参数： name=Tom&age=10   （有2个请求参数）
             // 第1个请求参数： name=Tom   参数名:name，参数值:Tom
             // 第2个请求参数： age=10     参数名:age , 参数值:10
     
             String name = request.getParameter("name");//name就是请求参数名
             String ageStr = request.getParameter("age");//age就是请求参数名
     
             int age = Integer.parseInt(ageStr);//需要手动进行类型转换
             System.out.println(name+"  :  "+age);
             return "OK";
         }
     }
     ```

     > 以上方式，仅做了解。

  2. SpringBoot方式

     在Springboot环境中，对原始的API进行了封装，接收参数的形式更加简单。 如果是简单参数，参数名与形参变量名相同，定义同名形参即可接收参数。

     ~~~java
     @RestController
     public class RequestController {
         // http://localhost:8080/simpleParam?name=Tom&age=10
         // 第1个请求参数： name=Tom   参数名:name，参数值:Tom
         // 第2个请求参数： age=10     参数名:age , 参数值:10
         
         //springboot方式
         @RequestMapping("/simpleParam")
         public String simpleParam(String name , Integer age ){//形参名和请求参数名保持一致
             System.out.println(name+"  :  "+age);
             return "OK";
         }
     }
     ~~~

     > **结论：不论GET、POST请求，对于简单参数来讲，只要保证请求参数名和Controller方法中的形参名保持一致，即可获取到请求参数中的数据值。**

  3. 参数名不一致

     在方法形参前面加上 @RequestParam 然后通过value属性执行请求参数名，从而完成映射。

     ```java
     @RestController
     public class RequestController {
         // http://localhost:8080/simpleParam?name=Tom&age=20
         // 请求参数名：name
     
         //springboot方式
         @RequestMapping("/simpleParam")
         public String simpleParam(@RequestParam("name") String username , @RequestParam("age") Integer intAge ){
             System.out.println(username+"  :  "+intAge);
             return "OK";
         }
     }
     ```

     > **注意事项：**
     >
     > @RequestParam中的required属性默认为true（默认值也是true），代表该请求参数必须传递，如果不传递将报错
     >
     > 如果该参数是可选的，可以将required属性设置为false
     >
     > ~~~java
     > @RequestMapping("/simpleParam")
     > public String simpleParam(@RequestParam(name = "name", required = false) String username, Integer age){
     > System.out.println(username+ ":" + age);
     > return "OK";
     > }
     > ~~~

- 实体参数

  > **请求参数名与实体类的属性名相同**

  1. 简单实体对象

     定义POJO实体类：

     ```java
     public class User {
         private String name;
         private Integer age;
     
         public String getName() {
             return name;
         }
     
         public void setName(String name) {
             this.name = name;
         }
     
         public Integer getAge() {
             return age;
         }
     
         public void setAge(Integer age) {
             this.age = age;
         }
     
         @Override
         public String toString() {
             return "User{" +
                     "name='" + name + '\'' +
                     ", age=" + age +
                     '}';
         }
     }
     
     ```

     Controller方法：

     ```java
     @RestController
     public class RequestController {
         //实体参数：简单实体对象
         @RequestMapping("/simplePojo")
         public String simplePojo(User user){
             System.out.println(user);
             return "OK";
         }
     }
     ```

  2. 复杂实体对象

     >User类中有一个Address类型的属性（Address是一个实体类）
     >
     >**请求参数名与形参对象属性名相同，按照对象层次结构关系即可接收嵌套实体类属性参数。**
     >
     >
     >
     >请求路径：
     >
     >```java
     >http://localhost:8080/complexPojo?name=Tom&age=26&address.province=北京&address.city=北京
     >```

     - Address实体类

     ```java
     public class Address {
         private String province;
         private String city;
     
         public String getProvince() {
             return province;
         }
     
         public void setProvince(String province) {
             this.province = province;
         }
     
         public String getCity() {
             return city;
         }
     
         public void setCity(String city) {
             this.city = city;
         }
     
         @Override
         public String toString() {
             return "Address{" +
                     "province='" + province + '\'' +
                     ", city='" + city + '\'' +
                     '}';
         }
     }
     ```

     - User实体类

     ```java
     public class User {
         private String name;
         private Integer age;
         private Address address; //地址对象
     
         public String getName() {
             return name;
         }
     
         public void setName(String name) {
             this.name = name;
         }
     
         public Integer getAge() {
             return age;
         }
     
         public void setAge(Integer age) {
             this.age = age;
         }
     
         public Address getAddress() {
             return address;
         }
     
         public void setAddress(Address address) {
             this.address = address;
         }
     
         @Override
         public String toString() {
             return "User{" +
                     "name='" + name + '\'' +
                     ", age=" + age +
                     ", address=" + address +
                     '}';
         }
     }
     ```

     Controller方法：

     ```java
     @RestController
     public class RequestController {
         //实体参数：复杂实体对象
         @RequestMapping("/complexPojo")
         public String complexPojo(User user){
             System.out.println(user);
             return "OK";
         }
     }
     ```

- 数组集合参数

  > 请求路径：
  >
  > ```java
  > http://localhost:8080/complexPojo?hobby=game&hobby=java
  > ```
  >
  > 
  >
  > 后端程序接收上述多个值的方式有两种：
  >
  > 1. 数组
  > 2. 集合

  1. 数组

     数组参数：**请求参数名与形参数组名称相同且请求参数为多个，定义数组类型形参即可接收参数**

     Controller方法：

     ```java
     @RestController
     public class RequestController {
         //数组集合参数
         @RequestMapping("/arrayParam")
         public String arrayParam(String[] hobby){
             System.out.println(Arrays.toString(hobby));
             return "OK";
         }
     }
     ```

  2. 集合

     集合参数：**请求参数名与形参集合对象名相同且请求参数为多个，@RequestParam 绑定参数关系**

     > 默认情况下，请求中参数名相同的多个值，是封装到数组。如果要封装到集合，要使用@RequestParam绑定参数关系

     Controller方法：

     ```java
     @RestController
     public class RequestController {
         //数组集合参数
         @RequestMapping("/listParam")
         public String listParam(@RequestParam List<String> hobby){
             System.out.println(hobby);
             return "OK";
         }
     }
     ```

- 日期参数

  > 因为日期的格式多种多样（如：2022-12-12 10:05:45 、2022/12/12 10:05:45），那么对于日期类型的参数在进行封装的时候，需要通过@DateTimeFormat注解，以及其pattern属性来设置日期的格式。
  >
  > 
  >
  > - @DateTimeFormat注解的pattern属性中指定了哪种日期格式，前端的日期参数就必须按照指定的格式传递。
  > - 后端controller方法中，需要使用Date类型或LocalDateTime类型，来封装传递的参数。

  Controller方法：

  ```java
  @RestController
  public class RequestController {
      //日期时间参数
     @RequestMapping("/dateParam")
      public String dateParam(@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") LocalDateTime updateTime){
          System.out.println(updateTime);
          return "OK";
      }
  }
  ```

- JSON参数：

  服务端Controller方法接收JSON格式数据：

  1. 传递json格式的参数，在Controller中会使用实体类进行封装。 
  2. 封装规则：**JSON数据键名与形参对象属性名相同，定义POJO类型形参即可接收参数。需要使用 @RequestBody标识。**
  3. @RequestBody注解：将JSON数据映射到形参的实体类对象中（JSON中的key和实体类中的属性名保持一致）

  实体类：Address

  ```java
  public class Address {
      private String province;
      private String city;
      
  	//省略GET , SET 方法
  }
  ```

  实体类：User

  ```java
  public class User {
      private String name;
      private Integer age;
      private Address address;
      
      //省略GET , SET 方法
  }    
  ```

  Controller方法：

  ```java
  @RestController
  public class RequestController {
      //JSON参数
      @RequestMapping("/jsonParam")
      public String jsonParam(@RequestBody User user){
          System.out.println(user);
          return "OK";
      }
  }
  ```

- 路径参数

  >会直接在请求的URL中传递参数，例如：
  >
  >~~~Java
  >http://localhost:8080/user/1		
  >http://localhost:880/user/1/0
  >~~~
  >

  1. 后端：使用{…}来标识该路径参数，需要使用@PathVariable获取路径参数

     Controller方法：

     ```java
     @RestController
     public class RequestController {
         //路径参数
         @RequestMapping("/path/{id}")
         public String pathParam(@PathVariable Integer id){
             System.out.println(id);
             return "OK";
         }
     }
     ```

  2. **传递多个路径参数：**

     Controller方法：

     ~~~java
     @RestController
     public class RequestController {
         //路径参数
         @RequestMapping("/path/{id}/{name}")
         public String pathParam2(@PathVariable Integer id, @PathVariable String name){
             System.out.println(id+ " : " +name);
             return "OK";
         }
     }
     ~~~




### 2. 响应

- **@ResponseBody注解：**

  - 类型：方法注解、类注解
  - 位置：书写在Controller方法上或类上
  - 作用：将方法返回值直接响应给浏览器
    - 如果返回值类型是实体对象/集合，将会转换为JSON格式后在响应给浏览器

  >@RestController = @Controller + @ResponseBody 

  下面我们来测试下响应数据：

  ~~~java
  @RestController
  public class ResponseController {
      //响应字符串
      @RequestMapping("/hello")
      public String hello(){
          System.out.println("Hello World ~");
          return "Hello World ~";
      }
      //响应实体对象
      @RequestMapping("/getAddr")
      public Address getAddr(){
          Address addr = new Address();//创建实体类对象
          addr.setProvince("广东");
          addr.setCity("深圳");
          return addr;
      }
      //响应集合数据
      @RequestMapping("/listAddr")
      public List<Address> listAddr(){
          List<Address> list = new ArrayList<>();//集合对象
          
          Address addr = new Address();
          addr.setProvince("广东");
          addr.setCity("深圳");
  
          Address addr2 = new Address();
          addr2.setProvince("陕西");
          addr2.setCity("西安");
  
          list.add(addr);
          list.add(addr2);
          return list;
      }
  }
  ~~~

- 统一响应结果

  > 前端：只需要按照统一格式的返回结果进行解析(仅一种解析方案)，就可以拿到数据。

  统一的返回结果使用类来描述，在这个结果中包含：

  - 响应状态码：当前请求是成功，还是失败

  - 状态码信息：给页面的提示信息

  - 返回的数据：给前端响应的数据（字符串、对象、集合）

  定义在一个实体类Result来包含以上信息。代码如下：

  ```java
  public class Result {
      private Integer code;//响应码，1 代表成功; 0 代表失败
      private String msg;  //响应码 描述字符串
      private Object data; //返回的数据
  
      public Result() { }
      public Result(Integer code, String msg, Object data) {
          this.code = code;
          this.msg = msg;
          this.data = data;
      }
      // get,set方法
  
      //增删改 成功响应(不需要给前端返回数据)
      public static Result success(){
          return new Result(1,"success",null);
      }
      //查询 成功响应(把查询结果做为返回数据响应给前端)
      public static Result success(Object data){
          return new Result(1,"success",data);
      }
      //失败响应
      public static Result error(String msg){
          return new Result(0,msg,null);
      }
  }
  ```

  改造Controller：

  ~~~java
  @RestController
  public class ResponseController { 
      //响应统一格式的结果
      @RequestMapping("/hello")
      public Result hello(){
          System.out.println("Hello World ~");
          //return new Result(1,"success","Hello World ~");
          return Result.success("Hello World ~");
      }
  
      //响应统一格式的结果
      @RequestMapping("/getAddr")
      public Result getAddr(){
          Address addr = new Address();
          addr.setProvince("广东");
          addr.setCity("深圳");
          return Result.success(addr);
      }
  
      //响应统一格式的结果
      @RequestMapping("/listAddr")
      public Result listAddr(){
          List<Address> list = new ArrayList<>();
  
          Address addr = new Address();
          addr.setProvince("广东");
          addr.setCity("深圳");
  
          Address addr2 = new Address();
          addr2.setProvince("陕西");
          addr2.setCity("西安");
  
          list.add(addr);
          list.add(addr2);
          return Result.success(list);
      }
  }
  ~~~

  




### 3. 分层解耦

- 三层架构

  1. 介绍

     >单一职责原则：一个类或一个方法，就只做一件事情，只管一块功能。
     >
     >这可以让类、接口、方法的复杂度更低，可读性更强，扩展性更好，也更利用后期的维护。

     - 以将代码分为三层：
       1. Controller：控制层。接收前端发送的请求，对请求进行处理，并响应数据。
       2. Service：业务逻辑层。处理具体的业务逻辑。
       3. Dao：数据访问层(Data Access Object)，也称为持久层。负责数据访问操作，包括数据的增、删、改、查。
     - 基于三层架构的程序执行流程：
       1. 前端发起的请求，由Controller层接收（Controller响应数据给前端）
       2. Controller层调用Service层来进行逻辑处理（Service层处理完后，把处理结果返回给Controller层）
       3. Serivce层调用Dao层（逻辑处理过程中需要用到的一些数据要从Dao层获取）
       4. Dao层操作文件中的数据（Dao拿到的数据会返回给Service层）

  2. 代码拆分

     **控制层：**接收前端发送的请求，对请求进行处理，并响应数据

     ```java
     @RestController
     public class EmpController {
         //业务层对象
         private EmpService empService = new EmpServiceA();
     
         @RequestMapping("/listEmp")
         public Result list(){
             //1. 调用service层, 获取数据
             List<Emp> empList = empService.listEmp();
     
             //3. 响应数据
             return Result.success(empList);
         }
     }
     ```

     **业务逻辑层：**处理具体的业务逻辑

     - 业务接口

     ~~~java
     //业务逻辑接口（制定业务标准）
     public interface EmpService {
         //获取员工列表
         public List<Emp> listEmp();
     }
     ~~~

     - 业务实现类

     ```java
     //业务逻辑实现类（按照业务标准实现）
     public class EmpServiceA implements EmpService {
         //dao层对象
         private EmpDao empDao = new EmpDaoA();
     
         @Override
         public List<Emp> listEmp() {
             //1. 调用dao, 获取数据
             List<Emp> empList = empDao.listEmp();
     
             //2. 对数据进行转换处理 - gender, job
             empList.stream().forEach(emp -> {
                 //处理 gender 1: 男, 2: 女
                 String gender = emp.getGender();
                 if("1".equals(gender)){
                     emp.setGender("男");
                 }else if("2".equals(gender)){
                     emp.setGender("女");
                 }
     
                 //处理job - 1: 讲师, 2: 班主任 , 3: 就业指导
                 String job = emp.getJob();
                 if("1".equals(job)){
                     emp.setJob("讲师");
                 }else if("2".equals(job)){
                     emp.setJob("班主任");
                 }else if("3".equals(job)){
                     emp.setJob("就业指导");
                 }
             });
             return empList;
         }
     }
     ```

     **数据访问层：**负责数据的访问操作，包含数据的增、删、改、查

     - 数据访问接口

     ~~~java
     //数据访问层接口（制定标准）
     public interface EmpDao {
         //获取员工列表数据
         public List<Emp> listEmp();
     }
     ~~~

     - 数据访问实现类

     ```java
     //数据访问实现类
     public class EmpDaoA implements EmpDao {
         @Override
         public List<Emp> listEmp() {
             //1. 加载并解析emp.xml
             String file = this.getClass().getClassLoader().getResource("emp.xml").getFile();
             System.out.println(file);
             List<Emp> empList = XmlParserUtils.parse(file, Emp.class);
             return empList;
         }
     }
     ```

- 分层解耦

  > **软件设计原则：高内聚低耦合**:
  >
  > 高内聚指的是：一个模块中各个元素之间的联系的紧密程度，如果各个元素(语句、程序段)之间的联系程度越高，则内聚性越高，即 "高内聚"。
  >
  > 低耦合指的是：软件中各个层、模块之间的依赖关联程序越低越好。

  1. 解耦思路

     - 提供一个容器，容器中存储一些对象(例：EmpService对象)
     - controller程序从容器中获取EmpService类型的对象

  2. **控制反转：** Inversion Of Control，简称IOC。对象的创建控制权由程序自身转移到外部（容器），这种思想称为控制反转。

     > 对象的创建权由程序员主动创建转移到容器(由容器创建、管理对象)。这个容器称为：IOC容器或Spring容器

  3. **依赖注入：** Dependency Injection，简称DI。容器为应用程序提供运行时，所依赖的资源，称之为依赖注入。

     > 程序运行时需要某个资源，此时容器就为其提供这个资源。
     >
     > 例：EmpController程序运行时需要EmpService对象，Spring容器就为其提供并注入EmpService对象

  4. IOC容器中创建、管理的对象，称之为：bean对象

- `IOC&DI`

  1. IOC详解

     - bean的声明

       > IOC控制反转，就是将对象的控制权交给Spring的IOC容器，由IOC容器创建及管理对象。IOC容器创建的对象称为bean对象。

       Spring框架为了更好的标识web应用程序开发当中，bean对象到底归属于哪一层，提供了@Component的衍生注解：

       - @Controller    （标注在控制层类上）

         ~~~java
         @RestController  //@RestController = @Controller + @ResponseBody
         public class EmpController {
         
             @Autowired //运行时,从IOC容器中获取该类型对象,赋值给该变量
             private EmpService empService ;
         
             @RequestMapping("/listEmp")
             public Result list(){
                 //1. 调用service, 获取数据
                 List<Emp> empList = empService.listEmp();
         
                 //3. 响应数据
                 return Result.success(empList);
             }
         }
         ~~~

       - @Service          （标注在业务层类上）

         ~~~java
         @Service
         public class EmpServiceA implements EmpService {
         
             @Autowired //运行时,从IOC容器中获取该类型对象,赋值给该变量
             private EmpDao empDao ;
         
             @Override
             public List<Emp> listEmp() {
                 //1. 调用dao, 获取数据
                 List<Emp> empList = empDao.listEmp();
         
                 //2. 对数据进行转换处理 - gender, job
                 empList.stream().forEach(emp -> {
                     //处理 gender 1: 男, 2: 女
                     String gender = emp.getGender();
                     if("1".equals(gender)){
                         emp.setGender("男");
                     }else if("2".equals(gender)){
                         emp.setGender("女");
                     }
         
                     //处理job - 1: 讲师, 2: 班主任 , 3: 就业指导
                     String job = emp.getJob();
                     if("1".equals(job)){
                         emp.setJob("讲师");
                     }else if("2".equals(job)){
                         emp.setJob("班主任");
                     }else if("3".equals(job)){
                         emp.setJob("就业指导");
                     }
                 });
                 return empList;
             }
         }
         ~~~

       - @Repository    （标注在数据访问层**Dao层**类上）

         ~~~java
         @Repository
         public class EmpDaoA implements EmpDao {
             @Override
             public List<Emp> listEmp() {
                 //1. 加载并解析emp.xml
                 String file = this.getClass().getClassLoader().getResource("emp.xml").getFile();
                 System.out.println(file);
                 List<Emp> empList = XmlParserUtils.parse(file, Emp.class);
                 return empList;
             }
         }
         ~~~

     - 要把某个对象交给IOC容器管理，需要在对应的类上加上如下注解之一：

       | 注解        | 说明                 | 位置                                            |
       | :---------- | -------------------- | ----------------------------------------------- |
       | @Controller | @Component的衍生注解 | 标注在控制器类上                                |
       | @Service    | @Component的衍生注解 | 标注在业务类上                                  |
       | @Repository | @Component的衍生注解 | 标注在数据访问类上（由于与mybatis整合，用的少） |
       | @Component  | 声明bean的基础注解   | 不属于以上三类时，用此注解                      |

       在IOC容器中，每一个Bean都有一个属于自己的名字，可以通过注解的value属性指定bean的名字。如果没有指定，默认为类名首字母小写。

       > 注意事项: 
       >
       > - 声明bean的时候，可以通过value属性指定bean的名字，如果没有指定，默认为类名首字母小写。
       > - 使用以上四个注解都可以声明bean，但是在springboot集成web开发中，声明控制器bean只能用@Controller。

  2. 组件扫描

     - 使用四大注解声明的bean，要想生效，还需要被组件扫描注解@ComponentScan扫描

       > @ComponentScan注解虽然没有显式配置，但是实际上已经包含在了引导类声明注解 @SpringBootApplication 中，==**默认扫描的范围是SpringBoot启动类所在包及其子包**==。 

     - 解决方案：手动添加@ComponentScan注解，指定要扫描的包   （==仅做了解，不推荐==）

- `DI详解`

  > 依赖注入，是指IOC容器要为应用程序去提供运行时所依赖的资源，而资源指的就是对象。

  使用了@Autowired这个注解，完成了依赖注入的操作，而这个Autowired翻译过来叫：自动装配。

  @Autowired注解，默认是按照**类型**进行自动装配的（去IOC容器中找某个类型的对象，然后完成注入操作）

  > 在IOC容器中，存在多个相同类型的bean对象，会报错。

  1. Spring提供了多个相同类型的bean对象解决方案：

     - @Primary

       使用@Primary注解：当存在多个相同类型的Bean注入时，加上@Primary注解，来确定默认的实现。

     - @Qualifier

       使用@Qualifier注解：指定当前要注入的bean对象。 在@Qualifier的value属性中，指定注入的bean的名称。不能单独使用，必须配合@Autowired使用

     - @Resource

       使用@Resource注解：是按照bean的名称进行注入。通过name属性指定要注入的bean的名称。

  > 面试题 ： @Autowird 与 @Resource的区别
  >
  > - @Autowired 是spring框架提供的注解，而@Resource是JDK提供的注解
  > - @Autowired 默认是按照类型注入，而@Resource是按照名称注入






# 6.`Mybatis`入门

- 什么是MyBatis?
  1. MyBatis是一款优秀的 **持久层** **框架**，用于简化JDBC的开发。

  2. MyBatis本是 Apache的一个开源项目iBatis，2010年这个项目由apache迁移到了google code，并且改名为MyBatis 。2013年11月迁移到Github。

  3. 官网：https://mybatis.org/mybatis-3/zh/index.html 
- 持久层：指的是就是数据访问层(dao)，是用来操作数据库的。
- 框架：是一个半成品软件，是一套可重用的、通用的、软件基础代码模型。在框架的基础上进行软件开发更加高效、规范、通用、可拓展。



## 1.快速入门

> Mybatis会把数据库执行的查询结果，使用实体类封装起来（一行记录对应一个实体类对象）
>
> Mybatis操作数据库的步骤：
>
> 1. 准备工作(创建springboot工程、数据库表user、实体类User)
>
> 2. 引入Mybatis的相关依赖，配置Mybatis(数据库连接信息)
>
> 3. 编写SQL语句(注解/XML)



- 创建springboot工程

  > 创建springboot工程，并导入 mybatis的起步依赖、mysql的驱动包。

  > 项目工程创建完成后，自动在pom.xml文件中，导入Mybatis依赖和MySQL驱动依赖

  ~~~xml
  <!-- 仅供参考：只粘贴了pom.xml中部分内容 -->
  <dependencies>
          <!-- mybatis起步依赖 -->
          <dependency>
              <groupId>org.mybatis.spring.boot</groupId>
              <artifactId>mybatis-spring-boot-starter</artifactId>
              <version>2.3.0</version>
          </dependency>
  
          <!-- mysql驱动包依赖 -->
          <dependency>
              <groupId>com.mysql</groupId>
              <artifactId>mysql-connector-j</artifactId>
              <scope>runtime</scope>
          </dependency>
          
          <!-- spring单元测试 (集成了junit) -->
          <dependency>
              <groupId>org.springframework.boot</groupId>
              <artifactId>spring-boot-starter-test</artifactId>
              <scope>test</scope>
          </dependency>
  </dependencies>
  ~~~

- 数据准备

  创建用户表user，并创建对应的实体类User。

  1. 用户表：

     ```sql
     -- 用户表
     create table user(
         id int unsigned primary key auto_increment comment 'ID',
         name varchar(100) comment '姓名',
         age tinyint unsigned comment '年龄',
         gender tinyint unsigned comment '性别, 1:男, 2:女',
         phone varchar(11) comment '手机号'
     ) comment '用户表';
     
     -- 测试数据
     insert into user(id, name, age, gender, phone) VALUES (null,'白眉鹰王',55,'1','18800000000');
     insert into user(id, name, age, gender, phone) VALUES (null,'金毛狮王',45,'1','18800000001');
     insert into user(id, name, age, gender, phone) VALUES (null,'青翼蝠王',38,'1','18800000002');
     insert into user(id, name, age, gender, phone) VALUES (null,'紫衫龙王',42,'2','18800000003');
     insert into user(id, name, age, gender, phone) VALUES (null,'光明左使',37,'1','18800000004');
     insert into user(id, name, age, gender, phone) VALUES (null,'光明右使',48,'1','18800000005');
     ```

  2. 实体类

     - 实体类的属性名与表中的字段名一一对应。

     ```java
     public class User {
         private Integer id;   //id（主键）
         private String name;  //姓名
         private Short age;    //年龄
         private Short gender; //性别
         private String phone; //手机号
         
         //省略GET, SET方法
     }
     ```

- 配置Mybatis

  > 在springboot项目中，可以编写application.properties文件，配置数据库连接信息。要连接数据库，就需要配置数据库连接的基本信息，包括：driver-class-name、url 、username，password。

  application.properties:

  ```properties
  #驱动类名称
  spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
  #数据库连接的url
  spring.datasource.url=jdbc:mysql://localhost:3306/mybatis
  #连接数据库的用户名
  spring.datasource.username=root
  #连接数据库的密码
  spring.datasource.password=1234
  ```

- 编写SQL语句

  在创建出来的springboot工程中，在引导类所在包下，在创建一个包 mapper。在mapper包下创建一个接口 UserMapper ，这是一个持久层接口（Mybatis的持久层接口规范一般都叫 XxxMapper）。

  UserMapper：

  ~~~java
  import com.itheima.pojo.User;
  import org.apache.ibatis.annotations.Mapper;
  import org.apache.ibatis.annotations.Select;
  import java.util.List;
  
  @Mapper
  public interface UserMapper {
      
      //查询所有用户数据
      @Select("select id, name, age, gender, phone from user")
      public List<User> list();
      
  }
  ~~~

  > @Mapper注解：表示是mybatis中的Mapper接口
  >
  > - 程序运行时：框架会自动生成接口的实现类对象(代理对象)，并给交Spring的IOC容器管理
  >
  >  @Select注解：代表的就是select查询，用于书写select查询语句

- 单元测试

  > 在创建出来的SpringBoot工程中，在src下的test目录下，已经自动创建好了测试类 ，并且在测试类上已经添加了注解 @SpringBootTest，代表该测试类已经与SpringBoot整合。
  >
  > 该测试类在运行时，会自动通过引导类加载Spring的环境（IOC容器）。要测试那个bean对象，就可以直接通过@Autowired注解直接将其注入进行，然后就可以测试了。 

  测试类代码如下： 

  ```java
  @SpringBootTest
  public class MybatisQuickstartApplicationTests {
  	
      @Autowired
      private UserMapper userMapper;
  	
      @Test
      public void testList(){
          List<User> userList = userMapper.list();
          for (User user : userList) {
              System.out.println(user);
          }
      }
  
  }
  ```

  > 运行结果：
  >
  > ~~~
  > User{id=1, name='白眉鹰王', age=55, gender=1, phone='18800000000'}
  > User{id=2, name='金毛狮王', age=45, gender=1, phone='18800000001'}
  > User{id=3, name='青翼蝠王', age=38, gender=1, phone='18800000002'}
  > User{id=4, name='紫衫龙王', age=42, gender=2, phone='18800000003'}
  > User{id=5, name='光明左使', age=37, gender=1, phone='18800000004'}
  > User{id=6, name='光明右使', age=48, gender=1, phone='18800000005'}
  > ~~~

- 解决SQL警告与提示

  > 默认在UserMapper接口上加的@Select注解中编写SQL语句是没有提示的。 如果想让idea给出提示对应的SQL语句，需要在IDEA中配置与MySQL数据库的链接。 



## 2.`JDBC`介绍(了解)

- 介绍

  > Mybatis框架，就是对原始的JDBC程序的封装。 

  JDBC： ( Java DataBase Connectivity )，就是使用Java语言操作关系型数据库的一套API。

  > 本质：
  >
  > - sun公司官方定义的一套操作所有关系型数据库的规范，即接口。
  >
  > - 各个数据库厂商去实现这套接口，提供数据库驱动jar包。
  >
  > - 我们可以使用这套接口(JDBC)编程，真正执行的代码是驱动jar包中的实现类。

- 代码

  操作步骤如下：

  1. 注册驱动
  2. 获取连接对象
  3. 执行SQL语句，返回执行结果
  4. 处理执行结果
  5. 释放资源

  > 在pom.xml文件中已引入MySQL驱动依赖，我们直接编写JDBC代码即可

  JDBC具体代码实现：

  ```java
  import com.itheima.pojo.User;
  import org.junit.jupiter.api.Test;
  import java.sql.Connection;
  import java.sql.DriverManager;
  import java.sql.ResultSet;
  import java.sql.Statement;
  import java.util.ArrayList;
  import java.util.List;
  
  public class JdbcTest {
      @Test
      public void testJdbc() throws Exception {
          //1. 注册驱动
          Class.forName("com.mysql.cj.jdbc.Driver");
  
          //2. 获取数据库连接
          String url="jdbc:mysql://127.0.0.1:3306/mybatis";
          String username = "root";
          String password = "1234";
          Connection connection = DriverManager.getConnection(url, username, password);
  
          //3. 执行SQL
          Statement statement = connection.createStatement(); //操作SQL的对象
          String sql="select id,name,age,gender,phone from user";
          ResultSet rs = statement.executeQuery(sql);//SQL查询结果会封装在ResultSet对象中
  
          List<User> userList = new ArrayList<>();//集合对象（用于存储User对象）
          //4. 处理SQL执行结果
          while (rs.next()){
              //取出一行记录中id、name、age、gender、phone下的数据
              int id = rs.getInt("id");
              String name = rs.getString("name");
              short age = rs.getShort("age");
              short gender = rs.getShort("gender");
              String phone = rs.getString("phone");
              //把一行记录中的数据，封装到User对象中
              User user = new User(id,name,age,gender,phone);
              userList.add(user);//User对象添加到集合
          }
          //5. 释放资源
          statement.close();
          connection.close();
          rs.close();
  
          //遍历集合
          for (User user : userList) {
              System.out.println(user);
          }
      }
  }
  ```

  > DriverManager(类)：数据库驱动管理类。
  >
  > - 作用：
  >
  >   1. 注册驱动
  >
  >   2. 创建java代码和数据库之间的连接，即获取Connection对象
  >
  > Connection(接口)：建立数据库连接的对象
  >
  > - 作用：用于建立java程序和数据库之间的连接
  >
  > Statement(接口)： 数据库操作对象(执行SQL语句的对象)。
  >
  > - 作用：用于向数据库发送sql语句
  >
  > ResultSet(接口)：结果集对象（一张虚拟表）
  >
  > - 作用：sql查询语句的执行结果会封装在ResultSet中

- 技术对比

  mybatis解决的问题：

  1. 数据库连接四要素(驱动、链接、用户名、密码)，都配置在springboot默认的配置文件 application.properties中

  2. 查询结果的解析及封装，由mybatis自动完成映射封装，我们无需关注

  3. 在mybatis中使用了数据库连接池技术，从而避免了频繁的创建连接、销毁连接而带来的资源浪费。

  > 使用SpringBoot+Mybatis的方式操作数据库，能够提升开发效率、降低资源浪费

  而对于Mybatis来说，我们在开发持久层程序操作数据库时，需要重点关注以下两个方面：

  1. application.properties

     ~~~properties
     #驱动类名称
     spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
     #数据库连接的url
     spring.datasource.url=jdbc:mysql://localhost:3306/mybatis
     #连接数据库的用户名
     spring.datasource.username=root
     #连接数据库的密码
     spring.datasource.password=1234
     ~~~

  2. Mapper接口（编写SQL语句）

     ~~~java
     @Mapper
     public interface UserMapper {
         @Select("select id, name, age, gender, phone from user")
         public List<User> list();
     }
     ~~~

     

 



## 3.数据库连接池

- 介绍

  > 没有数据库连接池时：
  >
  > 客户端执行SQL语句：要先创建一个新的连接对象，然后执行SQL语句，SQL语句执行后又需要关闭连接对象从而释放资源，每次执行SQL时都需要创建连接、销毁链接，这种频繁的重复创建销毁的过程是比较耗费计算机的性能。

  数据库连接池是个容器，负责分配、管理数据库连接(Connection)

  - 程序在启动时，会在数据库连接池(容器)中，创建一定数量的Connection对象

  允许应用程序重复使用一个现有的数据库连接，而不是再重新建立一个

  - 客户端在执行SQL时，先从连接池中获取一个Connection对象，然后在执行SQL语句，SQL语句执行完之后，释放Connection时就会把Connection对象归还给连接池（Connection对象可以复用）

  释放空闲时间超过最大空闲时间的连接，来避免因为没有释放连接而引起的数据库连接遗漏

  - 客户端获取到Connection对象了，但是Connection对象并没有去访问数据库(处于空闲)，数据库连接池发现Connection对象的空闲时间 > 连接池中预设的最大空闲时间，此时数据库连接池就会自动释放掉这个连接对象

  数据库连接池的好处：

  1. 资源重用
  2. 提升系统响应速度
  3. 避免数据库连接遗漏

- 产品

  1. 官方(sun)提供了数据库连接池标准（javax.sql.DataSource接口）

     - 功能：获取连接 

       ~~~java
       public Connection getConnection() throws SQLException;
       ~~~

     - 第三方组织必须按照DataSource接口实现

  2. 常见的数据库连接池：

     * C3P0
     * DBCP
     * Druid
     * Hikari (springboot默认)

     现在使用更多的是：Hikari（默认）、Druid  （性能更优越）

  3. 把默认的数据库连接池切换为Druid数据库连接池，只需要完成以下两步操作即可：

     > 参考官方地址：https://github.com/alibaba/druid/tree/master/druid-spring-boot-starter

     - 在pom.xml文件中引入依赖

       ```xml
       <dependency>
           <!-- Druid连接池依赖 -->
           <groupId>com.alibaba</groupId>
           <artifactId>druid-spring-boot-starter</artifactId>
           <version>1.2.8</version>
       </dependency>
       ```

     - 在application.properties中引入数据库连接配置

       方式1：

       ~~~properties
       spring.datasource.druid.driver-class-name=com.mysql.cj.jdbc.Driver
       spring.datasource.druid.url=jdbc:mysql://localhost:3306/mybatis
       spring.datasource.druid.username=root
       spring.datasource.druid.password=1234
       ~~~

       方式2：

       ~~~properties
       spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
       spring.datasource.url=jdbc:mysql://localhost:3306/mybatis
       spring.datasource.username=root
       spring.datasource.password=1234
       ~~~




## 4.`lombok`

- 介绍

  Lombok可以通过简单的注解来简化和消除一些必须有但显得很臃肿的Java代码。

  > 通过注解的形式自动生成构造器、getter/setter、equals、hashcode、toString等方法，并可以自动化生成日志变量，简化java开发、提高效率。

  | **注解**            | **作用**                                                     |
  | ------------------- | ------------------------------------------------------------ |
  | @Getter/@Setter     | 为所有的属性提供get/set方法                                  |
  | @ToString           | 会给类自动生成易阅读的  toString 方法                        |
  | @EqualsAndHashCode  | 根据类所拥有的非静态字段自动重写 equals 方法和  hashCode 方法 |
  | @Data               | 提供了更综合的生成代码功能（@Getter  + @Setter + @ToString + @EqualsAndHashCode） |
  | @NoArgsConstructor  | 为实体类生成无参的构造器方法                                 |
  | @AllArgsConstructor | 为实体类生成除了static修饰的字段之外带有各参数的构造器方法。 |

- 使用

  1. 在pom.xml文件中引入依赖

     ```xml
     <!-- 在springboot的父工程中，已经集成了lombok并指定了版本号，故当前引入依赖时不需要指定version -->
     <dependency>
         <groupId>org.projectlombok</groupId>
         <artifactId>lombok</artifactId>
     </dependency>
     ```

  2. 在实体类上添加注解

     ```java
     import lombok.Data;
     
     @Data
     public class User {
         private Integer id;
         private String name;
         private Short age;
         private Short gender;
         private String phone;
     }
     ```

     > 在实体类上添加了@Data注解，那么这个类在编译时期，就会生成getter/setter、equals、hashcode、toString等方法。
     >

     说明：@Data注解中不包含全参构造方法，通常在实体类上，还会添加上：全参构造、无参构造

     ~~~java
     import lombok.Data;
     
     @Data //getter方法、setter方法、toString方法、hashCode方法、equals方法
     @NoArgsConstructor //无参构造
     @AllArgsConstructor//全参构造
     public class User {
         private Integer id;
         private String name;
         private Short age;
         private Short gender;
         private String phone;
     }
     ~~~

  3. Lombok的注意事项：

     - Lombok会在编译时，会自动生成对应的java代码
     - 在使用lombok时，还需要安装一个lombok的插件（新版本的IDEA中自带）




## 5.`Mybatis`基础操作（注解）

> **创建一个新的springboot工程，选择引入对应的起步依赖（mybatis、mysql驱动、lombok）**
>
> CRUD（增删改查）

**创建对应的实体类Emp（实体类属性采用驼峰命名）**

~~~java
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Emp {
    private Integer id;
    private String username;
    private String password;
    private String name;
    private Short gender;
    private String image;
    private Short job;
    private LocalDate entrydate;     //LocalDate类型对应数据表中的date类型
    private Integer deptId;
    private LocalDateTime createTime;//LocalDateTime类型对应数据表中的datetime类型
    private LocalDateTime updateTime;
}
~~~



在Mybatis当中可以借助日志，查看到sql语句的执行、执行传递的参数以及执行结果。具体操作如下：

1. 打开application.properties文件

2. 开启mybatis的日志，并指定输出到控制台

```properties
#指定mybatis输出日志的位置, 输出控制台
mybatis.configuration.log-impl=org.apache.ibatis.logging.stdout.StdOutImpl
```





### 1.删除

- **功能：根据主键删除数据**

  1. SQL语句

     ~~~mysql
     -- 删除id=17的数据
     delete from emp where id = 17;
     ~~~

     > Mybatis框架让程序员更关注于SQL语句

  2. 接口方法

     ~~~java
     @Mapper
     public interface EmpMapper {
         
         //@Delete("delete from emp where id = 17")
         //public void delete();
         //以上delete操作的SQL语句中的id值写成固定的17，就表示只能删除id=17的用户数据
         //SQL语句中的id值不能写成固定数值，需要变为动态的数值
         //解决方案：在delete方法中添加一个参数(用户id)，将方法中的参数，传给SQL语句
         
         /**
          * 根据id删除数据
          * @param id    用户id
          */
         @Delete("delete from emp where id = #{id}")//使用#{key}方式获取方法中的参数值
         public void delete(Integer id);
         
     }
     ~~~

     > @Delete注解：用于编写delete操作的SQL语句

     > 如果mapper接口方法形参只有一个普通类型的参数，#{…} 里面的属性名可以随便写，如：#{id}、#{value}。但是建议保持名字一致。

- 测试

  在单元测试类中通过@Autowired注解注入EmpMapper类型对象

  ~~~java
  @SpringBootTest
  class SpringbootMybatisCrudApplicationTests {
      @Autowired //从Spring的IOC容器中，获取类型是EmpMapper的对象并注入
      private EmpMapper empMapper;
  
      @Test
      public void testDel(){
          //调用删除方法
          empMapper.delete(16);
      }
  
  }
  ~~~

- 预编译SQL

  1. 预编译SQL有两个优势：

     - 性能更高：预编译SQL，编译一次之后会将编译后的SQL语句缓存起来，后面再次执行这条语句时，不会再次编译。（只是输入的参数不同）。

     - 更安全(防止SQL注入)：将敏感字进行转义，保障SQL的安全性。

       > 用户在页面提交数据的时候人为的添加一些特殊字符，使得sql语句的结构发生了变化，最终可以在没有用户名或者密码的情况下进行登录。

  2. 参数占位符

     在Mybatis中提供的参数占位符有两种：${...} 、#{...}

     - #{...}
       - 执行SQL时，会将#{…}替换为?，生成预编译SQL，会自动设置参数值
       - 使用时机：参数传递，都使用#{…}

     - ${...}
       - 拼接SQL。直接将参数拼接在SQL语句中，存在SQL注入问题
       - 使用时机：如果对表名、列表进行动态设置时使用

     > 注意事项：在项目开发中，建议使用#{...}，生成预编译SQL，防止SQL注入安全。




### 2.新增

- 基本新增

  1. SQL语句：

     ```sql
     insert into emp(username, name, gender, image, job, entrydate, dept_id, create_time, update_time) values ('songyuanqiao','宋远桥',1,'1.jpg',2,'2012-10-09',2,'2022-10-01 10:00:00','2022-10-01 10:00:00');
     ```

  2. 接口方法：

     ```java
     @Mapper
     public interface EmpMapper {
     
         @Insert("insert into emp(username, name, gender, image, job, entrydate, dept_id, create_time, update_time) values (#{username}, #{name}, #{gender}, #{image}, #{job}, #{entrydate}, #{deptId}, #{createTime}, #{updateTime})")
         public void insert(Emp emp);
     
     }
     ```

     > 说明：#{...} 里面写的名称是对象的属性名

  3. 测试类：

     ```java
     import com.itheima.mapper.EmpMapper;
     import com.itheima.pojo.Emp;
     import org.junit.jupiter.api.Test;
     import org.springframework.beans.factory.annotation.Autowired;
     import org.springframework.boot.test.context.SpringBootTest;
     import java.time.LocalDate;
     import java.time.LocalDateTime;
     
     @SpringBootTest
     class SpringbootMybatisCrudApplicationTests {
         @Autowired
         private EmpMapper empMapper;
     
         @Test
         public void testInsert(){
             //创建员工对象
             Emp emp = new Emp();
             emp.setUsername("tom");
             emp.setName("汤姆");
             emp.setImage("1.jpg");
             emp.setGender((short)1);
             emp.setJob((short)1);
             emp.setEntrydate(LocalDate.of(2000,1,1));
             emp.setCreateTime(LocalDateTime.now());
             emp.setUpdateTime(LocalDateTime.now());
             emp.setDeptId(1);
             //调用添加方法
             empMapper.insert(emp);
         }
     }
     
     ```

- 主键返回

  > 概念：在数据添加成功后，需要获取插入数据库数据的主键。
  >
  > 需要在Mapper接口中的方法上添加一个Options注解，并在注解中指定属性useGeneratedKeys=true和keyProperty="实体类属性名"

  1. 主键返回代码实现：

     ~~~java
     @Mapper
     public interface EmpMapper {
         
         //会自动将生成的主键值，赋值给emp对象的id属性
         @Options(useGeneratedKeys = true,keyProperty = "id")
         @Insert("insert into emp(username, name, gender, image, job, entrydate, dept_id, create_time, update_time) values (#{username}, #{name}, #{gender}, #{image}, #{job}, #{entrydate}, #{deptId}, #{createTime}, #{updateTime})")
         public void insert(Emp emp);
     
     }
     ~~~

  2. 测试：

     ~~~java
     @SpringBootTest
     class SpringbootMybatisCrudApplicationTests {
         @Autowired
         private EmpMapper empMapper;
     
         @Test
         public void testInsert(){
             //创建员工对象
             Emp emp = new Emp();
             emp.setUsername("jack");
             emp.setName("杰克");
             emp.setImage("1.jpg");
             emp.setGender((short)1);
             emp.setJob((short)1);
             emp.setEntrydate(LocalDate.of(2000,1,1));
             emp.setCreateTime(LocalDateTime.now());
             emp.setUpdateTime(LocalDateTime.now());
             emp.setDeptId(1);
             //调用添加方法
             empMapper.insert(emp);
     
             System.out.println(emp.getDeptId());
         }
     }
     ~~~




### 3.更新

- SQL语句：

  ```sql
  update emp set username = 'linghushaoxia', name = '令狐少侠', gender = 1 , image = '1.jpg' , job = 2, entrydate = '2012-01-01', dept_id = 2, update_time = '2022-10-01 12:12:12' where id = 18;
  ```

- 接口方法：

  ```java
  @Mapper
  public interface EmpMapper {
      /**
       * 根据id修改员工信息
       * @param emp
       */
      @Update("update emp set username=#{username}, name=#{name}, gender=#{gender}, image=#{image}, job=#{job}, entrydate=#{entrydate}, dept_id=#{deptId}, update_time=#{updateTime} where id=#{id}")
      public void update(Emp emp);
      
  }
  ```

- 测试类：

  ```java
  @SpringBootTest
  class SpringbootMybatisCrudApplicationTests {
      @Autowired
      private EmpMapper empMapper;
  
      @Test
      public void testUpdate(){
          //要修改的员工信息
          Emp emp = new Emp();
          emp.setId(23);
          emp.setUsername("songdaxia");
          emp.setPassword(null);
          emp.setName("老宋");
          emp.setImage("2.jpg");
          emp.setGender((short)1);
          emp.setJob((short)2);
          emp.setEntrydate(LocalDate.of(2012,1,1));
          emp.setCreateTime(null);
          emp.setUpdateTime(LocalDateTime.now());
          emp.setDeptId(2);
          //调用方法，修改员工数据
          empMapper.update(emp);
      }
  }
  ```

  

### 4.查询

- 根据ID查询

  1. SQL语句：

     ~~~mysql
     select id, username, password, name, gender, image, job, entrydate, dept_id, create_time, update_time from emp;
     ~~~

  2. 接口方法：

     ~~~java
     @Mapper
     public interface EmpMapper {
         @Select("select id, username, password, name, gender, image, job, entrydate, dept_id, create_time, update_time from emp where id=#{id}")
         public Emp getById(Integer id);
     }
     ~~~

  3. 测试类：

     ~~~java
     @SpringBootTest
     class SpringbootMybatisCrudApplicationTests {
         @Autowired
         private EmpMapper empMapper;
     
         @Test
         public void testGetById(){
             Emp emp = empMapper.getById(1);
             System.out.println(emp);
         }
     }
     ~~~


  > 在测试的过程中，会发现有几个字段(deptId、createTime、updateTime)是没有数据值的

- 数据封装

  > - 实体类属性名和数据库表查询返回的字段名一致，mybatis会自动封装。
  > - 如果实体类属性名和数据库表查询返回的字段名不一致，不能自动封装。

   解决方案：

  1. 起别名

  2. 结果映射

     **手动结果映射**：通过 @Results及@Result 进行手动结果映射

     ```java
     @Results({@Result(column = "dept_id", property = "deptId"),
               @Result(column = "create_time", property = "createTime"),
               @Result(column = "update_time", property = "updateTime")})
     @Select("select id, username, password, name, gender, image, job, entrydate, dept_id, create_time, update_time from emp where id=#{id}")
     public Emp getById(Integer id);
     ```

     > @Results源代码：
     >
     > ~~~java
     > @Documented
     > @Retention(RetentionPolicy.RUNTIME)
     > @Target({ElementType.METHOD})
     > public @interface Results {
     > String id() default "";
     > 
     > Result[] value() default {};  //Result类型的数组
     > }
     > ~~~
     >
     > @Result源代码：
     >
     > ~~~java
     > @Documented
     > @Retention(RetentionPolicy.RUNTIME)
     > @Target({ElementType.METHOD})
     > @Repeatable(Results.class)
     > public @interface Result {
     > boolean id() default false;//表示当前列是否为主键（true:是主键）
     > 
     > String column() default "";//指定表中字段名
     > 
     > String property() default "";//指定类中属性名
     > 
     > Class<?> javaType() default void.class;
     > 
     > JdbcType jdbcType() default JdbcType.UNDEFINED;
     > 
     > Class<? extends TypeHandler> typeHandler() default UnknownTypeHandler.class;
     > 
     > One one() default @One;
     > 
     > Many many() default @Many;
     > }
     > ~~~

  3. 开启驼峰命名

     **开启驼峰命名(推荐)**：如果字段名与属性名符合驼峰命名规则，mybatis会自动通过驼峰命名规则映射

     > 驼峰命名规则：   abc_xyz    =>   abcXyz
     >
     > - 表中字段名：abc_xyz
     > - 类中属性名：abcXyz

     ```properties
     # 在application.properties中添加：
     mybatis.configuration.map-underscore-to-camel-case=true
     ```

     > 要使用驼峰命名前提是 实体类的属性 与 数据库表中的字段名严格遵守驼峰命名。

- 条件查询

  1. SQL语句：

     ```sql
     select id, username, password, name, gender, image, job, entrydate, dept_id, create_time, update_time 
     from emp 
     where name like '%张%' 
           and gender = 1 
           and entrydate between '2010-01-01' and '2020-01-01 ' 
     order by update_time desc;
     ```

  2. 接口方法：

     使用MySQL提供的字符串拼接函数：concat('%' , '关键字' , '%')

     ~~~java
     @Mapper
     public interface EmpMapper {
     
         @Select("select * from emp " +
                 "where name like concat('%',#{name},'%') " +
                 "and gender = #{gender} " +
                 "and entrydate between #{begin} and #{end} " +
                 "order by update_time desc")
         public List<Emp> list(String name, Short gender, LocalDate begin, LocalDate end);
     
     }
     
     ~~~

     > 执行结果：生成的SQL都是预编译的SQL语句（性能高、安全）



## 6.`Mybatis`的`XML`配置文件

- XML配置文件规范

  在Mybatis中使用XML映射文件方式开发，需要符合一定的规范：

  1. XML映射文件的名称与Mapper接口名称一致，并且将XML映射文件和Mapper接口放置在相同包下（同包同名）

  2. XML映射文件的namespace属性为Mapper接口全限定名一致

  3. XML映射文件中sql语句的id与Mapper接口中的方法名一致，并保持返回类型一致。

  ![001](https://cdn.jsdelivr.net/gh/silent-wuhen/Blog_picture01/H06_Java/2.JavaWeb/1.JavaWeb基础/001.png?raw=true)

  > \<select>标签：就是用于编写select查询语句的。
  >
  > - resultType属性，指的是查询返回的单条记录所封装的类型。

- XML配置文件实现

  1. 创建XML映射文件

  2. 编写XML映射文件

     > xml映射文件中的dtd约束，直接从mybatis官网复制即可

     ~~~xml
     <?xml version="1.0" encoding="UTF-8" ?>
     <!DOCTYPE mapper
       PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
       "https://mybatis.org/dtd/mybatis-3-mapper.dtd">
     <mapper namespace="">
      
     </mapper>
     ~~~

  3. 配置：XML映射文件的namespace属性为Mapper接口全限定名

     ~~~xml
     <?xml version="1.0" encoding="UTF-8" ?>
     <!DOCTYPE mapper
             PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
             "https://mybatis.org/dtd/mybatis-3-mapper.dtd">
     <mapper namespace="com.itheima.mapper.EmpMapper">
     
     </mapper>
     ~~~

  4. 配置：XML映射文件中sql语句的id与Mapper接口中的方法名一致，并保持返回类型一致

     ~~~xml
     <?xml version="1.0" encoding="UTF-8" ?>
     <!DOCTYPE mapper
             PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
             "https://mybatis.org/dtd/mybatis-3-mapper.dtd">
     <mapper namespace="com.itheima.mapper.EmpMapper">
     
         <!--查询操作-->
         <select id="list" resultType="com.itheima.pojo.Emp">
             select * from emp
             where name like concat('%',#{name},'%')
                   and gender = #{gender}
                   and entrydate between #{begin} and #{end}
             order by update_time desc
         </select>
     </mapper>
     ~~~

- MybatisX的使用

  MybatisX是一款基于IDEA的快速开发Mybatis的插件，为效率而生。



## 7. `Mybatis`动态`SQL`

### 1.`if&where&set`

>- `<if>`：用于判断条件是否成立。使用test属性进行条件判断，如果条件为true，则拼接SQL。
>
>  ~~~xml
>  <if test="条件表达式">
>     要拼接的sql语句
>  </if>
>  ~~~
>
>- 使用`<where>`标签代替SQL语句中的where关键字
>
>  `<where>`只会在子元素有内容的情况下才插入where子句，而且会自动去除子句的开头的AND或OR
>
>- `<set>`：动态的在SQL语句中插入set关键字，并会删掉额外的逗号。（用于update语句中）



- 条件查询

  1. 原有的SQL语句

     ~~~xml
     <select id="list" resultType="com.itheima.pojo.Emp">
             select * from emp
             where name like concat('%',#{name},'%')
                   and gender = #{gender}
                   and entrydate between #{begin} and #{end}
             order by update_time desc
     </select>
     ~~~

  2. 动态SQL语句

     ~~~xml
     <select id="list" resultType="com.itheima.pojo.Emp">
             select * from emp
             <where>
                  <!-- if做为where标签的子元素 -->
                  <if test="name != null">
                      and name like concat('%',#{name},'%')
                  </if>
                  <if test="gender != null">
                      and gender = #{gender}
                  </if>
                  <if test="begin != null and end != null">
                      and entrydate between #{begin} and #{end}
                  </if>
             </where>
             order by update_time desc
     </select>
     ~~~

  3. 测试方法：

     ~~~java
     @Test
     public void testList(){
         //只有性别
         List<Emp> list = empMapper.list(null, (short)1, null, null);
         for(Emp emp : list){
             System.out.println(emp);
         }
     }
     ~~~

- 更新员工

  1. 修改Mapper接口：

     ~~~java
     @Mapper
     public interface EmpMapper {
         //删除@Update注解编写的SQL语句
         //update操作的SQL语句编写在Mapper映射文件中
         public void update(Emp emp);
     }
     ~~~

  2. 修改Mapper映射文件：

     ~~~xml
     <?xml version="1.0" encoding="UTF-8" ?>
     <!DOCTYPE mapper
             PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
             "https://mybatis.org/dtd/mybatis-3-mapper.dtd">
     <mapper namespace="com.itheima.mapper.EmpMapper">
     
         <!--更新操作-->
         <update id="update">
             update emp
             <!-- 使用set标签，代替update语句中的set关键字 -->
             <set>
                 <if test="username != null">
                     username=#{username},
                 </if>
                 <if test="name != null">
                     name=#{name},
                 </if>
                 <if test="gender != null">
                     gender=#{gender},
                 </if>
                 <if test="image != null">
                     image=#{image},
                 </if>
                 <if test="job != null">
                     job=#{job},
                 </if>
                 <if test="entrydate != null">
                     entrydate=#{entrydate},
                 </if>
                 <if test="deptId != null">
                     dept_id=#{deptId},
                 </if>
                 <if test="updateTime != null">
                     update_time=#{updateTime}
                 </if>
             </set>
             where id=#{id}
         </update>
     </mapper>
     ~~~

  3. 测试方法：

     ~~~java
     @Test
     public void testUpdate2(){
             //要修改的员工信息
             Emp emp = new Emp();
             emp.setId(20);
             emp.setUsername("Tom222");
           
             //调用方法，修改员工数据
             empMapper.update(emp);
     }
     ~~~




### 2.`foreach`

- SQL语句：

  ~~~mysql
  delete from emp where id in (1,2,3);
  ~~~

- Mapper接口：

  ~~~java
  @Mapper
  public interface EmpMapper {
      //批量删除
      public void deleteByIds(List<Integer> ids);
  }
  ~~~

- XML映射文件：

  1. 使用`<foreach>`遍历deleteByIds方法中传递的参数ids集合

     ~~~xml
     <foreach collection="集合名称" item="集合遍历出来的元素/项" separator="每一次遍历使用的分隔符" 
              open="遍历开始前拼接的片段" close="遍历结束后拼接的片段">
     </foreach>
     ~~~

  2. 案例：

     ~~~xml
     <?xml version="1.0" encoding="UTF-8" ?>
     <!DOCTYPE mapper
             PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
             "https://mybatis.org/dtd/mybatis-3-mapper.dtd">
     <mapper namespace="com.itheima.mapper.EmpMapper">
         <!--删除操作-->
         <delete id="deleteByIds">
             delete from emp where id in
             <foreach collection="ids" item="id" separator="," open="(" close=")">
                 #{id}
             </foreach>
         </delete>
     </mapper> 
     ~~~




### 3.`sql&include`

- 问题分析：

  在xml映射文件中配置的SQL，有时可能会存在很多重复的片段，此时就会存在很多冗余的代码

- 解决方案

  1. `<sql>`：定义可重用的SQL片段

  2. `<include>`：通过属性refid，指定包含的SQL片段

- SQL片段： 抽取重复的代码

  ```xml
  <sql id="commonSelect">
   	select id, username, password, name, gender, image, job, entrydate, dept_id, create_time, update_time from emp
  </sql>
  ```

- 通过`<include>` 标签在原来抽取的地方进行引用。操作如下：

  ```xml
  <select id="list" resultType="com.itheima.pojo.Emp">
      <include refid="commonSelect"/>
      <where>
          <if test="name != null">
              name like concat('%',#{name},'%')
          </if>
          <if test="gender != null">
              and gender = #{gender}
          </if>
          <if test="begin != null and end != null">
              and entrydate between #{begin} and #{end}
          </if>
      </where>
      order by update_time desc
  </select>
  ```

  



# 7.`SpringBootWeb`案例

## 1.准备工作

- 数据库表

  ```sql
  create database tlias;
  
  use tlias
  
  -- 部门管理
  create table dept(
      id int unsigned primary key auto_increment comment '主键ID',
      name varchar(10) not null unique comment '部门名称',
      create_time datetime not null comment '创建时间',
      update_time datetime not null comment '修改时间'
  ) comment '部门表';
  -- 部门表测试数据
  insert into dept (id, name, create_time, update_time) values(1,'学工部',now(),now()),(2,'教研部',now(),now()),(3,'咨询部',now(),now()), (4,'就业部',now(),now()),(5,'人事部',now(),now());
  
  
  
  -- 员工管理(带约束)
  create table emp (
    id int unsigned primary key auto_increment comment 'ID',
    username varchar(20) not null unique comment '用户名',
    password varchar(32) default '123456' comment '密码',
    name varchar(10) not null comment '姓名',
    gender tinyint unsigned not null comment '性别, 说明: 1 男, 2 女',
    image varchar(300) comment '图像',
    job tinyint unsigned comment '职位, 说明: 1 班主任,2 讲师, 3 学工主管, 4 教研主管, 5 咨询师',
    entrydate date comment '入职时间',
    dept_id int unsigned comment '部门ID',
    create_time datetime not null comment '创建时间',
    update_time datetime not null comment '修改时间'
  ) comment '员工表';
  -- 员工表测试数据
  INSERT INTO emp
  	(id, username, password, name, gender, image, job, entrydate,dept_id, create_time, update_time) VALUES
  	(1,'jinyong','123456','金庸',1,'1.jpg',4,'2000-01-01',2,now(),now()),
  	(2,'zhangwuji','123456','张无忌',1,'2.jpg',2,'2015-01-01',2,now(),now()),
  	(3,'yangxiao','123456','杨逍',1,'3.jpg',2,'2008-05-01',2,now(),now()),
  	(4,'weiyixiao','123456','韦一笑',1,'4.jpg',2,'2007-01-01',2,now(),now()),
  	(5,'changyuchun','123456','常遇春',1,'5.jpg',2,'2012-12-05',2,now(),now()),
  	(6,'xiaozhao','123456','小昭',2,'6.jpg',3,'2013-09-05',1,now(),now()),
  	(7,'jixiaofu','123456','纪晓芙',2,'7.jpg',1,'2005-08-01',1,now(),now()),
  	(8,'zhouzhiruo','123456','周芷若',2,'8.jpg',1,'2014-11-09',1,now(),now()),
  	(9,'dingminjun','123456','丁敏君',2,'9.jpg',1,'2011-03-11',1,now(),now()),
  	(10,'zhaomin','123456','赵敏',2,'10.jpg',1,'2013-09-05',1,now(),now()),
  	(11,'luzhangke','123456','鹿杖客',1,'11.jpg',5,'2007-02-01',3,now(),now()),
  	(12,'hebiweng','123456','鹤笔翁',1,'12.jpg',5,'2008-08-18',3,now(),now()),
  	(13,'fangdongbai','123456','方东白',1,'13.jpg',5,'2012-11-01',3,now(),now()),
  	(14,'zhangsanfeng','123456','张三丰',1,'14.jpg',2,'2002-08-01',2,now(),now()),
  	(15,'yulianzhou','123456','俞莲舟',1,'15.jpg',2,'2011-05-01',2,now(),now()),
  	(16,'songyuanqiao','123456','宋远桥',1,'16.jpg',2,'2007-01-01',2,now(),now()),
  	(17,'chenyouliang','123456','陈友谅',1,'17.jpg',NULL,'2015-03-21',NULL,now(),now());
  ```

- 创建SpringBoot工程，选择引入对应的起步依赖（web、mybatis、mysql驱动、lombok） (版本选择2.7.5版本，可以创建完毕之后，在pom.xml文件中更改版本号)

  ```xml
  <?xml version="1.0" encoding="UTF-8"?>
  <project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
           xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
      <modelVersion>4.0.0</modelVersion>
      <parent>
          <groupId>org.springframework.boot</groupId>
          <artifactId>spring-boot-starter-parent</artifactId>
          <version>2.7.5</version>
          <relativePath/> 
      </parent>
      <groupId>com.itheima</groupId>
      <artifactId>tlias-web-management</artifactId>
      <version>0.0.1-SNAPSHOT</version>
      <name>tlias-web-management</name>
      <description>Demo project for Spring Boot</description>
      <properties>
          <java.version>11</java.version>
      </properties>
      <dependencies>
          <dependency>
              <groupId>org.springframework.boot</groupId>
              <artifactId>spring-boot-starter-web</artifactId>
          </dependency>
          <dependency>
              <groupId>org.mybatis.spring.boot</groupId>
              <artifactId>mybatis-spring-boot-starter</artifactId>
              <version>2.3.0</version>
          </dependency>
  
          <dependency>
              <groupId>com.mysql</groupId>
              <artifactId>mysql-connector-j</artifactId>
              <scope>runtime</scope>
          </dependency>
          <dependency>
              <groupId>org.projectlombok</groupId>
              <artifactId>lombok</artifactId>
              <optional>true</optional>
          </dependency>
          <dependency>
              <groupId>org.springframework.boot</groupId>
              <artifactId>spring-boot-starter-test</artifactId>
              <scope>test</scope>
          </dependency>
      </dependencies>
  
      <build>
          <plugins>
              <plugin>
                  <groupId>org.springframework.boot</groupId>
                  <artifactId>spring-boot-maven-plugin</artifactId>
                  <configuration>
                      <excludes>
                          <exclude>
                              <groupId>org.projectlombok</groupId>
                              <artifactId>lombok</artifactId>
                          </exclude>
                      </excludes>
                  </configuration>
              </plugin>
          </plugins>
      </build>
  
  </project>
  ```

- 配置文件application.properties中引入mybatis的配置信息，准备对应的实体类

  1. application.properties 

     ~~~properties
     #数据库连接
     spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
     spring.datasource.url=jdbc:mysql://localhost:3306/tlias
     spring.datasource.username=root
     spring.datasource.password=1234
     
     #开启mybatis的日志输出
     mybatis.configuration.log-impl=org.apache.ibatis.logging.stdout.StdOutImpl
     
     #开启数据库表字段 到 实体类属性的驼峰映射
     mybatis.configuration.map-underscore-to-camel-case=true
     ~~~
     
  2. 实体类

     ~~~java
     /*部门类*/
     @Data
     @NoArgsConstructor
     @AllArgsConstructor
     public class Dept {
         private Integer id;
         private String name;
         private LocalDateTime createTime;
         private LocalDateTime updateTime;
     }
     ~~~

     ~~~java
     /*员工类*/
     @Data
     @NoArgsConstructor
     @AllArgsConstructor
     public class Emp {
         private Integer id;
         private String username;
         private String password;
         private String name;
         private Short gender;
         private String image;
         private Short job;
         private LocalDate entrydate;
         private Integer deptId;
         private LocalDateTime createTime;
         private LocalDateTime updateTime;
     }
     ~~~

- 准备对应的Mapper、Service(接口、实现类)、Controller基础结构

  1. 数据访问层：

     - DeptMapper

     ~~~java
     package com.itheima.mapper;
     import org.apache.ibatis.annotations.Mapper;
     
     @Mapper
     public interface DeptMapper {
     }
     ~~~

     - EmpMapper

     ~~~java
     package com.itheima.mapper;
     import org.apache.ibatis.annotations.Mapper;
     
     @Mapper
     public interface EmpMapper {
     }
     
     ~~~

  2. 业务层：

     - DeptService

     ~~~java
     package com.itheima.service;
     
     //部门业务规则
     public interface DeptService {
     }
     ~~~

     - DeptServiceImpl

     ~~~java
     package com.itheima.service.impl;
     import lombok.extern.slf4j.Slf4j;
     import org.springframework.stereotype.Service;
     
     //部门业务实现类
     @Slf4j
     @Service
     public class DeptServiceImpl implements DeptService {
     }
     ~~~

     - EmpService

     ~~~java
     package com.itheima.service;
     
     //员工业务规则
     public interface EmpService {
     }
     ~~~

     - EmpServiceImpl

     ~~~java
     package com.itheima.service.impl;
     import com.itheima.service.EmpService;
     import lombok.extern.slf4j.Slf4j;
     import org.springframework.stereotype.Service;
     
     //员工业务实现类
     @Slf4j
     @Service
     public class EmpServiceImpl implements EmpService {
     
     }
     ~~~

  3. 控制层：

     - DeptController

     ~~~java
     package com.itheima.controller;
     import org.springframework.web.bind.annotation.RestController;
     
     //部门管理控制器
     @RestController
     public class DeptController {
     }
     ~~~

     - EmpController

     ~~~java
     package com.itheima.controller;
     import org.springframework.web.bind.annotation.RestController;
     
     //员工管理控制器
     @RestController
     public class EmpController {
     }
     ~~~

- 统一响应结果

  前后端工程在进行交互时，使用统一响应结果 Result。

  ~~~java
  package com.itheima.pojo;
  
  import lombok.AllArgsConstructor;
  import lombok.Data;
  import lombok.NoArgsConstructor;
  
  @Data
  @NoArgsConstructor
  @AllArgsConstructor
  public class Result {
      private Integer code;//响应码，1 代表成功; 0 代表失败
      private String msg;  //响应信息 描述字符串
      private Object data; //返回的数据
  
      //增删改 成功响应
      public static Result success(){
          return new Result(1,"success",null);
      }
      //查询 成功响应
      public static Result success(Object data){
          return new Result(1,"success",data);
      }
      //失败响应
      public static Result error(String msg){
          return new Result(0,msg,null);
      }
  }
  ~~~

  

## 2.查询部门

- Deptcontroller.java

  ```java
  package com.example.controller;
  
  @Slf4j
  @RestController
  public class DeptController {
  
      @Autowired
      private DeptService deptService;
  
      //    @RequestMapping(value = "/depts", method = RequestMethod.GET)
      @GetMapping("/depts")
      public Result list() {
          log.info("查询所以数据");
          List<Dept> deptList = deptService.list();
          return Result.success(deptList);
      }
      
  }
  
  ```
  
- DeptService.java

  ```java
  package com.example.service;
  
  import com.example.pojo.Dept;
  
  import java.util.List;
  
  public interface DeptService {
      List<Dept> list();
  }
  
  ```

- DeptServiceImpl.java

  ```java
  package com.example.service.impl;
  
  @Slf4j
  @Service
  public class DeptServiceImpl implements DeptService {
  
      @Autowired
      private DeptMapper deptMapper;
  
      @Override
      public List<Dept> list() {
          return deptMapper.list();
      }
  }
  
  ```
  
- DeptMapper.java

  ```java
  package com.example.mapper;
  
  @Mapper
  public interface DeptMapper {
  
      @Select("select * from dept")
      List<Dept> list();
  }
  
  ```



## 3.注解合并

```java
package com.example.controller;


@Slf4j
@RestController
@RequestMapping("/depts")
public class DeptController {

    @Autowired
    private DeptService deptService;

    //    @RequestMapping(value = "/depts", method = RequestMethod.GET)
    @GetMapping
    public Result list() {
        log.info("查询所以数据");
        List<Dept> deptList = deptService.list();
        return Result.success(deptList);
    }

    @DeleteMapping("{id}")
    public Result delete(@PathVariable Integer id) {
        log.info("id:" + id);
        deptService.delete(id);
        return Result.success();
    }

    @PostMapping
    public Result add(@RequestBody Dept dept) {
        log.info("add:{}", dept);
        deptService.add(dept);
        return Result.success();
    }

}

```



## 4.分页查询

- 查询语句

  ```sql
  -- 查询第n页,每页展示m条数据
  -- n,m需要前端传递数据，后端返回list和total
  select * from emp limt (n-1)*m,m;
  ```

- PageBean.java：分页查询的结果封装类

  ```java
  package com.example.pojo;
  
  
  import lombok.AllArgsConstructor;
  import lombok.Data;
  import lombok.NoArgsConstructor;
  
  import java.util.List;
  
  @Data
  @AllArgsConstructor
  @NoArgsConstructor
  public class PageBean {
      private Long total;
      private List rows;
  }
  
  ```

- EmpController.java

  ```java
  package com.example.controller;
  
  @Slf4j
  @RestController
  @RequestMapping("/emps")
  public class EmpController {
  
      @Autowired
      private EmpService empService;
  
      @GetMapping
      public Result page(@RequestParam(defaultValue = "1") Integer page,
                         @RequestParam(defaultValue = "10") Integer pageSize){
          log.info("分页查询，参数{}，{}",page,pageSize);
          PageBean pageBean = empService.page(page,pageSize);
          return Result.success(pageBean);
      }
  
  }
  
  ```
  
- EmpService.java

  ```java
  package com.example.service;
  
  
  import com.example.pojo.PageBean;
  
  public interface EmpService {
      PageBean page(Integer page, Integer pageSize);
  }
  
  ```

- EmpServiceImpl.java

  ```java
  package com.example.service.impl;
  
  @Slf4j
  @Service
  public class EmpServiceImpl implements EmpService {
      @Autowired
      private EmpMapper empMapper;
  
  
      @Override
      public PageBean page(Integer page, Integer pageSize) {
          // 1.获取总记录数
          Long count = empMapper.count();
  
          // 2.获取分页查询结果列表
          Integer start = (page - 1 ) * pageSize;
          List<Emp> empList = empMapper.page(start,pageSize);
  
          // 3.封装PageBean对象
          PageBean pageBean = new PageBean(count,empList);
  
          return pageBean;
      }
  }
  
  ```
  
- EmpMapper.java

  ```java
  package com.example.mapper;
  
  @Mapper
  public interface EmpMapper {
      @Select("select count(*) from emp")
      public Long count();
  
      @Select("select * from emp limit #{start},#{pageSize}")
      public List<Emp> page(Integer start,Integer pageSize);
  }
  
  ```
  
  

>使用PageHelper
>
>- 引入依赖
>
>  ```xml
>  <!-- pom.xml -->
>  <dependency>
>      <groupId>com.github.pagehelper</groupId>
>      <artifactId>pagehelper-spring-boot-starter</artifactId>
>      <version>1.4.6</version>
>  </dependency>
>  ```



## 5.条件分页查询

- 查询语句

  ```sql
  select *
  from emp
  <where>
      <if test="name != null">
          name like concat('%',#{name},'%')
      </if>
      <if test="gender != null">
          gender = #{gender}
      </if>
      <if test="begin != null and end != null">
          entrydate between #{begin} and #{end}
      </if>
  </where>
  order by update_time desc
  limit #{start},#{pageSize}
  ```

- EmpController.java

  ```java
  package com.example.controller;
  
  @Slf4j
  @RestController
  @RequestMapping("/emps")
  public class EmpController {
  
      @Autowired
      private EmpService empService;
  
      @GetMapping
      public Result page(@RequestParam(defaultValue = "1") Integer page,
                         @RequestParam(defaultValue = "10") Integer pageSize,
                         String name, Short gender,
                         @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate begin,
                         @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate end) {
          log.info("分页查询，参数{}，{},{},{},{},{}", page, pageSize,name,gender,begin,end);
  
          PageBean pageBean = empService.page(page, pageSize,name,gender,begin,end);
          return Result.success(pageBean);
      }
  
  
  }
  
  ```

- EmpService.java

  ```java
  package com.example.service;
  
  public interface EmpService {
  
      PageBean page(Integer page, Integer pageSize, String name, Short gender, LocalDate begin, LocalDate end);
  }
  
  ```

- EmpServiceImpl.java

  ```java
  package com.example.service.impl;
  
  @Slf4j
  @Service
  public class EmpServiceImpl implements EmpService {
      @Autowired
      private EmpMapper empMapper;
  
  
      @Override
      public PageBean page(Integer page, Integer pageSize, String name, Short gender, LocalDate begin, LocalDate end) {
          // 1.获取总记录数
          Long count = empMapper.count();
  
          // 2.获取分页查询结果列表
          Integer start = (page - 1) * pageSize;
          List<Emp> empList = empMapper.page(start, pageSize, name, gender, begin, end);
  
          // 3.封装PageBean对象
          PageBean pageBean = new PageBean(count, empList);
  
          return pageBean;
      }
  }
  ```

- EmpMapper.java

  ```java
  @Mapper
  public interface EmpMapper {
      @Select("select count(*) from emp")
      public Long count();
  
      //    @Select("select * from emp limit #{start},#{pageSize}")
      public List<Emp> page(Integer start, Integer pageSize, String name, Short gender, LocalDate begin, LocalDate end);
  
  }
  ```

- 在resources创建同样包名的xml文件，即：com/example/mapper/EmpMapper.xml

  ```xml
  <?xml version="1.0" encoding="UTF-8" ?>
  <!DOCTYPE mapper
          PUBLIC "-//mybatis.org//DTD Config 3.0//EN"
          "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
  
  <mapper namespace="com.example.mapper.EmpMapper">
      <!--    条件查询-->
      <select id="page" resultType="com.example.pojo.Emp">
          select *
          from emp
          <where>
              <if test="name != null">
                  name like concat('%',#{name},'%')
              </if>
              <if test="gender != null and name !=''" >
                  gender = #{gender}
              </if>
              <if test="begin != null and end != null">
                  entrydate between #{begin} and #{end}
              </if>
          </where>
          order by update_time desc
          limit #{start},#{pageSize}
      </select>
  
  </mapper>
  ```

  

## 6.批量删除

- 查询语句

  ```sql
  <delete id="delete">
      delete from emp
      where id in
      <foreach collection="ids" item="id" separator="," open="(" close=")">
          #{id}
      </foreach>
  </delete>
  ```

- EmpController.java

  ```java
  @DeleteMapping("/{ids}")
  public Result delete(@PathVariable List<Integer> ids){
      log.info("批量ID:{}",ids);
      empService.delete(ids);
      return Result.success();
  }
  ```

- EmpService.java

  ```java
  void delete(List<Integer> ids);
  ```

- EmpServiceImpl.java

  ```java
  @Override
  public void delete(List<Integer> ids) {
      empMapper.delete(ids);
  }
  ```

- EmpMapper.java

  ```java
  void delete(List<Integer> ids);
  ```

- 在resources创建同样包名的xml文件，即：com/example/mapper/EmpMapper.xml

  ```xml
  <delete id="delete">
      delete from emp
      where id in
      <foreach collection="ids" item="id" separator="," open="(" close=")">
          #{id}
      </foreach>
  </delete>
  ```




## 7.文件上传

- **文件上传** 是指用户将本地文件（如头像、视频）上传到 **服务器** 或 **云存储**，供后续访问。
- 常见存储方式：
  1. **本地存储**：文件存放在服务器磁盘。
  2. **云存储（OSS）**：存储在阿里云 OSS、MinIO、FastDFS 等云存储服务中。



### 1.本地上传

- html：

  ```html
  <form action="/upload" method="post" enctype="multipart/form-data">
      选择文件：<input type="file" name="image">
      <input type="submit" value="上传">
  </form>
  
  ```

  1. `type="file"`：表示选择文件。
  2. `enctype="multipart/form-data"`：必须设置，才能上传文件。

- controller处理文件上传

  ```java
  @RestController
  public class UploadController {
      @PostMapping("/upload")
      public Result upload(@RequestParam("image") MultipartFile image) throws IOException {
          // 获取原始文件名
          String originalFilename = image.getOriginalFilename();
          // 生成新的文件名
          String newFileName = UUID.randomUUID() + originalFilename.substring(originalFilename.lastIndexOf("."));
          // 存储到服务器本地磁盘
          image.transferTo(new File("E:/uploads/" + newFileName));
          return Result.success();
      }
  }
  
  ```

  1. **`MultipartFile`**：Spring Boot 提供的文件上传对象。
  2. **`transferTo()`**：将文件存储到服务器磁盘。



### 2.阿里云` OSS（对象存储服务）`

>1. 注册阿里云，开通 OSS 服务。
>2. 创建 `Bucket`（存储空间）。
>3. 获取 **AccessKey**（密钥）。
>4. 在 Spring Boot 中 **集成阿里云 SDK** 上传文件。
>
>[查看官方文档](https://help.aliyun.com/zh/oss/object-file-object)

1. **添加阿里云 OSS 依赖**

   ```xml
   <dependency>
       <groupId>com.aliyun.oss</groupId>
       <artifactId>aliyun-sdk-oss</artifactId>
       <version>3.10.2</version>
   </dependency>
   
   ```

2. **配置阿里云 OSS**

   ```yaml
   aliyun:
     oss:
       endpoint: https://oss-cn-hangzhou.aliyuncs.com
       accessKeyId: your-access-key
       accessKeySecret: your-secret-key
       bucketName: your-bucket-name
   
   ```

3. **引入工具类**

   ```java
   @Component
   public class AliOSSUtils {
       @Value("${aliyun.oss.endpoint}")
       private String endpoint;
       @Value("${aliyun.oss.accessKeyId}")
       private String accessKeyId;
       @Value("${aliyun.oss.accessKeySecret}")
       private String accessKeySecret;
       @Value("${aliyun.oss.bucketName}")
       private String bucketName;
   
       public String upload(MultipartFile file) throws IOException {
           OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);
           String fileName = UUID.randomUUID() + file.getOriginalFilename();
           ossClient.putObject(bucketName, fileName, file.getInputStream());
           ossClient.shutdown();
           return "https://" + bucketName + "." + endpoint + "/" + fileName;
       }
   }
   
   ```

4. #####  **调用 OSS 工具类上传文件**

   ```java
   @RestController
   public class UploadController {
       @Autowired
       private AliOSSUtils aliOSSUtils;
   
       @PostMapping("/upload")
       public Result upload(@RequestParam("image") MultipartFile image) throws IOException {
           String url = aliOSSUtils.upload(image);
           return Result.success(url);
       }
   }
   
   ```

   

## 8.配置文件

- @value注解用于外部配置属性注入

  ```java
  语法：
  @value("${配置文件的key}")
  ```

- yml配置文件（名：application.yml（推荐）或application.yaml）:冒号，缩进。

  ```yaml
  aliyun:
    oss:
      endpoint: https://oss-cn-hangzhou.aliyuncs.com
      accessKeyId: your-access-key
      accessKeySecret: your-secret-key
      bucketName: your-bucket-name
  ```

  1. 基本语法：

     - 大小写敏感

     - 数值前必须有空格作为分隔符

       ```yaml
       accessKeyId: your-access-key
       ```

     - 缩进表示层级关系（数目不重要）

     - `#`表示注释

  2. yml数据格式

     - 对象/map集合：

       ```yaml
       user:
           name: zhangsan
           age: 18
           password: 123456
       ```

     - 数组/List/Set集合：

       ```yaml
       hobby:
           - java
           - game
           - sport
       ```

  3. 创建的yml格式备份：

     ```yml
     # 数据库连接
     spring:
       datasource:
         driver-class-name: com.mysql.cj.jdbc.Driver
         url: jdbc:mysql://localhost:3306/tlias
         username: root
         password: root
       servlet:
         multipart:
           max-file-size: 10MB
           max-request-size: 100MB
     
     
     # mybatis配置
     mybatis:
       configuration:
         # mybatis日志输出到控制台
         log-impl: org.apache.ibatis.logging.stdout.StdOutImpl
         # 驼峰命名自动映射开关
         map-underscore-to-camel-case: true
     ```

- @ConfigurationProperties

  使用场景：不使用@value进行注入，前提命名相同。

  引入依赖：

  ```xml
  <dependency>
      <groupId>org.springframework.boot</groupId>
      <artifactId>spring-boot-configuration-processor</artifactId>
  </dependency>
  ```

  

  ```Java
  @Data
  @Component
  @ConfigurationProperties(prefix = "aliyun.oss")
  public class AliOSProperties {
      private String endpoint;
      private String accessKeyId;
      private String accessKeySecret;
      private String bucketName;
  }
  ```

  



# 8.登录认证

## 1.登录功能

- **LoginController**

  ~~~java
  @RestController
  public class LoginController {
  
      @Autowired
      private EmpService empService;
  
      @PostMapping("/login")
      public Result login(@RequestBody Emp emp){
          Emp e = empService.login(emp);
  	    return  e != null ? Result.success():Result.error("用户名或密码错误");
      }
  }
  ~~~

- **EmpService**

  ~~~java
  public interface EmpService {
  
      /**
       * 用户登录
       * @param emp
       * @return
       */
      public Emp login(Emp emp);
  
      //省略其他代码...
  }
  ~~~

- **EmpServiceImpl**

  ~~~java
  @Slf4j
  @Service
  public class EmpServiceImpl implements EmpService {
      @Autowired
      private EmpMapper empMapper;
  
      @Override
      public Emp login(Emp emp) {
          //调用dao层功能：登录
          Emp loginEmp = empMapper.getByUsernameAndPassword(emp);
  
          //返回查询结果给Controller
          return loginEmp;
      }   
      
      //省略其他代码...
  }
  ~~~

- **EmpMapper**

  ~~~java
  @Mapper
  public interface EmpMapper {
  
      @Select("select id, username, password, name, gender, image, job, entrydate, dept_id, create_time, update_time " +
              "from emp " +
              "where username=#{username} and password =#{password}")
      public Emp getByUsernameAndPassword(Emp emp);
      
      //省略其他代码...
  }
  ~~~

  

## 2.登录校验

>登录校验：指服务器端接收到浏览器发送的请求，对请求进行校验用户是否登录。

### 1.会话技术

- 会话：指的是浏览器与服务器之间的一次连接，一次会话可以包含多次请求和响应的。

- 会话跟踪：一种维护浏览器状态的方法，服务器需要识别多次请求是否来自于同一浏览器，以便在同一次会话的多次请求间共享数据。

- 会话跟踪技术：

  1. Cookie（客户端会话跟踪技术）：数据存储在客户端浏览器当中

     - 优点：HTTP协议中支持的技术（像Set-Cookie 响应头的解析以及 Cookie 请求头数据的携带，都是浏览器自动进行的，是无需我们手动操作的）
     - 缺点：
       - 移动端APP(Android、IOS)中无法使用Cookie
       - 不安全，用户可以自己禁用Cookie
       - Cookie不能跨域（协议、IP/协议、端口）

     ```java
     @Slf4j
     @RestController
     public class SessionController {
     
         //设置Cookie
         @GetMapping("/c1")
         public Result cookie1(HttpServletResponse response){
             response.addCookie(new Cookie("login_username","itheima")); //设置Cookie/响应Cookie
             return Result.success();
         }
     	
         //获取Cookie
         @GetMapping("/c2")
         public Result cookie2(HttpServletRequest request){
             Cookie[] cookies = request.getCookies();
             for (Cookie cookie : cookies) {
                 if(cookie.getName().equals("login_username")){
                     System.out.println("login_username: "+cookie.getValue()); //输出name为login_username的cookie
                 }
             }
             return Result.success();
         }
     }    
     ```

  2. Session（服务端会话跟踪技术）：数据存储在储在服务端

     - 优点：Session是存储在服务端的，安全
     - 缺点：
       - 服务器集群环境下无法直接使用Session
       - 移动端APP(Android、IOS)中无法使用Cookie
       - 用户可以自己禁用Cookie
       - Cookie不能跨域

  3. 令牌技术（本质是字符串）

     - 优点：
       - 支持PC端、移动端
       - 解决集群环境下的认证问题
       - 减轻服务器的存储压力（无需在服务器端存储）
     - 缺点：需要自己实现（包括令牌的生成、令牌的传递、令牌的校验）



### 2.`JWT（JSON Web Toke）`令牌

> [官网](https://jwt.io/)：https://jwt.io/

- JWT：定义了一种简洁的、自包含的格式，用于在通信双方以json数据格式安全的传输信息。由于数字签名的存在，这些信息是可靠的。

- JWT的组成：（每个部分之间使用英文的点来分割）

  1. Header(头）： 记录令牌类型、签名算法等。 例如：{"alg":"HS256","type":"JWT"}
  2. Payload(有效载荷）：携带一些自定义信息、默认信息等。 例如：{"id":"1","username":"Tom"}
  3. Signature(签名）：防止Token被篡改、确保安全性。将header、payload，并加入指定秘钥，通过指定签名算法计算而来。

  > Jwt使用base64编码（不是加密方式）将JSON格式的数据转换成字符串。

- JWT登录认证的场景中两步操作：

  1. 在登录成功之后，要生成令牌。
  2. 每一次请求当中，要接收令牌并对令牌进行校验。

- JWT生成和校验

  1. 引入依赖

     ```xml
     <!-- JWT依赖-->
     <dependency>
         <groupId>io.jsonwebtoken</groupId>
         <artifactId>jjwt</artifactId>
         <version>0.9.1</version>
     </dependency>
     ```

  2. 生成JWT

     ```java
     @Test
     public void genJwt(){
         Map<String,Object> claims = new HashMap<>();
         claims.put("id",1);
         claims.put("username","Tom");
         
         String jwt = Jwts.builder()
             .setClaims(claims) //自定义内容(载荷)          
             .signWith(SignatureAlgorithm.HS256, "itheima") //签名算法        
             .setExpiration(new Date(System.currentTimeMillis() + 24*3600*1000)) //有效期   
             .compact();
         
         System.out.println(jwt);
     }
     ```

  3. 校验JWT令牌(解析生成的令牌)：

     ```java
     @Test
     public void parseJwt(){
         Claims claims = Jwts.parser()
             .setSigningKey("itheima")//指定签名密钥（必须保证和生成令牌时使用相同的签名密钥）  
     	    .parseClaimsJws("eyJhbGciOiJIUzI1NiJ9.eyJpZCI6MSwiZXhwIjoxNjcyNzI5NzMwfQ.fHi0Ub8npbyt71UqLXDdLyipptLgxBUg_mSuGJtXtBk")
             .getBody();
     
         System.out.println(claims);
     }
     ```

     ```json
     结果：
     {id=1, exp=1672729730}
     ```

- 登录下发令牌

  1. 引入JWT工具类

     ```java
     public class JwtUtils {
     
         private static String signKey = "itheima";//签名密钥
         private static Long expire = 43200000L; //有效时间
     
         /**
          * 生成JWT令牌
          * @param claims JWT第二部分负载 payload 中存储的内容
          * @return
          */
         public static String generateJwt(Map<String, Object> claims){
             String jwt = Jwts.builder()
                     .addClaims(claims)//自定义信息（有效载荷）
                     .signWith(SignatureAlgorithm.HS256, signKey)//签名算法（头部）
                     .setExpiration(new Date(System.currentTimeMillis() + expire))//过期时间
                     .compact();
             return jwt;
         }
     
         /**
          * 解析JWT令牌
          * @param jwt JWT令牌
          * @return JWT第二部分负载 payload 中存储的内容
          */
         public static Claims parseJWT(String jwt){
             Claims claims = Jwts.parser()
                     .setSigningKey(signKey)//指定签名密钥
                     .parseClaimsJws(jwt)//指定令牌Token
                     .getBody();
             return claims;
         }
     }
     
     ```

  2. **登录成功，生成JWT令牌并返回**

     ```java
     @RestController
     @Slf4j
     public class LoginController {
         //依赖业务层对象
         @Autowired
         private EmpService empService;
     
         @PostMapping("/login")
         public Result login(@RequestBody Emp emp) {
             //调用业务层：登录功能
             Emp loginEmp = empService.login(emp);
     
             //判断：登录用户是否存在
             if(loginEmp !=null ){
                 //自定义信息
                 Map<String , Object> claims = new HashMap<>();
                 claims.put("id", loginEmp.getId());
                 claims.put("username",loginEmp.getUsername());
                 claims.put("name",loginEmp.getName());
     
                 //使用JWT工具类，生成身份令牌
                 String token = JwtUtils.generateJwt(claims);
                 return Result.success(token);
             }
             return Result.error("用户名或密码错误");
         }
     }
     ```

     



### 3.过滤器`Filter`

- Filter概念

  1. Filter表示过滤器，是 JavaWeb三大组件(Servlet、Filter、Listener)之一。
  2. 过滤器可以把对资源的请求拦截下来，从而实现一些特殊的功能
     - 使用了过滤器之后，要想访问web服务器上的资源，必须先经过滤器，过滤器处理完毕之后，才可以访问对应的资源。
  3. 过滤器一般完成一些通用的操作，比如：登录校验、统一编码处理、敏感字符处理等。

- 过滤器的基本使用操作

  1. 定义过滤器 ：1.定义一个类，实现 Filter 接口，并重写其所有方法。

     ```java
     //定义一个类，实现一个标准的Filter过滤器的接口
     public class DemoFilter implements Filter {
         @Override //初始化方法, 只调用一次
         public void init(FilterConfig filterConfig) throws ServletException {
             System.out.println("init 初始化方法执行了");
         }
     
         @Override //拦截到请求之后调用, 调用多次
         public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
             System.out.println("Demo 拦截到了请求...放行前逻辑");
             //放行
             chain.doFilter(request,response);
         }
     
         @Override //销毁方法, 只调用一次
         public void destroy() {
             System.out.println("destroy 销毁方法执行了");
         }
     }
     ```

  2. 配置过滤器：Filter类上加 @WebFilter 注解，配置拦截资源的路径。引导类上加 @ServletComponentScan 开启Servlet组件支持。

     ```java
     @WebFilter(urlPatterns = "/*") //配置过滤器要拦截的请求路径（ /* 表示拦截浏览器的所有请求 ）
     public class DemoFilter implements Filter {
         @Override //初始化方法, 只调用一次
         public void init(FilterConfig filterConfig) throws ServletException {
             System.out.println("init 初始化方法执行了");
         }
     
         @Override //拦截到请求之后调用, 调用多次
         public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
             System.out.println("Demo 拦截到了请求...放行前逻辑");
             //放行
             chain.doFilter(request,response);
         }
     
         @Override //销毁方法, 只调用一次
         public void destroy() {
             System.out.println("destroy 销毁方法执行了");
         }
     }
     ```

     ```java
     @ServletComponentScan
     @SpringBootApplication
     public class TliasWebManagementApplication {
     
         public static void main(String[] args) {
             SpringApplication.run(TliasWebManagementApplication.class, args);
         }
     
     }
     ```

- 过滤器的执行流程：

  ```TEXT
  放行前逻辑 -> 放行 -> 放行后逻辑
  ```

- 拦截路径

  | 拦截路径     | urlPatterns值 | 含义                               |
  | ------------ | ------------- | ---------------------------------- |
  | 拦截具体路径 | /login        | 只有访问 /login 路径时，才会被拦截 |
  | 目录拦截     | /emps/*       | 访问/emps下的所有资源，都会被拦截  |
  | 拦截所有     | /*            | 访问所有资源，都会被拦截           |

  ```java
  @WebFilter(urlPatterns = "/login")  //拦截/login具体路径
  public class DemoFilter implements Filter {
      @Override
      public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
          System.out.println("DemoFilter   放行前逻辑.....");
  
          //放行请求
          filterChain.doFilter(servletRequest,servletResponse);
  
          System.out.println("DemoFilter   放行后逻辑.....");
      }
  
  
      @Override
      public void init(FilterConfig filterConfig) throws ServletException {
          Filter.super.init(filterConfig);
      }
  
      @Override
      public void destroy() {
          Filter.super.destroy();
      }
  }
  ```

- 过滤器链：执行优先级是按时过滤器类名的自动排序确定的，类名排名越靠前，优先级越高。

- 登录校验-Filter

  1. 操作步骤：

     - 获取请求url
     - 判断请求url中是否包含login，如果包含，说明是登录操作，放行
     - 获取请求头中的令牌（token）
     - 判断令牌是否存在，如果不存在，返回错误结果（未登录）
     - 解析token，如果解析失败，返回错误结果（未登录）
     - 放行

  2. **登录校验过滤器：LoginCheckFilter**

     ```java
     @Slf4j
     @WebFilter(urlPatterns = "/*") //拦截所有请求
     public class LoginCheckFilter implements Filter {
     
         @Override
         public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException {
             //前置：强制转换为http协议的请求对象、响应对象 （转换原因：要使用子类中特有方法）
             HttpServletRequest request = (HttpServletRequest) servletRequest;
             HttpServletResponse response = (HttpServletResponse) servletResponse;
     
             //1.获取请求url
             String url = request.getRequestURL().toString();
             log.info("请求路径：{}", url); //请求路径：http://localhost:8080/login
     
     
             //2.判断请求url中是否包含login，如果包含，说明是登录操作，放行
             if(url.contains("/login")){
                 chain.doFilter(request, response);//放行请求
                 return;//结束当前方法的执行
             }
     
     
             //3.获取请求头中的令牌（token）
             String token = request.getHeader("token");
             log.info("从请求头中获取的令牌：{}",token);
     
     
             //4.判断令牌是否存在，如果不存在，返回错误结果（未登录）
             if(!StringUtils.hasLength(token)){
                 log.info("Token不存在");
     
                 Result responseResult = Result.error("NOT_LOGIN");
                 //把Result对象转换为JSON格式字符串 (fastjson是阿里巴巴提供的用于实现对象和json的转换工具类)
                 String json = JSONObject.toJSONString(responseResult);
                 response.setContentType("application/json;charset=utf-8");
                 //响应
                 response.getWriter().write(json);
     
                 return;
             }
     
             //5.解析token，如果解析失败，返回错误结果（未登录）
             try {
                 JwtUtils.parseJWT(token);
             }catch (Exception e){
                 log.info("令牌解析失败!");
     
                 Result responseResult = Result.error("NOT_LOGIN");
                 //把Result对象转换为JSON格式字符串 (fastjson是阿里巴巴提供的用于实现对象和json的转换工具类)
                 String json = JSONObject.toJSONString(responseResult);
                 response.setContentType("application/json;charset=utf-8");
                 //响应
                 response.getWriter().write(json);
     
                 return;
             }
     
     
             //6.放行
             chain.doFilter(request, response);
     
         }
     }
     ```

     引入依赖：

     ```xml
     <dependency>
         <groupId>com.alibaba</groupId>
         <artifactId>fastjson</artifactId>
         <version>1.2.76</version>
     </dependency>
     ```



### 4.拦截器`Interceptor`

>拦截器的使用步骤和过滤器类似，也分为两步：
>
>1. 定义拦截器
>
>2. 注册配置拦截器



- **快速开始**

  **自定义拦截器：**实现HandlerInterceptor接口，并重写其所有方法

  ~~~java
  //自定义拦截器
  @Component
  public class LoginCheckInterceptor implements HandlerInterceptor {
      //目标资源方法执行前执行。 返回true：放行    返回false：不放行
      @Override
      public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
          System.out.println("preHandle .... ");
          
          return true; //true表示放行
      }
  
      //目标资源方法执行后执行
      @Override
      public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
          System.out.println("postHandle ... ");
      }
  
      //视图渲染完毕后执行，最后执行
      @Override
      public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
          System.out.println("afterCompletion .... ");
      }
  }
  ~~~

  > 注意：
  >
  > ​	preHandle方法：目标资源方法执行前执行。 返回true：放行
  >
  > ​	postHandle方法：目标资源方法执行后执行
  >
  > ​	afterCompletion方法：视图渲染完毕后执行，最后执行

  

  **注册配置拦截器**：实现WebMvcConfigurer接口，并重写addInterceptors方法

  ~~~java
  @Configuration  
  public class WebConfig implements WebMvcConfigurer {
  
      //自定义的拦截器对象
      @Autowired
      private LoginCheckInterceptor loginCheckInterceptor;
  
      
      @Override
      public void addInterceptors(InterceptorRegistry registry) {
         //注册自定义拦截器对象
          registry.addInterceptor(loginCheckInterceptor).addPathPatterns("/**");//设置拦截器拦截的请求路径（ /** 表示拦截所有请求）
      }
  }
  ~~~

  

- **拦截路径**

  通过`addPathPatterns("要拦截路径")`方法，指定要拦截资源，`/**`，表示拦截所有资源。指定不拦截资源，调用`excludePathPatterns("不拦截路径")`方法，指定哪些资源不需要拦截。

  ~~~java
  @Configuration  
  public class WebConfig implements WebMvcConfigurer {
  
      //拦截器对象
      @Autowired
      private LoginCheckInterceptor loginCheckInterceptor;
  
      @Override
      public void addInterceptors(InterceptorRegistry registry) {
          //注册自定义拦截器对象
          registry.addInterceptor(loginCheckInterceptor)
                  .addPathPatterns("/**")//设置拦截器拦截的请求路径（ /** 表示拦截所有请求）
                  .excludePathPatterns("/login");//设置不拦截的请求路径
      }
  }
  ~~~

  在拦截器中除了可以设置`/**`拦截所有资源外，还有一些常见拦截路径设置：

  | 拦截路径  | 含义                 | 举例                                                |
  | --------- | -------------------- | --------------------------------------------------- |
  | /*        | 一级路径             | 能匹配/depts，/emps，/login，不能匹配 /depts/1      |
  | /**       | 任意级路径           | 能匹配/depts，/depts/1，/depts/1/2                  |
  | /depts/*  | /depts下的一级路径   | 能匹配/depts/1，不能匹配/depts/1/2，/depts          |
  | /depts/** | /depts下的任意级路径 | 能匹配/depts，/depts/1，/depts/1/2，不能匹配/emps/1 |

- **执行流程**

- **登录校验- Interceptor**

  **登录校验拦截器**

  ~~~java
  //自定义拦截器
  @Component //当前拦截器对象由Spring创建和管理
  @Slf4j
  public class LoginCheckInterceptor implements HandlerInterceptor {
      //前置方式
      @Override
      public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
          System.out.println("preHandle .... ");
          //1.获取请求url
          //2.判断请求url中是否包含login，如果包含，说明是登录操作，放行
  
          //3.获取请求头中的令牌（token）
          String token = request.getHeader("token");
          log.info("从请求头中获取的令牌：{}",token);
  
          //4.判断令牌是否存在，如果不存在，返回错误结果（未登录）
          if(!StringUtils.hasLength(token)){
              log.info("Token不存在");
  
              //创建响应结果对象
              Result responseResult = Result.error("NOT_LOGIN");
              //把Result对象转换为JSON格式字符串 (fastjson是阿里巴巴提供的用于实现对象和json的转换工具类)
              String json = JSONObject.toJSONString(responseResult);
              //设置响应头（告知浏览器：响应的数据类型为json、响应的数据编码表为utf-8）
              response.setContentType("application/json;charset=utf-8");
              //响应
              response.getWriter().write(json);
  
              return false;//不放行
          }
  
          //5.解析token，如果解析失败，返回错误结果（未登录）
          try {
              JwtUtils.parseJWT(token);
          }catch (Exception e){
              log.info("令牌解析失败!");
  
              //创建响应结果对象
              Result responseResult = Result.error("NOT_LOGIN");
              //把Result对象转换为JSON格式字符串 (fastjson是阿里巴巴提供的用于实现对象和json的转换工具类)
              String json = JSONObject.toJSONString(responseResult);
              //设置响应头
              response.setContentType("application/json;charset=utf-8");
              //响应
              response.getWriter().write(json);
  
              return false;
          }
  
          //6.放行
          return true;
      }
  ~~~

  **注册配置拦截器**

  ~~~java
  @Configuration  
  public class WebConfig implements WebMvcConfigurer {
      //拦截器对象
      @Autowired
      private LoginCheckInterceptor loginCheckInterceptor;
  
      @Override
      public void addInterceptors(InterceptorRegistry registry) {
         //注册自定义拦截器对象
          registry.addInterceptor(loginCheckInterceptor)
                  .addPathPatterns("/**")
                  .excludePathPatterns("/login");
      }
  }
  
  ~~~






## 3.异常处理

- 定义全局异常处理器，定义一个类，在类上加上一个注解@RestControllerAdvice。
- 全局异常处理器中，需定义一个方法捕获异常，在这个方法上需要加上注解@ExceptionHandler。通过@ExceptionHandler注解当中的value属性来指定我们要捕获的是哪一类型的异常。

~~~java
@RestControllerAdvice
public class GlobalExceptionHandler {

    //处理异常
    @ExceptionHandler(Exception.class) //指定能够处理的异常类型
    public Result ex(Exception e){
        e.printStackTrace();//打印堆栈中的异常信息

        //捕获到异常之后，响应一个标准的Result
        return Result.error("对不起,操作失败,请联系管理员");
    }
}
~~~

> @RestControllerAdvice = @ControllerAdvice + @ResponseBody
>
> 处理异常的方法返回值会转换为json后再响应给前端



# 9.事务管理&AOP

>**事务**：是一组操作的集合，它是一个不可分割的工作单位。事务会把所有的操作作为一个整体，一起向数据库提交或者是撤销操作请求。
>
>事务的操作主要有三步：
>
>1. 开启事务（一组操作开始前，开启事务）：start transaction / begin ;
>2. 提交事务（这组操作全部成功后，提交事务）：commit ;
>3. 回滚事务（中间任何一个操作出现异常，回滚事务）：rollback ;



## 1. Spring事务管理

### 1.Transactional注解

> @Transactional作用：在当前这个方法执行开始之前来开启事务，方法执行完毕之后提交事务。如果在这个方法执行的过程中出现了异常，就会进行事务的回滚操作。
>
> @Transactional注解：一般会在业务层当中来控制事务，因为在业务层当中，一个业务功能可能会包含多个数据访问的操作。在业务层来控制事务，就可以将多个数据访问操作控制在一个事务范围内。



- @Transactional注解书写位置：

  1. 方法
    - 当前方法交给spring进行事务管理
  2. 类
    - 当前类中所有的方法都交由spring进行事务管理
  3. 接口
    - 接口下所有的实现类当中所有的方法都交给spring 进行事务管理

- 在方法delete上加上 @Transactional 来控制事务 。

  ```java
  @Slf4j
  @Service
  public class DeptServiceImpl implements DeptService {
      @Autowired
      private DeptMapper deptMapper;
  
      @Autowired
      private EmpMapper empMapper;
  
      
      @Override
      @Transactional  //当前方法添加了事务管理
      public void delete(Integer id){
          //根据部门id删除部门信息
          deptMapper.deleteById(id);
          
          //模拟：异常发生
          int i = 1/0;
  
          //删除部门下的所有员工信息
          empMapper.deleteByDeptId(id);   
      }
  }
  ```

- 在application.yml配置文件中开启事务管理日志，这样就可以在控制看到和事务相关的日志信息了

  ~~~yaml
  #spring事务管理日志
  logging:
    level:
      org.springframework.jdbc.support.JdbcTransactionManager: debug
  ~~~






### 2.事务进阶

> @Transactional注解当中的两个常见的属性：
>
> 1. 异常回滚的属性：rollbackFor 
> 2. 事务传播行为：propagation



#### 1.rollbackFor

- 默认情况下，只有出现RuntimeException(运行时异常)才会回滚事务。若想所有的异常都回滚，需要来配置@Transactional注解当中的rollbackFor属性，通过rollbackFor这个属性可以指定出现何种异常类型回滚事务。

  ~~~java
  @Slf4j
  @Service
  public class DeptServiceImpl implements DeptService {
      @Autowired
      private DeptMapper deptMapper;
  
      @Autowired
      private EmpMapper empMapper;
  
      
      @Override
      @Transactional(rollbackFor=Exception.class)
      public void delete(Integer id){
          //根据部门id删除部门信息
          deptMapper.deleteById(id);
          
          //模拟：异常发生
          int num = id/0;
  
          //删除部门下的所有员工信息
          empMapper.deleteByDeptId(id);   
      }
  }
  ~~~

  

> 结论：
>
> - 在Spring的事务管理中，默认只有运行时异常 RuntimeException才会回滚。
> - 如果还需要回滚指定类型的异常，可以通过rollbackFor属性来指定。



#### 2.propagation

> @Transactional注解中的第二个属性propagation是用来配置事务的传播行为(当一个事务方法被另一个事务方法调用时，这个事务方法应该如何进行事务控制。)。



| **属性值**    | **含义**                                                     |
| ------------- | ------------------------------------------------------------ |
| REQUIRED      | 【默认值】需要事务，有则加入，无则创建新事务                 |
| REQUIRES_NEW  | 需要新事务，无论有无，总是创建新事务                         |
| SUPPORTS      | 支持事务，有则加入，无则在无事务状态中运行                   |
| NOT_SUPPORTED | 不支持事务，在无事务状态下运行,如果当前存在已有事务,则挂起当前事务 |
| MANDATORY     | 必须有事务，否则抛异常                                       |
| NEVER         | 必须没事务，否则抛异常                                       |
| …             |                                                              |

> 对于事务传播行为，只需要关注两个：
>
> - REQUIRED ：大部分情况下都是用该传播行为即可。
>
> - REQUIRES_NEW ：当我们不希望事务之间相互影响时，可以使用该传播行为。比如：下订单前需要记录日志，不论订单保存成功与否，都需要保证日志记录能够记录成功。



## 2.AOP基础

- AOP概述

  1. AOP英文全称：Aspect Oriented Programming（面向切面编程、面向方面编程），即面向特定方法编程。 
  2. AOP的作用：在程序运行期间在不修改源代码的基础上对已有方法进行增强（无侵入性: 解耦）
  3. AOP的优势：

     - 减少重复代码
     - 提高开发效率
     - 维护方便

- AOP快速入门

  1. 导入依赖：在pom.xml中导入AOP的依赖

     ~~~xml
     <dependency>
         <groupId>org.springframework.boot</groupId>
         <artifactId>spring-boot-starter-aop</artifactId>
     </dependency>
     ~~~

  2. 编写AOP程序：针对于特定方法根据业务需要进行编程

     ~~~java
     @Component
     @Aspect //当前类为切面类
     @Slf4j
     public class TimeAspect {
     
         @Around("execution(* com.itheima.service.*.*(..))") 
         public Object recordTime(ProceedingJoinPoint pjp) throws Throwable {
             //记录方法执行开始时间
             long begin = System.currentTimeMillis();
     
             //执行原始方法
             Object result = pjp.proceed();
     
             //记录方法执行结束时间
             long end = System.currentTimeMillis();
     
             //计算方法执行耗时
             log.info(pjp.getSignature()+"执行耗时: {}毫秒",end-begin);
     
             return result;
         }
     }
     ~~~

- AOP核心概念

  1. **连接点：JoinPoint**，可以被AOP控制的方法（暗含方法执行时的相关信息）。	连接点指的是可以被aop控制的方法。例如：入门程序当中所有的业务方法都是可以被aop控制的方法。

  2. **通知：Advice**，指哪些重复的逻辑，也就是共性功能（最终体现为一个方法）

  3. **切入点：PointCut**，匹配连接点的条件，通知仅会在切入点方法执行时被应用

  4. **切面：Aspect**，描述通知与切入点的对应关系（通知+切入点）

     切面所在的类，一般称为**切面类**（被@Aspect注解标识的类）

  5. **目标对象：Target**，通知所应用的对象





## 3. AOP进阶

### 1.通知类型

Around环绕通知：

~~~java
@Around("execution(* com.itheima.service.*.*(..))")
public Object recordTime(ProceedingJoinPoint pjp) throws Throwable {
    //记录方法执行开始时间
    long begin = System.currentTimeMillis();
    //执行原始方法
    Object result = pjp.proceed();
    //记录方法执行结束时间
    long end = System.currentTimeMillis();
    //计算方法执行耗时
    log.info(pjp.getSignature()+"执行耗时: {}毫秒",end-begin);
    return result;
}
~~~

> 只要我们在通知方法上加上了@Around注解，就代表当前通知是一个环绕通知。



Spring中AOP的通知类型：

- @Around：环绕通知，此注解标注的通知方法在目标方法前、后都被执行
- @Before：前置通知，此注解标注的通知方法在目标方法前被执行
- @After ：后置通知，此注解标注的通知方法在目标方法后被执行，无论是否有异常都会执行
- @AfterReturning ： 返回后通知，此注解标注的通知方法在目标方法后被执行，有异常不会执行
- @AfterThrowing ： 异常后通知，此注解标注的通知方法发生异常后执行



~~~java
@Slf4j
@Component
@Aspect
public class MyAspect1 {
    //前置通知
    @Before("execution(* com.itheima.service.*.*(..))")
    public void before(JoinPoint joinPoint){
        log.info("before ...");

    }

    //环绕通知
    @Around("execution(* com.itheima.service.*.*(..))")
    public Object around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        log.info("around before ...");

        //调用目标对象的原始方法执行
        Object result = proceedingJoinPoint.proceed();
        
        //原始方法如果执行时有异常，环绕通知中的后置代码不会在执行了
        
        log.info("around after ...");
        return result;
    }

    //后置通知
    @After("execution(* com.itheima.service.*.*(..))")
    public void after(JoinPoint joinPoint){
        log.info("after ...");
    }

    //返回后通知（程序在正常执行的情况下，会执行的后置通知）
    @AfterReturning("execution(* com.itheima.service.*.*(..))")
    public void afterReturning(JoinPoint joinPoint){
        log.info("afterReturning ...");
    }

    //异常通知（程序在出现异常的情况下，执行的后置通知）
    @AfterThrowing("execution(* com.itheima.service.*.*(..))")
    public void afterThrowing(JoinPoint joinPoint){
        log.info("afterThrowing ...");
    }
}

~~~



> 程序发生异常的情况下：
>
> - @AfterReturning标识的通知方法不会执行，@AfterThrowing标识的通知方法执行了
>
> - @Around环绕通知中原始方法调用时有异常，通知中的环绕后的代码逻辑也不会在执行了 （因为原始方法调用已经出异常了）



使用通知时的注意事项：

- @Around环绕通知需要自己调用 ProceedingJoinPoint.proceed() 来让原始方法执行，其他通知不需要考虑目标方法执行
- @Around环绕通知方法的返回值，必须指定为Object，来接收原始方法的返回值，否则原始方法执行完毕，是获取不到返回值的。



Spring提供了@PointCut注解，该注解的作用是将公共的切入点表达式抽取出来，需要用到时引用该切入点表达式即可。

~~~java
@Slf4j
@Component
@Aspect
public class MyAspect1 {

    //切入点方法（公共的切入点表达式）
    @Pointcut("execution(* com.itheima.service.*.*(..))")
    private void pt(){

    }

    //前置通知（引用切入点）
    @Before("pt()")
    public void before(JoinPoint joinPoint){
        log.info("before ...");

    }

    //环绕通知
    @Around("pt()")
    public Object around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        log.info("around before ...");

        //调用目标对象的原始方法执行
        Object result = proceedingJoinPoint.proceed();
        //原始方法在执行时：发生异常
        //后续代码不在执行

        log.info("around after ...");
        return result;
    }

    //后置通知
    @After("pt()")
    public void after(JoinPoint joinPoint){
        log.info("after ...");
    }

    //返回后通知（程序在正常执行的情况下，会执行的后置通知）
    @AfterReturning("pt()")
    public void afterReturning(JoinPoint joinPoint){
        log.info("afterReturning ...");
    }

    //异常通知（程序在出现异常的情况下，执行的后置通知）
    @AfterThrowing("pt()")
    public void afterThrowing(JoinPoint joinPoint){
        log.info("afterThrowing ...");
    }
}
~~~





### 2.通知顺序

重新启动SpringBoot服务，测试通知的执行顺序：

> 备注：
>
> 1.  把DeptServiceImpl实现类中模拟异常的代码删除或注释掉。
>
> 2.  注释掉其他切面类(把@Aspect注释即可)，仅保留MyAspect2、MyAspect3、MyAspect4 ，这样就可以清晰看到执行的结果，而不被其他切面类干扰。

通过以上程序运行可以看出在不同切面类中，默认按照切面类的类名字母排序：

- 目标方法前的通知方法：字母排名靠前的先执行
- 目标方法后的通知方法：字母排名靠前的后执行



如果控制通知的执行顺序有两种方式：

1. 修改切面类的类名（这种方式非常繁琐、而且不便管理）
2. 使用Spring提供的@Order注解



使用@Order注解，控制通知的执行顺序：

~~~java
@Slf4j
@Component
@Aspect
@Order(2)  //切面类的执行顺序（前置通知：数字越小先执行; 后置通知：数字越小越后执行）
public class MyAspect2 {
    //前置通知
    @Before("execution(* com.itheima.service.*.*(..))")
    public void before(){
        log.info("MyAspect2 -> before ...");
    }

    //后置通知 
    @After("execution(* com.itheima.service.*.*(..))")
    public void after(){
        log.info("MyAspect2 -> after ...");
    }
}
~~~

~~~java
@Slf4j
@Component
@Aspect
@Order(3)  //切面类的执行顺序（前置通知：数字越小先执行; 后置通知：数字越小越后执行）
public class MyAspect3 {
    //前置通知
    @Before("execution(* com.itheima.service.*.*(..))")
    public void before(){
        log.info("MyAspect3 -> before ...");
    }

    //后置通知
    @After("execution(* com.itheima.service.*.*(..))")
    public void after(){
        log.info("MyAspect3 ->  after ...");
    }
}
~~~

~~~java
@Slf4j
@Component
@Aspect
@Order(1) //切面类的执行顺序（前置通知：数字越小先执行; 后置通知：数字越小越后执行）
public class MyAspect4 {
    //前置通知
    @Before("execution(* com.itheima.service.*.*(..))")
    public void before(){
        log.info("MyAspect4 -> before ...");
    }

    //后置通知
    @After("execution(* com.itheima.service.*.*(..))")
    public void after(){
        log.info("MyAspect4 -> after ...");
    }
}
~~~



> 通知的执行顺序大家主要知道两点即可：
>
> 1. 不同的切面类当中，默认情况下通知的执行顺序是与切面类的类名字母排序是有关系的
> 2. 可以在切面类上面加上@Order注解，来控制不同的切面类通知的执行顺序







### 3.切入点表达式

切入点表达式：

- 描述切入点方法的一种表达式

- 作用：主要用来决定项目中的哪些方法需要加入通知

- 常见形式：

  1. execution(……)：根据方法的签名来匹配

  2. @annotation(……) ：根据注解匹配




#### 1.execution

execution主要根据方法的返回值、包名、类名、方法名、方法参数等信息来匹配，语法为：

~~~
execution(访问修饰符?  返回值  包名.类名.?方法名(方法参数) throws 异常?)
~~~

其中带`?`的表示可以省略的部分

- 访问修饰符：可省略（比如: public、protected）

- 包名.类名： 可省略

- throws 异常：可省略（注意是方法上声明抛出的异常，不是实际抛出的异常）

示例：

~~~java
@Before("execution(void com.itheima.service.impl.DeptServiceImpl.delete(java.lang.Integer))")
~~~



可以使用通配符描述切入点

- `*` ：单个独立的任意符号，可以通配任意返回值、包名、类名、方法名、任意类型的一个参数，也可以通配包、类、方法名的一部分

- `..` ：多个连续的任意符号，可以通配任意层级的包，或任意类型、任意个数的参数



切入点表达式的语法规则：

1. 方法的访问修饰符可以省略
2. 返回值可以使用`*`号代替（任意返回值类型）
3. 包名可以使用`*`号代替，代表任意包（一层包使用一个`*`）
4. 使用`..`配置包名，标识此包以及此包下的所有子包
5. 类名可以使用`*`号代替，标识任意类
6. 方法名可以使用`*`号代替，表示任意方法
7. 可以使用 `*`  配置参数，一个任意类型的参数
8. 可以使用`..` 配置参数，任意个任意类型的参数



**切入点表达式示例**

- 省略方法的修饰符号 

  ~~~java
  execution(void com.itheima.service.impl.DeptServiceImpl.delete(java.lang.Integer))
  ~~~

- 使用`*`代替返回值类型

  ~~~java
  execution(* com.itheima.service.impl.DeptServiceImpl.delete(java.lang.Integer))
  ~~~

- 使用`*`代替包名（一层包使用一个`*`）

  ~~~java
  execution(* com.itheima.*.*.DeptServiceImpl.delete(java.lang.Integer))
  ~~~

- 使用`..`省略包名

  ~~~java
  execution(* com..DeptServiceImpl.delete(java.lang.Integer))    
  ~~~

- 使用`*`代替类名

  ~~~java
  execution(* com..*.delete(java.lang.Integer))   
  ~~~

- 使用`*`代替方法名

  ~~~java
  execution(* com..*.*(java.lang.Integer))   
  ~~~

- 使用 `*` 代替参数

  ```java
  execution(* com.itheima.service.impl.DeptServiceImpl.delete(*))
  ```

- 使用`..`省略参数

  ~~~java
  execution(* com..*.*(..))
  ~~~

​	

注意事项：

- 根据业务需要，可以使用 且（&&）、或（||）、非（!） 来组合比较复杂的切入点表达式。

  ```java
  execution(* com.itheima.service.DeptService.list(..)) || execution(* com.itheima.service.DeptService.delete(..))
  ```

  

切入点表达式的书写建议：

- 所有业务方法名在命名时尽量规范，方便切入点表达式快速匹配。如：查询类方法都是 find 开头，更新类方法都是update开头

  ~~~java
  //业务类
  @Service
  public class DeptServiceImpl implements DeptService {
      
      public List<Dept> findAllDept() {
         //省略代码...
      }
      
      public Dept findDeptById(Integer id) {
         //省略代码...
      }
      
      public void updateDeptById(Integer id) {
         //省略代码...
      }
      
      public void updateDeptByMoreCondition(Dept dept) {
         //省略代码...
      }
      //其他代码...
  }
  ~~~

  ~~~java
  //匹配DeptServiceImpl类中以find开头的方法
  execution(* com.itheima.service.impl.DeptServiceImpl.find*(..))
  ~~~

- 描述切入点方法通常基于接口描述，而不是直接描述实现类，增强拓展性

  ~~~java
  execution(* com.itheima.service.DeptService.*(..))
  ~~~

- 在满足业务需要的前提下，尽量缩小切入点的匹配范围。如：包名匹配尽量不使用 ..，使用 * 匹配单个包

  ~~~java
  execution(* com.itheima.*.*.DeptServiceImpl.find*(..))
  ~~~

  

#### 2.@annotation

实现步骤：

1. 编写自定义注解

2. 在业务类要做为连接点的方法上添加自定义注解

   

**自定义注解**：MyLog

~~~java
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface MyLog {
}
~~~



**业务类**：DeptServiceImpl

~~~java
@Slf4j
@Service
public class DeptServiceImpl implements DeptService {
    @Autowired
    private DeptMapper deptMapper;

    @Override
    @MyLog //自定义注解（表示：当前方法属于目标方法）
    public List<Dept> list() {
        List<Dept> deptList = deptMapper.list();
        //模拟异常
        //int num = 10/0;
        return deptList;
    }

    @Override
    @MyLog  //自定义注解（表示：当前方法属于目标方法）
    public void delete(Integer id) {
        //1. 删除部门
        deptMapper.delete(id);
    }


    @Override
    public void save(Dept dept) {
        dept.setCreateTime(LocalDateTime.now());
        dept.setUpdateTime(LocalDateTime.now());
        deptMapper.save(dept);
    }

    @Override
    public Dept getById(Integer id) {
        return deptMapper.getById(id);
    }

    @Override
    public void update(Dept dept) {
        dept.setUpdateTime(LocalDateTime.now());
        deptMapper.update(dept);
    }
}
~~~



**切面类**

~~~java
@Slf4j
@Component
@Aspect
public class MyAspect6 {
    //针对list方法、delete方法进行前置通知和后置通知

    //前置通知
    @Before("@annotation(com.itheima.anno.MyLog)")
    public void before(){
        log.info("MyAspect6 -> before ...");
    }

    //后置通知
    @After("@annotation(com.itheima.anno.MyLog)")
    public void after(){
        log.info("MyAspect6 -> after ...");
    }
}
~~~



- execution切入点表达式
  - 根据我们所指定的方法的描述信息来匹配切入点方法，这种方式也是最为常用的一种方式
  - 如果我们要匹配的切入点方法的方法名不规则，或者有一些比较特殊的需求，通过execution切入点表达式描述比较繁琐
- annotation 切入点表达式
  - 基于注解的方式来匹配切入点方法。这种方式虽然多一步操作，我们需要自定义一个注解，但是相对来比较灵活。我们需要匹配哪个方法，就在方法上加上对应的注解就可以了





### 4.连接点

在Spring中用JoinPoint抽象了连接点，用它可以获得方法执行时的相关信息，如目标类名、方法名、方法参数等。

- 对于@Around通知，获取连接点信息只能使用ProceedingJoinPoint类型

- 对于其他四种通知，获取连接点信息只能使用JoinPoint，它是ProceedingJoinPoint的父类型



示例代码：

~~~java
@Slf4j
@Component
@Aspect
public class MyAspect7 {

    @Pointcut("@annotation(com.itheima.anno.MyLog)")
    private void pt(){}
   
    //前置通知
    @Before("pt()")
    public void before(JoinPoint joinPoint){
        log.info(joinPoint.getSignature().getName() + " MyAspect7 -> before ...");
    }
    
    //后置通知
    @Before("pt()")
    public void after(JoinPoint joinPoint){
        log.info(joinPoint.getSignature().getName() + " MyAspect7 -> after ...");
    }

    //环绕通知
    @Around("pt()")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        //获取目标类名
        String name = pjp.getTarget().getClass().getName();
        log.info("目标类名：{}",name);

        //目标方法名
        String methodName = pjp.getSignature().getName();
        log.info("目标方法名：{}",methodName);

        //获取方法执行时需要的参数
        Object[] args = pjp.getArgs();
        log.info("目标方法参数：{}", Arrays.toString(args));

        //执行原始方法
        Object returnValue = pjp.proceed();

        return returnValue;
    }
}

~~~





# 10.`SpringBoot`原理





# 11.`Maven`高级

**分模块设计:：就是将项目按照功能/结构拆分成若干个子模块，方便项目的管理维护、拓展，也方便模块键的相互调用、资源共享。**







## 1.继承

- 概念：继承描述的是两个工程间的关系，与java中的继承相似，子工程可以继承父工程中的配置信息，常见于依赖关系的继承。

- 作用：简化依赖配置、统一管理依赖

- 实现：

  ```xml
  <parent>
      <groupId>...</groupId>
      <artifactId>...</artifactId>
      <version>...</version>
      <relativePath>....</relativePath>
  </parent>
  ```

- 继承关系：

  1. 父工程tlias-parent的pom.xml文件配置如下：

     ```xml
     <parent>
         <groupId>org.springframework.boot</groupId>
         <artifactId>spring-boot-starter-parent</artifactId>
         <version>2.7.5</version>
         <relativePath/> <!-- lookup parent from repository -->
     </parent>
     
     <groupId>com.itheima</groupId>
     <artifactId>tlias-parent</artifactId>
     <version>1.0-SNAPSHOT</version>
     <packaging>pom</packaging>
     ```

     > Maven打包方式：
     >
     > - jar：普通模块打包，springboot项目基本都是jar包（内嵌tomcat运行）
     > - war：普通web程序打包，需要部署在外部的tomcat服务器中运行
     > - pom：父工程或聚合工程，该模块不写代码，仅进行依赖管理

  2. 子工程的pom.xml文件中，配置继承关系。

     ```xml
     <parent>
         <groupId>com.itheima</groupId>
         <artifactId>tlias-parent</artifactId>
         <version>1.0-SNAPSHOT</version>
         <relativePath>../tlias-parent/pom.xml</relativePath>
     </parent>
     
     <artifactId>tlias-utils</artifactId>
     <version>1.0-SNAPSHOT</version>
     ```

     > 注意：
     >
     > - 在子工程中，配置了继承关系之后，坐标中的groupId是可以省略的，因为会自动继承父工程的 。
     > - relativePath指定父工程的pom文件的相对位置（如果不指定，将从本地仓库/远程仓库查找该工程）。
     >   -  ../ 代表的上一级目录

- 版本锁定

  1. 在maven中，可以在父工程的pom文件中通过 `<dependencyManagement>` 来统一管理依赖版本。

     父工程：

     ```xml
     <!--统一管理依赖版本-->
     <dependencyManagement>
         <dependencies>
             <!--JWT令牌-->
             <dependency>
                 <groupId>io.jsonwebtoken</groupId>
                 <artifactId>jjwt</artifactId>
                 <version>0.9.1</version>
             </dependency>
         </dependencies>
     </dependencyManagement>
     ```

     子工程：

     ```xml
     <dependencies>
         <!--JWT令牌-->
         <dependency>
             <groupId>io.jsonwebtoken</groupId>
             <artifactId>jjwt</artifactId>
         </dependency>
     </dependencies>
     ```

     

     > 注意：
     >
     > - 在父工程中所配置的 `<dependencyManagement>` 只能统一管理依赖版本，并不会将这个依赖直接引入进来。 这点和 `<dependencies>` 是不同的。
     >
     > - 子工程要使用这个依赖，还是需要引入的，只是此时就无需指定 `<version>` 版本号了，父工程统一管理。变更依赖版本，只需在父工程中统一变更。

  2. 实现

     tlias-parent 中的配置

     - 1. 

     ```xml
     <!--统一管理依赖版本-->
     <dependencyManagement>
         <dependencies>
             <!--JWT令牌-->
             <dependency>
                 <groupId>io.jsonwebtoken</groupId>
                 <artifactId>jjwt</artifactId>
                 <version>0.9.1</version>
             </dependency>
     
             <!--阿里云OSS-->
             <dependency>
                 <groupId>com.aliyun.oss</groupId>
                 <artifactId>aliyun-sdk-oss</artifactId>
                 <version>3.15.1</version>
             </dependency>
             <dependency>
                 <groupId>javax.xml.bind</groupId>
                 <artifactId>jaxb-api</artifactId>
                 <version>2.3.1</version>
             </dependency>
             <dependency>
                 <groupId>javax.activation</groupId>
                 <artifactId>activation</artifactId>
                 <version>1.1.1</version>
             </dependency>
             <!-- no more than 2.3.3-->
             <dependency>
                 <groupId>org.glassfish.jaxb</groupId>
                 <artifactId>jaxb-runtime</artifactId>
                 <version>2.3.3</version>
             </dependency>
         </dependencies>
     </dependencyManagement>
     ```

     

     tlias-utils中的pom.xml配置

     如果依赖的版本已经在父工程进行了统一管理，所以在子工程中就无需再配置依赖的版本了。

     ```xml
     <dependencies>
         <!--JWT令牌-->
         <dependency>
             <groupId>io.jsonwebtoken</groupId>
             <artifactId>jjwt</artifactId>
         </dependency>
     
         <!--阿里云OSS-->
         <dependency>
             <groupId>com.aliyun.oss</groupId>
             <artifactId>aliyun-sdk-oss</artifactId>
         </dependency>
         <dependency>
             <groupId>javax.xml.bind</groupId>
             <artifactId>jaxb-api</artifactId>
         </dependency>
         <dependency>
             <groupId>javax.activation</groupId>
             <artifactId>activation</artifactId>
         </dependency>
         <!-- no more than 2.3.3-->
         <dependency>
             <groupId>org.glassfish.jaxb</groupId>
             <artifactId>jaxb-runtime</artifactId>
         </dependency>
     
         <!--WEB开发-->
         <dependency>
             <groupId>org.springframework.boot</groupId>
             <artifactId>spring-boot-starter-web</artifactId>
         </dependency>
     </dependencies>
     ```

     

     > 我们之所以，在springboot项目中很多时候，引入依赖坐标，都不需要指定依赖的版本 `<version>` ，是因为在父工程 spring-boot-starter-parent中已经通过 `<dependencyManagement>`对依赖的版本进行了统一的管理维护。

- 属性配置

  可以通过自定义属性及属性引用的形式，在父工程中将依赖的版本号进行集中管理维护。 具体语法为：

  1). 自定义属性

  ```xml
  <properties>
  	<lombok.version>1.18.24</lombok.version>
  </properties>
  ```

  

  2). 引用属性

  ```xml
  <dependency>
      <groupId>org.projectlombok</groupId>
      <artifactId>lombok</artifactId>
      <version>${lombok.version}</version>
  </dependency>
  ```

  

  就可以在父工程中，将所有的版本号，都集中管理维护起来。

  ```xml
  <properties>
      <maven.compiler.source>11</maven.compiler.source>
      <maven.compiler.target>11</maven.compiler.target>
  
      <lombok.version>1.18.24</lombok.version>
      <jjwt.version>0.9.1</jjwt.version>
      <aliyun.oss.version>3.15.1</aliyun.oss.version>
      <jaxb.version>2.3.1</jaxb.version>
      <activation.version>1.1.1</activation.version>
      <jaxb.runtime.version>2.3.3</jaxb.runtime.version>
  </properties>
  
  
  <dependencies>
      <dependency>
          <groupId>org.projectlombok</groupId>
          <artifactId>lombok</artifactId>
          <version>${lombok.version}</version>
      </dependency>
  </dependencies>
  
  <!--统一管理依赖版本-->
  <dependencyManagement>
      <dependencies>
          <!--JWT令牌-->
          <dependency>
              <groupId>io.jsonwebtoken</groupId>
              <artifactId>jjwt</artifactId>
              <version>${jjwt.version}</version>
          </dependency>
  
          <!--阿里云OSS-->
          <dependency>
              <groupId>com.aliyun.oss</groupId>
              <artifactId>aliyun-sdk-oss</artifactId>
              <version>${aliyun.oss.version}</version>
          </dependency>
          <dependency>
              <groupId>javax.xml.bind</groupId>
              <artifactId>jaxb-api</artifactId>
              <version>${jaxb.version}</version>
          </dependency>
          <dependency>
              <groupId>javax.activation</groupId>
              <artifactId>activation</artifactId>
              <version>${activation.version}</version>
          </dependency>
          <!-- no more than 2.3.3-->
          <dependency>
              <groupId>org.glassfish.jaxb</groupId>
              <artifactId>jaxb-runtime</artifactId>
              <version>${jaxb.runtime.version}</version>
          </dependency>
      </dependencies>
  </dependencyManagement>
  ```

  版本集中管理之后，要想修改依赖的版本，就只需要在父工程中自定义属性的位置，修改对应的属性值即可。

  

  > **面试题：`<dependencyManagement>` 与 `<dependencies>` 的区别是什么?**
  >
  > - `<dependencies>` 是直接依赖，在父工程配置了依赖，子工程会直接继承下来。 
  > - `<dependencyManagement>` 是统一管理依赖版本，不会直接依赖，还需要在子工程中引入所需依赖(无需指定版本)





## 2.聚合 

>- **聚合：**将多个模块组织成一个整体，同时进行项目的构建。
>- **聚合工程：**一个不具有业务功能的“空”工程（有且仅有一个pom文件） 【PS：一般来说，继承关系中的父工程与聚合关系中的聚合工程是同一个】
>- **作用：**快速构建项目（无需根据依赖关系手动构建，直接在聚合工程上构建即可）



- 实现

  在maven中，我们可以在聚合工程中通过 `<moudules>` 设置当前聚合工程所包含的子模块的名称。可以在 tlias-parent中，添加如下配置，来指定当前聚合工程，需要聚合的模块：

  ```java
  <!--聚合其他模块-->
  <modules>
      <module>../tlias-pojo</module>
      <module>../tlias-utils</module>
      <module>../tlias-web-management</module>
  </modules>
  ```

  此时，要进行编译、打包、安装操作，就无需在每一个模块上操作了。只需要在聚合工程上，统一进行操作就可以了。

- 继承与聚合对比

  1. **作用**
     - 聚合用于快速构建项目

     - 继承用于简化依赖配置、统一管理依赖

  2. **相同点：**

     - 聚合与继承的pom.xml文件打包方式均为pom，通常将两种关系制作到同一个pom文件中

     - 聚合与继承均属于设计型模块，并无实际的模块内容

  3. **不同点：**

     - 聚合是在聚合工程中配置关系，聚合可以感知到参与聚合的模块有哪些

     - 继承是在子模块中配置关系，父模块无法感知哪些子模块继承了自己



## 3. 私服

> 如果在项目中需要使用其他第三方提供的依赖，如果本地仓库没有，也会自动连接私服下载，如果私服没有，私服此时会自动连接中央仓库，去中央仓库中下载依赖，然后将下载的依赖存储在私服仓库及本地仓库中。

- 介绍

  1. **私服：**是一种特殊的远程仓库，它是架设在局域网内的仓库服务，用来代理位于外部的中央仓库，用于解决团队内部的资源共享与资源同步问题。
  2. **依赖查找顺序：**
     - 本地仓库
     - 私服仓库
     - 中央仓库
  3. **注意事项：**私服在企业项目开发中，一个项目/公司，只需要一台即可（无需我们自己搭建，会使用即可）。

- 资源上传与下载

  1. 步骤分析 

     第一步配置：在maven的配置文件中配置访问私服的用户名、密码。

     第二步配置：在maven的配置文件中配置连接私服的地址(url地址)。

     第三步配置：在项目的pom.xml文件中配置上传资源的位置(url地址)。

     > 私服仓库说明：
     >
     > - RELEASE：存储自己开发的RELEASE发布版本的资源。
     > - SNAPSHOT：存储自己开发的SNAPSHOT发布版本的资源。
     > - Central：存储的是从中央仓库下载下来的依赖。

     > 项目版本说明：
     >
     > - RELEASE(发布版本)：功能趋于稳定、当前更新停止，可以用于发行的版本，存储在私服中的RELEASE仓库中。
     > - SNAPSHOT(快照版本)：功能不稳定、尚处于开发中的版本，即快照版本，存储在私服的SNAPSHOT仓库中。

- 具体操作

  1. **设置私服的访问用户名/密码（在自己maven安装目录下的conf/settings.xml中的servers中配置）

     ```xml
     <server>
         <id>maven-releases</id>
         <username>admin</username>
         <password>admin</password>
     </server>
         
     <server>
         <id>maven-snapshots</id>
         <username>admin</username>
         <password>admin</password>
     </server>
     ```

  2. **设置私服依赖下载的仓库组地址（在自己maven安装目录下的conf/settings.xml中的mirrors、profiles中配置）**

     ```xml
     <mirror>
         <id>maven-public</id>
         <mirrorOf>*</mirrorOf>
         <url>http://192.168.150.101:8081/repository/maven-public/</url>
     </mirror>
     ```

     ```xml
     <profile>
         <id>allow-snapshots</id>
             <activation>
             	<activeByDefault>true</activeByDefault>
             </activation>
         <repositories>
             <repository>
                 <id>maven-public</id>
                 <url>http://192.168.150.101:8081/repository/maven-public/</url>
                 <releases>
                 	<enabled>true</enabled>
                 </releases>
                 <snapshots>
                 	<enabled>true</enabled>
                 </snapshots>
             </repository>
         </repositories>
     </profile>
     ```

  3. **IDEA的maven工程的pom文件中配置上传（发布）地址(直接在tlias-parent中配置发布地址)**

     ```xml
     <distributionManagement>
         <!-- release版本的发布地址 -->
         <repository>
             <id>maven-releases</id>
             <url>http://192.168.150.101:8081/repository/maven-releases/</url>
         </repository>
     
         <!-- snapshot版本的发布地址 -->
         <snapshotRepository>
             <id>maven-snapshots</id>
             <url>http://192.168.150.101:8081/repository/maven-snapshots/</url>
         </snapshotRepository>
     </distributionManagement>
     ```

  4. 配置完成之后，可在tlias-parent中执行**deploy**生命周期，将项目发布到私服仓库中。 











