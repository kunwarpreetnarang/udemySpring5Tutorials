pipeline {
    agent any
    stages {
        stage('--- Clean and compile project ---') {
            steps {
                //
                sh "mvn clean"
            }
        }
        stage('--- Run Test Cases ---') {
            steps {
                //
                sh "mvn test"
            }
        }
        stage('--- Deploy Project package ---') {
            steps {
                //
                sh "mvn package"
            }
        }
    }
}