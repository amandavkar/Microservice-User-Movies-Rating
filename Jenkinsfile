pipeline {
  
  agent any
   
  environment {
  registry = "amandavkar/user-movies-rating"
  registryCredential = 'dockerhub'
  dockerImage = ''
  }

  tools {
     // Install the Maven version configured as "M3" and add it to the path.
     maven "Maven"
  }

  stages {
    stage('Cloning Git') {
      steps {
        git 'https://github.com/amandavkar/Microservice-User-Movies-Rating.git'
      }
    }
	  
    stage('Build jar file') {
	  steps {
        // Run Maven on a Unix agent.
        sh "mvn -Dmaven.test.failure.ignore=true -DskipTests=true clean install"

        // To run Maven on a Windows agent, use
        // bat "mvn -Dmaven.test.failure.ignore=true -DskipTests=true clean install"
	  }
    }

    stage('Building image') {
      steps{
        script {
          dockerImage = docker.build registry + ":$BUILD_NUMBER"
        }
      }
    }

    stage('Deploy Image') {
      steps{
        script {
          docker.withRegistry( '', registryCredential ) {
            dockerImage.push()
			dockerImage.push("latest")
          }
        }
      }
    }

	stage('Remove Unused docker image') {
	  steps{
		sh "docker rmi $registry:$BUILD_NUMBER"
	  }
	}
	
//	stage('Copy deployment and service YAML files to Kubernetes master') {
//	  steps{
//	      sh "scp -r user-movies-rating.yml vagrant@k8s-master:/home/vagrant"
//	      sh "scp -r mysql-deployment.yml vagrant@k8s-master:/home/vagrant"
//	      sh "scp -r zipkin.yml vagrant@k8s-master:/home/vagrant"
//	  }
//	}
//	
//
//	stage('Execute Ansible playbook to deploy service in Kubernetes') {
//	  steps{
//		ansiblePlaybook installation: 'Ansible', inventory: '/etc/ansible/hosts', playbook: 'playbook-user-movies-rating.yml'
//		ansiblePlaybook installation: 'Ansible', inventory: '/etc/ansible/hosts', playbook: 'playbook-mysql-server.yml'
//		ansiblePlaybook installation: 'Ansible', inventory: '/etc/ansible/hosts', playbook: 'playbook-zipkin.yml'
//	  }
//	}
 }
	
}
