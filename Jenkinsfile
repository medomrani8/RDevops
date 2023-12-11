pipeline {
    agent any

    stages {
        stage('GIT') {
            steps {
                script {
                    git branch: 'master', credentialsId: 'Git_Token', url: 'https://github.com/medomrani8/RDevops.git'
                }
            }
        }

        stage('MVN CLEAN') {
            steps {
                script {
                    sh 'mvn clean'
                }
            }
        }

        stage('MVN COMPILE') {
            steps {
                script {
                    sh 'mvn compile'
                }
            }
        }

            stage('NEXUS') {
                steps {
                    sh 'mvn clean deploy -DskipTests=true'
                }
            }

    }
}
