# translation
双向翻译系统

拉下代码后springboot项目启动步骤：<p></p>
1.修改配置文件的数据库连接信息。（配置文件位置：translation\src\main\resources\application.yml）<br>
2.在mysql创建数据库，名称为：translation。<br>
3.在translation数据库下运行sql文件用来创建表结构和示例数据。（sql文件位置：translation\src\main\resources\sql\translation.sql）<br>
4.在idea中运行TranslationApplication.java,项目启动！！（启动java类位置：translation\src\main\java\com\system\translation\TranslationApplication.java）<br>