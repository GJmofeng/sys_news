# **个人项目**  

**项目简介**：
* 本项目是一个基于JavaWeb技术的在线新闻管理系统，旨在为用户提供一个便捷、高效的新闻阅读平台。
* 系统采用JSP+Servlet作为后端技术，结合MySQL数据库进行数据存储，前端界面则采用了Layui框架进行美化与优化。
* 项目支持三种用户角色：管理员、用户（读者）和编辑者（作者），每个角色拥有不同的权限和功能。
* 管理员负责审核文章，用户可以在线阅读新闻并进行评价，编辑者则负责新闻的编辑和发布。
* 系统结构分为新闻网站和管理后台两大部分，以满足不同用户的需求。

**说明报告：**

* 项目背景与目标：
* 随着互联网的发展，新闻传播方式发生了巨大变化，用户对于新闻获取的便捷性和实时性有了更高的要求。
* 本项目旨在开发一个在线新闻管理系统，通过角色划分和权限管理，实现新闻的高效发布、审核和阅读，同时提供用户评价功能，增强用户参与感。
* 
* 技术选型：
* - 后端：JSP+Servlet，作为JavaWeb开发的传统技术，能够稳定地处理业务逻辑和数据交互。
* - 数据库：MySQL，一个广泛使用的关系型数据库，适合存储结构化数据。
* - 前端：Layui，一个模块化前端框架，提供了丰富的UI组件和简洁的API，便于快速开发美观的前端界面。
  -采用MVC架构，分为数据层（dao）、业务层（service）、控制层（servlet）以及工具类（util）、实体类（entity）、过滤器（filter）将业务逻辑与表现层分离，提高代码可维护性和可扩展性。 
* - 开发工具：IDEA。
* 
* 系统架构：
* 系统分为前端新闻网站和后端管理后台两部分。前端面向用户，提供新闻阅读和评价功能；后端面向管理员和编辑者，提供新闻发布、审核和管理功能。
* 
* 数据库设计：
* 系统设计了6张数据库表，包括用户表、新闻表、评论表等，用于存储用户信息、新闻内容、评论数据等关键信息。
* 
* 功能模块：
* - 管理员模块：审核新闻、管理用户和编辑者、查看系统日志等。
* - 用户模块：阅读新闻、发表评论、查看个人评论等。
* - 编辑者模块：编辑新闻、发布新闻、查看新闻审核状态等。
* 
* 用户交互：
* 用户通过前端界面进行新闻的浏览和评论，管理员和编辑者通过后端管理界面进行新闻的发布和审核。
* 
* 安全与权限：
* 系统通过角色和权限控制确保数据安全，不同角色的用户只能访问其权限范围内的功能。
* 
* 部署与维护：
* 系统部署在支持Tomcat的服务器上。

* **项目演示：**
* 