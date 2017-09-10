FROM saltstack/ubuntu-14.04-minimal

MAINTAINER Saad Errazi <errazisaad@gmail.com>

#Adding ppa repository to base image repos list
#Actualise repos
#Install java

RUN sudo apt-get install python-software-properties
RUN	sudo add-apt-repository ppa:openjdk-r/ppa
RUN	sudo apt-get update
RUN	sudo apt-get install -y --force-yes openjdk-8-jre

# scala install
RUN sudo apt-get install wget && wget http://www.scala-lang.org/files/archive/scala-2.12.3.deb
RUN sudo dpkg -i scala-2.12.3.deb

 
# sbt installation
RUN echo "deb https://dl.bintray.com/sbt/debian /" | sudo tee -a /etc/apt/sources.list.d/sbt.list
RUN sudo apt-key adv --keyserver hkp://keyserver.ubuntu.com:80 --recv 2EE0EA64E40A89B84B2DF73499E82A75642AC823
RUN sudo apt-get install apt-transport-https 
RUN sudo apt-get update 
RUN sudo apt-get install -y --force-yes sbt

RUN mkdir /maths-library/

COPY maths-library/ /maths-library/

COPY run.sh /opt/

CMD ["/bin/bash", "/opt/run.sh", "-d"]
