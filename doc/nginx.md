# nginx
nginx为什么流行？

1、性能高
背景：Linux API 提供的 I/O 复用方式有三种：select、poll、epoll。 nginx使用是epoll来实现I/O 复用支持高并发。
epoll的优点：
1）fd 数量不限制。
2）非阻塞。 select/poll 会随着 fd 的增加而性能下降。epoll是回调方式
3）水平触发/边沿触发。 nginx使用的是边沿触发
4）mmap。

2、扩展性好。模块化架构，且生态好。如：OpenResty


## OpenResty

OpenResty的目标
1）Nginx 扩展为通用web应用服务器。如：php、nodejs。 不再是静态资源服务端 和 反向代理服务器
2）Nginx 脚本扩展编程。

OpenResty最佳实践：
https://moonbingbing.gitbooks.io/openresty-best-practices/content/openresty/inline_var.html
