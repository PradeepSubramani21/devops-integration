pipeline {

    agent any
    tools{
        maven 'maven_3_8_6'
    }

    stages {
        stage('Build') {
            steps {
                checkout([$class: 'GitSCM', branches: [[name: '*/main']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/PradeepSubramani21/devops-integration']]])
                sh 'mvn clean install'
            }
        }
        stage('Build image'){
           steps{
                script{
                    sh 'docker build -t pradeepsubramani/javajenkins .'
                }
           }
        }
        stage("Push image"){
            steps{
                withCredentials([string(credentialsId: 'dockerpassword', variable: 'dockerpassword')]) {
                    sh 'docker login -u pradeepsubramani -p ${dockerpassword}'
                    sh 'docker push pradeepsubramani/javajenkins'
                } 
            }
        }
    }
}
