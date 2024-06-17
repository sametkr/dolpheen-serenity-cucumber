pipeline {
    agent any
    tools {
        jdk 'java-17'
        maven 'Maven'
    }
    stages {
        stage('Build') {
            steps {
                sh 'mvn clean install'
            }
        }
        stage('Test') {
            steps {
                sh 'mvn verify'
            }
        }
        stage('Publish Report') {
            steps {
                publishHTML(target: [
                    reportName: 'Serenity Report',
                    reportDir: 'target/site/serenity',
                    reportFiles: 'index.html',
                    alwaysLinkToLastBuild: true,
                    keepAll: true
                ])
            }
        }
    }
}
