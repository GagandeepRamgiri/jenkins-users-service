pipeline {
    agent any

    stages {
          
        stage('compile') {
            steps {
                sh 'mvn compile'
            }
        }
        
        stage('clean') {
            steps {
                sh 'mvn clean'
            }
        }
        
        stage('test') {
            steps {
                sh 'mvn test'
            }
        }
            
        stage('build') {
            steps {
                sh 'mvn clean package -DskipTests'
            }
        }

         
        }
    }

