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

            stage('SonarQube') {
                        steps {
                            script {
                                def mavenCmd = "mvn verify sonar:sonar -Dsonar.login=$SONAR_TOKEN"
                                sh mavenCmd
                            }
                        }
                    }




    }

}
