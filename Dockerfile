FROM centos:7

MAINTAINER storys.zhang <storys.zhang@gmail.com>

RUN mkdir /usr/local/java
ADD jdk-11.0.3_linux-x64_bin.tar.gz /usr/local/java/

ENV JAVA_HOME /usr/local/java/jdk-11.0.3
ENV PATH $JAVA_HOME/bin:$PATH

# 挂载test-docker目录,创建/tmp目录并持久化到Docker数据文件夹，
VOLUME /tmp
# COPY or ADD to image
# 将编译目标jar包复制到/admin.jar
ADD admin-0.0.1-SNAPSHOT.jar admin.jar
 
RUN bash -c "touch /admin.jar"
 
# 默认8080端口
# 指定项目暴露的端口号，与项目配置一样,即容器配置的暴露端口
EXPOSE 8080
#ENTRYPOINT 执行项目 app.jar。为了缩短 Tomcat 启动时间，添加一个系统属性指向 "/dev/urandom" 作为 Entropy Source
#ENTRYPOINT ["java", "-jar", "app.jar"]