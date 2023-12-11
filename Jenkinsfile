pipeline {
    agent any
    environment {
            DOCKERHUB_CREDENTIALS = credentials('dockerhub-aziz')
             SONAR_TOKEN = credentials('Sonar_Token')
        }

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
                    sh 'mvn  deploy -Dmaven.test.skip=true'
                }
            }

            stage('MVN SONARQUBE') {
                               steps {
                                   sh 'mvn  sonar:sonar -Dsonar.login=admin -Dsonar.password=eae3af25-ddb0-42f0-ba04-66616b26aa15 -Dmaven.test.skip=true '
                               }
                           }



    }

}
