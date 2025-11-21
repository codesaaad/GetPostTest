pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
            git url: 'https://github.com/codesaaad/GetPostTest.git',
                                credentialsId: 'github-pat'
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
