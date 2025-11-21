pipeline {
    agent any

    tools {
        maven 'Maven_Latest_3.9.11'  // Maven name from jenkins
        jdk 'JDK_File_21'           //jdk name from jenkins
    }

    stages {
        stage('Checkout') {
            steps {
                git branch: 'main', url: 'https://github.com/codesaaad/GetPostTest.git'
            }
        }

        stage('Install Dependencies') {
            steps {
                bat "mvn clean install -DskipTests"
            }
        }

        stage('Run Tests') {
            steps {
                bat "mvn test"
            }
        }
    }

    post {
        always {
            junit testResults: 'target/surefire-reports/*.xml', allowEmptyResults: true
        }
    }
}