## 注意事项
由于该工程下的项目依赖Nacos注册中心，启动该工程下的项目需要先安装并启动Nacos，可以查看我的博客：

同时依赖sentinel服务端，需要下载安装sentinel服务端并启动
1. 访问：![https://github.com/alibaba/Sentinel/releases](https://github.com/alibaba/Sentinel/releases)，下载最新版 Sentinel Dashboard。
2. 利用下面的命令启动 Dashboard。
java -jar -Dserver.port=9100 sentinel-dashboard-1.8.2.jar 
这个命令的含义是启动 Sentinel Dashboard 应用，Sentinel Dashboard 会监听9100端口实现与微服务的通信。同时我们可以访问下面的网址查看 Sentinel Dashboard 的UI界面。
http://localhost:9100
在用户名、密码处输入 sentinel/sentinel，便可进入 Dashboard。