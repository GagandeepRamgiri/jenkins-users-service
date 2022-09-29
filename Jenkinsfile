pipeline {
    agent any
    
    environment {
    	DOCKER_IMG_NAME = 'user-service'
    	DOCKER_TMP_CONTAINER_NAME = 'tmp-user-service-container'
    }

    stages {
          
        stage('COMPILE') {
            steps {
                sh 'mvn compile'
            }
        }
        
        stage('CLEAN') {
            steps {
                sh 'mvn clean'
            }
        }
        
        stage('TEST') {
            steps {
                sh 'mvn test'
            }
        }
        /*
        stage('QUALITY') {
            steps {
                sh 'mvn sonar:sonar'
            }
        }
          */  
        stage('BUILD') {
            steps {
                sh 'mvn clean package -DskipTests'
            }
        }
        
        stage('DOCKERIZE') {
            steps {
                sh "docker build -t ${DOCKER_IMG_NAME}:latest -t ${DOCKER_IMG_NAME}:${BUILD_ID} ."
            }
        }
		
		stage('INTEGRATION TESTS'){
			steps{
				sh "docker run -dp 7070:8080 --rm --name ${DOCKER_TMP_CONTAINER_NAME} ${DOCKER_IMG_NAME}:latest"
				sleep 10
				sh 'curl -i http://localhost:7070/api/users'
				}
			}
         
        }
        
        post {
        	always {
        		sh 'docker stop ${DOCKER_TMP_CONTAINER_NAME}"
        		sh "docker rmi ${DOCKER_IMG_NAME}:latest ${DOCKER_IMG_NAME}:${BUILD_ID}"
        	}
        	
        }
    }

