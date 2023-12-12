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

             stage('JUnit / Mockito Tests') {
                                                 steps {
                                                     script {
                                                         def mavenCmd = 'mvn test'
                                                         sh mavenCmd
                                                     }
                                                 }
                                             }

             stage('Build docker image') {
                         steps {
                             dir('Events') {
                                 sh "docker build -t medomrani8/eventsproject-1.0.0 ."
                             }
                         }
                     }

                     stage('login to dockerhub') {
                         steps {
                             sh 'echo $DOCKERHUB_CREDENTIALS_PSW | sudo docker login -u $DOCKERHUB_CREDENTIALS_USR --password-stdin'
                         }
                     }



    }

}
