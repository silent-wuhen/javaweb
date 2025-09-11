# 第一章 绪论





## NoSQL数据库的分类

|   **分类**   |             **举例**             |                       **典型应用场景**                       |                  **数据模型**                   |                           **优点**                           |                           **缺点**                           |
| :----------: | :------------------------------: | :----------------------------------------------------------: | :---------------------------------------------: | :----------------------------------------------------------: | :----------------------------------------------------------: |
|  键值数据库  | **Redis**, Voldemort, Oracle BDB | 内容缓存，主要用于处理大量数据的高访问负载，也用于一些日志系统等等。 | Key 指向 Value 的键值对，通常用hash table来实现 |                          查找速度快                          |        数据无结构化，通常只被当作字符串或者二进制数据        |
|  列族数据库  |      Cassandra, HBase, Riak      |                       分布式的文件系统                       |      以列簇式存储，将同一列族数据存在一起       |          吞吐量大，可扩展性强，更容易进行分布式扩展          |                         功能相对局限                         |
| 文档型数据库 |         CouchDB, MongoDB         | Web应用（与Key-Value类似，Value是结构化的，不同的是数据库能够了解Value的内容） |    Key-Value对应的键值对，Value为结构化数据     | 数据结构要求不严格，表结构可变，不需要像关系型数据库一样需要预先定义表结构 |            查询性能不高，而且缺乏统一的查询语法。            |
|  图形数据库  | Neo4J, InfoGrid, Infinite Graph  |           社交网络，推荐系统等。专注于构建关系图谱           |                     图结构                      |     利用图结构相关算法。比如最短路径寻址，N度关系查找等      | 很多时候需要对整个图做计算才能得出需要的信息，而且这种结构不太好做分布式的集群方案。 |

1.  键值数据库：使用一个哈希表，这个表中有一个特定的key和一个指针指向特定的value
2. 列族数据库：采用的是列族数据模型，由多个行构成，每行数据包含多个列族，不同行可以有不同数量的列族。
3. 文档型数据库：数据模型是结构化的文档，半结构化的文档以特定的格式存储，比如JSON。文档型数据库可以看作是键值数据库的升级版，允许之间嵌套键值。
4.  图型数据库：以图论为基础，一个图是一个数学概念，用来表示一个对象集合，包括顶点及连接顶点的边。图数据库使用图作为数据模型来存储数据。

**问题：**分别说出类型名称和代表产品？

**答：**

1. 键值数据库：Redis
2. 列族数据库：HBase
3. 文档数据库：MongoDB
4. 图形数据库：Neo4j



# 第二章 MongoDB文档数据库

## MongoDB基础

### 基本概述

#### 文档数据模型

1. 在文档数据库中，文档是处理信息的基本单位。
2. 多个键及其关联的值有序地放置在一起便是文档。
3. 文档是一个个键值(key-value)对(即BSON)。
4.  MongoDB 的文档不需要设置相同的字段，并且相同的字段不需要相同的数据类型，这与关系型数据库有很大的区别。

文档的特点：

1. 文档中的键值对是有序的：
2. 值区分字符串和数字
3. 键区分大小写：

#### 文档存储结构

文档数据库的存储结构分为四个层次，从小到大依次是：键值对、文档（document）、集合（collection）、数据库（database）。

MongoDB中的文档、集合、数据库对应于关系数据库中的行数据、表、数据库。

1. 键值对：文档数据库存储结构的基本单位是键值对，具体包含数据和类型。键值对的数据包含键和值，键的格式一般为字符串，值的格式可以包含字符串、数值、数组、文档等类型。可以将键值对分为**基本键值**对和**嵌套键值对**。

   - UTF-8格式字符串。
   - 不用有“\0”的字符串，习惯上不用“. ”和“$”。
   - 以“_”开头的多为保留键，自定义时一般不以“_”开头。
   - **文档键值对是有序的，MongoDB中严格区分大小写。**

