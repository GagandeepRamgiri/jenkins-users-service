pipeline {
    agent any

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
                sh 'docker build -t user-service:latest .'
            }
        }
		
		stage('INTEGRATION TESTS'){
			steps{
				sh 'docker run -dp 7070:8080 --rm --name tmp-user-service-container user-service:latest'
				sleep 10
				sh 'curl -i http://localhost:7070/api/users'
				}
			}
         
        }
        
        post {
        	always {
        		sh 'docker stop tmp-user-service-container'
        	}
        	
        }
    }

