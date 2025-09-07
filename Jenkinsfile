pipeline{
    agent any
    tools{
        maven 'maven-3.9.6'
    }
    stages{
        stage('Build Maven'){
            steps{
                checkout scmGit(branches: [[name: '*/master']], extensions: [], userRemoteConfigs: [[credentialsId: '0f97699b-7e98-433d-bee0-855cee36a215', url: 'https://github.com/usmanrana4106/studentInformationSystem']])
                sh 'mvn clean install -DskipTests'
            }
        }
        stage('Build Docker Image'){
            steps{
                script{
                    sh 'Docker build -t usmanrana4106/sisjenkinpipeline .'
                }
            }
        }
        stage('Push image to hub'){
            steps{
                script{
                    withCredentials([string(credentialsId: 'dockerhub-pwd', variable: 'dockerhubpwd')]){
                        sh 'docker login -u usmanrana4106 -p ${dockerhubpwd}'
                    }
                    sh 'docker push usmanrana4106/sisjenkinpipeline'
                }
            }
        }
    }
}