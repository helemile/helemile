FROM centos
VOLUME ["test1", "test2", "/mylog/test3"]

ENV MYPATH /usr/local
WORKDIR $MYPATH

RUN yum install -y mariadb-server

EXPOSE 3306

CMD /bin/sh