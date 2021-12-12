FROM openjdk:11-jdk

#==========
# Maven
#==========
ENV MAVEN_VERSION 3.5.4
ARG USER_HOME_DIR="/root"

RUN curl -fsSL http://archive.apache.org/dist/maven/maven-3/$MAVEN_VERSION/binaries/apache-maven-$MAVEN_VERSION-bin.tar.gz | tar xzf - -C /usr/share \
  && mv /usr/share/apache-maven-$MAVEN_VERSION /usr/share/maven \
  && ln -s /usr/share/maven/bin/mvn /usr/bin/mvn

ENV MAVEN_HOME /usr/share/maven
ENV MAVEN_CONFIG "$USER_HOME_DIR/.m2"

#========================
# git
#========================
RUN apt-get -y update
RUN apt-get -y install git

#========================================
# Add normal user with passwordless sudo
#========================================
RUN useradd remoteuser --shell /bin/bash --create-home \
  && usermod -a -G sudo remoteuser \
  && echo 'ALL ALL = (ALL) NOPASSWD: ALL' >> /etc/sudoers \
  && echo 'remoteuser:secret' | chpasswd

RUN apt-get update -y && apt-get -y install vim

#===============
# XVFB
#===============
RUN apt-get update -y \
  && apt-get -y install \
    xvfb \
  && rm -rf /var/lib/apt/lists/* /var/cache/apt/*

ENV SCREEN_WIDTH 1360
ENV SCREEN_HEIGHT 1020
ENV SCREEN_DEPTH 24
ENV DISPLAY :99.0

#===============
# Google Chrome
#===============
RUN wget -q -O - https://dl-ssl.google.com/linux/linux_signing_key.pub | apt-key add - \
  && echo "deb http://dl.google.com/linux/chrome/deb/ stable main" >> /etc/apt/sources.list.d/google-chrome.list \
  && apt-get update -qqy \
  && apt-get -qqy install \
    google-chrome-stable \
  && rm /etc/apt/sources.list.d/google-chrome.list \
  && rm -rf /var/lib/apt/lists/*

RUN mkdir /tmp/.X11-unix
RUN chmod -R go-rwx /tmp/* /tmp/.[!.]*
RUN chmod 1777 /tmp/.X11-unix
RUN chmod 1777 /tmp

USER root

RUN mkdir /home/remoteuser/serenity-project

WORKDIR /home/remoteuser/serenity-project

RUN git clone https://github.com/leftty/ui-homework.git

RUN cd ui-homework