2. 文档：一组有序的键值对集合。文档的数据结构与JSON基本相同，所有存储在集合中的数据都是BSON格式。BSON是一种类JSON的二进制存储格式。

   文档与文档之间的关系包括嵌入和引用两种。

3. 集合：是一些文档构成的对象。文档类似于关系型数据库中的“行”，那么集合就如同“表”。集合存在于数据库中，没有固定的结构，这意味着用户对集合可以插入不同格式和类型的数据。通常情况下插入集合的数据都会有一定的关联性，即一个集合中的文档应该具有相关性。

4. 数据库：由集合组成。开发过程中，通常将一个应用的所有数据存储到同一个数据库中。

#### 数据类型

​		BSON目前主要用于MongoDB中，选择JSON进行改造的原因主要是JSON的通用性及JSON的schemaless的特性。BSON改进的主要特性有下面三点。

- 更快的遍历速度

- 操作更简易

- 支持更多的数据类型

  ![3.png](https://github.com/silent-wuhen/Blog_picture01/blob/main/3.%E6%96%87%E6%A1%A3%E5%9B%BE%E7%89%87/3.NoSQL/3.png?raw=true)



#### MongoDB安装

```
windows版：
下载安装包直接安装

在D:\mongodb\data\目录下
创建db目录用于存储数据
创建log目录用于存储日志文件

方法一：
1.管理员运行cmd,输入：
cd D:\mongodb\data\bin
mongod -dbpath "D:\mongodb\data\db" -logpath "D:\mongodb\data\log\mon.log"    # 命令行不能关闭
2.另外打开一个cmd，输入：
mongo

方法二：
1.管理员运行cmd,输入：
cd D:\mongodb\data\bin
mongod -dbpath "D:\mongodb\data\db" -logpath "D:\mongodb\data\log\mon.log" --install --serviceName "MongoDB"

2.开启/关闭服务
net start/stop MongoDB

3.移除MongoDB开机自启（先关闭服务）：
mongod -dbpath "D:\mongodb\data\db" -logpath "D:\mongodb\data\log\mon.log" --remove --serviceName "MongoDB"
```



### 数据库与集合的基本操作

#### 数据库操作

1. 数据库的命名规则：要符合UTF-8标准的字符串

   | **序号** |                         **注意事项**                         |
   | :------: | :----------------------------------------------------------: |
   |  **1**   |                        **不能是空串**                        |
   |  **2**   | **不得含有/、\、？、$、空格、空字符等，基本只能使用ASCII中的字母和数字** |
   |  **3**   |                 **区分大小写，建议全部小写**                 |
   |  **4**   |                     **名称最多为64字节**                     |
   |  **5**   |     **不得使用保留的数据库名，如：admin、local、config**     |

2. MongoDB系统保留的数据库

   |     **库名**     |                           **作用**                           |
   | :--------------: | :----------------------------------------------------------: |
   |    **admin**     | **权限数据库，添加用户到该数据库中，该用户会自动继承数据库的所有权限** |
   |    **local**     |               **数据库中的数据永远不会被复制**               |
   |    **config**    |       **分片时，config数据库在内部使用，保存分片信息**       |
   |     **test**     |             **默认数据库，可以用来做各种测试等**             |
   | **自定义数据库** |            **根据应用系统的需要建立的业务数据库**            |

   

3. 数据库操作：

   ```
   1.查看数据库
   show dbs
   
   2.创建自定义数据库:如果数据库不存在，MongoDB会在第一次使用该数据库时创建数据库
   use test
   
   3.统计数据库信息:使用stats()方法查看,一定要用use切换至数据库
   use test
   db.stats()
   
   4.删除数据库:使用dropDatabase()方法
   db.dropDatabase()
   
   5.查看集合:使用getCollectionNames()方法
   use test
   db.getCollectionNames()
   ```

   

#### 集合操作

1. 集合命名规则：集合名称要求符合UTF-8标准的字符串

   | **序号** | **注意事项**                                    |
   | -------- | ----------------------------------------------- |
   | **1**    | **集合名不能是空串**                            |
   | **2**    | **不能含有空字符\0**                            |
   | **3**    | **不能以“system.”开头，这是系统集合保留的前缀** |
   | **4**    | **集合名不能含保留字符$**                       |

2. 集合操作

   ```
   1.展示所有集合
   show collections
   
   2.创建集合
   显式：
   	db.createCollection(name, options)
   		options(可选项):
               capped	Boolean	（可选）如果为true，则启用封闭的集合。如果指定true，则还需要指定size参数
               size	数字	（可选）指定上限集合的最大大小（以字节为单位）。如果capped为true，那么还需要指定此字段的值
               max	数字	（可选）指定上限集合中允许的最大文档数
           eg:db.createCollection("myDB",{capped:true,size:6142800,max:10000})
   隐式：插入文档时，如果集合不存在，隐式自动创建
   	db.myDB.insert({"name":"tom"})
   
   3.集合重命名：renamecollection()方法
   Show collections；
   db.myDB.renameCollection( "orders2014" )；
   
   4.删除集合：使用drop()方法
   db.orders2014.drop()
   
   5.查看文档
   db.test.find()
   
   ```
   
   

### 文档的基本操作

- 文档是MongoDB中存储的基本单元，是一组有序的键值对集合。文档中存储的文档键的格式是符合UTF-8标准的字符串。

| **1** | **不能包含\0字符（空字符），因为这个字符表示键的结束**       |
| ----- | ------------------------------------------------------------ |
| **2** | **不能包含“$”和“.”，因为“.”和“$”是被保留的，只能在特定环境下使用** |
| **3** | **区分类型（如字符串和整数等），同时也区分大小写**           |
| **4** | **键不能重复，在一条文档里起唯一的作用**                     |



- 文档的操作：

```
1.插入操作
	(1)insert()方法
    db.collection.insert(		//collection为集合名，
    <document or array of documents>,	//表示可设置插入一条或多条文档
    {
        writeConcern: <document>,	//可选字段，自定义写出错级别
        ordered: <boolean>     	//可选字段
    }
    )
    
    eg:
        //插入不指定_id字段的文档
        db.test.insert({"name":"hbk","age":18})
        //插入指定_id字段的文档
        db.test.insert({_id:10,"name":"hbk","age":18})
        //使用变量方式插入文档
        a=({"name":"hbk","age":18})
        db.test.insert(a)
        //有序插入多条文档
        db.test.insert([
        	{_id:11,"name":"hbk","age":18}
        	{_id:12,"name":"hbk","age":18}
        ],
        {ordered:true}
        )
        
        (2)insertOne(), 插入一条文档。
        (3)insertMany(), 插入多条文档。


2.更新操作：update()和save()方法
	(1)update()
	db.collection.update(
    <query>,	//设置查询条件
    <update>,	//更新操作符
    {
      Upsert,	//布尔可选项，
        multi,
        writeConcern,
        collation
    }
    )
    
    eg:
    	db.test.update(
    	{
    	item:"card"
    	},
    	{$set:{qty:35}}
    	)
    	
    (2)save()
    db.collection.save（obj）	// _id已存在则更新，不存在则插入


3.删除操作：永久删除
	(1)remove()
	db.collection.remove( 
    <query>, 	//设置文档的删除条件
    { 
        justOne: <boolean>, writeConcern: <document> 
    })
    eg:
    	db.test.remove({"name":"hbk"})
    	
	(2)delete:deleteOne()和deleteMany()方法删除文档
	db.collection.deleteMany({})	//删除集合下所有的文档
    db.collection.deleteMany({ status : "A" })	//删除status等于A的全部文档
    db.collection.deleteOne( { status: "D" })	//删除status等于D的一个文档 


4.查询操作
	(1)find()方法,findOne()
	语法：db.collection.find(query, projection) 
		query：设置条件
		projection：投影操作符，返回指定字段
	注：可使用.pretty()格式化显示所有文档，更直观
		eg: db.test.find()
	
	(2)查询条件
	见下表：
```

|    **操作符**    |                   **格式**                    |                           **实例**                           |          **与RDBMS where语句比较**           |
| :--------------: | :-------------------------------------------: | :----------------------------------------------------------: | :------------------------------------------: |
|   **等于(=)**    |             **{<key>:{<value>}**              |                **db.test.find({price:24 })**                 |              **where price=24**              |
|   **大于(>)**    |           **{<key>:{$gt:<value>}}**           |              **db.test.find({price:{$gt:24}})**              |              **where price>24**              |
|   **小于(<)**    |           **{<key>:{$lt:<value>}}**           |              **db.test.find({price:{$lt:24}})**              |              **where price<24**              |
| **大于等于(>=)** |          **{<key>:{$gte:<value>}}**           |             **db.test.find({price:{$gte:24}})**              |             **where price>=24**              |
| **小于等于(<=)** |          **{<key>:{$lte:<value>}}**           |             **db.test.find({price:{$lte:24}})**              |             **where price<=24**              |
|  **不等于(!=)**  |           **{<key>:{$ne:<value>}}**           |              **db.test.find({price:{$ne:24}})**              |             **where price!=24**              |
|   **与(and)**    |      **{key01:value01,key02:value02,…}**      |     **db.test.find({name:"《MongoDB教程》",price:24})**      | **where name="《MongoDB教程》"and price=24** |
|    **或(or)**    | **{$or:[{key01:value01},{key02:value02},…]}** | **db.test.find({$or:[{name:"《MongoDB教程》"},{price:24}]})** | **where name="《MongoDB教程》"or price=24**  |

```
	(3)特定类型查询
	 //查询age为null的字段，还会返回不包含这个键的文档
	 db.test.find({age:null})  
	 //查询有3个元素的数组
	 db.test.find({tags:{$size:3}})
     //查询数组里的某一个值代码
     db.test.find({tags:"MongoDB"})
     //限制查询个数
     db.test.find().limit(3)
     //掠过指定文档
     db.test.find().skip(1)
     //对查询结果进行排序，1是升序，-1是降序
     db.test.find().sort({"price":1})
     //使用正则表达式
     db.test.find({tags:{$regex:"MongoDB"}})

5.游标：指对数据一行一行的进行操作
三种情况会让游标被销毁。
① 客户端保存的游标变量不在作用域内。
② 游标遍历完成后，或者客户端主动发送终止消息。
③ 在服务器端10分钟内未对游标进行操作。

	见下表
```

|     **hasNext**     |          **判断是否有更多的文档**          |
| :-----------------: | :----------------------------------------: |
|      **next**       |           **用来获取下一条文档**           |
|     **toArray**     |          **将查询结果放到数组中**          |
|      **count**      |        **查询的结果为文档的总数量**        |
|      **limit**      |          **限制查询结果返回数量**          |
|      **skip**       |           **跳过指定数目的文档**           |
|      **sort**       |           **对查询结果进行排序**           |
| **objsLeftlnBatch** |  **查看当前批次剩余的未被迭代的文档数量**  |
|    **addOption**    | **为游标设置辅助选项，修改游标的默认行为** |
|      **hint**       |         **为查询强制使用指定索引**         |
|     **explain**     |        **用于获取查询执行过程报告**        |
|    **snapshot**     |           **对查询结果使用快照**           |





### 索引

1.   索引可以提升文档的查询速度，但建立索引的过程需要使用计算与存储资源，在已经建立索引的前提下，插入新的文档会引起索引顺序的重排

2. 索引的类型大致包含单键索引、复合索引、多键值索引、地理索引、全文索引、散列索引等

   - 单键索引：对于单字段索引和排序操作，索引键的排序顺序（即升序或降序）无关紧要。

     ![4.png](https://github.com/silent-wuhen/Blog_picture01/blob/main/3.%E6%96%87%E6%A1%A3%E5%9B%BE%E7%89%87/3.NoSQL/4.png?raw=true)

   - 复合索引：复合索引可以支持在多个字段上进行的匹配查询。（db.collection.createIndex( { <key1>: <type>, <key2>: <type2>, ... } )）

     ![5.png](https://github.com/silent-wuhen/Blog_picture01/blob/main/3.%E6%96%87%E6%A1%A3%E5%9B%BE%E7%89%87/3.NoSQL/5.png?raw=true)

   - 多键值索引

   - 地理索引

   - 其他索引：全文索引、散列索引（哈希索引）

3. 索引的操作：

   ```
   1.创建索引单键索引
   db.collection.createIndex( { key: 1 } )		//1为升序，-1为降序
   
   2.创建索引复合索引
   db.collection.createIndex( { <key1>: 1, <key2>:-1, ... } )
   
   3.查看现有的索引
   db.records.getIndexes()
   
   4.删除索引
   db.collection.dropIndex({score:1})
   db.collection.dropIndexes()		//删除所有索引
   
   5.修改索引
   只能删除后，重新创建
   ```

   

### 聚合

具体见书P120

1. 聚合：用于处理数据并返回计算结果。聚合操作将来自多个文档的值组合在一起，按条件分组后，再进行一系列操作（如求和、平均值、最大值、最小值）以返回单个结果。

2. 聚合的方法：聚合管道、map-reduce和单一目标聚合方法。

   - 聚合管道：最基本的管道阶段提供过滤器，其操作类似查询和文档转换，可以修改输出文档的形式。

   - map-reduce：

     ```
     语法：
     db.collection.mapReduce(
     function() {emit(key,value);},
     function(key,values) {return reduceFunction}
     { query: document,out: collection}
     )
     
     ```

     



## MongoDB进阶



### 集群架构

MongoDB有三种集群部署模式，分别为

1. 主从复制（Master-Slaver）：（目前已不推荐使用）集群中只能有一个主节点，主节点提供所有的增、删、查、改服务，从节点不提供任何服务，但是可以通过设置使从节点提供查询服务，这样可以减少主节点的压力。
2. 副本集（Replica Set）：取代了Master-Slaver模式，是一种互为主从的关系。副本集与主从复制的区别在于，当集群中主节点发生故障时，副本集可以自动投票，选举出新的主节点，并引导其余的从节点连接新的主节点，而且这个过程对应用是透明的。
3. 分片（Sharding）模式：是指将数据拆分并分散存放在不同机器上的过程。有时也用分区来表示这个概念。将数据分散到不同的机器上，不需要功能强大的大型计算机就可以存储更多的数据，处理更大的负载。适合处理大量数据，它将数据分开存储，不同服务器保存不同的数据，所有服务器数据的总和即为整个数据集。构建分片模式需要三个组件：分片服务器（Shard Server）、配置服务器（Config Server）和路由服务器（Route Server）。



### MongoDB分布式集群部署



#### 分布式集群架构

1. 在实际生产环境中，MongoDB的集群架构是分布式的，集群会结合副本集和分片机制保证生产过程的高可靠性和高可扩展性。

   ![6.png](https://github.com/silent-wuhen/Blog_picture01/blob/main/3.%E6%96%87%E6%A1%A3%E5%9B%BE%E7%89%87/3.NoSQL/6.png?raw=true)

2.  副本集和分片联合部署的基本思路是先建立副本集，然后将每个副本集作为整体建立分片



#### 部署副本集

标准副本集一般会部署三个成员，即一个Primary和两个Secondary，实现数据的冗余和容错。

```
1.启动副本集

（1）修改配置文件
启动mongod实例前先修改配置文件/etc/mongodrs1.conf，主要是对path、dbpath、port的修改。

（2）启动mongod副本集
在Shell终端执行：mongod --shardsvr --replSet rs1 --config /etc/mongodrs1.conf 

（3）初始化副本集
 启动MongoDB的副本集服务后，可在任意一台机器上连接MongoDB的服务，例如，在Node1节点上执行以下命令连接Node2节点上的mongod服务。
mongo --host 10.90.9.102 --port 27018
使用rs.initiate()对副本集进行初始化，经过初始化后，执行rs.status()查看副本集状态

（4）添加成员
目前rs1副本集还只有Node2这个Primary节点，需要将Node1、Node3节点添加到副本集中，执行以下命令添加副本集成员：
rs.add("10.90.9.101：27018")
rs.add("10.90.9.103：27018")


2.测试副本集复制功能
（1）在Primary节点上添加数据
在Primary节点上创建myDB数据库，在此数据库中创建集合myCollection，并插入5个文档.

2）在Secondary节点上查看副本数据
使用mongo命令连接Secondary节点，Secondary节点上的数据默认是不允许读写的，可以通过以下命令设置副本节点允许查询。
db.getMongo().setSlaveOk() 

3）管理副本集
通过rs.config()命令可以查看副本集中每个成员的属性
修改副本集属性可通过如下命令实现：
con=rs.conf()
con.members[1].priority=2
rs.reconfig(con)

```



#### 部署分片集群

分片集群由配置服务器、路由服务器、分片服务器和客户端组成。客户端可以是Shell终端，也可以是具体的应用程序。配置服务器（Config Server）是普通的mongod服务器，保存着集群的配置信息：集群中有哪些分片、分片的是哪些集合，以及数据块的分布。分片服务器（Shard Server）存储具体的分片数据。启动集群后，路由服务器（Route Server）加载Config Server中的分片信息，客户端通过连接Route Server来获取集群中的数据信息。

```
1.启动分片机制
（1）配置Config Server
Config Server相当于集群的大脑，保存着集群和分片的元数据，即各分片包含哪些数据的信息。鉴于它所包含数据的极端重要性，必须启用其日志功能，并确保其数据保存在非易失性驱动器上。
配置服务器是独立的mongod进程，所以可以像启动“普通的”mongod进程一样启动配置服务器：
mongod --replSet config --configsvr --dbpath /home/ubuntu/mongodb/data/config --port 27030 –logpath 
/home/ubuntu/mongodb/data/config.log --logappend --fork


（2）配置Route Server
三个配置服务器均处于运行状态后，启动一个mongos进程供应用程序连接。因为mongos进程需要知道配置服务器的地址，所以必须使用--configdb选项启动mongos：
mongos --configdb config/10.90.9.101:27030,10.90.9.102:27030,10.90.9.103:27030 –logpath 
/home/ubuntu/mongodb/data/mongos.log --logappend --fork


2.测试分片机制
（1）添加分片
为了将副本集转换为分片，需告知mongos副本集名称和副本集成员列表。
（2）数据分片
除非明确指定规则，否则MongoDB不会自动对数据进行拆分。如有必要，必须明确告知数据库和集合。
假设希望对myDB数据库中的Mytest集合按照_id键进行分片。首先对myDB数据库执行以下命令启用分片：
sh.enableSharding("myDB")
命令执行成功后，用sh.status()查询分片状态，数据库myDB的patitioned属性值为true。

```



### MongoDB编程方法

#### 通过Java访问MongoDB

详细代码见P138

1. 安装Java语言驱动包
   - （1）Maven方式
   - （2）手动导入 
2. 编程实现
   - （1）import基础类库
   - （2）连接数据库
   - （3）切换至集合
   - （4）插入文档
   - （5）删除文档
   - （6）更新数据
   - （7）查询数据
   - （8）其他方法



#### 通过Python访问MongoDB

详细代码见P141

1. 安装pymongo驱动可使用pip方式：

   pip install pymongo

2. 建立连接

   - （1）模块引用
   - （2）访问数据库

3. 集合操作

   - （1）插入文档
   - （2）检索文档
   - （3）更新数据
   - （4）删除数据



#### MongoDB的可视化工具Robomongo  

 Robomongo是一个界面友好且免费的MongoDB可视化工具，可在Robomongo官网下载此软件。





# 第三章 HBase列族数据库



## 认识HBase



## HBase数据模型与使用



## HBase原理实现



# 第四章 Redis、Memcached键值数据库





# 第五章 Neo4j图形数据库



# 第六章 New SQL数据库



# 第七章 综合实验
