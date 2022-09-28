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

         
        }
    }

