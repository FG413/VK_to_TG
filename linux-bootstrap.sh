#!/bin/sh
while true; do
    read -p "Do you wish to install this program? " yn
    case $yn in
        [Yy]* ) break;;
        [Nn]* ) exit;;
        * ) echo "Please answer y/yes or n/no.";;
    esac
done
echo "Starting bootstraping Message resender bot..."
echo "Downloading and installing JDK 17..."
apt-get update
apt-get install -y gnupg
wget -q -O - https://download.bell-sw.com/pki/GPG-KEY-bellsoft | sudo apt-key add -
echo "deb [arch=amd64] https://apt.bell-sw.com/ stable main" | sudo tee /etc/apt/sources.list.d/bellsoft.listCopy
apt-get update
apt-get install bellsoft-java17
java -version
echo "JDK is installed"
echo "Installing docker..."
for pkg in docker.io docker-doc docker-compose podman-docker containerd runc; do sudo apt-get remove $pkg; done
# Add Docker's official GPG key:
sudo apt-get update
sudo apt-get install ca-certificates curl gnupg
sudo install -m 0755 -d /etc/apt/keyrings
curl -fsSL https://download.docker.com/linux/ubuntu/gpg | sudo gpg --dearmor -o /etc/apt/keyrings/docker.gpg
sudo chmod a+r /etc/apt/keyrings/docker.gpg

# Add the repository to Apt sources:
echo \
  "deb [arch="$(dpkg --print-architecture)" signed-by=/etc/apt/keyrings/docker.gpg] https://download.docker.com/linux/ubuntu \
  "$(. /etc/os-release && echo "$VERSION_CODENAME")" stable" | \
  sudo tee /etc/apt/sources.list.d/docker.list > /dev/null
sudo apt-get update
sudo apt-get install docker-ce docker-ce-cli containerd.io docker-buildx-plugin docker-compose-plugin
echo "Docker installed!"
echo "Pulling and running posrgres"
docker run -d -p 5432:5432 --name postgres -e POSTGRES_PASSWORD=password postgres:15
echo "Installing git..."
apt-get update
apt install git
echo "Git is READY"
echo "Cloning repository..."
git clone https://github.com/FG413/VK_to_TG.git
echo "Repository is cloned"
nohup ./mvnw spring-boot:run > nohup.txt &