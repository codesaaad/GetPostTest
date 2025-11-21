pipeline {
    agent any

     stages {
            stage('Clean Workspace') {
                steps {
                    deleteDir() // This wipes the entire workspace
                }
            }
    stages {
        stage('Checkout') {
            steps {
                    git branch: 'main', url: 'https://github.com/codesaaad/GetPostTest.git'
                    checkout scm
            }
        }

        stage('Install Dependencies') {
            steps {
                sh "mvn clean install -DskipTests"
            }
        }

        stage('Run Tests') {
            steps {
                sh "mvn test"
            }
        }
    }

    post {
        always {
            junit 'target/surefire-reports/*.xml'
        }
    }
}
